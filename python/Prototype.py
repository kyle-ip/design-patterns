"""
原型模式
    用原型实例指定创建对象的种类，并且通过拷贝这些原型创建新的对象；
    从一个对象创建另外一个可定制的对象，不需要知道任何创建的细节；
"""

import abc

class Prototype(metaclass=abc.ABCMeta):

    @abc.abstractmethod
    def clone(self):
        pass

# TODO
class ConcreatePrototype1(Prototype):

    def __init__(self, id):
        self.id = id

    def clone(self):
        return