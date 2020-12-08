"""
外观模式
    为子系统的一组接口提供一个高层接口，是的子系统更容易使用（客户端无需执行多个操作，降低系统的复杂程度）；
    在面向对象软件系统中，类与类之间的关系越多，不能表示系统设计得越好，反而表示系统中类之间的耦合度太大，这样的系统在维护和修改时都缺乏灵活性；
    一个类的改动会导致多个类发生变化，而外观模式的引入在很大程度上降低了类与类之间的耦合关系（新增或移除子系统都很方便，无需修改客户类）。

    在以下场景中适用：
        在设计阶段，应该有意识地将不同的两层分离（如 MVC 架构），层与层之间建立外观；
        在开发阶段，子系统因为不断重构烟花变得越来越复杂，增加外观可以提供简单接口、减少子系统之间的依赖；
        在维护阶段，可能由于大型系统难以维护和扩展，但包含重要的功能，新的需求也依赖于它，
            可以开发一个外观类来提供设计粗糙或高度复杂的遗留代码的简单清晰的接口，让新系统与外观对象交互，外观类与旧系统交互。

    在本例中启动一个实验需要三个前置条件：用户是否已经登陆，课程是否满足学习的条件，实验是否满足可以启动；
    旧的客户类需要判断三个条件才允许执行，在新的客户类中添加了外观类，通过对外接口屏蔽客户类对子系统的直接访问，使客户类的操作更简洁
"""

""" 用户类 """
class User(object):
    def is_login(self):
        return True

    def has_privilege(self, privilege):
        return True

""" 课程类 """
class Course(object):
    def can_be_learned(self):
        return True

""" 实验类 """
class Lab(object):
    def can_be_started(self):
        return True

""" 旧的客户类 """
class Client(object):

    def __init__(self, user, course, lab):
        self.user = user
        self.course = course
        self.lab = lab

    def start_lab(self):
        # 需要判断用户是否登陆，课程是否可以学习，实验是否可以开始。
        if self.user.is_login() \
                and self.course.can_be_learned() \
                and self.lab.can_be_started():
            print("start lab")
        else:
            print("can not start lab")

""" 新的Lab类 """
class FacadeLab(object):

    # 应用了面向对象模式
    def __init__(self, user, course, lab):
        self.user = user
        self.course = course
        self.lab = lab

    def can_be_started(self):
        if self.user.is_login() and self.course.can_be_learned() and self.lab.can_be_started():
            return True
        else:
            return False

""" 新的客户类 """
class NewClient(object):

    # 使用外观模式
    def __init__(self, facade_lab):
        self.lab = facade_lab

    def start_lab(self):
        if self.lab.can_be_started:     # 开始实验，只需要判断 FacadeLab 是否可以开始
            print("start lab")
        else:
            print("can not start lab")


if __name__ == '__main__':
    user = User()
    course = Course()
    lab = Lab()
    client = Client(user, course, lab)
    client.start_lab()

    print("Use Facade Pattern:")
    facade_lab = FacadeLab(user, course, lab)
    facade_client = NewClient(facade_lab)
    facade_client.start_lab()