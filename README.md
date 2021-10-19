### 拦截器
#### 概述
Spring MVC的拦截器类似于Servlet开发中的过滤器Filter，用于处理器进行预处理和后处理。开发者可以自己定义一些拦截器来实现特定功能。
过滤器与拦截器的区别：拦截器是AOP思想的具体应用。
- 过滤器
    - servlet规范中的一部分，任何java web工程都可以使用
    - 在url-pattern中配置了/*之后，就可以对所有访问的资源进行拦截
- 拦截器
    - 拦截器是Spring MVC框架自己的，只有使用了SpringMVC框架的工程才能使用
    - 拦截器只会拦截访问的controller控制器方法，如果访问的是jsp/html/css/image/js是不会进行拦截的 （静态资源过滤）
#### 自定义拦截器
想要自定义拦截器，必须实现HandlerInterceptor接口。
1. 新建一个Module，springmvc-07-Interceptor，添加web支持
2. 配置web.xml和applicationContext.xml文件
3. 编写一个拦截器MyInterceptor.java
4. 重新部署后访问：http://localhost:8080/springmvc_07_interceptor_war_exploded/hello，此时可以看到Tomcat Server日志打印如下。
说明了拦截器的实际执行顺序。
```plain/text
============== preHandle() 处理前 ==============
TestController => hello()请求执行了
============== postHandle() 处理后 ==============
============== afterCompletion() 清理 ==============
```
* ！！！ 拓展学习AOP的3中实现方式，横切（注解，类写，实现Spring类接口来实现）。拦截器是AOP的一种实现方式，自己用AOP横切写应该也要能实现。
PS: AOP直接横切bean的方法，interceptor这里实在controller中应用拦截请求路径
