"""
建造者模式
    封装一个对象的构造过程，并允许按步骤构造；
    将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示；
    在以下场景中适用：
        当创建复杂对象的算法应该独立于该对象的组成部分、装配方式时；
        当构造过程必须允许被构造的对象有不同表示时。

    在本例中，产品的构建由很多复杂组件组成：如人的头、身体、手、脚，组件的某些细节不同、构造出的产品也不同（胖手、瘦手）；
    通过一个指挥者按照产品的创建步骤来指挥建造者一步步执行产品的创建；
    当需要创建不同的产品时，只需要派生一个具体的建造者，重写相应的组件构建方法即可：
        可以创建胖子和瘦子，但都是通过指挥者指导其创建过程，所以指挥者不需要修改。
"""


""" 建造者基类 """
class PersonBuilder(object):
    def BuildHead(self):
        pass

    def BuildBody(self):
        pass

    def BuildArm(self):
        pass

    def BuildLeg(self):
        pass

""" 胖子建造者类 """
class PersonFatBuilder(PersonBuilder):  
    type = '胖子'

    def BuildHead(self):
        print("构建%s的头" % self.type)

    def BuildBody(self):
        print("构建%s的身体" % self.type)

    def BuildArm(self):
        print("构建%s的手" % self.type)

    def BuildLeg(self):
        print("构建%s的脚" % self.type)

""" 瘦子建造者类 """
class PersonThinBuilder(PersonBuilder):
    type = '瘦子'

    def BuildHead(self):
        print("构建%s的头" % self.type)

    def BuildBody(self):
        print("构建%s的身体" % self.type)

    def BuildArm(self):
        print("构建%s的手" % self.type)

    def BuildLeg(self):
        print("构建%s的脚" % self.type)

""" 指挥者类 """
class PersonDirector(object):  # （指挥建造者创建人的实例）
    pb = None

    def __init__(self, pb):
        self.pb = pb

    def CreatePereson(self):
        self.pb.BuildHead()
        self.pb.BuildBody()
        self.pb.BuildArm()
        self.pb.BuildLeg()


if __name__ == '__main__':
    pb = PersonThinBuilder()        # 指定一个瘦子建造者
    pd = PersonDirector(pb)         # 创建指挥者，并指定让它指挥的建造者对象
    pd.CreatePereson()              # 建造者创建人的实例

    pb = PersonFatBuilder()
    pd = PersonDirector(pb)
    pd.CreatePereson()