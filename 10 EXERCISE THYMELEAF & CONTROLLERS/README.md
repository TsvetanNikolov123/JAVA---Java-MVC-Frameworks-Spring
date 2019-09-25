10 Project: Resident Evil
=========================

---
---

**Resident Evil** is a system that registers virus spreads across the world. It
is a significantly big project, and as such it will have several parts. In this
exercise you will land the basis of the application. You will also create the
majority of the visual design.

<kbd><img src="https://user-images.githubusercontent.com/32310938/65640074-2d80b480-dff2-11e9-9f5e-bedddb715d55.png" alt="alt text" width="800" height=""></kbd>

---

Exercises: Thymeleaf Engine
===========================

Problems for exercises and homework for the [“Java MVC Frameworks - Spring”
course \@
SoftUni](https://softuni.bg/trainings/1538/java-mvc-frameworks-spring-march-2017).

1.Views
-------

You would need couple of views. Separate the **menu and the forms** in html
files and include them. Use a design that you find appropriate. The examples use
**Bootstrap 4**.

<kbd><img src="https://user-images.githubusercontent.com/32310938/65640079-31143b80-dff2-11e9-8fb7-76fbb6a6baeb.png" alt="alt text" width="800" height=""></kbd>

-   **Home**

    -   Entry point of the application

-   **Viruses**

    -   Dropdown menu with 2 buttons – [**Show**] and [**Add**]

    -   [**Show**] – All the viruses are shown here. You can **edit** and
        **delete** each virus.

    -   [**Add**] – You can add.

   **NOTE:** \#900C45 this is the color you need

2.Data Entities
---------------

Create the required **entities**. Use the appropriate **data types**.

-   **Virus**

    -   Name – Cannot be empty, should be between **3** and **10** symbols.

    -   Description – Cannot be empty, should be between **5** and **100**
        symbols.

        -   Represented as Text in the database

    -   Side Effects – Should have a maximum of **50** symbols.

    -   Creator – Should be either **Corp** or **corp**.

    -   Is Deadly – Boolean

    -   Is Curable – Boolean

    -   Mutation – Cannot be null. Should hold one of the following values:

        -   ZOMBIE

        -   T_078_TYRANT

        -   GIANT_SPIDER

    -   Turnover Rate – Number, between **0** and **100**.

    -   Hours Until Turn (to a mutation) – Number, between **1** and **12**.

    -   Magnitude – Cannot be null. Should hold one of the following values:

        -   Low

        -   Medium

        -   High

    -   Released On – Date, should be before the “**today**” date.

    -   Capitals – A **collection** of **Capitals**.

-   **Capitals**

    -   Name

    -   Latitude

    -   Longitude

3.Establish the Back-End
------------------------

Create the required:

-   **Entities**

-   **Models**

-   **Repositories**

-   **Services**

-   **Controllers**

   **Load** the **capitals** by the provided **SQL.**

4.Add Viruses
-------------

Create a functionality to **add** Viruses. Make the necessary **validations**.
Create a custom annotation to validate the Release Date.

<kbd><img src="https://user-images.githubusercontent.com/32310938/65640089-37a2b300-dff2-11e9-8d56-339025653ee7.png" alt="alt text" width="800" height=""></kbd>

<kbd><img src="https://user-images.githubusercontent.com/32310938/65640099-3d989400-dff2-11e9-9813-e2bc61ce3731.png" alt="alt text" width="800" height=""></kbd>

5.Show Viruses
--------------

Create a functionality that **shows** all of the created viruses.

<kbd><img src="https://user-images.githubusercontent.com/32310938/65640104-40938480-dff2-11e9-9d81-e61bae92c5f3.png" alt="alt text" width="800" height=""></kbd>

6.Edit Viruses
--------------

Create a functionality to **edit** Viruses. You should be able to edit
everything **except** the **release date**. Make the necessary **validations.**

7.Delete Viruses
----------------

Create a functionality to **delete** Viruses
<br/>

### Solution: <a title="Resident Evil" href="https://github.com/TsvetanNikolov123/JAVA---Java-MVC-Frameworks-Spring/tree/master/10%20EXERCISE%20THYMELEAF%20%26%20CONTROLLERS/Resident%20Evil%20v%201.2/residentevil">Resident Evil</a>

---