Project: Product Shop
=====================

**Product Shop** is a system that registers users, categories, products and
orders. It is a significantly big project, and as such it will have several
parts. In this exercise you will land the basics of the application, in other
words - the user functionality.

<kbd><img src="https://user-images.githubusercontent.com/32310938/65675507-f4c6f680-e056-11e9-8ab7-beaf361ff0ca.png" alt="alt text" width="800" height=""></kbd>

---
---

Workshop: Part 1 - Users
========================

---
---

1.Views
-------

You will be given a couple of views.

<kbd><img src="https://user-images.githubusercontent.com/32310938/65675507-f4c6f680-e056-11e9-8ab7-beaf361ff0ca.png" alt="alt text" width="800" height=""></kbd>

<kbd><img src="https://user-images.githubusercontent.com/32310938/65675569-17f1a600-e057-11e9-9ec4-aa91e98f0a57.png" alt="alt text" width="800" height=""></kbd>

<kbd><img src="https://user-images.githubusercontent.com/32310938/65675577-1aec9680-e057-11e9-9837-518b15298400.png" alt="alt text" width="800" height=""></kbd>

<kbd><img src="https://user-images.githubusercontent.com/32310938/65675790-6d2db780-e057-11e9-92f2-c4ec31a1ecce.png" alt="alt text" width="800" height=""></kbd>

<kbd><img src="https://user-images.githubusercontent.com/32310938/65675801-70c13e80-e057-11e9-96db-37f66f22d2fc.png" alt="alt text" width="800" height=""></kbd>

<kbd><img src="https://user-images.githubusercontent.com/32310938/65675810-7585f280-e057-11e9-88d5-2a26f488690c.png" alt="alt text" width="800" height=""></kbd>

<kbd><img src="https://user-images.githubusercontent.com/32310938/65675815-79197980-e057-11e9-8816-7ef2717482e1.png" alt="alt text" width="800" height=""></kbd>

2.Data Entities
---------------

Create the required **entities**. Use the appropriate **data types**. In this
exercise you will have Users and their Roles

-   **User**

    -   **Id –** primary key, universally unique identifier

    -   **Password –** string

    -   **Email –** string

-   **Role**

    -   **Id –** primary key, universally unique identifier

    -   **Authority -** string

3.Establish the Back-End
------------------------

Create the required:

-   **Entities**

-   **Models**

-   **Repositories**

-   **Services**

-   **Controllers**

4.Register User
---------------

Create a functionality to **register** Users.

<kbd><img src="https://user-images.githubusercontent.com/32310938/65675569-17f1a600-e057-11e9-9ec4-aa91e98f0a57.png" alt="alt text" width="800" height=""></kbd>

5.Login User
------------

Create a functionality that **logs in** user.

<kbd><img src="https://user-images.githubusercontent.com/32310938/65675577-1aec9680-e057-11e9-9837-518b15298400.png" alt="alt text" width="800" height=""></kbd>

6.View Profile
--------------

Create a functionality to **view** the current logged in user’s profile. You
should be able to go to edit profile page.

<kbd><img src="https://user-images.githubusercontent.com/32310938/65675801-70c13e80-e057-11e9-96db-37f66f22d2fc.png" alt="alt text" width="800" height=""></kbd>

7.Edit User’s Profile
---------------------

Create a functionality to **edit** User, in other words a functionality that can
change the user’s password and/or email

<kbd><img src="https://user-images.githubusercontent.com/32310938/65675810-7585f280-e057-11e9-88d5-2a26f488690c.png" alt="alt text" width="800" height=""></kbd>

8.Admin Functionality
---------------------

Admins should be able to see all users and change their roles

<kbd><img src="https://user-images.githubusercontent.com/32310938/65675815-79197980-e057-11e9-8816-7ef2717482e1.png" alt="alt text" width="800" height=""></kbd>

---
---

Workshop: Part 2 - Products
===========================

---
---

1.Views
-------

These are the additional views you must implement.

<kbd><img src="https://user-images.githubusercontent.com/32310938/65677977-38236400-e05b-11e9-83b8-67201c113b85.png" alt="alt text" width="800" height=""></kbd>

<kbd><img src="https://user-images.githubusercontent.com/32310938/65677991-3d80ae80-e05b-11e9-8098-4db807ba4933.png" alt="alt text" width="800" height=""></kbd>

<kbd><img src="https://user-images.githubusercontent.com/32310938/65678014-43768f80-e05b-11e9-848d-0d4739ed5975.png" alt="alt text" width="800" height=""></kbd>

<kbd><img src="https://user-images.githubusercontent.com/32310938/65678033-496c7080-e05b-11e9-809c-ebcc1c0d2486.png" alt="alt text" width="800" height=""></kbd>

<kbd><img src="https://user-images.githubusercontent.com/32310938/65678050-51c4ab80-e05b-11e9-9db6-b2c0099cce3c.png" alt="alt text" width="800" height=""></kbd>

**NOTE**: The **Navigation** contains all of the added categories as radio
buttons. Depending on your selection of a **radio** button, you should render
different products. If you select the [**All**] button you should render all
products.

<kbd><img src="https://user-images.githubusercontent.com/32310938/65678086-5f7a3100-e05b-11e9-9eeb-8f1acaa754c0.png" alt="alt text" width="800" height=""></kbd>

<kbd><img src="https://user-images.githubusercontent.com/32310938/65678112-6bfe8980-e05b-11e9-9992-95aa57fc7d3d.png" alt="alt text" width="800" height=""></kbd>

<kbd><img src="https://user-images.githubusercontent.com/32310938/65678119-70c33d80-e05b-11e9-903a-9e518702a223.png" alt="alt text" width="800" height=""></kbd>

<kbd><img src="https://user-images.githubusercontent.com/32310938/65678141-7751b500-e05b-11e9-987b-b3e74806f77d.png" alt="alt text" width="800" height=""></kbd>

<kbd><img src="https://user-images.githubusercontent.com/32310938/65678156-7de02c80-e05b-11e9-9a82-87243df81a0f.png" alt="alt text" width="800" height=""></kbd>

2.Data Entities
---------------

Create the required **entities**. Use the appropriate **data types**. In this
exercise you will have Users and their Roles

-   **Product**

    -   **Id –** primary key, universally unique identifier

    -   **Name –** string

    -   **Description –** string

    -   **Price** – a floating-point number

    -   **ImageUrl** – a string

    -   **Categories –** a collection of **Category** objects.

-   **Category**

    -   **Id –** primary key, universally unique identifier

    -   **Name -** string

3.Establish the Back-End
------------------------

Create the required:

-   **Entities**

-   **Models**

-   **Repositories**

-   **Services**

-   **Controllers**

4.Functionality
---------------

### Categories

Implement all **CRUD** operations for the **Categories**. They should be pretty
simple as the entity itself is not that complex.

### Products

Implement all **CRUD** operations for the **Products**. NOTE: You cannot
**edit** the **image** of the **Product**.

---
---

Workshop: Part 3 - Orders
=========================

---
---

1.Views
-------

These are the additional views you must implement.

Add “**Order Product**” button into the product details page.

<kbd><img src="https://user-images.githubusercontent.com/32310938/65681156-11682c00-e061-11e9-8293-5d16a162e301.png" alt="alt text" width="800" height=""></kbd>

<kbd><img src="https://user-images.githubusercontent.com/32310938/65681164-14fbb300-e061-11e9-8d38-a92c9059f27b.png" alt="alt text" width="800" height=""></kbd>

<kbd><img src="https://user-images.githubusercontent.com/32310938/65681180-17f6a380-e061-11e9-8a0c-5e5e7724474d.png" alt="alt text" width="800" height=""></kbd>

<kbd><img src="https://user-images.githubusercontent.com/32310938/65681205-1c22c100-e061-11e9-9419-206b4a82d2fb.png" alt="alt text" width="800" height=""></kbd>

<kbd><img src="https://user-images.githubusercontent.com/32310938/65681215-1e851b00-e061-11e9-9601-d2b0422b91d1.png" alt="alt text" width="800" height=""></kbd>

2.Data Entities
---------------

Create the required **entities**. Use the appropriate **data types**. In this
exercise you will have Users and their Roles

-   **Product**

    -   **Id –** primary key, universally unique identifier

    -   **Product –** a product which is ordered

    -   **Customer –** user who is ordering

    -   **OrderDate** – date with time

    -   **Quantity –** number

    -   **TotalPrice –** decimal number

3.Establish the Back-End
------------------------

Create the required:

-   **Entities**

-   **Models**

-   **Repositories**

-   **Services**

-   **Controllers**

4.Functionality
---------------

### Order Product

Implement Order functionality.

### List User’s Orders

Implement a functionality that lists all orders made by the logged in user.

### List All Orders

For Admins only, implement List All Orders.

### Orders Details

Implement a page that shows details for a given order.

---
---

Workshop: Part 4 – Testing
==========================

---
---

1.Service Testing
-----------------

You have been tasked to perform Unit testing on the **Service Layer** of the
**Product Shop** application. Test all methods with all possible cases you can
think of.

Use the **Code Coverage runner** of **IntelliJ** or a tool like
[EclEmma](https://www.eclemma.org/) for **Eclipse** in order to calculate the
coverage of your unit tests. Try to achieve a **Code Coverage** of **80%** on
the **Services**.

2.Integration Testing
---------------------

You have been tasked to perform Integration testing on the **Web Layer** of the
**Product Shop** application. Test all methods with all possible cases you can
think of.

---
---
Workshop: Part 4.5 – Error Handling
===================================

---
---

1.Error Action & Error Page
---------------------------

By default, upon encountering an exception, Spring tries to find an action
mapping at URL "**/error**". If it finds the mapping, Spring sends the error
information there. If there is no such mapping, the **Whitelabel** page is
visualized instead.

Your task is to implement an Error action mapping on "**/error**". It would be
better if the action is in a separate controller. The action should return a
simple **Thymeleaf** view, which you should also implement.

Visualize basic error data – **HTTP Status Code**, **Exception message** etc.
Format it in a User-friendly way.

**NOTE**: The mapping type of the error action is a [**GET**] mapping.

2.Basic Error Handling
----------------------

Implement **global exception handlers**, for exceptions which may occur during
**Framework processes**. For example, database exceptions, Spring request chain
exceptions, etc.

The global exception handler should always return a **500 Internal Server
Error**.

**NOTE**: If you implement everything correctly, it should result in the Error
page, you’ve implemented in the previous task.

3.Custom Error Handling
-----------------------

Implement **Custom Exceptions**, for every Application error you can think of,
like requesting details about a non-existent Product, Ordering with invalid data
etc.

Annotate the exceptions with the appropriate **\@ResponseStatus** annotation.

Attach appropriate messages, which should be constants, for easy code
maintenance.

**NOTE**: If you implement everything correctly, it should result in the Error
page, you’ve implemented in the previous task.

4.\*\* Setting up application environments
------------------------------------------

Do a little research on how you can setup environments in the Spring
application. Setup a **Production environment** and **Development environment**.

In **Production environment** you should keep public error information to an
**absolute minimum**. Only a User-friendly message and a status.

In **Development environment** you should present maximum information about the
error. You should present error message, stack trace etc.

---
---
Workshop: Part 5 – Shopping Cart
================================

---
---

1.Views
-------

These are the additional views you must implement.

<kbd><img src="https://user-images.githubusercontent.com/32310938/65681729-2db89880-e062-11e9-9d8e-db5f5c79a224.png" alt="alt text" width="800" height=""></kbd>

<kbd><img src="https://user-images.githubusercontent.com/32310938/65681733-2f825c00-e062-11e9-9459-e3e9768e0b91.png" alt="alt text" width="800" height=""></kbd>

<kbd><img src="https://user-images.githubusercontent.com/32310938/65681739-34471000-e062-11e9-8340-6d11babb483f.png" alt="alt text" width="800" height=""></kbd>

<kbd><img src="https://user-images.githubusercontent.com/32310938/65681742-37da9700-e062-11e9-983b-a61f9d3d4cd4.png" alt="alt text" width="800" height=""></kbd>

2.Establish the Back-End
------------------------

Create the required:

-   **Entities**

-   **Models**

-   **Repositories**

-   **Services**

-   **Controllers**

3.Functionality
---------------

Implement a shopping cart. You should be able to add products to cart, remove
them, see details about the current condition of the cart and checkout.

<br/>

### Solution: <a title="Product Shop" href="https://github.com/TsvetanNikolov123/JAVA---Java-MVC-Frameworks-Spring/tree/master/17%20WORKSHOP/Product%20Shop/app">Product Shop</a>

---