"""
单例模式：
    系统确保只有一个对象实例存在；
    无论对类实例化多少次，对象只会生成一次且在首次生成；
    其中通过装饰器实现的单例模式也称为装饰器模式；

    用户无需更改代码即可使用该扩展实例；
    不需要在每次调用都创建一个对象，可以节省内存、减少动态产生销毁对象的开销。
"""

import sqlite3
from flask import current_app
from flask import _app_ctx_stack as stack


""" 实现1：把工作类封装在单例类中 """
class Singleton1(object):

    # 类变量：工作类的实例
    _instance = None

    """ 对外隐藏的工作类（不够灵活） """
    class Worker(object):

        def __init__(self):
            pass

        def display(self):
            """
            返回当前实例的ID（全局唯一）
            :return:
            """
            return id(self)

    def __init__(self):
        """
        判断类变量中是否已保存工作类 _A 的实例，不存在则创建
        """
        if not Singleton1._instance:
            Singleton1._instance = Singleton1.Worker()

    def __getattr__(self, attr):
        """
        属性直接从 Singleton._instance 中获取，如 s1.display()
        :param attr:
        :return:
        """
        return getattr(self._instance, attr)


""" 实现2：使用单例类装饰器实现单例类与工作类解耦（注意不能用于多线程环境） """
class Singleton2(object):

    def __init__(self, cls):
        """
        :param cls:     被装饰类
        """
        self._cls = cls

    def instance(self):
        """
        返回真正的实例
        """
        try:
            return self._instance
        except AttributeError:
            self._instance = self._cls()
            return self._instance

    def __call__(self):
        """
        单例类装饰器不可被调用
        :return:
        """
        raise TypeError('Singletons must be accessed through `Instance()`.')

    def __instancecheck__(self, inst):
        """
        检查inst是否是指定类中的一个实例
        :param inst:
        :return:
        """
        return isinstance(inst, self._decorated)

@Singleton2
class Worker(object):
    def __init__(self):
        pass

    def display(self):
        return id(self)

""" 实现3：基于装饰器的另一种做法 """
def Singleton3(cls):
    instances = {}
    def _singleton(*args, **kwargs):
        if cls not in instances:
            instances[cls] = cls(*args, **kwargs)
        return instances[cls]
    return _singleton

@Singleton3
class Worker3:
    pass

""" 实现4：基于继承 """
class Singleton4(object):
    def __new__(cls, *args, **kwargs):
        if not hasattr(cls, '_instance'):
            orig = super(Singleton4, cls)
            cls._instance = orig.__new__(cls, *args, *kwargs)
        return cls._instance

class Worker4(Singleton4):
    pass

""" 实例：通过单例模式实现Flask的数据库扩展，保证连接数据库只发生一次，每次使用数据库都使用同一个连接 """
class SQLite3(object):

    def __init__(self, app=None):
        self.app = app
        if app:
            self.init(app)

    def init(self, app):
        """
        应用数据库扩展初始化
        :param app:
        :return:
        """
        app.config.setdefault('SQLITE3_DATABASE', ':memory:')
        app.teardown_appcontext(self.close)

    def connect(self):
        """
        连接 SQLite
        :return:
        """
        return sqlite3.connect(
            current_app.config['SQLITE3_DATABASE']
        )

    def close(self, exception):
        """
        关闭 SQLite 连接
        :param exception:
        :return:
        """
        ctx = stack.top
        if hasattr(ctx, 'sqlite3_db'):
            ctx.sqlite3_db.close()

    @property
    def connection(self):
        """
        单例模式：使用 flask._app_ctx_stack 存放 sqlite 链接，
            每次获取数据库链接时都通过 connection 获取
        """
        ctx = stack.top
        if ctx:
            if not hasattr(ctx, 'sqlite3_db'):
                ctx.sqlite3_db = self.connect()
            return ctx.sqlite3_db

if __name__ == '__main__':

    # test1
    s1 = Singleton1()
    s2 = Singleton1()
    print(id(s1), s1.display())     # 2931451082456 2931452960664
    print(id(s2), s2.display())     # 2931452960608 2931452960664

    # test2
    s1 = Worker.instance()
    s2 = Worker.instance()
    print(s1.display())     # 2806755209904
    print(s2.display())     # 2806755209904
    print(s1 is s2)         # True