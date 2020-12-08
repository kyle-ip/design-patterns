"""
装饰器模式
    装饰器的本质是 AOP（面向切面编程），在不改变类定义（组件）的前提下动态改变类的行为（开闭原则），同时提高代码复用性；
    每种要装饰的功能都独立写在不同装饰器（函数、类）中，可以有选择地、按顺序地让装饰器包装组件来扩展功能；

    在本例中，create_container 方法是组件（Component），docker_host_required 是装饰器（Decorator）；
    装饰器的作用在于扩展组件的功能，对于组件而言无需知道装饰器的存在。
"""

from functools import wraps

HOST_DOCKER = 0


""" 装饰器函数 """
def docker_host_required(f):

    """
    要求 host 类型必须是 HOST_DOCKER，否则引起异常
    :param f:
    :return:
    """
    @wraps(f)                                       # f 即为 create_container 方法
    def wrapper(*args, **kwargs):                   # args[0] 即为 self（Host 对象），args[1] 为传入的第一个参数
        print(args)
        if args[0].type != HOST_DOCKER:
            raise Exception("Not docker host")
        else:
            return f(*args, **kwargs)
    return wrapper


""" 主机类 """
class Host(object):

    def __init__(self, type):
        self.type = type

    @docker_host_required
    def create_container(self):
        print("create container")


if __name__ == '__main__':

    host = Host(HOST_DOCKER)
    host.create_container()
    print("")
    host = Host(1)
    host.create_container()