Coverage: 34%
# Project Title -  QA-SoftwareCore-Fundamental-Project-Specification

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

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

What things you need to install the software and how to install them

```
Give examples
```

### Installing

A step by step series of examples that tell you how to get a development env running

Say what the step will be

```
Give the example
```

And repeat

```
until finished
```

End with an example of getting some data out of the system or using it for a little demo

## Running the tests

Explain how to run the automated tests for this system. Break down into which tests and what they do

### Unit Tests 

Explain what these tests test, why and how to run them

```
Give an example
```

### Integration Tests 
Explain what these tests test, why and how to run them

```
Give an example
```

### And coding style tests

Explain what these tests test and why

```
Give an example
```

## Deployment

Add additional notes about how to deploy this on a live system

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Authors

* **Chris Perrins** - *Initial work* - [christophperrins](https://github.com/christophperrins)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

* Hat tip to anyone whose code was used
* Inspiration
* etc
