"""
组合模式
    将对象组合成树形结构表示，使得客户端对单个对象和组合对象的使用具有一致性；
    通常会生成一颗对象树，对象树中的叶子结点代表单个对象，其他节点代表组合对象；
    用某一组合对象的方法，会迭代调用所有其叶子对象的方法；

    在本例中，员工包括一般员工和领导，一般员工为叶子节点、领导为非叶子节点，领导可作为员工的父节点；
    领导可以添加成员，并使得领导开始工作时、其属下成员都会一并起工作。
"""

import abc

""" 员工抽象类 """
class Worker(object, metaclass=abc.ABCMeta):

    def __init__(self, name):
        self.name = name

    @abc.abstractmethod
    def work(self):
        pass

""" 一般员工类 """
class Employe(Worker, metaclass=abc.ABCMeta):

    def work(self):
        print("Employ: %s start to work " % self.name)

""" 领导类 """
class Leader(Worker):

    def __init__(self, name):
        self.members = []
        super(Leader, self).__init__(name)

    def add_member(self, employe):
        if employe not in self.members:
            self.members.append(employe)

    def remove_member(self, employe):
        if employe in self.members:
            self.members.remove(employe)

    def work(self):
        print("Leader: %s start to work" % self.name)
        for employe in self.members:
            employe.work()


if __name__ == '__main__':
    employe_1 = Employe("employe_1")
    employe_2 = Employe("employe_2")
    leader_1 = Leader("leader_1")
    leader_1.add_member(employe_1)
    leader_1.add_member(employe_2)

    employe_3 = Employe("employe_3")
    leader_2 = Leader("leader_2")
    leader_2.add_member(employe_3)
    leader_2.add_member(leader_1)
    leader_2.work()