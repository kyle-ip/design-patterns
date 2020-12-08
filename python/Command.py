"""
命令模式：
    将一系列操作封装到命令类中，命令类对外公开一个执行方法execute；
    调用命令的对象只需要执行命令的 execute 方法即可完成所有操作（实现命令的调用对象与命令具体操作解耦）；
    抽象出调用者、接收者和命令，调用者把命令发送给接收者、接收者接收并执行命令；
    封装性：命令被封装，客户端需要什么功能则执行什么命令，不需要直到命令执行的细节。
    扩展性：接收者类对操作进行最基本的封装，命令类对这些基本的操作进行二次封装，代码复用性很好。
"""
import abc


""" 命令接收者，负责执行命令 """
class Receiver(object):

    def start(self):
        print("Virtual machine start")

    def stop(self):
        print("Virtual machine stop")

""" 命令抽象类 """
class Command(object, metaclass=abc.ABCMeta):

    @abc.abstractmethod
    def execute(self):
        pass

""" 开机命令类 """
class StartVmCommand(Command):

    def __init__(self, recevier):
        self.recevier = recevier

    def execute(self):
        self.recevier.start()

""" 停机命令类 """
class StopVmCommand(Command):

    def __init__(self, recevier):
        self.recevier = recevier

    def execute(self):
        self.recevier.stop()

""" 命令调用者，发起命令 """
class ClientInvoker(object):

    def __init__(self, command):
        self.command = command

    def do(self):
        self.command.execute()


if __name__ == '__main__':
    recevier = Receiver()
    start_command = StartVmCommand(recevier)

    client = ClientInvoker(start_command)       # 命令调用者同时也是客户端，通过命令实例也执行真正的操作
    client.do()

    stop_command = StopVmCommand(recevier)      # 能告诉命令接收者执行不同的操作
    client.command = stop_command
    client.do()