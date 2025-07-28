Server
A server is a system that provides data or services to other systems (clients) over a network.

Responds to requests from clients.

Used in websites, applications, databases, etc.

Web Server
Serves static content like HTML, CSS, JavaScript, and images.

Communicates over HTTP/HTTPS.

Handles browser requests and sends back web pages.

Examples: Apache, Nginx

Application Server
Executes dynamic web content and backend logic.

Provides services like security, database access, and transaction management.

Example: Apache Tomcat

Contains a Servlet Container for managing Java servlets.

Web Container
A part of the application server that loads, runs, and manages Java web components like Servlets and JSP.

Handles:

HTTP request and response processing

Servlet life cycle management

Server-side Programming
Code that runs on the server to handle business logic and database interaction.

Used for:

Processing user inputs

Fetching data from databases

Sending dynamic content to clients

Examples of Server-side Languages

Java

Python

PHP

Node.js

.NET

JDBC (Java Database Connectivity)
Java API used to connect and interact with databases.

Allows executing SQL queries from Java applications.

Steps:

Connect to the database

Execute SQL statements

Process results

Servlets
A Java class that handles HTTP requests and generates responses.

Used to develop dynamic web applications.

Deployed on servers like Tomcat.

Servlet Life Cycle

Initialization (init())

Request Handling (doGet() or doPost())

Destruction (destroy())

How to Run a Servlet

Create a Dynamic Web Project

Add Servlet class

Create HTML form inside webapp directory

Add Tomcat Server in Eclipse

Run the project

Access using: http://localhost:8080/YourProject/sample.html

Localhost
Refers to the local computer.

IP address: 127.0.0.1

Used for testing web applications on the local machine.

IP Address and Port
IP Address

A unique address assigned to each device in a network.

Port

Identifies specific processes or services on a system.

Example: 127.0.0.1:8080 (8080 is the port number)

Analogy

IP Address → City

Port → House Number

Protocol
A set of rules for data communication between systems.

Common Protocols

HTTP: Web communication

HTTPS: Secure HTTP

FTP: File Transfer

SMTP: Email sending

HTTP Error Codes
Code	Type	Description
200	Success	Request was successful
400	Client Error	Bad request from client
500	Server Error	Error occurred on the server side