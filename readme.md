该项目是一个利用Maven构建的多maven模块的Springboot项目，列举出用到的东西。

1.maven的多模块工程构建
2.springboot整合MyBatis
    (1).xml格式的  (2). 注解形式
3.springboo整合Swagger
4.加入Filter和Mockmvc测试
5.增加了Vaild和BingResult参数校验
6.Springboot整合了Druid数据源  访问 http://localhost:8888/maven-modules/druid 可以查看对应的数据库的监控
7.完美集成Redis
8.集成Aop:
    execution()是最常用的切点函数，其语法如下所示：
    
        整个表达式可以分为五个部分：
    
        1、execution(): 表达式主体。
    
        2、第一个*号：表示返回类型， *号表示所有的类型。
    
        3、包名：表示需要拦截的包名，后面的两个句点表示当前包和当前包的所有子包，com.sample.service.impl包、子孙包下所有类的方法。
    
        4、第二个*号：表示类名，*号表示所有的类。
    
        5、*(..):最后这个星号表示方法名，*号表示所有的方法，后面括弧里面表示方法的参数，两个句点表示任何参数
