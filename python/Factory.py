"""
工厂模式家族：
    包括简单工厂模式、工厂方法模式、抽象工厂模式
"""

import abc
import random

""" 
    简单工厂模式
        产品类的实例由工厂类的静态方法创建（传入需要创建的产品类型，返回产品）
        在课程工厂中传入课程类型（基础、进阶），返回基础或进阶课程的实例
"""

class BasicCourse(object):

    def get_labs(self):
        return "basic_course: labs"

    def __str__(self):
        return "BasciCourse"

class AdvanceCourse(object):

    def get_labs(self):
        return "project_course: labs"

    def __str__(self):
        return "AdvanceCourse"


class SimpleCourseFactory(object):

    @staticmethod
    def create_course(type):
        """
        简单工厂，用于创建课程
        :param type:
        :return:
        """
        if type == 'bc':
            return BasicCourse()
        elif type == 'ac':
            return AdvanceCourse()

"""
    工厂方法模式
        简单工厂模式存在问题：每增加一种产品就需要修改工厂的代码（if...elif...）；
        工厂方法模式对工厂抽象化，每个具体工厂实现抽象工厂的方法并只负责一种产品的生产；
        每当增加新产品时只需要增加对应的工厂即可。
"""

class Factory(object, metaclass=abc.ABCMeta):
    """ 抽象工厂类，其子类需要实现 create_course 方法 """
    @abc.abstractmethod
    def create_course(self):
        pass

class BasicCourseFactory(Factory):
    def create_course(self):
        return BasicCourse()


class AdvanceCourseFactory(Factory):
    def create_course(self):
        return AdvanceCourse()

"""
    抽象工厂模式
        工厂方法模式存在问题：产品数量多同时会产生非常多工厂类；
        抽象工厂模式中的一种工厂可同时创建两种产品，而向外提供由两种产品结合的服务；
        如基础课程结合Linux虚拟机、进阶课程结合Mac虚拟机分别提供为两种服务，工厂面向服务生产产品、可以同时创建课程和虚拟机。
"""

class LinuxVm(object):
    def start(self):
        return "Linux vm running"


class MacVm(object):
    def start(self):
        return "Mac OSX vm running"

class Factory(object, metaclass=abc.ABCMeta):

    @abc.abstractmethod
    def create_course(self):
        pass

    @abc.abstractmethod
    def create_vm(self):
        pass


class BasicCourseLinuxFactory(Factory):

    def create_course(self):
        return BasicCourse()

    def create_vm(self):
        return LinuxVm()


class AdvanceCourseMacFactory(Factory):

    def create_course(self):
        return AdvanceCourse()

    def create_vm(self):
        return MacVm()

def get_factory():
    """
    随机获取一个工厂类
    """
    return random.choice([BasicCourseLinuxFactory, AdvanceCourseMacFactory])()


if __name__ == "__main__":

    # test1
    # t = random.choice(['bc', 'ac'])
    # course = SimpleCourseFactory.create_course(t)
    # print(course.get_labs())

    # test2
    # factory = random.choice([BasicCourseFactory, AdvanceCourseFactory])()
    # course = factory.create_course()
    # print(course.get_labs())

    # test3
    factory = get_factory()
    course = factory.create_course()
    vm = factory.create_vm()
    print(course.get_labs())
    print(vm.start())