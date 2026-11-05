# Spring Managed Beans using XML Configuration

This project shows how Spring creates and manages Java objects (called **Beans**) using an XML file (`beans.xml`). 

Normally in Java, when we need an object, we write:
```java
User user = new User();
```
In Spring, we don't do that manually. Instead, we let Spring handle object creation and assign values for us. This concept is called **Inversion of Control (IoC)** and **Dependency Injection (DI)**.

In this project, we cover two main ways to pass values into our beans:
1. **Setter Injection** (using `<property>` tags)
2. **Constructor Injection** (using `<constructor-arg>` tags with order, index, and type matching)

---

## 📑 Project Guide (Attached PDF)

I have included a step-by-step PDF guide with Eclipse screenshots inside the `docs` folder:

- **File Path:** [`docs/spring-managed-beans-using-xml-type.pdf`](./docs/spring-managed-beans-using-xml-type.pdf)
- **Link:** 📄 **[Open Step-by-Step PDF Guide](./docs/spring-managed-beans-using-xml-type.pdf)**

---

## 📌 Important Terms Explained Simply

- **Spring Bean:** Just a regular Java object created and managed by Spring.
- **IoC Container (`ApplicationContext`):** The Spring engine. It reads `beans.xml`, creates the objects, and gives them to you when you ask.
- **Dependency Injection (DI):** Giving values or dependencies to an object from the outside instead of hardcoding them inside the class.
- **Setter Injection:** Spring creates the object using the empty constructor, then calls setter methods (like `setName()`) to set values.
- **Constructor Injection:** Spring passes values directly into the constructor when it creates the object.
- **POJO:** Plain Old Java Object. A standard Java class with private variables, constructors, and getters/setters.

---

## 💻 Tech Stack

- **Java Version:** JDK 17
- **Framework:** Spring Context `6.2.19`
- **Build Tool:** Apache Maven
- **IDE:** Eclipse IDE

---

## 📁 Project Structure

```text
spring-managed-beans-using-xml-type/
├── docs/
│   └── spring-managed-beans-using-xml-type.pdf    # PDF guide with screenshots
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── amazon/
│   │   │           └── user/
│   │   │               ├── App.java               # Main class to run the program
│   │   │               └── User.java              # POJO class
│   │   └── resources/
│   │       └── beans.xml                          # Spring bean definitions
│   └── test/
│       └── java/
│           └── com/amazon/user/spring_managed_beans_using_xml_type/
│               └── AppTest.java
├── pom.xml                                        # Maven dependencies
└── README.md
```

---

## 🛠️ Step-by-Step Implementation

### Step 1: Add Spring Context in `pom.xml`
To use Spring, we added `spring-context` to our `pom.xml`. This brings in the Spring IoC container.

```xml
<dependencies>
    <!-- JUnit for basic testing -->
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>3.8.1</version>
        <scope>test</scope>
    </dependency>

    <!-- Spring Context dependency -->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-context</artifactId>
        <version>6.2.19</version>
        <scope>compile</scope>
    </dependency>
</dependencies>
```

---

### Step 2: Create the `User` POJO Class (`User.java`)
We created a simple class with 4 fields: `id`, `name`, `type`, and `location`.
It has:
- A default (no-argument) constructor (required for Setter Injection).
- A parameterized constructor (required for Constructor Injection).
- Standard getters, setters, and a method `displayUserInfo()` to print details.

```java
package com.amazon.user;

public class User {
    private int id;
    private String name;
    private String type;
    private String location;

    // Default constructor
    public User() {
        super();
    }

    // Parameterized constructor
    public User(int id, String name, String type, String location) {
        super();
        this.id = id;
        this.name = name;
        this.type = type;
        this.location = location;
    }

    public void displayUserInfo() {
        System.out.println("User [id=" + id + ", name=" + name + ", type=" + type + ", location=" + location + "]");
    }

    // Getters and Setters below...
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
}
```

---

### Step 3: Configure Beans in `beans.xml`
Inside `src/main/resources/beans.xml`, we configure 5 different beans to practice different injection styles:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="
        http://www.springframework.org/schema/beans 
        http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!-- 1. Setter Injection (user1 and user2) -->
    <!-- Spring calls default constructor, then uses setter methods -->
    <bean class="com.amazon.user.User" id="user1">
        <property name="id" value="101" />
        <property name="name" value="Alpha" />
        <property name="type" value="Non-Prime" />
        <property name="location" value="BLR" />
    </bean>

    <bean class="com.amazon.user.User" id="user2">
        <property name="id" value="102" />
        <property name="name" value="Beta" />
        <property name="type" value="Prime" />
        <property name="location" value="HYD" />
    </bean>

    <!-- 2. Constructor Injection: Basic Order (user3) -->
    <!-- Values are passed in the order the constructor expects them -->
    <bean class="com.amazon.user.User" id="user3">
        <constructor-arg value="103" />
        <constructor-arg value="Charlie" />
        <constructor-arg value="Prime" />
        <constructor-arg value="CHN" />
    </bean>
    
    <!-- 3. Constructor Injection: By Index (user4) -->
    <!-- We explicitly tell Spring which position (0, 1, 2, 3) each value belongs to -->
    <bean class="com.amazon.user.User" id="user4">
        <constructor-arg index="0" value="104" />
        <constructor-arg index="1" value="Delta" />
        <constructor-arg index="2" value="Non-Prime" />
        <constructor-arg index="3" value="BBN" />
    </bean>

    <!-- 4. Constructor Injection: By Type (user5) -->
    <!-- We tell Spring the exact Java data type of each parameter -->
    <bean class="com.amazon.user.User" id="user5">
        <constructor-arg type="int" value="105" />
        <constructor-arg type="java.lang.String" value="Epsilon" />
        <constructor-arg type="java.lang.String" value="Prime" />
        <constructor-arg type="java.lang.String" value="KOL" />
    </bean>

</beans>
```

---

### Step 4: Load Container and Run the App (`App.java`)
In `App.java`, we follow 3 simple steps:
1. **Start the Container:** Load `beans.xml` using `ClassPathXmlApplicationContext`.
2. **Ask for Beans:** 
   - Recommended way: `context.getBean("user1", User.class)` (Type-safe, no manual cast needed).
   - Old way: `(User) context.getBean("user2")` (Requires explicit downcasting).
3. **Use the Bean:** Call `displayUserInfo()`.

```java
package com.amazon.user;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        String configFile = "beans.xml";
        
        // 1. Create the Spring IoC container
        ApplicationContext context = new ClassPathXmlApplicationContext(configFile);
        
        // 2. Request beans from the container
        User user1 = context.getBean("user1", User.class); // 1st way (Type-safe)
        User user2 = (User) context.getBean("user2");      // 2nd way (Downcasting)
        User user3 = context.getBean("user3", User.class);
        User user4 = context.getBean("user4", User.class);
        User user5 = context.getBean("user5", User.class);
        
        // 3. Use the beans
        user1.displayUserInfo();
        user2.displayUserInfo();
        user3.displayUserInfo();
        user4.displayUserInfo();
        user5.displayUserInfo();
    }
}
```

---

## ⚡ How to Run

### In Eclipse:
1. Open `src/main/java/com/amazon/user/App.java`.
2. Right-click anywhere in the file editor.
3. Click **Run As** > **Java Application**.

### From Command Line:
```bash
mvn clean compile
mvn exec:java -Dexec.mainClass="com.amazon.user.App"
```

---

## 🖥️ Expected Output

When you run the project, you should see this in your console:

```text
User [id=101, name=Alpha, type=Non-Prime, location=BLR]
User [id=102, name=Beta, type=Prime, location=HYD]
User [id=103, name=Charlie, type=Prime, location=CHN]
User [id=104, name=Delta, type=Non-Prime, location=BBN]
User [id=105, name=Epsilon, type=Prime, location=KOL]
```

---

## 👤 Author

- **Aaditya Kumar:** [linkedin.com/in/hiaadityahere](https://www.linkedin.com/in/hiaadityahere)
