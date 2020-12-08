"""
观察者模式：
    当被观察对象发生变化时，观察者能及时得到通知并更新（观察者与被观察对象解耦）；
    比如当课程发生变化时，用户和机构都会被通知
"""

import abc

""" 被观察对象的基类 """
class Subject(object):

    def __init__(self):
        self._observers = []

    def attach(self, observer):
        """
        注册观察者
        :param observer:
        :return:
        """
        if observer not in self._observers:
            self._observers.append(observer)

    def detach(self, observer):
        """
        注销观察者
        :param observer:
        :return:
        """
        try:
            self._observers.remove(observer)
        except ValueError:
            pass

    def notify(self):
        """
        通知所有观察者，执行观察者的更新方法
        :return:
        """
        for observer in self._observers:
            observer.update(self)

""" 课程对象，被观察的对象 """
class Course(Subject):

    def __init__(self):
        super(Course, self).__init__()
        self._message = None

    @property
    def message(self):
        return self._message

    @message.setter
    def message(self, msg):     # 当被观察对象的 message 被修改时即会触发 notify ，通知所有绑定在它上面的观察者
        self._message = msg
        self.notify()

""" 观察者抽象类 """
class Observer(object, metaclass=abc.ABCMeta):
    @abc.abstractmethod
    def update(self, subject):
        pass

""" 用户观察者 """
class UserObserver(Observer):
    def update(self, subject):
        print("User observer: %s" % subject.message)

""" 机构观察者 """
class OrgObserver(Observer):
    def update(self, subject):
        print("Organization observer: %s" % subject.message)


if __name__ == '__main__':

    user = UserObserver()       # 初始化一个用户观察者
    org = OrgObserver()         # 初始化一个机构观察者

    course = Course()           # 初始化一个课程

    course.attach(user)         # 注册观察者
    course.attach(org)

    course.message = "two observers"        # 设置course.message，这时观察者会收到通知

    course.detach(user)         # 注销一个观察者
    course.message = "single observer"