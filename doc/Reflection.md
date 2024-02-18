Task Eight: Reflection Now that you’re complete, it’s time to reflect upon your design.
To begin, create another PlantUML class diagram modelling your source code for Bulls & Cows stored in doc/final-class.puml .
You might find that this is different from the initial design you did in Task One. In a markdown file named doc/reflection.md,
write two to four paragraphs including the following:
● Reflecting back on the first day, what have you been able to achieve and what skills have you learned from this course?
The first day I was a beginner who had no idea what Java was, and now that I have learned the basics of Java and am trying to use them, they will provide me with important support both when writing code and when thinking about code. 
Here are some brief descriptions of our courses according to the chapters:

Introduction to Java: This course provides a basic understanding of the Java programming language, its history, features, and applications. It serves as the foundation for learning why Java is important and where it can be applied.
Object-Oriented Programming:concepts, including classes, objects, inheritance, and polymorphism, are introduced. This is a fundamental aspect of Java and helps learners model and solve problems using objects.
Program Control Flow: Learners acquire knowledge about conditional statements, loops, and control flow in programs. These are crucial for creating logically structured code.
Arrays & Classes: Topics cover the use of arrays and how to create and use classes. Arrays are data structures for storing multiple data elements, and classes are essential in Java for defining object attributes and behavior.
Abstraction & Inheritance: This course explores abstract classes, interfaces, and multiple inheritance through interfaces. Understanding these concepts aids in building maintainable and extensible code.
UML: The usage of UML diagrams to visualize and design software systems is introduced. This helps in better planning and designing Java applications.
Exceptions: Handling exceptions that occur during program execution is covered. This is a vital part of writing robust code to deal with potential errors.
IO (Input/Output): IO topics include reading and writing files, handling input/output streams, and more. This knowledge is crucial for data interaction and file operations in Java.
Generics & Collections: Learners grasp how to write more generic code using generics and work with data collections. This is vital for managing and manipulating data sets efficiently.
Collections, Lambdas, & Recursion: This course further extends collection concepts, introduces Lambda expressions for concise coding, and explains the use of recursion in problem-solving.
Swing: The final course covers the Swing library, a way to create graphical user interfaces (GUIs) in Java. Learners discover how to create windows, components, and handle user input for developing interactive applications.

In summary, completing these Java courses means acquiring a solid foundation in Java programming, encompassing object-oriented programming, control flow, exception handling, file operations, and data manipulation.
These concepts are the initial stepping stones towards becoming a proficient Java developer and supporting future career growth and participation in Java projects.


● Why do you believe your design is a good design for this assignment?
My project contains the Game, Player, HumanPlayer, ComputerAI, MediumComputerAI, HardComputerAI, and fileGuessesPlayer classes, which have clear inheritance and association relationships between them. 
See UML for details. This makes the project logical and flexible between methods, which I think is worth thinking about every time I start a new project, that is, how to modularize the code.

In the process of writing code, more classes and methods will be used, based on preliminary thinking, we create a good class, but write more methods and even modify classes is necessary, all in order to achieve more and better functions.
I'm proud of the fact that when I finished task3 I found that my code was illogical and tried to re-create a set of modularized code for the main start () method to get the project going.

● If your final implementation is different to the initial design, explain why you have made such changes.
In the initial thinking of this project, I mainly considered the classes to be created and the relationship between classes, but I did not think about the methods in the classes in detail, 
so that when Game () called other methods, their functions were always unable to be realized, and I moved the positions of methods to make the code unreadable.