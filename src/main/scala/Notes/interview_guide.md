__What is Scala? Is it a Language or Platform? Does it support OOP or FP?__
- Scala stands for SCAlable LAnguage
- Both OOP & Functional Programming

__Is Scala Statically-Typed Language? What is Statically-Typed Language and What is Dynamically-Typed Language? What is the difference between statically typed and dynamically typed languages?__
- Yes, type set at compile time

__Scala Pure OOP?__
- Yes, Scala pure OOP, java is not due to primitive type with static members

__Scala Advantage__
- simple, concise, expressive, more readable
- type safe
- immutable and no side-effects
- reusable code
- more modularity
- oop & functional
- less error prone: Either, Try
- better parallel & concurrency
- highly scalable & maintainable code
- distributed applications
- java interoperability

__Scala Disadvantage__
- backward incompatible

__Object Structure__
- object as super class of all
- check the diagram

__Access Modifier__
- "public" word not needed since it is default

__Scala Int vs Java Integer__
- both are classes
- to represent integer numbers
- 32-bit signed integers
- however, scala Int does not implement comparable interface, java does

__Nothing, Nil, None__
- Nothing is a Type, it is subtype of anything in Scala, no instances of Nothing
- object None extends Option[Nothing]
- object Nil extends List[Nothing]
- Null is a Type, null is the only instance of scala.Null in Scala

__Unit vs void__
- Unit is a final class, void is a keyword
- Unit has one value ()

__val vs var__
- var mutable, val immutable

__Some Features__
- OOP & FP
- Strong type
- Support all functional features
- Type inference
- Pattern matching
- Closure
- Persistent data structure
- Actor model concurrency
- Interoperable with Java

__FP use recursion, tail recursion, immutable, no side-effect way of looping__

__Scala supports operator overloading__
- the only operator is "="

__Scala does not have static members__
- since Scala is pure OOP
- hard to deal with static members in concurrency applications

__Statement vs Expression__
- Expression can evaluate to a value e.g. Scala if
- Statement performs actions, e.g. Java if
- Scala is expression-oriented, Java is statement-based

__Function vs Method__
- Function is not associated with a class of trait but defined in Scala Package
- Method exists in Scala class or trait, is associated with an object

__Scala Predef__
- console IO
- collection utility
- string utility
- implicit conversion
- assertion utility

__Scala Interview Questions__
- Primary vs Auxiliary Constructor
- Primary: parameterless or parameter constructor
- class Person //parameterless
- class Person (firstName: String, lastName: String) //two parameters to create instances of class
- Auxiliary: def this(firstName: String, middleName: String, lastName: String) { this(firstName, " ", lastName) }
- Each Auxiliary Constructor should start with a call to previous defined another Auxiliary Constructor or Primary Constructor. Otherwise compile-time error.

__case class__
- case class, no new keyword
- Scala compiler, by default, add toString, companion object, copy, used in pattern matching
- case class/object be default is serializable
- no boiler code compared to class

__case object vs object__
- case object is serializable

__isInstanceOf vs asInstanceOf__
- isInstanceOf is to check type
- asInstanceOf is to cast type

__Array vs List__
- array: mutable, fixed size, invariant
- list: immutable, variable size, covariant

__lazy__
- Eager Evaluation means evaluating program at compile-time or program deployment-time irrespective of clients are using that program or not.
- Lazy Evaluation means evaluating program at run-time on-demand that means when clients access the program then only its evaluated.

__Scala solves diamond problem by using the left most trait__

__Scala Object__
- as singleton object
- to hold static methods
- to define factory methods

__when a class is "new"ed, a call to apply method in companion object

__Private Constructor in Scala__
- class Person private (name: String)
- object Person{ def apply(name: String) = new Person(name) }

__Companion object can access private members of companion class in Scala__
- In Scala, a Companion object can access private members of it’s Companion class and Companion class can access it’s Companion object’s private members
- the main design decision is to separate static and instance members

——for-yield patter__
- create a new collection of the same type

__Tool Stack__
- Play framework, SBT as build tool, ScalaTest/Spec2 for unit test, SCoverage for code coverage, Scalastyle to check code style

__HOF__
- Take other functions as arguments
- Return functions as their results

__Call by name, call by value__
- call by name: def myFunction(a: Int, b: => Int) {}
- call by value: def myFunction(a: Int, b: Int) {}

__trait vs abstract class__
- trait can have mixin
- abstract modules closer to java
- 
