# educurd
EduCurd:
Developed system to private education business, where administrators can keep track of teachers and students, and perform some administrative functions. Teachers and students are identified by their email addresses.
Development Environment and Setup
Backend – Java 13
Database – MySql (Configuration - Please refer to the application.properties file)
IDE – IntelliJ IDEA
MySQL Workbench 8.0
PostMan

API’s:
1.	To add a teacher
 
Details
Post API: http://localhost:8081/api/teachers
This endpoint to add a new teacher.
Body:  
{"name" : "t10",
"email" : "t10@gmail.com"}

Where: 
Name – Teachers name in String (required).
Email- Teacher email in String Should be unique(required).

Returns: Returns all info about the added teacher included the generated id.
{
    "teacher": {
        "id": 10,
        "name": "t10",
        "email": "t10@gmail.com"
    }
}

201 – Created: Everything work as expected.
400 – Bad Request: the request was unacceptable. Reason: missing a required parameter.
500 – Server Error: Something went wrong 

2.	To add a student
 
Details
Post API: http://localhost:8081/api/students
This endpoint to add a new student.
Body:  
{"name" : "s10",
"email" : "s10@gmail.com"}

Where: 
Name – Student name in String (required).
Email- Student email in String Should be unique(required).
Returns: Returns all info about the added teacher included the generated id.
{
    "student": {
        "id": 10,
        "name": "s10",
        "email": "s10@gmail.com"
    }
}

201 – Created: Everything work as expected.
400 – Bad Request: the request was unacceptable. Reason: missing a required parameter.
500 – Server Error: Something went wrong 

3.	To register one or more student to a specified teacher.
 
Details
Post API: http://localhost:8081/api/students/register
This endpoint to add teacher and student relationship.
Body:  
{"teacher" : "t1@gmail.com",
"student" : [
    "s7@gmail.com",
    "s10@gmail.com"]
}

Where: 
teacher – teacher email in String (required).
Student - Student email in List (required).

204 – No Content: Successfully fulfilled the request
400 – Bad Request: the request was unacceptable. Reason: missing a required parameter.
500 – Server Error: Something went wrong 

4.	To retrieve student who are registered to all of the given teachers.
 
Details
Get API: http://localhost:8081/api/commonStudents?teacher=t2@gmail.com&teacher=t1@gmail.com
This get method to retrieve teacher and student relationship.
Body:  No Body , Teacher email provided as query parameters
Where: 
teacher – teacher email in String (required).

Returns: Returns teacher and student relationship by listing the student email under the particular teacher or combined teacher.
{
    "students": [
        "s3@gmail.com",
        "s5@gmail.com",
        "s7@gmail.com",
        "s10@gmail.com"
    ]
}
200 – OK: the request successful.
400 – Bad Request: the request was unacceptable. Reason: missing a required parameter.
500 – Server Error: Something went wrong 
