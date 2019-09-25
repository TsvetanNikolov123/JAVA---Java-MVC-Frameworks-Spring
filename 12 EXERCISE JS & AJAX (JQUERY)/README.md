12 Project: Resident Evil
=========================

---
---

**Resident Evil** is a system that registers virus spreads across the world. It
is a significantly big project, and as such it will have several parts. In this
exercise you will land the basis of the application. You will also create the
majority of the visual design.

<kbd><img src="https://user-images.githubusercontent.com/32310938/65643095-8273f900-dff9-11e9-88b7-da690985c2ee.png" alt="alt text" width="800" height=""></kbd>

Exercises: JavaScript & AJAX
============================

Problems for exercises and homework for the [“Java MVC Frameworks - Spring”
course \@
SoftUni](https://softuni.bg/trainings/1538/java-mvc-frameworks-spring-march-2017).

1.Fetching & Loading Data
-------------------------

You have been tasked to modify the Viruses Show page, in a way that it could
also visualize Capitals. But how will that happen, they have different
properties, we can just put them In the same table… And if we visualize 2 tables
it will be ugly.

Well, here’s where JavaScript comes. We will add 2 Radio Buttons at the top of
the page, which will act as selectors. Depending on the selected button,
different data will be visualized. The page will look like this initially:

<kbd><img src="https://user-images.githubusercontent.com/32310938/65643110-8b64ca80-dff9-11e9-8e23-0f7c139bc698.png" alt="alt text" width="800" height=""></kbd>

When you choose **Viruses**, the message below should be deleted and the usual
table with all **Viruses** should be visualized, like in the last exercise.

<kbd><img src="https://user-images.githubusercontent.com/32310938/65643116-8e5fbb00-dff9-11e9-8884-44b4cae5d264.png" alt="alt text" width="800" height=""></kbd>

When you choose **Capitals**, a table with all the **Capitals** should be
visualized.

<kbd><img src="https://user-images.githubusercontent.com/32310938/65643121-915aab80-dff9-11e9-8d45-4964724b3d35.png" alt="alt text" width="800" height=""></kbd>

**Both actions** should be done **asynchronously** with **JavaScript** and
**AJAX**.

2.Virus Form Fragment
---------------------

The form for **Viruses** has the same composition for **Create**, **Update** and
**Delete**.  
It is quite inefficient to have **3 views** with the same **layout**, so let’s
create a little reusability. Extract a **Thymeleaf Fragment**, which contains
the whole **Virus Form** and include it in the **3 separate pages**. That way
you will have no repetition and you will have maximum reusability.

**NOTE**: You will probably need to configure the form as sometimes the
**fields** will be **disabled,** and the action will be different.
<br/>

### Solution: <a title="Resident Evil" href="https://github.com/TsvetanNikolov123/JAVA---Java-MVC-Frameworks-Spring/tree/master/12%20EXERCISE%20JS%20%26%20AJAX%20(JQUERY)/residentevil">Resident Evil</a>

---