# DSA Lab Record
----------------


- Intro to Java
- Basic Stucture of java
- Advantages of java
- Java Architecture
1) Matrix Operations
  a) Matrix Addition
  b) Matrix Multiplication
2) Sorting
   a) Selection Sort
   b) Bubble Sort
3) Searching
   a) Linear Search
   b) Binary Search
4) String Sorting
   


----------------
### Intro to Java


150 words : ``` Java, a widely used programming language, has gained immense popularity due to its versatility and extensive application domains. Created by James Gosling and his team at Sun Microsystems in the 1990s, Java has evolved into a fundamental tool for software development. One of its key strengths is platform independence, enabling Java programs to run on any device equipped with a Java Virtual Machine (JVM). This "write once, run anywhere" capability allows developers to create software that can be deployed across diverse platforms, including desktops, servers, mobile devices, and embedded systems. Java follows an object-oriented programming paradigm, offering developers a robust set of tools and features for building modular, scalable, and maintainable applications. Moreover, Java boasts a vast ecosystem of libraries, frameworks, and tools that further enhance its functionality and ease of use. As a result, Java continues to be a top choice for developers worldwide, powering a wide range of applications and systems. ```

### Basic Structure of Java

```
- Package Declaration: Optional, but recommended. It defines the package in which the class resides, providing organization and avoiding naming conflicts.
- Import Statements: Optional. They allow you to import classes from other packages for use in the current class.
- Class Declaration: Every Java program must have at least one class. It is declared using the "class" keyword, followed by the class name.
- Main Method: Every Java program must have a main method, which serves as the entry point for the program execution. It is declared as "public static void main(String[] args)".
- Class Body: It contains the variables, methods, and constructors that define the behavior and characteristics of the class.
- Variables: They are used to store data. Variables can be declared and initialized within a class.
- Methods: They represent actions or behaviors of the class. Methods can have parameters and a return type, and they are defined within the class body.
- Statements: They are written inside methods and perform specific actions or calculations. Statements are executed sequentially unless control flow statements are used to alter the program's flow.


// Package Declaration
package com.example;

// Import Statements (none in this example)

// Class Declaration
public class HelloWorld {

    // Main Method
    public static void main(String[] args) {
        
        // Statements
        System.out.println("Hello, World!");
    }
}


```


### Adv of Java

```
    Portability: Java programs can run on any platform with a Java Virtual Machine (JVM), making them highly portable and reducing platform-specific dependencies.

    Community Support: Java has a large and active community of developers, providing resources, documentation, and support for troubleshooting and learning.

    Compatibility: Java ensures backward compatibility, allowing older Java applications to run on newer versions of the Java platform without significant modifications.

    Industry Standard: Java is widely used in the industry and has become a de facto standard for enterprise software development.

    Integration: Java provides APIs and tools for seamless integration with other technologies and systems.

    Garbage Collection: Java's automatic memory management system frees developers from manual memory allocation and deallocation, reducing memory-related errors.

    Performance: Java's runtime optimizations, JIT compilation, and advanced profiling tools contribute to its high performance.

    Global Usage: Java is used globally in a wide range of applications, from large-scale enterprise systems to embedded devices, making it a versatile and widely applicable language.

    Open Source Libraries: Java has a vast collection of open-source libraries and frameworks that enhance development productivity and provide ready-made solutions for common tasks.

    Scalability: Java's support for multi-threading and distributed computing enables applications to scale efficiently to handle increasing workloads.

These advantages have established Java as a robust, reliable, and widely adopted programming language in various industries and domains.

```

### Java Arch

```
Java architecture refers to the structure and components of the Java platform that enable the execution of Java programs. The key elements of Java architecture include:

    Java Development Kit (JDK): It provides the tools necessary for developing, compiling, and running Java applications. The JDK includes the Java compiler, runtime environment, and various development utilities.

    Java Virtual Machine (JVM): It is the cornerstone of Java's platform independence. The JVM executes Java bytecode, which is generated by the Java compiler. It provides a layer of abstraction between the Java program and the underlying operating system, enabling the same code to run on different platforms.

    Java Runtime Environment (JRE): It consists of the JVM and necessary libraries. The JRE is responsible for executing Java applications and provides the runtime environment required for Java programs to run.

    Class Loader: It is responsible for loading Java classes into memory at runtime. The class loader dynamically loads the required classes and resolves dependencies.

    Java API (Application Programming Interface): It is a collection of pre-built libraries and classes that provide ready-to-use functionality for various tasks, such as file handling, networking, database connectivity, and user interface development.

    Java Development Tools: These include Integrated Development Environments (IDEs) like Eclipse and IntelliJ IDEA, which offer comprehensive tools for coding, debugging, and testing Java applications.

The Java architecture ensures the portability, scalability, and security of Java applications. It provides a robust foundation for developing and running Java programs across different platforms and environments.

```