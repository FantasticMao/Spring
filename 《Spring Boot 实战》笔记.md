《Spring Boot 实战》笔记
---

**依赖注入 IoC**

声明 Bean 注解：
1. `@Component` 组件，没有明确角色
2. `@Repository` 在数据访问层使用
3. `@Service` 在业务逻辑层使用
4. `@Controller` 在视图控制层使用

注入 Bean 注解：
1. `@Autowired` Spring 提供的注解
2. `@Inject` JSR-330 提供的注解
3. `@Resource` JSR-250 提供的注解

配置 Bean 注解：
1. `@Configuration` 声明当前类是一个配置类
2. `@ComponentScan` 自动扫描包名下所有使用 `@Component`、`@Repository`、`@Service`、`@Controller` 的类
3. `@Bean` 声明当前方法的返回值为一个 Bean
4. `@Import` 导入一个配置类

Java 类配置是 Spring 4.x 推荐使用的方式。

---

**切面编程 AOP**

Spring 支持 AspectJ 的注解式切面编程：
1. 使用 `@Aspect` 声明当前类是一个切面
2. 使用 `@After`、`@Before`、`@Around` 定义 Advice (建议)
3. `@After`、`@Before`、`@Around` 参数的拦截规则为 PointCut (切点)
4. 符合条件的每一个 PointCut 为 JoinPoint (连接点)

---

**Bean Scope**

Scope 描述的是 Spring 容器如何创建 Bean 实例。Spring 的 Scope 有以下几种：
1. Singleton 一个 Spring 容器中只有一个 Bean，默认配置
2. Prototype 每次调用新建一个 Bean
3. Request Web 项目中每一个 Http Request新建一个 Bean
4. Session Web 项目中每一个 Http Session新建一个 Bean
5. GlobalSession 只有在 Portal 应用中有用，每个 Global Http Session 新建一个 Bean

---

**Bean init & destroy**

Spring 支持对 Bean 的生命周期进行操作，可使用 XML 配置或 Java 配置或注解配置：
1. XML 配置 <Bean> 标签中的 init-method 和 destroy-method
2. Java 配置 `@Bean` 注解中的 initMethod 和 destroyMethod
3. JSR-250 中的 `@PostConstruct` 和 `@PreDestroy`

---

**Spring EL**

Spring EL 支持在 XML 和注解中使用表达式，类似 JSP 的 EL 表达式语言。

Spring 主要在 `@Value` 注解的参数中使用表达式

---

**Profile**

Profile 为在不同环境下使用不同的配置提供了支持，如数据库连接。在代码中使用 `@Profile` 指定不同环境下的配置。

设定环境可以通过以下三种方法：
1. 通过 Environment 的 ActiveProfiles 来设定当前 context 所需要的配置环境
2. 通过配置 JVM 的 spring.profiles.active 启动参数设定
3. Web 项目中通过配置 Servlet 的 context parameter 参数设定

---

**Application Event**

Spring 的事件 (Application Event)为 Bean 和 Bean 之间的消息通信提供了支持。当一个 Bean 处理完一个任务之后，希望另一个 Bean 知道并能做相应的处理，这时我们就需要让另一个 Bean 监听当前 Bean 所发送的事件。

Spring 的事件需要遵循如下流程：
1. 自定义事件，继承 `ApplicationEvent`
2. 自定义事件监听器，实现 `ApplicationListener`
3. 使用容器发布事件

--- 

**Spring Aware**

Spring Aware 的目的是为了让 Bean 获取 Spring 容器的服务。所谓的 Spring Aware，是意味着容器中的 Bean 可以有意识地与 Spring 容器进行交互，从而调用 Spring 框架所提供的资源。Spring Aware 是为 Spring 框架内部使用的，若使用了 Spring Aware 则意味着当前 Bean 已经与 Spring 框架耦合。

---

**TaskExecuter**

Spring 通过任务执行器 (TaskExecuter) 来实现多线程和并发编程。`ThreadPoolTaskExecuter` 是一个基于线程池的 `TaskExecuter`。配置类中使用 `@EnableAsync` 注解开启对异步任务的支持，在 Bean 方法中使用 `@Async` 注解声明其是一个异步任务。

---

**Scheduled**

在 Spring 中实现计划任务很简单。通过在配置类中使用 `@EnableScheduling` 开启对计划任务的支持，然后在需要计划执行的方法上注解 `@Scheduled`。Spring 的 Scheduled 支持多种类型的计划任务，包含 cron、fixDelay、fixRate 等。

---

**Conditional**

`@Conditional` 注解能根据特定条件创建特定的 Bean，Spring Boot 中大量应用到条件注解。判断条件类继承 `Condition` 类并重写 matches 方法，作为参数传递给 `@Conditional` 即可。

---

**@Enable*注解工作原理**

如 `@EnableAspectJAutoProxy`、`@EnableAsync`、`@EnableScheduling`、`@EnableWebMvc`、`@EnableConfigurationProperties`、`@EnableJpaRepositories` 等等的 @Enable\* 注解，其实现原理主要分为以下三类：
1. 直接导入配置类，如 `@EnableScheduling`
2. 依据条件选择配置类，如 `@EnableAsync`
3. 动态注册 Bean，如 `@EnableAspectJAutoProxy`
