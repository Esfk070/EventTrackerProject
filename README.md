# EventTrackerProject

## Overview

Week 12 homework for Sill Distillery.

Full-stack project using MySQL, Spring Boot, Spring Data JPA.

## How to run
* In Postman, you may view all, view by id, add, update, and delete a new Soldier data entry
* View All Soldiers
  * Request: GET, URL: http://localhost:8085/api/soldiers
* View Soldier by ID
  * Request: GET, URL: http://localhost:8085/api/soldier/7
* Create new Soldier
  * Request: POST, URL: http://localhost:8085/api/soldier
* Update Soldier By ID
  * Request: PUT, URL: http://localhost:8085/api/soldier/7
  * Add a Body set to Raw JSON type
* Delete Soldier by ID from DataBase
  * Request: DELETE, URL: http://localhost:8085/api/soldier/7
* Un-Enable Soldier
  * Request: DELETE, URL: http://localhost:8085/api/soldierun/7

## HTML/JavaScript Front End using XHR/AJAX

##Database Schema 
![Database Schema](./src/main/resources/static/images/SoldierAppSchemaDiagram.png)
./src/main/resources/static/images/your-image-name.png
## REST Endpoints
| HTTP Verb | URI                  | Request Body | Response Body | Response Codes |
|-----------|----------------------|--------------|---------------|----------------|
| GET       | `/api/soldiers`      |              | List Soldiers    | 200 |
| GET       | `/api/soldier/4`   |              | Representation of soldier `4` | 200, 404 |
| POST      | `/api/soldier`      | Representation of a new _soldier_ resource | Representation of created _soldier_ | 201, 400 |
| PUT       | `/api/soldier/4`   | Representation of a new version of _soldier_ `4` | Representation of updated _soldier_ | 200, 404, 400 |
| DELETE    | `/api/soldier/4`   |              | | 204, 404, 400 |
## Technologies Used

* Java
* STS: Spring Tool Suite
* JPA: Java Persistence API
* MySQL, MySQL Workbench
* AWS
* git, GitHub

## Lessons Learned
* Both a hard delete and a "set enabled to false" method will be useful for most applications.  THe hard delete method will probably be only given to admin users and the applicaiton users will have access to the alternate delete method.
* Database construction needs to be done very deliberately and thoughtfully.  Every field and table should have an application to a planned feature as entity creation and testing can be time consuming.
* Obtaining the correct error responses can be complicated. Methods returning objects or null and then subsequent methods performing null checks seems to be a good route to ensure that the proper errors are outputed
* Reading the console output is critical for tracking down issues, especially that user stories are stretching through multiple java files.

## Where to go from here
* I think there is a market for a consolidated user friendly App for military personel to track service member and equipment information.  I would like this app to be able help facilitate this need.


