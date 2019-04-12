# e-learning

1-Download the project  
2-Import as existing maven project  
3-Maven Update  
4-Run ElearningApplication.java as java application 
5-open url http://localhost:8080/h2-console to access h2 database with username sa and password sa  

----------------------------------- 

Test the application with postman or any other tool   
Here is the list of API 
POST http://localhost:8080/student To add student   
sampledata:
    { 
        "id": 1,  
        "name": "John", 
        "email":"jhon@gmail.com", 
        "username": "Jhon_1", 
        "password": "password"  
    } 
    
POST http://localhost:8080/course To add Course
sampledata: 
{
        "id": 3,
        "name": "ADF",
        "description": "ADF Framwork",
        "publishDate": "2019-04-11T22:00:00.000+0000",
        "lastUpdated": null,
        "totalHours": 30,
        "instractor": "Java Prof."
    }
    
 GET http://localhost:8080/course to get all courses  
 
 POST http://localhost:8080/course/register?studentId=1&courseId=3 to  register student to course
 
 PUT http://localhost:8080/course/unregister?studentId=1&courseId=3 to unregister student from course
 
 GET http://localhost:8080/course/student?studentId=1 to get all courses registered by student
 
 ------
 
 TODO List:
 
 1- Add sequirity and make login service  
 2- Add Logging to th application 
 3- Solve th issue of Test Classes as they are not working  
 
