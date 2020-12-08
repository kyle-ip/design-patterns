"""
桥接模式
    利用使用“对象间的组合关系”解耦了抽象和实现之间固有绑定关系，使抽象和实现可以沿着各自维度变化；
    类似于多继承方案，但多继承方案会违背了类的单一职责原则（一个类只有一个变化），复用性不好；
    系统中使用继承没有问题，但由于抽象化角色和具体化角色需要独立变化，设计要求需要独立管理这两者；

    在以下场景中适用：
    一个系统需要在构件的抽象化角色和具体化角色之间增加更多的灵活性，避免在两个层次之间建立静态的联系；
    实现化角色的改变对客户端是完全透明的，即设计要求实现化角色的任何改变不应当影响客户端；
    一个构件有多于一个的抽象化角色和实现化角色，系统需要它们之间进行动态耦合。

    在本例中，汽车在公路上行驶，路、车两个维度各自修改产生的变化相互不影响
"""

""" 公路基类 """
class AbstractRoad(object):
    car = None

""" 车辆基类 """
class AbstractCar(object):
    def run(self):
        pass

""" 市区街道类 """
class Street(AbstractRoad):
    def run(self):
        self.car.run()
        print("在市区街道上行驶")

""" 高速公路类 """
class SpeedWay(AbstractRoad):
    def run(self):
        self.car.run()
        print("在高速公路上行驶")

""" 小汽车类 """
class Car(AbstractCar):
    def run(self):
        print("小汽车")

""" 公共汽车 """
class Bus(AbstractCar):
    def run(self):
        print("公共汽车")

if __name__ == "__main__":
    road1 = SpeedWay()
    road1.car = Car()
    road1.run()

    road2 = SpeedWay()
    road2.car = Bus()
    road2.run()