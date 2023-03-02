# About

Personal annotation of the course [TDD – Desenvolvimento de Software Guiado npor Testes](https://www.coursera.org/learn/tdd-desenvolvimento-de-software-guiado-por-testes) at Coursera.

# What is a high quality software?

- **Wrote for developer**
- **Clean code**:
    * Easy to read
    * Easy to understand
    * Easy to change

## Principals of a high quality code

- **KISS**: keep It Simple, Stupid! The solutions must be the more simple as it could be.
- **YAGNI**: You Aren't Gonna Need It! Do not anticipate code that you don't use now.
- **DRY**: Don't Repeat your self! Avoid duplicate code.
- **TDA**: Tell, Don't Ask! We do not change a attribute/data of a class B from a class A. Instead, the class A must tell to the class B to deal with her own data.

- **LoD**: Law of Demeter. We don't want to work with the "friend of my friend". I mean, if a class A needs class B, and class B needs class C, the class A do not need to know about class C.

- **SOLID principals**

- **Express the intention**: the name of variables, function, methods ans tests gave a hint about intention.

- **Design Patterns**

- **GRASP**: General Responsibility Assignment Software Principals.


# TDD: a approach to build high qualify code

**TDD** is a abbreviation for *Test Driven Development*.

TDD isn't a test technique. It is a software development technique where we make the tests before to design the code of our application.

## TDD cicles

```mermaid
graph LR
    A((1 - test)) --> B((2 - code))
    B --> C((3- refactor))
    C --> A
```

- **test**: write a failing test.
- **code**: make the test pass.
- **refactor**: improve your code.

## 1 - Adding a test

Add a test to:

- Design the class interface
- Define the expected behavior

## 2 - Make the test pass

Make the test pass by:

- Implementing the class behavior
- Doing the simplest/dummy solution

## 3 - Refactor

Improve your code applying principals of a high quality code like SOLID, Design Patterns, etc. Please see [Refactoring Guro](https://refactoring.guru/pt-br/).

Basically:

- Clean your code
- Improve your class design

## Baby Steps

You must to add little behavior from one test to another.

Baby steps do not mean slow development, but often switch between tests and application code.

# TDD: BDUF versus NoDUF

- 1: Using TDD with BDUF?

- 2: avoid BDUF, I mean, do the NoDUF?

Neither, we need to anticipate the enough of our project, so we need the Enough Deign Up Front (EDUF) that is also called Rough Design Up Front (RDUF). That is a kind o Emergent Design.

The emphasis of RDUF is on WHAT TO DO and not on HOW TO DO.

In most of the cases it is enough to do a *Class-responsibility-collaboration card* [(CRC)](https://en.wikipedia.org/wiki/Class-responsibility-collaboration_card) design.

![](imgs/crc-card-example.png)

## BDUF 

**Big Design Up Front** is a software development approach in which the program's design is to be completed and perfected before that program's implementation is started. 

    Proponents of waterfall model argue that time spent in designing is a worthwhile investment, with the hope that less time and effort will be spent fixing a bug in the early stages of a software product's lifecycle than when that same bug is found and must be fixed later.

    Critics (notably those who practice agile software development) argue that BDUF is poorly adaptable to changing requirements and that BDUF assumes that designers are able to foresee problem areas without extensive prototyping and at least some investment into implementation.

[Wikipédia](https://en.wikipedia.org/wiki/Big_Design_Up_Front)

## NoDUF

**No Deign Up Front** is the oppose of BDUF.