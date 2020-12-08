"""
模板方法模式
    结构中只存在父类与子类之间的继承关系：先定义一个类模板，在模板类中定义各种操作的顺序（骨架），但并不实现这些操作，这些操作由子类来操作；
    将一些复杂流程的实现步骤封装在一系列基本方法中，在抽象父类中提供模板方法来定义这些基本方法的执行次序框架；
    通过其子类来覆盖某些具体的执行步骤，从而使得相同的算法框架可以有不同的执行结果；

    在本例中模板为钓鱼方法，决定了抽象方法的调用顺序，这在父类中实现、由子类实例调用；
        抽象方法为钓鱼方法的每个步骤（准备鱼饵、选择出行方式、选择钓鱼地点），这在子类中实现，由钓鱼方法内部调用。
"""

import abc

""" 钓鱼模板基类 """
class Fishing(object, metaclass=abc.ABCMeta):

    def finishing(self):
        """
        具体方法：确定了要依次执行哪些操作才能钓鱼
        :return:
        """
        self.prepare_bait()
        self.go_to_riverbank()
        self.find_location()
        print("start fishing")

    @abc.abstractmethod
    def prepare_bait(self):
        """
        准备鱼饵
        :return:
        """
        pass

    @abc.abstractmethod
    def go_to_riverbank(self):
        """
        选择出行方式
        :return:
        """
        pass

    @abc.abstractmethod
    def find_location(self):
        """
        选择钓鱼地点
        :return:
        """
        pass

""" John 钓鱼步骤 """
class JohnFishing(Fishing):

    def prepare_bait(self):
        print("John: buy bait from Taobao")

    def go_to_riverbank(self):
        """
        从淘宝购买鱼饵
        """
        print("John: to river by driving")

    def find_location(self):
        """
        在岛上选择钓点
        """
        print("John: select location on the island")


""" Simon 钓鱼步骤 """
class SimonFishing(Fishing):

    def prepare_bait(self):
        """
        从京东购买鱼饵
        """
        print("Simon: buy bait from JD")

    def go_to_riverbank(self):
        """
        骑自行车去钓鱼
        """
        print("Simon: to river by biking")

    def find_location(self):
        """
        在河边选择钓点
        """
        print("Simon: select location on the riverbank")


if __name__ == '__main__':
    f = JohnFishing()       # John 去钓鱼
    f.finishing()

    f = SimonFishing()      # Simon 去钓鱼
    f.finishing()
