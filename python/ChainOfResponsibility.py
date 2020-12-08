"""
责任链模式
    将被请求的对象连成一条链，沿着链传递请求，直到有一个对象处理它为止；
    使得多个对象都有机会处理请求，从而避免请求的发送者和接收者之间有耦合关系；
    有多个对象可以处理一个请求、或对请求接收者不明确时，最终处理请求的对象在运行时可以自动确定

    在本例中，通过一个请求 API 逐级向上递交资金审批流程，直到可以被某级对象处理为止
"""


""" 处理者基类 """
class BaseHandler(object):

    def successor(self, successor):
        self._successor = successor

""" 第一级请求处理者类 """
class RequestHandlerL1(BaseHandler):
    name = "TeamLeader"

    def handle(self, request):
        if request < 500:
            print("审批者[%s]，请求金额[%s]，审批结果[审批通过]" % (self.name, request))
        else:
            print("\033[31;1m[%s]无权审批，交给下一个审批者\033[0m" % self.name)
            self._successor.handle(request)

""" 第二级请求处理者类 """
class RequestHandlerL2(BaseHandler):
    name = "DeptManager"

    def handle(self, request):
        if request < 5000:
            print("审批者[%s]，请求金额[%s]，审批结果[审批通过]" % (self.name, request))
        else:
            print("\033[31;1m[%s]无权审批，交给下一个审批者\033[0m" % self.name)
            self._successor.handle(request)


""" 第三级请求处理者类 """
class RequestHandlerL3(BaseHandler):
    name = "CEO"

    def handle(self, request):
        if request < 10000:
            print("审批者[%s],请求金额[%s]，审批结果[审批通过]" % (self.name, request))
        else:
            print("\033[31;1m[%s]要太多钱了，不批\033[0m" % self.name)
            # self._successor.handle(request)


""" 请求 API 类 """
class RequestAPI(object):
    h1 = RequestHandlerL1()
    h2 = RequestHandlerL2()
    h3 = RequestHandlerL3()

    h1.successor(h2)        # 指定下一级处理者（领导）
    h2.successor(h3)

    def __init__(self, name, amount):
        self.name = name
        self.amount = amount

    def handle(self):
        """
        统一请求接口
        :return:
        """
        self.h1.handle(self.amount)


if __name__ == "__main__":
    r1 = RequestAPI("YWH", 30000)
    r1.handle()
    print(r1.__dict__)