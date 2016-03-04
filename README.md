Online Shop based on Spring Framework
=============


This is student project in the subject Data Base at Wroclaw University Of Technology.

Technologies used:
* Spring MVC
* Spring Security 
* Hibernate
* Thymeleaf
* Bootstrap
* Maven to build


Installation
-----------

You can build and run this application with Maven.
Firstly, import project to Eclipse as existing Maven project.
Also, you should create database and add properties like url, user and password  in pom.xml file. 

Now,build parent module with Maven: (type proper profile: development or production)
 

```
mvn clean install 
```

Later build webapp module:

```
clean install tomcat7:run
```
Also with proper profile(both profiles should match)


Usage
-----

```
After building and running application will work on localhost:8080 .
```

You can get access to administration page with those credentials: 
```
login : shop
password : 123456
```

Licence
------------

Apache 2.0 Licence
