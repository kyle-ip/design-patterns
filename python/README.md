# DesignPattern

## 常用设计模式的 Python 实现
- 创建型
    - [单例模式](https://github.com/yipwinghong/DesignPattern/blob/master/Singleton.py)
    - [工厂模式](https://github.com/yipwinghong/DesignPattern/blob/master/Factory.py)
    - [建造者模式](https://github.com/yipwinghong/DesignPattern/blob/master/Builder.py)
- 行为型
    - [策略模式](https://github.com/yipwinghong/DesignPattern/blob/master/Strategy.py)
    - [观察者模式](https://github.com/yipwinghong/DesignPattern/blob/master/Observer.py)
    - [命令模式](https://github.com/yipwinghong/DesignPattern/blob/master/Command.py)
    - [模板方法模式](https://github.com/yipwinghong/DesignPattern/blob/master/TemplateMethod.py)
    - [责任链模式](https://github.com/yipwinghong/DesignPattern/blob/master/ChainOfResponsibility.py)
- 结构型
    - [适配器模式](https://github.com/yipwinghong/DesignPattern/blob/master/Apdater.py)
    - [装饰器模式](https://github.com/yipwinghong/DesignPattern/blob/master/Decorator.py)
    - [代理模式](https://github.com/yipwinghong/DesignPattern/blob/master/Proxy.py)
    - [组合模式](https://github.com/yipwinghong/DesignPattern/blob/master/Composite.py)
    - [外观模式](https://github.com/yipwinghong/DesignPattern/blob/master/Facade.py)
    - [享元模式]()
    - [桥接模式](https://github.com/yipwinghong/DesignPattern/blob/master/Bridge.py)

## 六大设计原则

### 单一职责原则 (Single Responsibility Principle)
一个类只负责一项职责/操作的原则，目的在于：
- 降低类的复杂度；
- 提高类的可读性、系统的可维护性；
- 降低变更引起的风险

如果一个类负责多个职责，其中一项发生变化就要修改整个类，可能会导致其他职责运行错误，对于一个类只应该有一个引起它变化的原因。


### 里氏替换原则 (Liskov Substitution Principle)
引用基类的地方必须能透明地使用其子类的对象（使用基类进行定义，运行时使用子类对象），需要注意：
- 子类可以实现父类的抽象方法，但不能覆盖父类的非抽象方法；
- 子类中可以增加自己特有的方法；
- 子类的方法重载父类的方法时，输入参数要比父类方法的输入参数更宽松。


### 依赖倒置原则 (Dependence Inversion Principle)
- 抽象不应该依赖于细节，细节应当依赖于抽象（即针对接口而非实现编程）；
- 在程序代码中传递参数时或在关联关系中，尽量引用层次高的抽象层类；

所谓高层次的抽象层类即使用接口和抽象类进行变量类型声明、参数类型声明、方法返回类型声明，以及数据类型的转换等，需要注意：
- 每个类尽量都有接口或抽象类，或者抽象类和接口两者都具备；
- 变量的表名类型尽量是接口或者抽象类；
- 尽量不要覆写基类的方法；
- 结合里氏替换原则使用。

### 接口隔离原则 (Interface Segregation Principle)
- 客户端不应该依赖它不需要的接口，一个类对另一个类的依赖应该建立在最小的接口上；
- 当一个接口太大时，我们需要将它分割成一些更细小的接口（承担相对独立的角色），使用该接口的客户端仅需知道与之相关的方法即可；
- 单一职责原则要求的是类和接口职责单一，注重的是职责，这是业务逻辑上的划分；
- 接口隔离原则要求控制接口的粒度：
    - 接口不能太小，如果太小会导致系统中接口泛滥，不利于维护；
    - 接口不能太大，太大的接口将违背接口隔离原则，灵活性较差，使用起来很不方便。

### 迪米特原则 (Law of Demeter)
- 一个对象应该对其他对象有最少的了解；
- 一个类应该对自己需要耦合或调用的类知道得最少，尽量减少对象之间的交互；
- 如果两个对象之间不必彼此直接通信，那么这两个对象就不应当发生任何直接的相互作用；
- 如果其中的一个对象需要调用另一个对象的某一个方法的话，可以通过第三者转发这个调用；
- 在代理模式和外观模式中都有体现这个原则。

### 开闭原则 (Open Closed Principle)
- 一个软件实体应该通过扩展来实现变化（对扩展开放），而不是通过修改已有的代码来实现变化（对修改关闭）；
- 设计一个软件系统模块（类，方法）的时候，应该在不修改原有的模块（修改关闭）的基础上扩展其功能（扩展开放）；
- 优势在于软件系统可复用，并且易于维护：
    - 稳定性：扩展功能不修改原来的代码，这可以让软件系统在变化中保持稳定。
    - 扩展性：对扩展开放，通过扩展提供新的或改变原有的功能，让软件系统具有灵活的可扩展性。