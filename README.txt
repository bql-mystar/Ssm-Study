Spring
    Spring程序开发步骤：
        1、导入Spring开发的基本包坐标
        2、编写接口和实现类
        3、创建Spring核心配置文件
        4、在Spring配置文件中配置
        5、使用Spring的API获得Bean实例

    Spring配置文件
        Bean标签极本配置：
            默认情况下，调用对象的无参构造函数，如果没有无参构造函数，则创建失败

        Bean标签范围配置：
            scope指对象的作用范围：
                当scope的取值为singleton时，Bean的实例化个数为1，
                    Bean的实例化时机为：当Spring配置文件被加载时，实例化配置Bean
                        Bean生命周期：
                            对象创建：当应用加载，创建容器时，对象被创建了
                            对象运行：只要容器在，对象一直活着
                            对象销毁：当应用卸载，销毁容器时，对象就被销毁

                当scope的取值为prototype时，Bean的实例化个数为多个，
                            Bean的实例化时机为：当调用getBean方法时时实例化Bean
                                Bean生命周期：
                                    对象创建：当使用对象时，创建新的实例对象
                                    对象运行：只要对象在使用中，就一直活着
                                    对象销毁：当对象长时间不用时，被Java的垃圾回收机制回收

        Bean生命周期配置
            init-method：指定类中初始化方法名称
            destroy-method：指定类中销毁方法名称

        Bean实例化三种方式：
            无参构造方法实例化
            工厂静态方法实例化
            工厂实例方法实例化

        Bean的依赖注入：
            通过set方法进行注入
            通过有参构造方法进行注入

        Bean的依赖注入的数据类型
            普通数据类型
            引用数据类型
            集合数据类型

        引入其它配置文件(分模块开发)
            在Spring主配置文件通过import标签进行加载
                <import resource="application-xxx.xml" />

    Spring相关API
        ApplicationContext的继承体系：
            applicationContext：接口类型，代表应用上下文，可以通过其实例获得Spring容器中的Bean对象

        ApplicationContext的实现类：
            ClassPathXmlApplicationContext
                它是从类的根路径下加载配置文件 推荐使用这种
            FileSystemXmlApplicationContext
                它是从磁盘路径上加载配置文件，配置文件可以在磁盘的任意位置
            AnnotationConfigApplicationContext
                当使用注解配置容器对象时，需要使用此类来创建Spring容器，它用来读取注解

        getBean方法使用：
            当参数的数据类型是字符串时，表示根据Bean的id从容器中获得Bean实例，返回是Object，需要强转。
            当参数的数据类型是Class类型时，表示根据类型从容器中匹配Bean实例，当容器中相同类型的Bean有多个时,则此方法会报错。

    Spring注解开发：
        Spring原始注解：
            主要用于替代<Bean>的配置
            @Component  便于在类上用于实例化Bean
            @Controller  使用在web层类上用于实例化Bean
            @Service  使用在service层类上用于实例化Bean
            @Repository  使用在dao层类上用于实例化Bean
            @Qualifier  结合@Autowired一起使用，用于根据名称进行依赖注入
            @Resource  相当于@Autowired + @Qualifier，按照名称进行注入
            @Value  注入普通属性
            @Scope  标注Bean的作用范围
            @PostConstruct  使用在方法上标注该方法是Bean的初始化方法  相当于init-method
            @PreDestory  使用在方法上标注该方法是Bean的销毁方法    相当于destroy-method

            注意：
                使用注解进行开发时，需要在applicationContext.xml中配置组件扫描，
                作用是指定哪个包及其子包下的Bean需要进行扫描以便识别使用注解配置的类、字段和方法
                <context:component-scan base-package="xxx" />

        Spring新注解：
            使用原始注解还不能全部替代xml配置文件，还需要使用注解替代的配置如下：
                非自定义的Bean的配置：<bean>
                加载properties文件的配置：<context:property-placeholder>
                组件扫描的配置：<context:component-scan />
                导入其它文件：<import>

            @Configuration：用于指定当前类是一个Spring配置类，当创建容器时会从该类上加载注释
            @ComponentScan：用于指定作用于Spring的初始化容器时要扫描的包，作用和Spring的xml配置文件中的<component-scan base-package="xxx" />一样
            @Bean：使用在方法上，标注将该方法的返回值存储到Spring容器中
            @PropertySource：用于加载.properties文件中的配置
            @Import：用于导入其它配置类

    Spring集成Junit
        1、导入Spring集成junit坐标
        2、使用@Runwith注解替换原来的运行期
        3、使用@ContextConfiguration指定配置文件或配置类
        4、使用@Autowired注入需要测试的对象
        5、创建测试方法进行测试

    Spring集成web环境：
        1、配置ContextLoaderListener监听器
        2、使用WebApplicationContextUtils获得应用上下文

SpringMVC：
    开发步骤：
        1、导入SpringMVC相关坐标
        2、配置SpringMVC核心控制器DispatcherServlet
        3、创建Controller类和视图页面
        4、使用注解配置Controller类中业务方法的映射地址
        5、配置SpringMVC核心文件spring-mvc.xml
        6、客户端发起请求测试

    SpringMVC的执行流程：
        1、用户发送请求至前端控制器DispatchServlet
        2、DispatcherServlet收到请求调用HandlerMapping处理器映射器。
        3、处理器映射器找到具体的处理器(可以根据xml配置、注解进行查找)，生成处理器对象及处理器拦截器(如果有则生成)一并返回给DispatcherServlet
        4、DispatcherServlet调用HandlerAdapter处理器适配器。
        5、HandlerAdapter经过适配调用具体的处理器(Controller，也叫后端控制器)。
        6、Controller执行完成返回ModelAndView。
        7、HandlerAdapter将controller执行结果ModelAndView返回给DispatcherServlet。
        8、DispatcherServlet将ModelAndView传给ViewReslover视图解析器。
        9、ViewReslover解析后返回具体View。
        10、DispatcherServlet根据View进行渲染视图(即将模型数据填充至视图中)。DispatcherServlet响应用户。

    SpringMVC注解解析：
        @RequestMapping：用于建立请求URL和处理请求方法之间的对应关系
            位置：
                类上：请求URL的第一级访问目录，此处不写的话，就相当于应用的根目录
                方法上：请求URL的第二级访问目录，于类上的使用@RequestMapping标注的一级目录一起组成访问虚拟路径
            属性：
                value：用于指定请求的URL，它和path属性的作用是一样的
                method：用于指定请求的方式
                params：用于指定请求参数的条件，它支持简单的表达式，要求请求参数的key和value必须和配置的一模一样

    SpringMVC的数据响应：
        SpringMVC数据响应方式：
            1、页面跳转：
                直接返回字符串：此种方式会将返回的字符串与视图解析器的前后缀拼接后跳转
                通过ModelAndView对象返回
            2、回写数据：
                直接返回字符串：将需要回写的字符串直接返回，但此时需要通过@ResponseBody注解告知SpringMVC框架，方法返回的字符串不是跳转而是直接在http响应体中返回
                返回对象或集合：
                    在方法上添加@ResponseBody，在在配置文件中进行以下配置
                            <bean class="org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter">
                                <property name="messageConverters">
                                    <list>
                                        <bean class="org.springframework.http.converter.json.MappingJackson2HttpMessageConverter" />
                                    </list>
                                </property>
                            </bean>
                    使用上述方法配置比较麻烦，因此可以在配置文件中，可以使用mvc的注释驱动代替上述配置
    SpringMVC获得请求数据：
        基本类型参数
        POJO类型参数
        数组类型参数
        集合类型参数
            1、通过创建一个VO对象，里面设置一个属性为对应的集合
            2、通过Ajax提交，指定contentType为json形式，那么可以在方法的参数位置使用@RequestBody，直接接收集合数据而无需使用POJO进行包装

        请求数据乱码问题：
            当post请求时，数据会出现乱码，我们可以设置一个过滤器来进行编码的过滤

        参数绑定注解@RequestParam
            当请求的参数名称和Controller的业务方法参数名称不一致时，就需要通过@RequestParam注解显示的绑定
            注解@RequestParam还有如下参数可以使用：
                value：与请求参数名称
                required：在此指定请求参数是否必须包括，默认是true，提交时如果没有此参数则报错
                defaultValue：当没有指定请求参数时，则使用指定的默认值赋值

        获得请求头：
            1、@RequestHeader：使用@RequestHeader可以获得请求头信息，相当于request.getHeader()
                @RequestHeader注解的属性如下：
                    value：请求头的名称
                    required：是否必须携带此头
            2、@CookieValue：使用@CookieValue可以获得指定Cookie的值
                @CookieValue注解的属性如下：
                    value：指定cookie的名称
                    required：是否必须携带此cookie

        文件上传：
            1、文件上传三要素：
                表单项type="file"
                表单提交方式为post
                表单的enctype属性是多部分表单形式，及enctype="multipart/form-data"

            2、单文件上传步骤
                导入fileupload和io坐标
                配置文件上传解析器
                编写文件上传代码

    SpringMVC自定义类型转换器
        自定义类型转换器步骤：
            1、定义转换器类实现接口Converter接口
            2、在配置文件中声明转换器
            3、在<annotation-driven>中引用转换器

    JdbcTemplate基本使用：
        开发步骤：
            1、导入spring-jdbc和spring-tx坐标
            2、创建数据库表和实体
            3、创建Jdbc Template对象
            4、执行数据库操作

    SpringMVC拦截器：
        SpringMVC拦截器类似于Servlet开发中的过滤器Filter，用于对处理器进行预处理和后处理
            将拦截器按一定的顺序联结成一条链，这条链称为拦截器链。在访问被拦截的方法或字段时，拦截器链中的拦截器就会按其之前定义的顺序被调用。拦截器也是AOP思想的具体实现
            拦截器和过滤器的区别:
                过滤器使用范围：是Servlet规范中的一部分，任何JavaWeb工程都可以使用
                    拦截范围：在url-pattern中配置了/*之后，可以对所有要访问的资源拦截

                拦截器适用范围：是SpringMVC框架自己的，只有使用了SpringMVC框架的工程才能用
                    拦截范围：在<mvc:mapping path="" />中配置了/**之后，也可以对所有资源进行拦截，但是可以通过<mvc:exclude-mapping path="" />标签排除不需要拦截的资源

        自定义拦截器：
            1、创建拦截器类实现HandlerInterceptor接口
            2、配置拦截器
            3、测试拦截器的拦截效果

    SpringMVC异常处理：
        异常处理的两种方式：
            1、使用SpringMVC提供的简单异常处理器SimpleMappingExceptionResolver
            2、实现Spring的异常处理接口HandlerExceptionResolver自定义自己的异常处理器
                自定义异常处理器步骤：
                    1、创建异常处理器类实现HandlerExceptionResolver
                    2、配置异常处理类
                    3、编写异常页面
                    4、测试异常跳转

Spring AOP
    在程序运行期间，在不修改源码的情况下对方法进行功能增强
    减少重复代码，提高开发效率，并且便于维护

    AOP的底层是通过Spring提供的的动态代理技术实现的。在运行期间，Spring通过动态代理技术动态的生成代理对象，代理对象方法执行时进行增强功能的介入，在去调用目标对象的方法，从而完成功能的增强。

    常用的动态代理技术：
        JDK代理：基于接口的动态代理技术
        cglib代理：基于父类的动态代理技术

    Target(目标对象)：代理的目标对象
    Proxy(代理)：一个类被AOP织入增强后，就会产生一个结果代理类
    Joinpoint(连接点)：所谓连接点是指那些被拦截到的点。在spring中，这些点指的是方法，因为spring只支持方法类型的连接点
    Pointcut(切入点)：所谓切入点是指我们要对哪些Joinpoint进行拦截的定义
    Advice(通知/增强)：所谓通知是指拦截到Joinpoint之后所要做的事情就是通知
    Aspect(切面)：是切入点和通知(引介)的结合
    Weaving(织入)：是指把增强应用到目标对象来创建新的代理对象的过程，spring采用动态代理织入，而Aspect采用编译期织入和类装在期织入

    步骤：
        1、导入AOP坐标
        2、创建目标接口和目标类(内部有切点)
        3、创建切面类(内部有增强方法)
        4、将目标类和切面类的对象创建权交给spring
        5、在applicationContext.xml中配置织入关系
        6、测试代码

    切点表达式写法：
        execution([修饰符] 返回值类型 包名.类名.方法名(参数))
        访问修饰符可以省略
        返回值类型、包名、类名、方法名可以使用星号*代替任意
        包名与类名之间一个点.代表当前包下的类，两个点..表示当前包及其子包下的类
        参数列表可以使用两个点..表示任意个数，任意类型的参数列表

    通知的类型：
        通知的配置语法：
            <aop:通知类型 method=“切面类中方法名” pointcut=“切点表达式"></aop:通知类型>

        前置通知 <aop:before> 用于配置前置通知 指定增强的方法在切入点方法之前执行
        后置通知 <aop:after-returning> 用于配置后置通知 指定增强的方法在切入点方法之后执行
        环绕通知 <aop:around> 用于配置环绕通知 指定增强的方法在切入点方法之前和之后都执行
        异常抛出通知 <aop:throwing> 用于配置异常抛出通知 指定增强的方法在出现异常时执行
        最终通知 <aop:after> 用于配置最终通知 无论增强方式执行是否有异常都会执行

    切点表达式抽取：
        当多个增强的切点表达式相同时，可以将切点表达式进行抽取，在增强中使用pointcut-ref属性代替pointcut属性来引用抽取后的切点表达式。

    基于注解的AOP开发：
        步骤：
            1、创建目标接口和目标类（内部有切点)
            2、创建切面类(内部有增强方法)
            3、将目标类和切面类的对象创建权交给spring
            4、在切面类中使用注解配置织入关系
            5、在配置文件中开启组件扫描和AOP的自动代理
            6、测试

        切点表达式的抽取：
            同xml配置aop一样，我们可以将切点表达式抽取。抽取方式是在切面内定义方法，在该方法上使用@Pointcut注解定义切点表达式，然后在在增强注解中进行引用。

    Spring事务控制：
        Spring声明式事务控制底层就是AOP
        编程式事务控制：
            事务的隔离级别：
                1、读未提交
                2、读已提交
                3、可重复读
                4、串行化
            事务的传播行为：
                REQUIRED:如果当前没有事务，就新建一个事务，如果已经存在一个事务中，加入到这个事务中。一般的选择（默认值）
                SUPPORTS:支持当前事务，如果当前没有事务，就以非事务方式执行(没有事务)
                MANDATORY:使用当前的事务，如果当前没有事务，就抛出异常
                REQUERS_NEW:新建事务，如果当前在事务中，把当前事务挂起。
                NOT_SUPPORTED:以非事务方式执行操作，如果当前存在事务，就把当前事务挂起
                NEVER:以非事务方式运行，如果当前存在事务，抛出异常
                NESTED:如果当前存在事务，则在嵌套事务内执行。如果当前没有事务，则执行REQUIRED类似的操作
                超时时间:默认值是-1，没有超时限制。如果有，以秒为单位进行设置
                是否只读:建议查询时设置为只读

            基于xml的声明式事务控制：
                1、配置平台事务管理器
                    <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
                        <property name="dataSource" ref="dataSource" />
                    </bean>
                2、事务通知的配置
                    <tx:advice id="txAdvice" transaction-manager="transactionManager">
                        <tx:attributes>
                            <tx:method name="*" propagation="REQUIRED" isolation="DEFAULT" read-only="false" timeout="-1"/>
                        </tx:attributes>
                    </tx:advice>
                3、配置事务的aop织入
                    <aop:config>
                        <aop:advisor advice-ref="txAdvice" pointcut="execution(* com.xie.service.impl.*.*(..))" />
                    </aop:config>


            基于注解的声明式事务控制：
                1、配置平台事务管理器
                    <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
                        <property name="dataSource" ref="dataSource" />
                    </bean>
                2、事务通知的配置
                    <tx:advice id="txAdvice" transaction-manager="transactionManager">
                        <tx:attributes>
                            <tx:method name="*" propagation="REQUIRED" isolation="DEFAULT" read-only="false" timeout="-1"/>
                        </tx:attributes>
                    </tx:advice>
                3、配置事务的aop织入
                    在方法上使用@Transactional注释，表明该方法有事务控制，也可以在类上使用@Transactional注释，表明该类下的所有方法都有事务控制
                    当类上和方法上都有@Transactional注释时，就近原则，优先使用方法上的注释配置
                4、配置事务的注解驱动
                    <tx:annotation-driven transaction-manager="transactionManager"/>











