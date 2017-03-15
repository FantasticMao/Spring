《Spring Boot实战》笔记
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

Java 类配置是 Spring 4.x 推荐使用的方式。

---

**切面编程 AOP**

Spring 支持 AspectJ 的注解式切面编程：
1. 使用 `@AspectJ` 声明当前类是一个切面
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
2. Java 配置 `@Bean` 注解中的 `initMethod` 和 `destroyMethod`
3. JSR-250 中的 `@PostConstruct` 和 `PreDestroy`

---

**Spring EL**

Spring EL 支持在 XML 和注解中使用表达式，类似 JSP 的 EL 表达式语言。

Spring 主要在 `@Value` 注解的参数中使用表达式

---
