04 Exercises: Spring Boot Introduction
======================================

---
---

Problems for exercises and homework for the [“Java Web Development Basics”
course \@ SoftUni](https://softuni.bg/courses/java-web-development-basics).
Submit your solutions on the **course page** of the **current instance**.

Let’s exercise a little the knowledge we’ve accumulated during the lesson for
Spring Boot. As you have seen only the basics, and theory, the problems won’t be
that hard. But they will definitely be fun and productive.

We will implement a simple application, only with Controllers and Spring data,
exploring the most interesting exploits of the Spring Platform.

---

Real Estate Agency
==================

Real Estate Agency is an application in which you **registers** and **finds** a
real estate offers based on a given criteria.

You will have to create a simple MVC application which has several pages and 1
object entity.

You will be given all resources like **styles, images** and **html** files.

1.Data
------

This is the data layer of the application. There is 1 data object for you to
implement.

### Offer

Create a **Offer** class, which holds the following properties:

-   **id** – a **String**.

-   **apartmentRent** – a **BigDecimal**.

-   **apartmentType** – a **String**.

-   **agencyCommission** – a **BigDecimal**.

2.Home Controller
-----------------

Implement a **controller**, which listens on the **index route** (“**/**”).

It should support only a **GET** request.

It should return the following HTML page, upon a **GET** request.

<kbd><img src="https://user-images.githubusercontent.com/32310938/65625280-2fd41600-dfd4-11e9-9889-ab4328d8c948.png" alt="alt text" width="800" height=""></kbd>

On the home page you must list all **available** offers. If there aren’t any a
message must be displayed.

<kbd><img src="https://user-images.githubusercontent.com/32310938/65625287-32cf0680-dfd4-11e9-8507-e32a401ea0e6.png" alt="alt text" width="800" height=""></kbd>

3.Offer Controller
------------------

Implement a **controller**, which listens on the following **routes:**

### Register (“/register”)

It should support **GET** & **POST** requests.

It should return the following HTML page, upon a **GET** request.

<kbd><img src="https://user-images.githubusercontent.com/32310938/65625306-38c4e780-dfd4-11e9-8cb8-a8afd4e08797.png" alt="alt text" width="800" height=""></kbd>

Rent price and commission rate should be **numbers**. Rent price must be
**positive number** (greater than zero (0)). Commission rate should be greater
or equal to zero (0) and lower or equal to one hundred (100). Apartment type
should be **non-empty string**.

If some of these conditions or all of them **are not met**, you should redirect
to register page.

If **all is good** you should 'post' the new offer on the agency and redirect to
home page.

### Find (“/find”)

It should support **GET** & **POST** requests.

It should return the following HTML page, upon a **GET** request.

<kbd><img src="https://user-images.githubusercontent.com/32310938/65625311-3a8eab00-dfd4-11e9-90bf-e20841f6c3ae.png" alt="alt text" width="800" height=""></kbd>

Family budget must be **positive number (greater than zero (0)).** Apartment
type and Family name should be **non-empty strings**.

If some of these conditions or all of them **are not met**, you should redirect
to find page.

If **all is good** you should start searching through all registered offers into
the agency. The first offer that meets the requirements, namely:

\- The type of apartment you are looking for is **absolutely the same** as the
registered one.

\- The family budget needs to be **enough** to take the current apartment: *rent
+ commission in percent of the current rental of the apartment*.

**Is leased!** That means you should remove the offer from the database and you
should redirect to home page.
<br/>

### Solution: <a title="Real Estate Agency" href="https://github.com/TsvetanNikolov123/JAVA---Java-MVC-Frameworks-Spring/tree/master/4%20EXERCISE%20SPRING%20BOOT%20INTRODUCTION/Real%20Estate%20Agency/realestate">Real Estate Agency</a>

---