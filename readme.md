#Online TODO List
I have done the project according to my best understanding  of the given requirements I went an extra mile by adding other functionality on top of the given requirement like registering a new user which I implemented the backend I was only left with hooking the backend with the front end another functionality I added was  the functionality to view a specific task in detail from the list in the table I was not yet done with that , but in terms of the given requirement I did cover the minimum functionality of the application.

The approach taken for the solution was to use the spring MVC approach as my design pattern the reason I went with approach was spring boot its quite easy to spin a spring boot application, Ease of Dependency Management- Ease of Dependency Management spring Boot implicitly packages the required third-party dependencies for each type of Spring-based application and provides them through so-called starter packages (spring-boot-starter-web, spring-boot-starter-data-jpa, etc.) and also Automatic Сonfiguration - automatically configure your Spring application based on the jar dependencies you added. For example, if you add Spring-boot-starter-web, Spring Boot will automatically configure registered beans such as DispatcherServlet, ResourceHandlers, and MessageSource.

The 1st thing I did in approaching the solution was the database designing to understand how my tables are related that was the User and the Task table so I took time to understand the relationship of the tables, the columns involved, unique constraints, and the primary keys then I created the entity relationship Diagrams to show my relationships before implementation. Then I chose the JPA implementation of persistence layer because it works so well with databases. For the database I used H2 in memory database.
I also looked at the package structure of my application where I wanted to follow the model view controller design pattern , so the application is categorised in packages that is Controller where I have the controller which interact with the view(html) and also the DTO(Data Transfer Object) the reason I used the DTO was to avoid passing the entity object directly to the view, then I have the service layer package where it deals with the business logic , from that I have the model package where I have all my entities for my application and also I have the repository package it has the repo classes which allows me interact with the database.
For security I have used spring security to secure my application and to access any application resources you have to log in 1st The application is a 3 layer architecture UI- templates, Backend – Services, Models and the Database – H2. Also have implemented logging to allow the debugging and understanding the objects within the application at any given time. I have tried to add comments so that it explains to anyone who reads the code can understand the flow of the system. Unit tests are also included in some instances though I could have done more to improve the unit test coverage but due to time constraints I could not do much. Unit tests make the application to be more robust.

In terms of technologies, I used the following
1 Spring boot
2 Spring security
3 H2 Database
4 Thymeleaf templating
5 Maven
6 JPA(Hibernate)

If I were give more time I could have completed  the registration process of a new user, forget password flow in the case of users who forget their passwords, Also encode the password so that its not stored as plain text in the database, robust error handling but I believe I covered the requirement of the assignment.


##Running the Application
1.	The application is based on the assumption that users are already created so I have manually inserted a list of users in the database with the use of the data.sql file which is on the path …… /deloitte/deloitte/src/main/resources.data.sql
2.	When running the application locally run the spring boot app which has the embedded tomcat or else can use the war file in the project.
3.	Once spring boot is up and running navigate to http://localhost:8080/login where you be promoted to enter the username and password and validation for username and password is done with spring security calling the database to validate the credentials.
4.	If you want to check the available users for username and password in the database you can navigate to http://localhost:8080/h2-console assuming you are running the app locally and you will prompted the password to connect to the database which is found in the application properties file.Once logged in you can see the tables in the database that is User and Task table.
5.	Get one user from the table then you can use it to log in to the application http://localhost:8080/login  e.g  Username : Username: asmith Password: protest1@
6.	Once logged in you can create a task , view the list and delete the task as mentioned in the requirement as minimum functionality.
      Good Luck- Any questions please reach out happy to explain the approach I used.`
