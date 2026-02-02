# M.Dhanush-skill-exchange-project
1. Introduction

The Skill Exchange & Booking System is a menu-driven command-line application developed using Core Java, MySQL, and JDBC.
The main objective of this project is to provide a platform where users can offer skills, browse available skills, and book skill sessions from other users.

This project demonstrates practical implementation of:

* Java programming concepts
* Database connectivity using JDBC
* CRUD operations
* Relational database design


2. Objectives of the Project

* To understand JDBC connectivity between Java and MySQL
* To implement menu-driven CLI applications
* To perform CRUD operations using SQL
* To work with relational tables and joins
* To develop a real-world usable system



3. Scope of the Project

* Users can register and log in
* Users can add skills they offer
* Users can browse skills offered by others
* Users can book skills
* Users can view their booking history
* The project is designed for learning purposes and can be extended in the future with advanced features.


4. Technology Stack
* Technology	Description
* Java	Core Java (JDK 8+)
* Database	MySQL
* Connectivity	JDBC
* IDE	Eclipse / IntelliJ / VS Code
* OS	Windows / Linux / macOS


5. System Requirements
Hardware Requirements

* Minimum 4 GB RAM
* 10 GB free disk space
* Any standard processor
* Software Requirements
* JDK 8 or higher
* MySQL Server
* MySQL Connector/J (JDBC Driver)
* Java IDE or Command Prompt


6. Database Design
Database Name
skill_exchange

Tables Overview

* users
* skills
* bookings

6.1 users Table

Stores user account information.

Field	Type	Description
user_id	INT (PK)	Unique user ID
name	VARCHAR(50)	User name
email	VARCHAR(50)	User email
password	VARCHAR(50)	User password


6.2 skills Table

Stores skills offered by users.

Field	Type	Description
skill_id	INT (PK)	Skill ID
user_id	INT (FK)	Owner of skill
skill_name	VARCHAR(50)	Skill name
description	VARCHAR(100)	Skill details
price_per_hour	DOUBLE	Skill price


6.3 bookings Table

Stores booking details.

Field	Type	Description
booking_id	INT (PK)	Booking ID
skill_id	INT (FK)	Booked skill
booked_by	INT (FK)	User who booked
booking_date	DATE	Booking date
status	VARCHAR(20)	Booking status


7. Project Architecture

The project follows a DAO (Data Access Object) based architecture.

Components:

* Main Class – Handles menu & user interaction
* DAO Classes – Database operations
* DBConnection – JDBC connection handling


8. Project Modules
8.1 User Module

* User Registration
* User Login

8.2 Skill Module

* Add Skill
* View All Skills

8.3 Booking Module

* Book Skill
* View Booking History

9. Class Description
9.1 DBConnection.java

* Establishes connection with MySQL database
* Uses JDBC DriverManager

9.2 UserDAO.java

* Handles user registration
* Performs user authentication

9.3 SkillDAO.java

* Adds new skills
* Displays available skills using SQL JOIN

9.4 BookingDAO.java

* Handles skill booking
* Displays user booking history

9.5 Main.java

* Entry point of application
* Contains menu-driven logic



10. Application Workflow

* User launches application
* User registers or logs in
* After login:
* Add skills
* Browse skills
* Book skills
* View bookings
* User logs out or exits



11. Sample Output
=== SKILL EXCHANGE SYSTEM ===
1. Register
2. Login
3. Exit

--- USER MENU ---
1. Add Skill
2. Browse Skills
3. Book Skill
4. View My Bookings
5. Logout



12. Advantages of the System

* Simple and user-friendly
* Real-world application concept
* Demonstrates Java + JDBC integration
* Easy to maintain and extend
* Reduces manual record keeping


13. Limitations

* No password encryption
* No admin module
* Command-line interface only
* No payment gateway


14. Future Enhancements

* Password hashing & security
* Admin dashboard
* Skill rating & reviews
* Payment integration
* GUI using JavaFX or Swing
* REST API integration


15. Conclusion

The Skill Exchange & Booking System successfully demonstrates the use of Core Java, JDBC, and MySQL to build a real-world, menu-driven application.
The project strengthens understanding of database connectivity, SQL operations, and Java programming concepts.

16. References

* Java Documentation
* MySQL Documentation
* JDBC API Guide
