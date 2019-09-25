16 Exercises: Integration Testing
=================================

---
---

Problems for exercises and homework for the [“Java Web Development Basics”
course \@ SoftUni](https://softuni.bg/courses/java-web-development-basics).
Submit your solutions on the **course page** of the **current instance**.

---

Car Dealer 
===========

Car Dealer is an application for cars and car parts sales accounting. It manages
customers, cars, parts, suppliers and sales. You have been given the
infrastructure of the back-end – entities, repositories, services, configuration
etc.

You will also be given a simple documentation of the application.

Documentation
=============

1.Database Documentation
------------------------

The database of the Car Dealer application supports 5 entities:

### Customer

-   Has a **Id** – a **UUID string**

-   Has a **Name** – a **string**

-   Has a **Birth Date** – a **LocalDate** object

-   Has a **Is Young Driver** – a **boolean**

### Car

-   Has a **Id** – a **UUID string**

-   Has a **Make** – a **string**

-   Has a **Model** – a **string**

-   Has a **Travelled Distance** – a **64-bit integer**

-   Has **Parts** – a **collection** of **Part** objects

### Supplier

-   Has a **Id** – a **UUID string**

-   Has a **Name** – a **string**

-   Has a **Is Importer** – a **boolean**

### Part

-   Has a **Id** – a **UUID string**.

-   Has a **Name** – a **string**

-   Has a **Price** – a **BigDecimal** object

-   Has a **Supplier** – a **Supplier** object**.**

### Car Sale

-   Has a **Id** – a **UUID string**.

-   Has a **Discount** – a **floating-point** (percentage)

-   Has a **Customer** – a **Customer** object

-   Has a **Car** – a **Car** object**.**

### Car Sale

-   Has a **Id** – a **UUID string**.

-   Has a **Discount** – a **floating-point** (percentage)

-   Has a **Customer** – a **Customer** object

-   Has a **Part** – a **Part** object**.**

-   Has a **Quantity** – a **32-bit integer**.

Here is a database schema:

<kbd><img src="https://user-images.githubusercontent.com/32310938/65645724-52c8ef00-e001-11e9-9330-9414316dc6fe.jpg" alt="alt text" width="900" height=""></kbd>

2.Functionality Documentation
-----------------------------

The functionality is:

User:

-   Register

-   Login

-   Logout

Customer:

-   Add customer

-   List all customers

Car:

-   Add car

-   Edit car

-   Delete car

-   List all cars

Supplier:

-   Add supplier

-   Edit supplier

-   Delete supplier

-   List all suppliers

Part:

-   Add part

-   Edit part

-   Delete part

-   List all parts

Integration Testing
===================

You have been tasked to perform Integration testing on the **Web Layer** of the
**Car Dealer** application. Test all methods with all possible cases you can
think of.
<br/>

### Solution: <a title="Car Dealer" href="https://github.com/TsvetanNikolov123/JAVA---Java-MVC-Frameworks-Spring/tree/master/16%20EXERCISE%20INTEGRATION%20TESTING/Car%20Dealer">Car Dealer</a>

---