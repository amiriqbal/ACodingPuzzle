# ACodingPuzzle

Coding Puzzle

Given a string comprising just the characters (,),{,},[,] determine if
it is well—formed or not by applying the following rules:

-Each type of bracket needs to be first opened then closed

-Good: () or [] or {}
-Bad: (() or {}}

-You can only close the last bracket that was opened
-Good: ({})
-Bad: ({)}

-Inside parenthesis () only braces {} are allowed
-Good: ({})
-Bad: ([1) or (())

-Inside braces {} only square brackets [] are allowed
-Good: {[]}
-Bad: {()} or {{}}

-Any bracket can appear (directly) inside square brackets []

-Good: [()] or [{}] or [[1] or [[[]]]
-Bad: [(H)]
-You can use a list of braces where a single one is allowed of that
type
-Good: [()()] or {[][()()]} or ()()

-An empty string is not valid a expression
-Any other characters than (){}[] will invalidate the string

For a given string print out True if the string is well—formed or
False if otherwise.

Part I.)

Write a program that can read from stdin. Process all lines and print
out the result to stdout.

Part II.)

Enhance the program from “Part I” so it uses a multi—threaded
approach. Dispatch the actual strings to test to as many threads as
the machine has cores. Because the order is not necessarily the same
as the input provide the output with the referring index of the nth
input like this (no spaces):

O:True
l:False

Limitations

Java Compiler: >= Java 7

Design goals


1. All of the requirements are met and it compiles and produces
correct results

2. It demonstrates the definition of "Clean code".

3. Reasonable design

4. Reasonable performance (CPU, Memory, I/O)



-For submission the source files including a pom.xml for the project, it can be compiled with maven and jar wit dependencies will execute.
