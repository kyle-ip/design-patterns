"""
代理模式
    通过代理可以实现访问控制，如使用缓存代理解决热点资源访问问题；
    代理对象与真实对象实现共同的接口，可以在不改变原接口的情况下，使用真实对象的地方都可以使用代理对象；
    代理对象作为中介，可以将客户端请求传递给真实对象前做一些预处理；
    在以下场景中适用：
        远程代理（为对象在不同地址空间提供局部代表，隐藏地址空间信息）
        虚拟代理（根据需要创建开销很大的对象）
        安全代理（控制真实对象访问时的权限）
        智能指引（调用真实对象时，代理处理另外的事）

    在本例中客户端通过代理访问图片，而无需知道代理获取图片并返回的过程；
    代理实现了对客户端屏蔽的缓存过程，假设客户端直接请求获取图片而不通过代理，也就无法享用缓存带来的优势。
"""

import abc
from time import sleep

""" Redis服务类 """
class Redis(object):

    def __init__(self):
        self.cache = dict()

    def get(self, key):
        return self.cache.get(key)

    def set(self, key, value):
        self.cache[key] = value

""" 抽象图片类 """
class AbstractImage(object, metaclass=abc.ABCMeta):

    @abc.abstractmethod
    def url(self):
        pass

""" 图片类 """
class Image(AbstractImage):

    def __init__(self, name):
        self.name = name

    @property
    def url(self):
        sleep(2)
        return "https://dn-syl-static.qbox.me/img/logo-transparent.png"


""" 图片代理类 """
class ImageProxy(AbstractImage):

    def __init__(self, image):
        self.image = image

    @property
    def url(self):
        addr = redis.get(self.image.name)
        if not addr:                            # 首次访问会从真正的图片对象中获取地址，并把地址存入 Redis
            addr = self.image.url
            print("Set url in redis cache!")
            redis.set(self.image.name, addr)
        else:                                   # 以后每次访问都从 Redis 缓存中获取
            print("Get url from redis cache!")
        return addr


""" 客户端类，用于显示图片 """
class Page(object):

    def __init__(self, image):
        self.image = image

    def render(self):
        print(self.image.url)       # 首次访问是通过 Image().url，第二次是 ImageProxy().url，是相同的接口


redis = Redis()

if __name__ == '__main__':
    img = Image(name="logo")
    proxy = ImageProxy(img)
    page = Page(proxy)
    page.render()           # 首次访问
    print("")
    page.render()           # 第二次访问