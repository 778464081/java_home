- 什么是JSP 
    Java Server Page 动态网页技术（现在基本没人用）
    
- JSP的本质：Servlet
  
- JSP中可以存在什么东西
    - 指令： <%@ 指令名称 属性1=值1,属性2=值2,属性3=值3...%>
    - html代码、注释
    - 声明 ： Java 代码 : 成员存在。形式：<%! 声明内容 %>
    - JS：JavaScript
    - EL表达式: 形式：${1+1}
    - 表达式 ： <%=表达式内容%> , 定义在service方法中
    - JSP注释 <%-- 注释内容 --%>
    - Java代码 ： <% Java代码 %>

- 指令（了解）
    形式： <%@ 指令名称 属性1=值1,属性2=值2,属性3=值3...%>
    有且仅有三个！
    - page
      ```
        isErrorPage : 指定当前页面是一个错误页面，错误通常指的是 500，服务器方面的错误。
        contentType : 用于指定响应报头 
        extends : 继承
        import : 用于导入包中的类
        isELIgnored : 是否忽略EL表达式
        buffer : 缓冲区，默认大小8kb。 缓冲区大小可以自由设置，但是如果设置为0，那么autoFlush就必须设置为true。
        autoFlush : 是否自动刷出
        pageEncoding : 当前页面的编码
        session : 如果设置成false，则不启用session
      ```
    - include : 包含 , 已经没有人使用了。
        ```
          1. 是否可以包含图片 ?
          2. 是否可以包含其他的jsp页面 ? 
          3. 是否可以包含 html页面 ？ 
          4. 是否可以包含 .txt 文件 ？
        ```
    - taglib ： 引入对应的标签库
    
    

- 内置对象（自行查阅）
    声明在service方法中的内置对象：page、pageContext、config、request、response、session、application、out、exception
    如果想要查看exception，就需要在指令中指定 isErrorPage="true"
    
- EL表达式 ： 本质 字符串 ，只不过是有类进行了解析，才可以达到效果。

    字段和属性 ： 自己总结
    
    保留字：
    ```
    and eq gt true no lt empty instanceof
    or ne le false ge null div mod
    ```
  
  EL的内置对象 ： 
  ```
    pageContext : 用于获取其他对象（request、session、response）
    pageScope ： 对应 pageContext 所属的范围，其中，可以用户存取数据（setAttribute）
    requestScope ： 对应 request 所属的范围，其中，可以用户存取数据（setAttribute）
    sessionScope ： 对应 session 所属的范围，其中，可以用户存取数据（setAttribute）
    applicationScope ： 对应 application 所属的范围，其中，可以用户存取数据（setAttribute）
  ```
    如果存储了相同的名称，那么获取数据的时候，从小到大。
  
  EL表达式中可以写表达式( 简单的表达式 ) 
  
  EL运算符：
  ```
  Addition: +、
  Substraction: -、
  Multiplication: *、
  Division: /、 div、
  Remainder: % 、 mod、
  == ：eq、
  !=：ne、
  < ： lt、
  >：gt、
  <=：le、
  >=: ge、
  &&：and、
  ||：or、
  !：not
  ```

- 标准标签库
    需要引入对应的标准标签库：c
    set标签和remove标签
    if标签
    foreach标签

- 练习1 ：用 JSP + Servlet 实现 登录、注册、注销、获取列表 操作即可 。可选操作：增加、删除、修改
- 练习2  ： 实现隔行换色