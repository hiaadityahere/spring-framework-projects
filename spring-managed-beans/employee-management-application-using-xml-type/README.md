# Injecting Nested Objects (Beans) using XML Configuration

In our previous project, our bean (`User`) only had simple fields like `int` and `String`.

In this project, an `Employee` has an `Address` and a `Department`. These are not primitive values—they are **custom objects** (non-primitive types) of our own classes.

Here, we explore how Spring handles **nested objects** using the `ref` attribute inside `<constructor-arg>`. Instead of manually creating `Address` and `Department` inside `Employee`, Spring creates them first and injects their object references into `Employee` for us.

---

## 📑 Project Guide (Attached PDF)

A step-by-step PDF guide with Eclipse screenshots is available in the `docs` folder:

- **File Path:** [`docs/spring-manages-nested-beans-xml-type.pdf`](./docs/spring-manages-nested-beans-xml-type.pdf)
- **Link:** 📄 **[Open Step-by-Step PDF Guide](./docs/spring-manages-nested-beans-xml-type.pdf)**

---

## 📌 Important Terms Explained Simply

- **Nested Object / Non-Primitive Dependency:** When a class holds references to other custom classes (e.g., `Employee` contains `Address` and `Department`).
- **`ref` vs `value`:**
  - `value`: Used for literal values (numbers, text: `101`, `"Alpha"`).
  - `ref`: Used to pass an existing bean by its `id` (`ref="address"`, `ref="department"`).
- **Dependency Resolution:** Spring analyzes the dependency graph. It notices that `employee` requires `address` and `department`, so it instantiates those two beans first before constructing `employee`.

---

## 💻 Tech Stack

- **Java Version:** JDK 17
- **Framework:** Spring Context `6.2.19`
- **Build Tool:** Apache Maven
- **IDE:** Eclipse IDE

---

## 📁 Project Structure

```text
employee-management-application-using-xml-type/
├── docs/
│   └── spring-manages-nested-beans-xml-type.pdf   # Step-by-step PDF guide
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── amazon/
│   │   │           └── employee/
│   │   │               ├── Address.java           # POJO for Address
│   │   │               ├── Department.java        # POJO for Department
│   │   │               ├── Employee.java          # POJO with nested Address & Department
│   │   │               └── App.java               # Main entry point (IoC bootstrap)
│   │   └── resources/
│   │       └── beans.xml                          # Spring XML configuration
│   └── test/
│       └── java/
├── pom.xml                                        # Maven dependencies
└── README.md
```

---

## 🔍 Understanding `ref` vs `value`

Every `<constructor-arg>` tag needs to know what it is injecting:

| Attribute | When to Use | Example |
| :--- | :--- | :--- |
| **`value`** | For simple/literal values (numbers, text, booleans). Spring converts the string to the expected parameter type. | `<constructor-arg value="Alpha" />` |
| **`ref`** | For passing another Spring-managed bean. Provide the bean's `id`. | `<constructor-arg ref="address" />` |

> **Quick rule of thumb:**  
> If in plain Java you would pass a literal (`101`, `"Alpha"`), use `value`.  
> If you would pass an object reference variable (`address`, `department`), use `ref`.

---

## 🛠️ Key Classes & Configuration Highlights

### `pom.xml`
- Adds the `spring-context` dependency (`6.2.19`), which provides the Spring IoC container and bean lifecycle management.

### `Address.java`
- **Fields:** `city`, `state`, and `country` (`String`).
- **Constructor:** Only contains an all-arguments constructor (no default constructor or setters), forcing Spring to use constructor injection.
- **`toString()`:** Formatted with tab indents (`\t`) so address fields display cleanly across separate lines.

### `Department.java`
- **Fields:** `departmentId` (`int`) and `departmentName` (`String`).
- **Constructor:** Uses an all-arguments constructor.
- **`toString()`:** Overridden to return simply the `departmentName`.

### `Employee.java`
- **Fields:** Holds primitive fields (`id`, `name`) alongside nested object references (`Address address` and `Department department`).
- **Constructor:** Takes all 4 parameters: `(int id, String name, Address address, Department department)`.
- **`displayEmployeeInfo()`:** Prints employee details; printing `address` and `department` automatically invokes their custom `toString()` methods.

### `beans.xml`
- **`address` bean:** Configured with 3 `<constructor-arg value="..." />` tags for city, state, and country.
- **`department` bean:** Configured with 2 `<constructor-arg value="..." />` tags for id and name.
- **`employee` bean:** Mixes both injection types:
  - First two arguments use `value` for `id` (`"101"`) and `name` (`"Alpha"`).
  - Last two arguments use `ref="address"` and `ref="department"` to link the ready-made beans.
- **Important note on order:** `<constructor-arg>` order must match constructor parameter order, but the order of `<bean>` tags in XML does not matter. Spring resolves the dependency tree and creates `address` and `department` first.

### `App.java`
- **Initializes Container:** Loads `beans.xml` via `ClassPathXmlApplicationContext`.
- **Requests Employee:** Retrieves the bean using type-safe retrieval:
  ```java
  Employee employee1 = context.getBean("employee", Employee.class);
  ```
- **Automatic Wiring:** Notice we never explicitly ask the container for `address` or `department` in code. Spring creates and injects them automatically behind the scenes.
- **Executes Logic:** Calls `employee1.displayEmployeeInfo()`.

---

## ⚙️ What Spring Does Behind the Scenes

1. Reads `beans.xml` and discovers all three bean definitions.
2. Identifies that `employee` depends on `address` and `department`.
3. Creates `address` and `department` instances using their constructor values.
4. Creates `employee`, passing the newly created `address` and `department` object references into its constructor.
5. Supplies the fully assembled `employee` bean when `context.getBean(...)` is invoked.

---

## ⚡ How to Run

### In Eclipse:
1. Open `src/main/java/com/amazon/employee/App.java`.
2. Right-click inside the editor.
3. Select **Run As** > **Java Application**.

### From Command Line:
```bash
mvn clean compile
mvn exec:java -Dexec.mainClass="com.amazon.employee.App"
```

---

## 🖥️ Expected Output

```text
Employee Details: 
Name: Alpha
Address: 
	city = BLR
	state = Karnataka
	country=India
Department: engineering
```

---

## 👤 Author

- **Aditya:** [linkedin.com/in/hiaadityahere](https://www.linkedin.com/in/hiaadityahere)
