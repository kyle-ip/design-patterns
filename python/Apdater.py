"""
适配器模式
    把一个类的接口变换成客户端所期待的另一种接口，使原本因接口不兼容而无法在一起工作的两个类能够在一起工作；
    在本例中旧课程类通过一个 show 方法显示三种信息，在新课程类中则改为 show_desc、show_teacher、show_labs 方法分别展示三类信息；
    对于客户端而言，要查询三种信息还是使用旧接口 show，所以新课程类需要接入适配器；
    从提供课程对象改为提供适配器对象，但客户端的接口调用方式不会改变。

"""

""" 旧的课程类 """
class OldCourse(object):

    def show(self):
        print("show description")           # 显示描述信息
        print("show teacher of course")     # 显示教师信息
        print("show labs")                  # 显示实验信息


""" 使用课程对象的客户端 """
class Page(object):

    def __init__(self, course):
        self.course = course

    def render(self):
        self.course.show()

""" 新的课程类 """
class NewCourse(object):

    def show_desc(self):
        print("show description")

    def show_teacher(self):
        print("show teacher of course")

    def show_labs(self):
        print("show labs")

""" 适配器 """
class Adapter(object):

    def __init__(self, course):
        self.course = course

    # 尽管实现了新的课程类，但是在很多代码中还是需要使用 OldCourse.show() 方法
    def show(self):
        self.course.show_desc()
        self.course.show_teacher()
        self.course.show_labs()


if __name__ == '__main__':
    old_course = OldCourse()
    page = Page(old_course)
    page.render()
    print("")
    new_course = NewCourse()

    adapter = Adapter(new_course)       # 新课程类没有 show 方法，我们需要使用适配器进行适配
    page = Page(adapter)
    page.render()