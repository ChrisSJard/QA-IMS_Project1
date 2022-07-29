# Project Title -  QA-SoftwareCore-Fundamental-Project-Specification

Please view Release Version 1.0.0 to view document
* Packaged Jar file
* UML diagram - file IMS UML.drawio open into drawer.io web application as size is large.
* ERD diagram - file IMS ERD_ open into drawer.io web application.
* Risk assessment documentation.

## Objective

The overall objective of the project is the following:

  * To create an application with utilisation of supporting tools, methodologies and technologies that encapsulate all fundamental modules covered during training.

Specifically, you are required to create an application using the language from your Programming Fundamentals Module which interacts with a Managed Database.
You must plan the approach you will take to complete this project using the design techniques learnt, and also create a CI Pipeline that can automate the building and deployment of your artifact.

## Domain
You are required to build an application that an end user can interact with via a CLI (Command Line Interface).
The application needs to be an inventory management system that needs to be able to:

* Add a customer to the system
* View all customers in the system
* Update a customer in the system
* Delete a customer in the system.
* Add an item to the system
* View all items in the system
* Update an item in the system
* Delete an item in the system
* Create an order in the system.
* View all orders in the system.
* Delete an order in the system
* Add an item to an order.
* Calculate a cost for an order.
* Delete an item in an order.

When considering the entities in this domain:
* A customer needs to have a name.
* An item needs to have a name and a value.
* An order needs to have a customer and contains items

## Extension
* Add a user to the system
* List all users
* Changes to customers, items and orders need to be tied to a user.
* A user should have a username and password
* You must be able to log in as a user within the system to make any changes.

## Constraints
* Version Control System - Git
* Source Code Management - GitHub
* Kanban Board - Jira
* Database - MySQL Server 5.7+ (local or cloud hosted)
* Back-end Programming Language - Java
* Build Tool - Maven
* Unit Testing - JUnit

## Jira Connection

Please use link to view Jira software Sprint
[Jira link](https://chrissjard-1995.atlassian.net/jira/software/projects/SCFPS/boards/4)

## Getting Started

Using your preferred Version control software , clone the repository on this repository into your own. Use clone SSH.
Go to src/main/resources/sql-schema.sql and import this file into your database management system. Execute the SQL query -> This will generate the necessary database and tables.
Go to src/main/java/com/qa/ims/Runner and run this class.
An interface will appear to run various CRUD applications on the console

### Prerequisites

* IDE able to run JAVA applications (e.g [Eclipse IDE link](https://www.eclipse.org/downloads/)
* Maven (to install use link [Maven install](https://maven.apache.org/install.html)
* A database management system that can run mySQL quesries. 

### Dependencies
* maven compiler
* jqno.equalsverifier
* h2database
* mysql-connector <8.0.19>
* apache.logging.log4j <2.13.3>
* mockito <3.7.7>
* Junit <4.13.1>
* apache.maven.plugins <3.2.0>
* jacoco <0.8.5>
* apache.maven.deploy <3.0.0-M1>

### Installing

Once steps are perfromed in Getting Started section.
Run the Runner.java in your ide or console.
A termianl will appear as shown:
Welcome to the Inventory Management System!
CUSTOMER: Information about customers
ITEM: Individual Items
ORDER: Purchase of items
STOP: To close the application
awaiting input ...

Input >>"Item" on the console
What would you like to do with item:
CREATE: To save a new entity into the database
READ: To read an entity from the database
UPDATE: To change and entity already in the database
DELETE: To remove an entity from the database
RETURN: To return to domain delection
awaiting input ...
Input >> Create
Input product name >>
Input product description >>
Input product value >>

Product created

Input >> Read
Product "[productid=1, description= "", name= "", value = long]"

 
## Running the tests

Running Test are located in the src/test/java folder

Go to the Java files in the specified folder, right click and run as Junit test. (You must have Junit dependency installed to have option or Eclipse whhich has it build in)

### Unit Tests

Unit tests are a testing approach that targets the very fundamental building blocks of an application, the idea is to prove that each 'unit' of the application is functioning as expected
These tests were focused on the customer , order and product classes.
Location src/test/java/com/qa/ims/persistence/domain/ 

```
@Test 
public void constructorTest(){
    Customer object = new Customer("harry","bon");
    assertTrue( object instanceof Customer);
}
```

### Integration Tests

Intergration Testing was used to best database functionality using Mockito and used to test external dependencies.
These test were focused on the controller classes.
Location src/test/java/com/qa/ims/controllers/

```
@Test 
public void testCreate(){
   final String description = "This is a description test";
   final String name = "product name test";
   final Double value = 10.0;
   final Product created = new Product(name, description, value);
  
   Mockito.when(utilsMock.getString()).thenReturn(name, description);
   Mockito.when(utilsMock.getDouble()).thenReturn(value);
   Mockito.when(daoMock.create(created)).thenReturn(created);

   assertEquals(created, controllerMock.create());
   Mockito.verify(utilsMock, Mockito.times(2)).getString();
   Mockito.verify(utilsMock, Mockito.times(1)).getDouble();
   Mockito.verify(daoMock, Mockito.times(1)).create(created);
}
``` 


## Deployment

Using Maven as dependency handler
Open up console to directory with pom file
mvn clean - clear any existing built packages
mvn package - build the package

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use Git for version control.

## Authors

* **Chris Perrins** - *Initial work* - [christophperrins](https://github.com/christophperrins)
* **Christian Jardine** - *Updated work to controller, order, customer systems* 
## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*


