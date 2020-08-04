# 1 认知Servlet

## 1-1 Servlet的组成

**Java Servlet：**

​		Servlet 是一个基于 Java 技术的 Web 组件，运行在服务器端，由 Servlet 容器所管理，用于生成动态的内容。Servlet 是平台独立的 Java 类，开发一个 Servlet，实际上就是按照Servlet 规范编写一个 Java 类。Servlet 被编译为平台独立的字节码，可以被动态地加载到支持 Java 技术的 Web 服务器中运行。

**Filter：**

​		与 Servlet 不同，Servlet 规范中的 Filter 并不能处理用户请求，也不能对客户端生成响应。 主要用于对请求进行预处理，也可以对响应进行后处理，是个典型的处理链。

**Listener：**

​		Servlet 规范中的 Listener 是通过观察者设计模式进行实现的，用来监听 Web 服务器中的各种事件，比如与生命周期有关的事件、与属性操作有关的事件的。

## 1-2 Servlet 容器

​	Servlet 不能独立运行，它必须被部署到 Servlet 容器中，由容器来实例化和调用 Servlet的方法，Servlet 容器在 Servlet 的生命周期内包容和管理 Servlet。

如非特别说明，本书中所使用的 Servlet 容器、JSP 容器、Web 容器、容器均指 Apache Tomcat 。

## 1-3 Servlet 接口

**javax.servlet.Servlet** 接口是所有 Servlet 类必须实现的接口，在该接口中定义了所有 Servlet 都必须实现的 5 个方法。

```java
public interface Servlet {
 /**
当容器加载 Servlet 实现类并完成实例化后，调用该方法完成初始化操作。
容器通过该方法的参数向 Servlet 实例传递信息。
当需要在处理客户端请求之前完成某些准备工作时，可以在该方法内部实现。
容器必须保证正确执行初始化方法(init)后，才能调用 Servlet 实例的 service 方法。
 */
 public void init( ServletConfig config ) throws ServletException;
 //容器通过调用 service 方法来接收客户端的请求并做出响应。
 public void service( ServletRequest request , ServletResponse response )
 throws ServletException, IOException;
 //当容器检测到一个 Servlet 实例应该从服务器中被移除时，会调用该对象的 destory 方
法，以便释放由该 Servlet 实例所占用的资源。
 public void destroy();
//该方法返回关于当前 Servlet 的描述信息，可以由实现者来指定返回的内容。
 public String getServletInfo();
//该方法返回由 init 方法传入的 ServletConfig 对象。
 public ServletConfig getServletConfig();
 }
```

## 1-4 Servlet 实现类

​	javax.servlet 包中还定义了 **GenericServlet** 类，该类实现了javax.servlet.**Servlet 接口**中的大部分方法**，唯一未实现的方法是 service 方法**。同时GenericServlet 类还实现了 javax.servlet.ServletConfig 接口java.io.Serializable 接口。

```java
public abstract class GenericServlet 
 implements Servlet , ServletConfig , java.io.Serializable {
 
 private static final long serialVersionUID = 1L;
 
 private transient ServletConfig config;
 
 public GenericServlet() { /* NOOP */ }
 
 @Override
 public String getInitParameter(String name) {
 return getServletConfig().getInitParameter(name);
 }
 
 @Override
 public Enumeration<String> getInitParameterNames() {
 return getServletConfig().getInitParameterNames();
 }
 
 @Override
 public ServletConfig getServletConfig() { return config ; }
 
 @Override
 public ServletContext getServletContext() {
 return getServletConfig().getServletContext();
 }
 
 @Override
 public void init( ServletConfig config ) throws ServletException {
 this.config = config;
 this.init();
 }
 /*根据 JavaEE 规范，GenericServlet 类增加了一个无参数的 init 方法
 该方法不带任何参数，在 GenericServlet 类中该方法不做任何操作(NOOP)。
当某个继承 GenericServlet 类的类需要完成初始化操作时，可以重写该方法。该方法由
另一个带参数的 init(ServletConfig)方法来调用。*/
 public void init() throws ServletException { /* NOOP by default */ }
 
 public void log( String msg ) {
 getServletContext().log(getServletName() + ": " + msg);
 }
 
 public void log( String message , Throwable t ) {
 getServletContext().log(getServletName() + ": " + message, t);
 }
 
 @Override
 public abstract void service( ServletRequest req , ServletResponse resp )

 throws ServletException , IOException ;
 
 @Override
 public void destroy() { /* NOOP by default */ }
 
 @Override
 public String getServletName() { return config.getServletName(); }
 
 @Override
 public String getServletInfo() { return ""; }
    
 }
```

 	**javax.servlet.http 包**中还定义了采用 HTTP 通信协议的 **HttpServlet 类**，该类继承GenericServlet 类并实现了 service(ServletRequest,ServletResponse)方法，并在其中定义了与 HTTP 协议中的 DELETE、GET、OPTIONS、POST、PUT、TRACE 等请求方式对应的 doDelete()、doGet()、doOptions()、doPost(),、doPut()、doTrace()等方法。

​		需要特别注意的是在 javax.servlet.http.HttpServlet 类中有两个 service 方法:

```java
protected void service( ServletRequest request , ServletResponse response ) 

protected void service( HttpServletRequest request, HttpServletResponse response )
```

当客户端访问相应的 Servlet程序时，容器在保证 Servlet实例完成初始化操作的前提下，随后会调用service(ServletRequest,ServletResponse)方法，再由该方法调用另外一个 service方法。

## 体系结构

![](C:\Users\要不要买菜\Desktop\java-advence\Servlet\Snipaste_2020-07-13_10-14-36.jpg)



## 1-5 请求形式

表单form

超链接

AJAX

```java
var $http = new XMLHttpRequest();
$http.open( "GET" , "http://wd.malajava.org/learner/verify/sign/in" ) ;
$http.send( null );
```

# 2 开发Servlet程序

​	所谓开发 Servlet 程序，就是创建实现了 javax.servlet.Servlet 接口的类。因此一个 Servlet 程序的本质就是一个特殊的 Java 类，这些类的特点是: 

​		• 它们都不是独立的应用程序，都没有 main 方法。

​		• 它们都不能直接运行，而是生存在 Servlet 容器内，由容器管理来管理它们。

​		• 它们都有自己的生命周期，都包含了 init 方法和 destory 方法。

​		• 它们都有一个 service 方法用来响应客户端请求。

## 2-1 四种开发方法

刀耕火种:实现 Servlet 接口的所有抽象方法

擒贼擒王:继承 GenericServlet 类并重写 service 方法

分而治之:继承 HttpServlet 类并重写 doGet 和 doPost 方法

殊途同归:继承 HttpServlet 类并重写 service 方法



## 2-2 三种部署方式

 **通过 web.xml 实现部署**

```xml
<servlet>
<servlet-name>primitiveServlet</servlet-name>
<servlet-class>org.malajava.servlet.PrimitiveServlet</servlet-class>
</servlet>

<servlet-mapping>
<servlet-name>primitiveServlet</servlet-name>
<url-pattern>/primitive</url-pattern>
</servlet-mapping>
```

 **通过@WebServlet 注解实现部署**

```java
@WebServlet("/primitive")
//等于
@WebServlet ( urlPatterns="/primitive" ) //urlPatterns 与value等效
```

 **通过 ServletContext 动态部署**

ServletContext 接口中定义了以下不同形式的 addServlet 方法:

```java
public ServletRegistration.Dynamic addServlet( String servletName , String className )
```

该方法中:

第一个参数为 Servlet 名称，作用相当于 web.xml 中的<servlet-name>；

第二个参数 className 为 Servlet 实现类的全限定类名，作用相当于 web.xml 中的<servlet-class>。



```java
public ServletRegistration.Dynamic addServlet( String servletName , Servlet servlet )
```

该方法中:

第一个参数为 Servlet 名称，作用相当于 web.xml 中的<servlet-name>；

第二个参数 servlet 为 Servlet 实现类的实例(需要手动创建 Servlet 实现类的实例)。



```java
public ServletRegistration.Dynamic addServlet( String name , Class<? extends Servlet> sc )
```

该方法中:

第一个参数为 Servlet 名称，作用相当于 web.xml 中的<servlet-name>；

第二个参数为 Servlet 实现类对应的 Class 对象( 通过 "类名.class" 来获取 )。



```java
@WebListener
 public class ApplicationListener implements ServletContextListener {
 
 /** 当容器加载当前 Web 应用时，执行该方法 */
 public void contextInitialized(ServletContextEvent event) {
 ServletContext application = event.getServletContext();
 
 // 向容器注册名称为 generalServlet 的 servlet
 Dynamic d = application.addServlet( "generalServlet" , GeneralServlet.class );
 // 为新注册的 servlet 建立 URL 映射
 d.addMapping( "/general" );
 
 }
 
 /** 当容器卸载当前 Web 应用时，执行该方法 */
 public void contextDestroyed(ServletContextEvent sce) {
	 }
 
 }
```

# 3 理解请求/响应过程

## 3-1 创建请求对象和响应对象

​	容器在确定访问哪个 servlet 后，在确保该 servlet 实例已经完成初始化的前提下调用该

servlet 实例的 service 方法来处理客户端的请求。而**被调用的 service 方法需要接收两个参数，即 request 和 resposne ，**因此必须在容器调用 service 方法之前就将这两个参数对应的对象创建好。

因此，在**从接收到请求到容器调用 servlet 实例的 service 方法之前**，完成了以下操作:

(1) **解析 HTTP 请求**( parse HTTP request )：

​	容器解析 HTTP 请求，并根据客户请求的 URL 来确定用户访问的是哪个 Web 应用，确定用户访问哪个 servlet 

(2) **创建请求对象**( create an instance of HttpServletRequest )：

​	容器解析 HTTP 请求后会创建一个表示该请求的 HttpServletRequest 对象，该对象中包含了 HTTP 请求中的所有数据。

(3) **创建响应对象**( create an instance of HttpServletResponse )：

​	容器通过解析 HTTP 请求可以确定需要向哪个用户做出回应，随后容器会创建一个HttpServletResponse 对象，该对象用来收纳向用户回应的信息。



## 3-2 获取请求数据并报头响应数据

**随后，容器会调用 servlet 实例的 service 方法，在该方法内部，完成以下操作**

(1) **从请求中获取数据**( get request information )

​	通过由参数传入的 HttpServletRequest 对象，可以获取 HTTP 请求中所包含的所有数据，这些数据包括请求方式、URI、请求协议、请求报头、请求正文等，

​		**主要是通过 getParameter 方法来获取表单中的数据:**

```java
String username = request.getParameter( "username" ); 
String password = request.getParameter( "password" );
```

(2) **向响应对象中输出数据**( output response information )

​	通过由参数传入的 HttpServletRespone 对象可以向客户端发送数据，这些信息包括响应状态代码、响应状态描述信息、响应报头、响应正文等，

​		通过 setContentType 方法设置发送到客户端的响应的内容类型，以即其编码方式:

```java
response.setContentType( "text/html;charset=UTF-8" );
```

它等同于 **setHeader( "content-type" , "text/html;charset=UTF-8" )** ，用于预先"告知"浏览器本次发送的内容的类型和字符编码方式。

​	通过响应对象获取了一个字符输出流:

```java
PrintWriter w = response.getWriter() ;
w.println( "<h1 align='center'>" );
w.println( "欢迎" + username );
w.println( "<h1>" );
/*注意：println 打印的是字符，write 打印的是其字节 */
```

确切地说，这个输出流并不是直接向客户端直接输出数据，而是将数据输出到由容器管理的、与当前 response 对象对应的内存当中。

## 3-3 向客户端返回响应数据

**向客户端返回响应数据**

​	当 servlet 实例的 service 方法执行结束后，容器会将 HttpServletResponse 对象中所包含的所有数据封装成 HTTP 响应( encapsulation HTTP response )，并由容器向发起请求的客户端发送 HTTP 响应( send HTTP response )

![](C:\Users\要不要买菜\Desktop\java-advence\Servlet\Snipaste_2020-07-14_17-03-37.jpg)

# 4  Servlet 生命周期

## 4-1 容器对Servlet 的两种处理方式

**懒惰的处理方式：**

​		只有在有客户端请求 Servlet类 时，容器才加载 Servlet 类，随后创建 Servlet 类的实例并调用该实例的 init 方法完成初始化操作，最后再通过 service 方法向客户端做出响应。

在默认情况下 Servlet 的生命周期:

a) 当某个 Servlet 首次被访问时，容器完成以下操作: 

​	• 加载相应的 Servlet 类 

​	• 创建相应的 Servlet 实例

​	• 调用已创建的 Servlet 实例的 init 方法完成初始化操作

b) 无论是第一次被访问还是后续访问，都通过 service 方法来响应客户端请求

​	• service 方法必须是在 init 方法正确执行完成后才能执行

c) 等到容器认为不再需要某个 Servlet 实例时，容器会调用该实例的 destory 方法

​	• 调用 destory 方法的主要目的是为了释放由该 Servlet 实例所占用的资源

​	• 调用 destory 的时机可能是容器重新加载或卸载当前 Web 应用时

d) 卸载相应的 Servlet 类 

​	• 当某个类不再被使用时 JVM 将卸载这个类并回收相应的内存

​	• 卸载某个类在本例中无法通过代码来体现(需要结合类的生命周期来理解)

**积极的处理方式：**

​		容器启动时，就会加载servlet类，，随后创建 Servlet 类的实例并调用该实例的 init 方法完成初始化操作，容器在接收到客户端请求后只需要调用 service 方法



可通过@WebServlet( urlPatterns = "/prepared.do" , loadOnStartup = 1 )的loadOnStartup来设置处理方式，默认值为-1；

loadOnStartup 的主要作用是: 

​	• 告知容器在加载当前 Web 应用时就加载该类并完成实例化、初始化操作。

​	• 同时 loadOnStartup 属性的取值越小，容器越优先加载该 Servlet 。

​	简单来说，当 loadOnStartup 属性的取值为非负数时，容器会在加载当前 Web 应用时就初始化该 Servlet。而当存在多个 Servlet 都需要在容器加载当前 Web 应用时完成初始化操作时，loadOnStartup 的取值较小的 Servlet 的会优先被加载并初始化。

## 4-2 总结 Servlet 生命周期

**(1) 加载类**

​		容器会根据 loadOnStartup 的设置来确定什么时候加载 Servlet 类并完成实例化、初始化等操作。当 loadOnStartup 的取值为非负数时，容器会在加载该 Web 应用时就加载相应的 Servlet 类。容器从加载某个 Web 应用到卸载该 Web 应用这段时间内，该 Web 应用内的一个 Servlet类只加载一次。

**(2) 实例化**

​		容器在加载 Servlet 类后会创建该 Servlet 类的实例。

**(3) 初始化**

​		容器创建 Servlet 实例后，随即调用该 Servlet 实例的 init 方法完成初始化操作。通过 init方法，容器可以向该 Servlet 实例传递数据

**(4) 提供服务**

​		当客户端通过指定的 URL 向容器发起请求时，容器会根据接收到的请求，确定访问哪个Web 应用的哪个 Servlet，然后由容器调用该 Servlet 实例的 service 方法向客户端提供服务。

**(5) 销毁实例**

​		当容器卸载某个 Web 应用时，会先销毁该 Web 应用中所有的 Servlet 实例。销毁 Servlet实例时会调用 Servlet 实例的 destory 方法。

**(6) 卸载类**

​		当容器卸载某个 Web 应用时，会销毁其中所有的 Servlet 实例，在 Servlet 实例被销毁后，相应的 Servlet 类将不再被引用，此时容器会卸载这些 Servlet 类。

# 5 ServletConfig 

​		在初始化阶段，容器会通过 init 方法的 ServletConfig 参数向 Servlet 传递数据。

```java
public void init( ServletConfig config ) throws ServletException
```

## 5-1 ServletConfig 接口

```java
public String getServletName();
```

​	用于获取 Servlet 的名称，该方法返回的 Servlet 名称与 web.xml 中<servlet-name>标 记的内容或@WebServlet 注解的 name 属性值相同。

```java
public ServletContext getServletContext();
```

​	该方法用于获取 ServletContext 对象。ServletContext 对象通常被称作 servlet 上下文对象，在 servlet 程序运行阶段，可以通过 ServletCotnext 对象来访问当前 Web 应用内部的相关资源。

```java
public String getInitParameter(String name);
```

​	根据指定初始化参数名称获取该初始化参数的值。

```java
public Enumeration<String> getInitParameterNames();
```

​	获取容器向当前 Servlet 实例传递的所有初始化参数的名称。



​		容器在调用 Servlet 实例的 init 方法之前，会先创建一个 ServletConfig 类型的对象，该 对象内部包含了容器需要向 Servlet 传递的数据，故而可以在 Servlet 实例的 init 方法内可以通过 ServletConfig 对象获取由容器传递的数据。

## 5-2 Servlet 初始化参数

​	容器通过 ServletConfig 对象向 Servlet 实例传递的数据中，主要是由用户指定的初始化参数，这些初始化参数可以通过 web.xml 和注解两种方式来指定。

**在 web.xml 中指定 Servlet 初始化参数**

```xml
<servlet>
<servlet-name>ConfigurationServlet</servlet-name>
<servlet-class>org.malajava.servlet.ConfigurationServlet</servlet-class>
<init-param>
<param-name>charsetName</param-name>
<param-value>UTF-8</param-value>
</init-param>
</servlet>

<servlet-mapping>
<servlet-name>ConfigurationServlet</servlet-name>
<url-pattern>/config.do</url-pattern>
</servlet-mapping>
```

**在@WebServlet 注解中指定 Servlet 初始化参数**

```java
 @WebServlet( value = "/init.do" ,
	initParams = @WebInitParam( name = "charsetName" , value = "UTF-8" ) 
      )
```

<img src="C:\Users\要不要买菜\Desktop\java-advence\Servlet\Snipaste_2020-07-14_19-27-55.jpg" style="zoom:150%;" />

# 6  处理Servlet 请求

 ## 6-1 HTTP 请求

​	通常，一个 HTTP 请求由请求行(起始行)、请求头(首部)、空行、请求体(实体)等四部分组成，图 4-1 中展示了这四个部分的组成结构。

![](C:\Users\要不要买菜\Desktop\java-advence\Servlet\Snipaste_2020-07-14_19-30-45.jpg)

### 6-1-1 请求行

​	HTTP 请求报文的起始行是一个 HTTP 请求报文中的第一行，因此也被称作请求行( Request Line )，其主要作用是用来说明请求方式、将要访问的资源、以及所使用的协议，

其一般形式为:

​		Method Request-URL Protocol

比如:

​		GET /servlet/config.do HTTP/1.1

其中: 

​	 GET 表示客户端发送请求时所采用的请求方式

​	 /servlet/config.do 是客户端所访问资源路径

​	 HTTP/1.1 表示本次请求是基于 HTTP 协议发送的

#### 6-1-1-1 请求方式

​	请求方式也称为动作，用来表明对特定资源的操作方式。在 HTTP 1.0 中定义了三种请求方式：GET、POST、HEAD ，而 HTTP 1.1 中则新增了五种请求方式: OPTIONS、PUT、DELETE、TRACE、CONNECT。

1. **GET**

   ​	GET 动作用于获取资源，当采用 GET 方式请求指定资源时，被访问的资源经服务器解析后立即返回响应内容。通常以 GET 方式请求特定资源时，请求中不应该包含请求体，所有需要向被请求资源传 递的数据都应该通过 URL 向服务器传递。比如:http://localhost:8080/goods/list?type=6&status=valid其中?之后的 type=6&status=valid 就是向 http://localhost:8080/goods/list 发送的数据，这部分通常被称作 QueryString (中文称作查询字符串)。 在 QueryString 中，参数名称和参数值之间使用等号连接，比如 type=6。多个参数之间使用&符号连接，比如:type=6&status=valid另外，需要特别注意 QueryString 并不属于请求体。

2. **POST** 

   POST 动作用于提交数据，当采用 POST 方式向指定位置提交数据时，数据被包含在请求体中，服务器接收到这些数据后可能会建立新的资源、也可能会更新已有的资源。同时 POST 方式的请求体可以包含非常多的数据，而且格式不限。因此 POST 方式用途较为广泛，几乎所有的提交操作都可以使用 POST 方式来完成。虽然用 GET 方式也可以提交数据，但一般不用 GET 方式而是用 POST 方式。在 HTTP协议中，建议 GET 方式只用来获取数据，而 POST 方式则用来提交数据(而不是获取数据)。

**3. PUT**

​	PUT 动作用于向指定位置提交数据，当采用 PUT 方式向指定位置提交数据时，数据被包含在请求体中，服务器接收到这些数据后直接在当前位置(即提交数据时指定的位置)创建新的资源。PUT 方式和 POST 方式极为相似，都可以向服务器提交数据，但 PUT 方式通常指定了资源的存放位置(即提交数据时指定的位置)，而 POST 方式所提交的数据由服务器决定存放位置(可能是新增数据，也可能是更新数据)。 在 HTTP 规范中，建议 PUT 方式只用来创建新的资源。

4. **DELETE**

   DELETE 动作用于删除特定位置的资源。采用 DELETE 方式访问特定位置的资源时，服务器接受到请求后会删除当前位置对应的 资源。

5. **HEAD**

   HEAD 动作用于获取响应头，采用 HEAD 方式请求指定资源时，被访问的资源经服务器解析后立即返回响应，但返回的响应中仅包含状态行和响应头，不包含响应体。HEAD 动作通常用于完成测试 URI 的有效性、获取资源更新时间等操作。

6. **TRACE**

   TRACE 动作用于回显服务器收到的请求，主要用于测试或诊断。

7. **OPTIONS**

OPTIONS 动作用于查询服务器针对特定资源所支持的 HTTP 请求方式，即询问客户端可以以那些方式来请求相应的资源，同时使用 OPTIONS 方式也可以用来测试服务器的性能。

8. **CONNECT**

   CONNECT 动作要求在与代理服务器通信时建立隧道，实现用隧道协议进行 TCP 通信。主要使用 SSL（安全套接层）和 TLS（传输层安全）协议把通信内容加密后经网络隧道传输。尽管 HTTP 协议中定义了以上八种不同的动作(请求方式) 来表明对特定资源的操作方式，但遗憾的是，在主流浏览器中并不能完全支持这八种动作(请求方式)，因此我们在 Web开发中所使用的请求方式仍然以 GET 和 POST 为主。

### 6-1-2 请求头

​	请求头可以由多个不同的部分组成，每个部分被称作一个字段，每个字段都由名称和取值两部分组成:

字段名称 : 字段值

比如:

​	Accept: image/gif.image/jpeg,*/*

​	Accept-Language: zh-cn

​	Connection: Keep-AliveHost: localhost

​	User-Agent: Mozila/4.0(compatible;MSIE5.01;Window NT5.0)

​	Accept-Encoding: gzip,deflate

#### 6-1-2-1 常用请求头字段

1. Host

   Host 用于声明当前请求所访问的服务器 在 Host 请求报头中不仅仅包含了当前请求所访问服务器地址，也包含了被访问的服务器程序对应的端口号。比如 Host : localhost:8080 。

2. Content-Type

   Content-Type 用于声明当前请求所提交内容的 MIME 类型通常在使用 POST 方式发起请求时才会考虑设置 Content-Type 请求报头。Content-Type 请求报头不仅用来声明当前请求所提交内容的类型，也决定客户端程序对当前请求所提交内容的编码方式。

   Content-Type 请求报头的取值可以是以下类型: 

   ​	application/x-www-form-urlencoded

   ​	multipart/form-data

   ​	text/plain

3. Content-Length 

   Content-Length 用于声明当前请求所提交内容的长度

4. Accept 

   Accept 用于声明客户端程序能够处理的 MIME 类型对于能够以多种格式返回某种资源的服务器程序，可以通过检查 accept 请求报头来确定应该使用哪种格式。比如 HelloServlet 返回的内容可以是纯文本格式，也可以是 HTML 文档格式，当请求报头中的 accept 报头为 text/html 时则表示客户端期望返回的 MIME 类型为 text/html，则HelloServlet 应该向该客户端返回 HTML 文档格式。

5. Accept-Encoding

   Accept-Encoding 用于声明客户端程序所支持的数据解码方式。通常使用 Accept-Encoding 请求报头指定客户端可以支持的数据解码方式。服务器可以通过检查 Accept-Encoding 请求报头，来确定将数据发送到客户端之前，使用何种编码方式对数据进行压缩，以节约带宽。而 Accept-Encoding 请求报头所设置的就是客户端所能够支持的压缩格式。比如当 Accept-Encoding 请求报头的取值为 gzip 时，就表示客户端支持以 gzip 方式进行解压，因此服务器在发送数据给客户端之前可以使用 gzip 方式对数据进行压缩。

6. Accept-Language

   Accept-Language 用于声明客户端程序所支持的语言当被请求的服务器提供多语言支持时，可以通过设置 Accept-Language 请求报头来声明期望服务器返回的语言类型，比如 Accept-Language : zh-CN 表示期望服务器返回简体中文。

7. Connection

   keep-alive 当浏览器与服务器通信时对于长连接如何进行处理：close/keep-alive 

8. Cookie

   Cookie 报头用于向服务器回传 cookie 数据。

9. Referer

   Referer 用于向服务器回传当前页面的来源(通常是一个网址)，用来用来反应从哪里跳转到了当前页面。

10. Pragma

    no-cache(兼容 http1.0, 在 http/1.1 协议中，它的含义和 cache- control:no-cache 相 

同) 

11. upgrade-insecure-request:1 

    如果在 https 的页面需要加载 http 的资源，那么浏览器就会报错或者提示，为了促进用 户升级协议，同时不需要网站开发者劳师动众地把整个网站的 http 资源改成 https 资源，chrome 增加一个 Upgrade-Insecure-Requests: 1 头，告诉服务器，浏览器可以处理 https协议，然后服务器返回 Content-Security-Policy: upgrade-insecure-requests 响应头，或者通过 meta 响应头设置，告诉浏览器，对于页面的 http 资源，请求时可以自动升级到 https，比如在 https 的网站上有一张图片 url 是 http://localhost/1.jpg，浏览器请求时会把 url 变 成 https://localhost/1.jpg，所以这里首先需要服务器在端有相对应的资源。但是有一种情况例外，那就是 https 网站中 a 标签对应的外站资源不会被升级，比如 a 网站有一张 b 网站的链接，那么这个链接对应的 url 不会升级

12. User-Agent

    客户端信息（操作系统、浏览器及版本、浏览器渲染引擎等）

### 6-1-3 请求体

​	请求体( Request Body )，也被称作请求正文或实体，它位于 HTTP 请求的最后一部分，与请求头之间使用空行进行分隔。请求体中的数据可以是字符数据，也可以是字节数据。

​	通常，我们采用 GET 方式访问指定资源时，并不会在 HTTP 请求中包含请求体，此时如果需要向被访问资源传递数据，一律通过 QueryString 方式实现，通常可以通过点击超链接或以 GET 方式提交表单来实现。

#### 6-1-3-1 字符数据

​	采用 POST 方式向指定位置提交数据时，被提交的数据包含在 HTTP 请求的请求体中，而当请求报头中 content-type 字段的取值为 application/x-www-form-urlencoded 时，在请求体中所包含的是字符数据，其形式为：

​		name1=value&name2=value2

当 content-type 取值为 text/plain 时，在请求体中所包含的也是字符数据，其形式为:

​	name1=value

​	name2=value2

此时，请求体中的每一行对应一条数据，每条数据的名称和取值使用等号连接。

#### 6-1-3-2 字节数据

​	采用 POST 方式向指定位置提交数据时，当请求报头中 content-type 字段的取值为multipart/form-data 时，在请求体中所包含的是字节数据，此时如果将这些字节数据转换为文本格式，则其形式为:

```java
 ------WebKitFormBoundary2E4jNhSZJ5vcXQhv
 Content-Disposition: form-data; name="表单控件名称"
 
 数据
 ------WebKitFormBoundary2E4jNhSZJ5vcXQhv
 Content-Disposition: form-data; name="表单控件名称"; filename="文件名称"
 Content-Type: text/plain
 
 数据
 ------WebKitFormBoundary2E4jNhSZJjava5vcXQhv--
```

​	当请求报头中 content-type 字段的取值为 multipart/formdata 时，请求体中的数据被划分成若干个不同的部分，比如第 2 行到第 4 行是一部分数据，而第 6 行到第 9 行则表示另外一部分数据，他们之间使用特殊的符号(比如第 5 行的内容)为分隔符。而每一部分数据中，又通过空行(第 3 行和第 8 行)分割为两个部分，即请求头和数据两部分。

## 6-2 ServletRequest

​		容器在解析 HTTP 请求后，将 HTTP 请求中的数据映射到新创建的 ServletRequest 对象中，再将该对象传递给相应 Servlet 实例的 service 方法。因此 ServletRequest 对象中包含了 Web 客户端向 Servlet 程序发送的数据

### 6-2-1 ServletRequest接口

常用方法：

1、获取协议

```java
public String getProtocol() ;
```

2、获取请求头

```java
public String getContentType();
//	该方法用于从请求头中获取名称为 content-type 的字段值。
```

```java
public int getContentLength();
//该方法用于从请求头中获取名称为 content-length 的字段值
```

```java
public long getContentLengthLong();
//该方法是 Servet 3.1 中新增的用于获取 content-length 字段取值的方法。
```

3、获取请求参数

```java
public String getParameter( String name )
       // 该方法用于从请求对象中获取指定参数名称(name)对应的单个参数值.
```

```java
public Enumeration<String> getParameterNames()
        //该方法用于获取请求对象中所有的请求参数名称。
```

```java
public String[ ] getParameterValues(String name)
    //该方法用于从请求对象中获取指定参数名称对应的多个值的方法，当页面上通过同一个名称传递多个取值时，可以使用该方法来获取这些取值(比如页面上的 checkbox)。
```

```java
public Map<String, String[ ]> getParameterMap()
    //该方法用于获取所有请求参数及其取值，其返回类型是 Map，其中 key 为参数名称，value 为参数值。因为同一个参数名称可能对应多个取值，所以这里的 value 是 String 数组类型。
```

4、 读取请求体数据

```java
public BufferedReader getReader()
    //该方法返回一个可以读取请求体中所包含内容的字符输入流，当请求报头中 content-type 字段的取值为 application/x-www-form-urlencoded 或 text/plain 时，可以通过该方法来读取请求体中所包含的字符数据。
```

```java
public ServletInputStream getInputStream()
    //该方法返回一个可以读取请求体中所包含内容的字节输入流，当请求报头中 content-type 字段的取值为 multipart/form-data 时，可以通过该方法来读取请求体中所包含的字节数据。
```

5、字符编码

```java
public void setCharacterEncoding( String e ) throws UnsupportedEncodingException
   //该方法用于设置请求体中使用的字符编码的名称。当需要使用特定字符编码方案来读取请求体中的数据时，必须首先调用该方法来设置目标字符编码方案，之后才可以通过 getParameter 或 getReader 等方法来读取请求体中的数据。否则，若先通过 getParameter 或 getReader 等方法来读取请求体中的数据而不是先设置字符编码方案，则该设置将无效。
```

```java
public String getCharacterEncoding()

//该方法用于获取请求体中使用的字符编码方案的名称。如果从未指定过处理请求体数据时所使用的字符编码方案，则返回 null，此时容器会采用当前默认的字符编码方案来处理请求体中的数据
```

6、 属性操作

```java
public void setAttribute( String attributeName, Object attributeValue ) 
    //该方法用于将指定对象关联到当前请求对象的指定属性上，其中 attributeName 表示属性名称，attributeValue 表示属性值。
public Object getAttribute( String attributeName ) 
//该方法用于从请求对象中获取指定名称的属性的属性值。
public Enumeration<String> getAttributeNames()
//用于从请求对象中获取所有的属性名称。
public void removeAttribute( String attributeName ) 
//该方法用于从请求对象中删除指定的属性。
```



7、 其它

```java
public ServletContext getServletContext();
//该方法是 Servlet 3.0 中为 ServletRequest 新增加的方法，用于获取 ServletContext 对象(中文称作 Servlet 上下文对象)。通常通过ServletContext 对象可以访问整个Web应用内部的资源，因此在很多场合中，都可以将 ServletContext 对象当作整个 Web 应用对应的对象来对待，以至于在 JSP 内置对象中，更是将 ServletContext 对象命名为 application 。
```

## 6-3 HttpServletRequest 接口

​		javax.servlet.http.HttpServletRequest 接口继承了 ServletRequest 接口，它是针对HTTP 协议提供的一个接口，

1. 从请求行获取数据的方法

```java
public StringBuffer getRequestURL();
//用于获取完整的请求路径，包括协议、主机名、端口、资源路径等。
public String getRequestURI();
//用于获取当前请求所访问的资源路径(不包含协议、主机名、端口等)。
public String getMethod();
//用于获取本次请求所采用的请求方式，比如 GET、POST 等。
public String getContextPath();
//用于获取当前 Web 应用对应的路径，比如上一章中 core 工程对应的 /core 。
public String getQueryString();
//当客户端采用 GET 方式请求指定资源时，如果同时向服务器发送了数据，则这些数据被编码到 request-URL 中，该方法即用于获取 request-URL 中的 queryString 部分。
```

2. 从请求头获取数据的方法

```java
public Cookie[ ] getCookies();
//用于从请求头中获取所有的 cookie。
public long getDateHeader( String name );
//用于从请求头中获取指定名称的、用来表示日期和时间的字段取值。
public String getHeader( String name );
//用于从请求头中获取指定名称的字段的单个取值。
public Enumeration<String> getHeaders( String name );
//用于从请求头中获取指定名称的字段的所有取值。
public Enumeration<String> getHeaderNames();
//用于获取请求头中所有的字段名称。
public int getIntHeader( String name );
//以整数形式返回请求头中指定名称的字段的单个取值。
```

3. 从请求体获取数据的方法

```java
public Part getPart(String name) throws IOException , ServletException
//当处理文件上传操作时，使用 getPart 方法可以获得表单中单个<input type="file">对应的 Java 对象，它是一个 Part 类型的对象，其中封装了所上传的文件的内容、名称、类型等信息。
public Collection<Part> getParts() throws IOException , ServletException
//当处理文件上传操作时，使用该方法可以获取文件上传表单中所有的<input type="file">对应的 Part 对象对应的 Collection 集合。
```

## 6-4 获取请求数据

### 6-4-1 获取Http请求行的数据

```java
String method = request.getMethod(); // 请求方法
StringBuffer buffer = request.getRequestURL(); // 被请求资源的路径
String queryString = request.getQueryString(); // 获取 QueryString
if( queryString != null ) { // 如果 QueryString 不为 null
buffer.append( "?" );
buffer.append( queryString ); // 将 QueryString 追加到 request-URL 尾部
}
String url = buffer.toString();
String protocol = request.getProtocol(); // 协议
```

### 6-4-2 获取 HTTP 请求头中的数据

```java
// 获得所有请求报头名称
 Enumeration<String> headerNames = request.getHeaderNames();
 while ( headerNames.hasMoreElements() ) {
 String name = headerNames.nextElement(); // 获取请求头的名称
 String value = request.getHeader( name ); // 根据请求头的名称获取其取值
 System.out.println( name + " : " + value ); // 在控制台输出报头名称和取值
 }
```

​		这里需要注意 java.util.Enumeration 类型，它是一个相当古老的接口，在 JDK 1.2 之前被广泛使用，从 JDK 1.2 开始被 java.util.Iterator 所取代，在 Java 9 中甚至为其增加了asIterator()方法用于将该类型的实例转换为 Iterator 对象。

### 6-4-3 获取 HTTP 请求体中的数据

```java
4 BufferedReader br = request.getReader(); // 获取读取请求正文数据的字符输入流
4 String s = null;
4 while ( ( s = br.readLine() ) != null ) { // 每次从请求正文中读取一行数据
4 System.out.println( s ); // 在控制台输出读取到的数据
5 } 
```

## 6-5 文件上传

​	当一个表单未显式指定 enctype 属性的取值时，其默认值为 application/x-www-formurlencoded，**当需要通过 POST 方式向服务器提交字节数据时，enctype 属性的取值必须为multipart/form-data :**

输出文件：

```java
// 从请求对象中获取可以读取请求体数据的字节输入流
InputStream in = request.getInputStream();

// 使用平台默认编码方案将字节输入流转换为字符输入流
InputStreamReader reader = new InputStreamReader( in );

// 创建用于从指定字符输入流中读取数据的字符缓冲流
BufferedReader br = new BufferedReader( reader );

String s = null ;
while( ( s = br.readLine() ) != null ) {
System.out.println( s );
}
```

### 6-5-1  multipart config 

在 Servlet 3.0 体系中，提供了两种方法来为 Servlet 程序提供 multipart config :

1. **在 web.xml 中使用 <multipart-config> 标签配置**

```xml
<servlet>
<servlet-name>binaryServlet</servlet-name>
<servlet-class>org.malajava.servlet.BinaryServlet</servlet-class>
<multipart-config></multipart-config>
</servlet>
<servlet-mapping>
<servlet-name>binaryServlet</servlet-name>
<url-pattern>/binary</url-pattern>
</servlet-mapping>
```

​		在<multipart-config>标签内部，还可以指定以下子标签: 

 <location>

标签<location>用于指定文件的存放目录，该标签内指定的内容必须是字符串类型。

 <max-request-size>

标签<max-request-size>用于指定 multipart/form-data 请求所提交数据的最大值，该标签内所指定的内容必须是数值类型。max-request-size 默认值为-1L，表示不限制multipart/form-data 请求所提交的数据量。

 <max-file-size>

标签<max-file-size>用于指定 multipart/form-data 请求中所包含的文件大小，该标签内所指定的内容必须是数值类型。max-file-size 默认值为-1L，表示不限制文件大小。 

 <file-size-threshold>

标签<file-size-threshold>内所指定的内容必须是数值类型，当上传的文件体积大于该 数值时，文件内容先写入到缓存文件中。file-size-threshold 的默认值为 0，表示被上传的文件首先写入到缓存文件中，当调用 Part 对象的 write 方法时，再将缓存文件中的内容输出到

<location>标签指定的目录中。通常，缓存文件所在的位置由容器来设定。

2. **在指定 Servlet 类上标注 @MultipartConfig 注解**

除了在 web.xml 中为 servlet 指定 multipart config ，还可以通过在相应 Servlet 类上添加@MultipartConfig 注解的方式指定，可以标注为以下形式:

​			@MultipartConfig( location = "D:/upload" )

@MultipartConfig 注解中还可以指定以下属性: 

 location

该属性与<location>标签作用相同。

maxRequestSize

该属性与<max-request-size>标签作用相同。 

maxFileSize

该属性与<max-file-size>标签作用相同。 

fileSizeThreshold

该属性与<file-size-threshold>标签作用相同。





不论是通过 web.xml 还是通过注解方式，只要为 Servlet 程序配置了 multipart config， 则在相应的 Servlet 程序中就可以通过 HttpServletRequest 对象的 getPart 方法来获取multipart/form-data 请求中所包含的各部分数据。multipart/form-data 请求中所包含的每部分数据都会对应一个 Part 对象，通过该对象即可获取相应部分的数据以及与该部分数据有关的其它信息。

### 6-5-2 Part

当为 Servlet 程序配置了 multipart config 后，即可通过以下形式来获取该部分数据对应的 Part 对象:

​				Part part = request.getPart( "upfile" );

遂后即可通过 Part 对象来获取该部分所包含的所有数据。

**Servlet 3.1 中为 Part 接口定义了以下方法用于获取这些数据:**

```java
public Collection<String> getHeaderNames()
//用于从该部分数据所包含的请求头中获取所有字段的名称组成的集合。
public String getHeader(String name)
//用于从该部分数据所包含的请求头中获取指定字段名称对应的单个取值。
public Collection<String> getHeaders(String name)
//用于从该部分数据所包含的请求头中获取指定字段名称对应的所有取值。
public String getName()
//用于获取该部分数据对应的表单组件的名称，比如<input type="text" name="name">组件对应的名称为 name，而<input type="file" name="upfile">对应的名称则为 upfile。 该名称与请求头中 content-disposition 字段取值中的 name="name"部分对应。
public String getSubmittedFileName()
//该方法为 Servlet 3.1 新增方法，用于获取用户所上传文件文件的原始名称，与请求头中content-disposition 字段取值中的 filename="hello.txt"部分对应。
public long getSize()
//用于获取该部分数据中正文数据的大小，对于文件上传操作来说，就是获取用户所上传文件的大小。
public String getContentType()
//用于获取该部分数据中正文数据的 MIME 类型，与请求头中 content-type 字段对应。
public void write(String fileName) throws IOException
//用于将该部分数据中的正文数据写入到指定文件中，对于文件上传操作来说，就是将文件内容写入到指定文件中。
public void delete() throws IOException
//用于删除该部分数据对应的缓存文件。
public InputStream getInputStream() throws IOException
    //该方法用于返回一个字节输入流，通过该流可以读取该部分数据中的正文数据。
```



### 6-5-3 单文件上传

```java
//使用	@MultipartConfig( location = "D:/upload" )指定上传的路径
Part part = request.getPart( "upfile" ); 
if( part != null ) {
// Servlet 3.1 开始可以直接获取用户所上传文件的原始名称
String filename = part.getSubmittedFileName();
// 如果文件名称不为 null 并且不是空串
if( filename != null && !filename.trim().isEmpty() ) { // 注意 感叹号
part.write( filename ); // 将文件内容保存到约定位置
return;
}
}
```

### 6-5-4 多文件上传

```java
Collection<Part> parts = request.getParts();
if( parts != null && parts.size() > 0 ){
for( Part p : parts ){
String filename = p.getSubmittedFileName();
if( filename != null && ! filename.trim().isEmpty() ) { // 注意 感叹号
p.write( filename );
}
}
w.println( "<h3>上传成功</h3>" );
return;
}
```

## 6-5-5  将文件保存到指定路径

**配置web.xml 文件:**

```xml
   <context-param>
        <param-name>store</param-name>
        <param-value>D:/Tomcat</param-value>
    </context-param>
```

**开发servlet:**

```java
Part part =req.getPart("upload");  //获得上传的文件
String filename = part.getSubmittedFileName();//获得该文件的名称
ServletContext sc = req.getServletContext();
String load = sc.getInitParameter("store");//获得路径
Path path = Path.of(load,filename);//在指定位置创建文件
InputStream in = part.getInputStream();
Files.copy( in , path, StandardCopyOption.REPLACE_EXISTING ); //将文件放入指定路径，有相同文件则覆盖
```



<img src="C:\Users\要不要买菜\Desktop\java-advence\Servlet\Snipaste_2020-07-14_21-08-43.jpg" style="zoom:100%;" />









# 7设置Servlet响应

## 7-1 HTTP响应

一个 HTTP 响应由状态行(起始行)、响应头(首部)、空行、响应体(实体)等四部分组成，

![](C:\Users\要不要买菜\Desktop\java-advence\Servlet\Snipaste_2020-07-14_21-12-11.jpg)

### 7-1-1 状态行

HTTP 响应报文的状态行是一个 HTTP 响应报文中的第一行，因此也被称作响应行

( Response Line )，其主要作用是用来说明响应协议、响应状态代码、原因短语，

其一般形式为:

​				protocol status-code reason-phrase

比如:

​				HTTP/1.1  200   OK

其中: 

​	 HTTP/1.1 表示本次响应是基于 HTTP 协议发送的

​	 200 表示本次响应的状态代码 

​	 OK 表示本次响应的原因短语(相当于本次响应的简单描述)

根据 HTTP 标准，HTTP 响应可以采用不同的状态代码和原因短语，但同一个 HTTP 请求只能采用一种状态代码和原因短语。

#### 7-1-1-1 状态代码

​	响应的状态代码是反映服务器对请求的响应结果，客户端根据不同的状态代码做出不同的处理，在 HTTP 协议中定义了不同的数字来表示不同的响应状态： 

```
100 ～ 199
表示请求已接收，继续处理。
200 ～ 299
表示请求已被成功接收、理解、接受。
300 ～ 399
重定向，要完成请求必须进行更进一步的操作。
400 ～ 499
表示客户端错误，请求有语法错误或请求无法实现。 
500 ～ 599
```

#### 7-1-1-2 常用状态码

```
200 OK
客户端请求成功。
302 Found
客户端得到服务端 302 状态码后向服务端发出新的请求。
400 Bad Request
客户端请求有语法错误，不能被服务器所理解。
401 Unauthorized
请求未经授权。
403 Forbidden
服务器收到请求，但是拒绝提供服务。
404 Not Found
请求资源不存在，比如客户端输入的 URL 在服务器上不存在。
405 Method Not Allowed
请求行中指定的请求方法不能被用于请求相应的资源。
500 Internal Server Error
服务器发生不可预期的错误。
503 Server Unavailable
服务器不能处理客户端的请求，一段时间后可能恢复正常。
```

## 7-2 设置响应

​	Servlet 规范中定义了 ServletResponse 接口来表示响应类型，容器通过该类型的对象向 客 户 端 发 送 响 应 数 据 ， 因 此 所 有 需 要 向 客 户 端 发 送的数据都要 首 先 设 置 到ServletResponse 对象中，再由 Servlet 容器将 ServletResponse 响应对象封装为 HTTP 响 应并发送给相应的客户端。

### 7-2-1 设置状态

HttpServletResponse 接口中定义了以下方法来设置状态行中的数据:

```java
public void setStatus( int statusCode )
public void sendError( int statusCode ) throws IOException
public void sendError( int statusCode , String reasonPhrase ) throws IOException
```

在 Servlet 3.0 规范中新增了以下方法用于获取状态代码:

```java
public int getStatus() ;
```

### 7-2-2 设置响应头

由 ServletResponse 接口中定义的用来设置响应报头的方法:

```java
public void setContentType( String mimeType )
   // response.setContentType( "text/html;charset=UTF-8" );
public void setContentLength( int length )
public void setContentLengthLong( long length )
```

另外，在 HttpServletResponse 接口中定义了以下用来设置响应报头的方法:

```java
public void setHeader( String name , String value )
    //response.setHeader( "content-type" , "text/plain;charset=UTF-8" );
public void addHeader( String name , String value )
public void setIntHeader( String name , int value )
public void addIntHeader( String name , int value )
public void setDateHeader( String name , long date )
public void addDateHeader( String name , long date )
public void addCookie( Cookie cookie )
```

从 Servlet 3.0 开始，HttpServletResponse 接口中新增了以下方法用以获取响应报头:

```java
public Collection<String> getHeaderNames()
public String getHeader( String name )
public Collection<String> getHeaders( String name )
public boolean containsHeader( String name )
```

## 7-3 设置响应体

容器通过 ServletResponse 对象向客户端发送响应数据，因此如果需要向客户端发送字符数据，必须首先将数据输出到 ServletResponse 对象中。

### 7-3-1 发送字符数据

ServletResponse 接口中提供了用来获取字符输出流的方法:

```java
public PrintWriter getWriter() throws IOException
```

显式设置向 ServletResponse 对象中所输出数据的字符编码方案

```java
public void setCharacterEncoding( String charset )
```

在开发 Servlet 程序时，除了可以通过 setCharacterEncoding 方法来显式设置字符编码方案外，还可以通过以下方法来隐式设置，该方法通过设置 Locale 对象的方式来设置响应对象中字符数据的字符编码方案，不同的 Locale 对象表示不同的国家或地区，而 Java 语言中为不同国家或地区提供了默认的字符编码方案，因此通过 setLocale 方法可以实现隐式设置字符编码方案。

```java
public void setLocale( Locale locale )
```

```java
// 设置向 response 对象中输出的字符数据的字符编码方案
response.setCharacterEncoding( "UTF-8" );
// 设置将来向HTTP客户端发送响应时响应数据的MIME类型
response.setContentType( "text/html;charset=UTF-8" );
// 获得用于向 response 对象中输出数据的字符输出流
PrintWriter w = response.getWriter();
// 使用 JDK 1.8 提供的 LocalDateTime 获得当前时间
LocalDateTime datetime = LocalDateTime.now();
// 指定日期时间的模式
String pattern = "G yyyy年MM月dd日 E HH点mm分ss秒SSS毫秒" ;
// 创建日期时间解析/格式化器
DateTimeFormatter formatter = DateTimeFormatter.ofPattern( pattern );
// 使用 DateTimeFormatter 实例对 日期时间 进行格式化
String str = formatter.format( datetime );
w.println( "<H3 style='text-align : center ;'>" );
w.println( str );
w.println( "<H3>" );
```

**不论是 setContentType 方法 还是 setCharacterEncoding 方法都必须在 getWriter 方法执行之前执行，否则这些设置将是无效的。**

### 7-3-2 发送字节数据

ServletResponse 接口中除了提供了用于获取字符输出流的方法，还提供了用于获取字节输出流的方法:

​			public ServletOutputStream getOutputStream() throws IOException

通过该方法返回的字节输出流可以向 ServletResponse 对象中输出字节数据。与向 ServletResponse 对象中输出字符数据相同，在向 ServletResponse 对象中输出 字节数据前，应该首先设置 MIME 类型。

### 7-3-3 显示图片

```java
File fod = new File( "D:/map.jpg" );
if( fod.exists() && fod.isFile() ) {
InputStream in = new FileInputStream( fod );

// 设置将来向HTTP客户端发送响应时响应数据的MIME类型
response.setContentType( "image/jpeg" );
OutputStream out = response.getOutputStream();
// 声明用来缓存从字节输入流中所读取到的有效字节的数组
final byte[] bytes = new byte[ 1024 ];
int n ; // 用来统计从字节输入流中读取到的有效字节数的变量

// 从字节输入流中读取字节到数组中并统计实际读取到的字节数
while( ( n = in.read( bytes ) ) != -1 ) {
// 将读取到的有效字节写入到字节输出流中
out.write( bytes , 0 , n );
}
// 关闭流
out.close();
in.close();
    
    //第二种写法
ServletContext sc = req.getServletContext();	//在xml文件中一直配置其信息
String path= sc.getInitParameter("store");
String filename = "log.png";
Path source = Path.of(path,filename);
resp.setContentType("image/png");
OutputStream out = resp.getOutputStream();
Files.copy(source,out);
```

### 7-3-4 下载图片

​	通过设置响应头中 content-disposition 字段来“命令”浏览器将接受到的响应数据保存到本地磁盘中，而不是在浏览器中直接以图片形式显示。

​	响应头中 content-disposition 字段的默认值为 inline，表示浏览器在接受到响应数据后直接解析这些数据并在浏览器窗口中显示，如果期望浏览器保存这些数据而不是在浏览器窗口中显示这些数据，可以将 content-disposition 字段的值设置为 attachment，同时可以通过 filename 参数来设置被保存的文件名称:

```java
response.setHeader( "content-disposition" , "attachment;filename=" + name );
```



```java
File fod = new File( "D:/map.jpg" );
if( fod.exists() && fod.isFile() ) {
// 获取服务器上的原始文件名称
String name = fod.getName() ; 
// 获取用于读取文件中数据的字节输入流
InputStream in = new FileInputStream( fod );
// 设置将来向HTTP客户端发送响应时响应数据的MIME类型
response.setContentType( "image/jpeg" );
response.setHeader( "content-disposition" , "attachment;filename=" + name );
OutputStream out = response.getOutputStream();
// 声明用来缓存从字节输入流中所读取到的有效字节的数组
final byte[] bytes = new byte[ 1024 ];
int n ; // 用来统计从字节输入流中读取到的有效字节数的变量
// 从字节输入流中读取字节到数组中并统计实际读取到的字节数
while( ( n = in.read( bytes ) ) != -1 ) {
// 将读取到的有效字节写入到字节输出流中
out.write( bytes , 0 , n );
}
// 关闭流
out.close();
in.close();
```

### 7-3-5 生成验证码

​	自己看书去！！！

# 8 请求转发与重定向

## 8-1请求转发

 request.getRequestDispatcher(转发地址).forward(request,response)：

1、**属于转发，也是服务器跳转，相当于方法调用**，在执行当前文件的过程中转向执行目标文件，两个文件(当前文件和目标文件)属于同一次请求，前后页共用一个request，可以通过此来传递一些数据或者session信息，request.setAttribute()和request.getAttribute()。

2、在前后两次执行后，地址栏不变，仍是当前文件的地址。

3、不能转向到本web应用之外的页面和网站，所以转向的速度要快。

4、URL中所包含的“/”表示应用程序(项目)的路径。

```java
/**
请求转发会跳转至请求转发对应的servlet（或页面）
然后在回到自己的servlet继续走完自己的servlet
*/
```

### include()方法

其实Servlet的forward方法就是将请求继续往下传，因此在这个过程中，传递的参数一直都是可以访问到的，include的方法其实是将另一个servlet中的输出内容包含进来

## 8-2 重定向

```java
/**
重定向会先走完自己的servlet
然后在跳转值其对定向的Servlet（或页面）
*/
```

response.sendRedirect()：

```java
         // 设置 响应状态码
response.setStatus( 302 ); // 浏览器接到响应后首先看 状态码，发现状态码是 302 就会立即摆好 pose 准备打开另外一个地址
 // 通过 响应头 中的 location 的 字段 向浏览器发送新的地址
response.setHeader( "location" , "http://www.baidu.com" );

//直接跳转
response.sendRedirect( "/zhu/ge/liang?message=helloxiaoliang" );
```
response.setStatus( 302 ); // 浏览器接到响应后首先看 状态码，发现状态码是 302 就会立即摆好 pose 准备打开另外一个地址
 // 通过 响应头 中的 location 的 字段 向浏览器发送新的地址
response.setHeader( "location" , "http://www.baidu.com" );

//直接跳转
response.sendRedirect( "/zhu/ge/liang?message=helloxiaoliang" );

1、**属于重定向，也是客户端跳转，相当于客户端向服务端发送请求之后**，服务器返回一个响应，客户端接收到响应之后又向服务端发送一次请求，一共是2次请求，前后页不共用一个request，不能读取转向前通过request.setAttribute()设置的属性值。

2、在前后两次执行后，地址栏发生改变，是目标文件的地址。

3、可以转向到本web应用之外的页面和网站，所以转向的速度相对要慢。

4、URL种所包含的"/"表示根目录的路径。

特殊的应用：对数据进行修改、删除、添加操作的时候，应该用response.sendRedirect()。如果是采用了request.getRequestDispatcher().forward(request,response)，那么操作前后的地址栏都不会发生改变，仍然是修改的控制器，如果此时再对当前页面刷新的话，就会重新发送一次请求对数据进行修改，这也就是有的人在刷新一次页面就增加一条数据的原因。

# 9Session

## 9-1 请求追踪之 Cooike

### 9-1-1设置cooike

```java
Cookie coo = new Cookie("name", "value");//创建一个键值对的cookie对象
coo.setMaxAge(60*60*24*7);//设置cookie的生命周期
response.addCookie(coo);//添加到response中
```



```java
		// 使用UUID类提供的randomUUID产生一个UUID实例
        UUID uuid = UUID.randomUUID();	//产生的uuid唯一
        String s = uuid.toString() ;
        String identifier = s.replaceAll( "-" , "" );
        System.out.println( "UUID: " + identifier );
        // 创建 Cookie 实例
        Cookie cookie = new Cookie( "identifier" , identifier );
        // cookie.setDomain( domain ); // 域( domain ) 由容器来设置
        cookie.setPath( "/" ); // path 可以由 Servlet 来设置
		//域后以"/"开头的地址皆可以接受该cookie
        int expiry = 60 * 60 * 24 * 10 ;
        cookie.setMaxAge(expiry); // max-age可以由 Servlet 来设置，表示cookie的最长保存时间
        cookie.setSecure( false ); // true 表示仅在安全连接环境下才发送
        cookie.setHttpOnly( false ); // true 表示仅仅通过 HTTP 协议发送给服务器，而不允许在客户端通过 JavaScript 等脚本来访问

        response.addCookie( cookie ); // 将 cookie 添加到 响应头中
```

### 9-1-2访问cookie

```java
    Cookie[] cookies = request.getCookies();
        if( cookies != null && cookies.length > 0 ) {
            for( Cookie c : cookies ){
                System.out.println( c.getName() + " : " + c.getValue() );
            }
        } 
```

### 9-1-3 Servlet Cookie 方法

```java
public void setDomain(String pattern)
//该方法设置 cookie 适用的域，例如 runoob.com。
    
public String getDomain()
//该方法获取 cookie 适用的域，例如 runoob.com。  
    
public void setMaxAge(int expiry)
//该方法设置 cookie 过期的时间（以秒为单位）。如果不这样设置，cookie 只会在当前 session 会话中持续有效。  
    
public int getMaxAge()
//该方法返回 cookie 的最大生存周期（以秒为单位），默认情况下，-1 表示 cookie 将持续下去，直到浏览器关闭。    
    
public String getName()
//该方法返回 cookie 的名称。名称在创建后不能改变。  
    
public void setValue(String newValue)
//该方法设置与 cookie 关联的值。   
    
public String getValue()
//该方法获取与 cookie 关联的值。    
    
public void setPath(String uri)
//该方法设置 cookie 适用的路径。如果您不指定路径，与当前页面相同目录下的（包括子目录下的）所有 URL 都会返回 cookie。    
    
public String getPath()
//该方法获取 cookie 适用的路径。   
    
public void setSecure(boolean flag)
//该方法设置布尔值，表示 cookie 是否应该只在加密的（即 SSL）连接上发送。  
    
public void setComment(String purpose)
//设置cookie的注释。该注释在浏览器向用户呈现 cookie 时非常有用。   
    
public String getComment()
//获取 cookie 的注释，如果 cookie 没有注释则返回 null。    
 
```



## 9-2 Session

### 9-2-1 HttpSession 接口方法

```java
public Object getAttribute(String name)
//该方法返回在该 session 会话中具有指定名称的对象，如果没有指定名称的对象，则返回 null。
    
public Enumeration getAttributeNames()
//该方法返回 String 对象的枚举，String 对象包含所有绑定到该 session 会话的对象的名称
    
public long getCreationTime()
//该方法返回该 session 会话被创建的时间，自格林尼治标准时间 1970 年 1 月 1 日午夜算起，以毫秒为单位。   
    
public String getId()
//该方法返回一个包含分配给该 session 会话的唯一标识符的字符串。   
    
public long getLastAccessedTime()
//该方法返回客户端最后一次发送与该 session 会话相关的请求的时间自格林尼治标准时间 1970 年 1 月 1 日午夜算起，以毫秒为单位。
    
public int getMaxInactiveInterval()
//该方法返回 Servlet 容器在客户端访问时保持 session 会话打开的最大时间间隔，以秒为单位。    
    
public void invalidate()
//该方法指示该 session 会话无效，并解除绑定到它上面的任何对象
    
public boolean isNew()
//如果客户端还不知道该 session 会话，或者如果客户选择不参入该 session 会话，则该方法返回 true。
    
public void removeAttribute(String name)
//该方法将从该 session 会话移除指定名称的对象。
    
public void setAttribute(String name, Object value)
//该方法使用指定的名称绑定一个对象到该 session 会话。
    
public void setMaxInactiveInterval(int interval)
//该方法在 Servlet 容器指示该 session 会话无效之前，指定客户端请求之间的时间，以秒为单位。
    
```

### 9-2-2 设置Session

```java
 HttpSession session = req.getSession();
```

