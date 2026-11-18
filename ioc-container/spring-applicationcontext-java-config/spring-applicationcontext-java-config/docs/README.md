# Spring Beans using Java Config with ApplicationContext

This project shows how to create Spring beans using **Java configuration** (`@Configuration` and `@Bean`) with **`ApplicationContext`** as the IoC Container.

The example is a simple order flow: `OrderService` depends on `OrderRepository`, and Spring creates both beans and injects the dependency through the constructor.

## Tech Stack

* Java 17
* Maven
* Spring Context 6.1.21
* Eclipse IDE

## Prerequisites

* Java 17
* Maven
* Eclipse IDE
* Git

## IoC Container

There are two types of IoC Container:

1. `BeanFactory`
2. `ApplicationContext`

### 2. `ApplicationContext`

* `ApplicationContext` is one of the types of Spring IoC Container.
* It is a sub-interface of `BeanFactory` which has all the features of `BeanFactory` and it also contains the advanced enterprise-level features like- event publishing, internationalization (messages), resource loading etc.
* `ApplicationContext` uses eager loading.
* The implementations of `ApplicationContext` are:
   1. `ClassPathXmlApplicationContext` (XML-Based)
   2. `FileSystemXmlApplicationContext` (XML-Based)
   3. `AnnotationConfigApplicationContext` (Java-Based & Annotation-Based)

---

## Step 1: Create the Maven Project

Standard Maven Setup with these values:

| Field | Value |
|---|---|
| Archetype | `maven-archetype-quickstart` 1.1 |
| Group Id | `com.flipkart` |
| Artifact Id | `spring-applicationcontext-java-config` |
| Version | `0.0.1-SNAPSHOT` |
| Package | `com.flipkart.spring_applicationcontext_java_config` |

---

## Step 2: Add Spring Context Dependency

Add the `spring-context` dependency inside `<dependencies>` in `pom.xml`.
Dependency link: <https://mvnrepository.com/artifact/org.springframework/spring-context/6.1.21>

```xml
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-context</artifactId>
    <version>6.1.21</version>
</dependency>
```

Spring 6 needs Java 17, so make sure the project is using Java 17.

---

## Step 3: Create the Classes

Create these four classes (full code is available in the [PDF](./spring-applicationcontext-java-config.pdf)).

| Class | Package | Purpose |
|---|---|---|
| `OrderRepository` | `repository` | Data layer class. |
| `OrderService` | `service` | Business layer class. |
| `SpringConfig` | `config` | Java configuration class. |
| `App` | `com.flipkart.spring_applicationcontext_java_config` | Main class that creates the `ApplicationContext` and gets the bean. |

* **`OrderRepository`**
  * A normal Java class with a `saveOrder()` method.
  * It prints `Order saved to database.`

* **`OrderService`**
  * It has an `OrderRepository` object (HAS-A relationship).
  * The `OrderRepository` is injected through the constructor (constructor dependency injection).
  * Its `placeOrder()` method prints `Placing order...` and then calls `saveOrder()` of `OrderRepository`.

* **`SpringConfig`**
  * `@Configuration` tells Spring that this class contains bean definitions.
  * `@Bean` on a method tells Spring to manage the returned object as a bean.
  * `orderRepository()` creates the `OrderRepository` bean.
  * `orderService()` creates the `OrderService` bean with the name `orderService` and passes `orderRepository()` into its constructor.

* **`App`**
  * It creates the `ApplicationContext` with `SpringConfig`, gets the `OrderService` bean, calls `placeOrder()` and closes the context.

---

## Project Structure

```text
spring-applicationcontext-java-config
├── docs
│	├── README.md
│	└── spring-applicationcontext-java-config.pdf
├── src
│   └── main
│       └── java
│           └── com
│               └── flipkart
│                   └── spring_applicationcontext_java_config
│                       ├── App.java
│                       ├── config
│                       │   └── SpringConfig.java
│                       ├── repository
│                       │   └── OrderRepository.java
│                       └── service
│                           └── OrderService.java
├── .gitignore
└── pom.xml
```

---

## How `App.java` Works

1. **Creating `ApplicationContext` and registering `SpringConfig`**
   * `AnnotationConfigApplicationContext` is created with `SpringConfig.class`.
   * Spring automatically processes `@Configuration` and `@Bean` annotations and registers the corresponding bean definitions.

2. **Retrieving `OrderService` bean using its bean name and type**
   * `getBean("orderService", OrderService.class)` gives us the `OrderService` bean.

3. **Calling the business method**
   * `placeOrder()` is called on the bean.

4. **Closing `ApplicationContext`**
   * `context.close()` releases resources and destroys singleton beans managed by the context.

---

## Why is `App.java` simpler than the `BeanFactory` project?

* `AnnotationConfigApplicationContext` registers the `@Configuration` class and processes it by itself.
* So we do not need `AnnotatedBeanDefinitionReader` and `ConfigurationClassPostProcessor` here. Both of these steps were done manually with `BeanFactory`.
* Calling `orderRepository()` inside `orderService()` also gives the same `OrderRepository` bean, because the `@Configuration` class is processed by Spring.

## Eager Loading in `ApplicationContext`

* `ApplicationContext` creates all singleton beans when the context itself is created.
* In this project, the `OrderRepository` and `OrderService` beans are created at step 1, when `new AnnotationConfigApplicationContext(SpringConfig.class)` runs.
* `getBean()` in step 2 only returns the bean which is already created.

---

## Run the Project

Open `App.java`, right-click >> **Run As >> Java Application**.

### Output

```text
Placing order...
Order saved to database.
```

---

## Clone the Project Locally

1. Open a terminal and run:
   ```bash
   git clone https://github.com/hiaadityahere/spring-framework-projects.git
   cd spring-framework-projects/spring-applicationcontext-java-config
   ```
2. Open Eclipse and go to **File >> Import >> Maven >> Existing Maven Projects >> Next**.
3. Click **Browse**, select the `spring-applicationcontext-java-config` folder inside the cloned repository, and click **Finish**.
4. Wait for Maven to download the dependencies, or right-click the project >> **Maven >> Update Project** (Alt+F5).
5. Open `App.java`, right-click >> **Run As >> Java Application**.