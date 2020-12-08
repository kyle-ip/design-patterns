"""
策略模式：
    将不同的算法封装为不同的类，它们之间可以互换；
    算法的特点是完成相同的工作，只是实现的方式不同，因此应该以相同的方式调用；
    由于不同的算法都分别封装为不同的类，因此可以通过自己的接口单独进行单元测试，也不会因一个算法出错影响其他算法；

    封装变化：区别于生成产品的工厂模式，算法不应该用工厂产生，而是随时可以互相替换的策略——变化点，应该对变化点进行封装；
    与简单工厂模式结合：把不同的算法封装为类、通过同名方法实现，在策略类中传入/修改算法名称，即可以相同的方式调用算法；
    如本例中的 info 类，无论策略作任何变化，都是通过 context.show() 调用。
"""

import abc

""" 抽象显示对象 """
class AbsShow(object, metaclass=abc.ABCMeta):
    @abc.abstractmethod
    def show(self):
        pass

""" 管理员的显示操作 """
class AdminShow(AbsShow):
    def show(self):
        print("show with admin")

""" 普通用户的显示操作 """
class UserShow(AbsShow):
    def show(self):
        print("show with user")

""" 问题对象类（策略，与简单工厂结合） """
class Context(object):
    def __init__(self, strategy_name):      # 当算法数量较多时，需要大量的 if...elif...，因此可以优化为反射调用
        if strategy_name == "Admin":
            self.show_obj = AdminShow()
        elif strategy_name == "User":
            self.show_obj = UserShow()

    def show(self):
        self.show_obj.show()

if __name__ == '__main__':
    context = Context("Admin")          # 传入对象为管理员，则显示管理员的内容
    context.show()

    context.show_obj = UserShow()       # 替换原来的显示对象为一般用户，体现了策略模式的互换行为
    context.show()