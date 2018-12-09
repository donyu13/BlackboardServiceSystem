# BlackboardServiceSystem

A system provide blackboard service.
RESTful service: GET, PUT, POST, DELETE Courses, Students, Professors, Announcements and Boards

Cloud Storage: DynamoDB

Serverless: Lambda 
  When a course is created, a SNS topic is generated. 
  When a student register the course, he subscribes the SNS topic automatically.
  When course publishes an annoucement, the studetn will receive an notice email.


## Test
```
Postman Test Requests Collection link:
For assignment 2
  https://www.getpostman.com/collections/76550016f4c7fb908cef
For assignment 3
  https://www.getpostman.com/collections/0bbeb373d960219774b5

<Course>
1. GET
webapi/courses
webapi/courses/{courseID}
2. POST 
webapi/courses/
body: 
{
"courseId":10,
"professorId": 1
}
3.PUT
webapi/courses/{courseID}
body: 
{
"professorId": 2
}
4.DELETE 
webapi/courses/{courseID}

<Professor>
1. GET
webapi/professors
webapi/professors/{professorID}
2. POST 
webapi/professors/
body: 
{
"department": "Information Systems",
"firstName": "Anne",
"professorId": 6,
"joiningate": "1.11.2018",
"lastName": "Zhao"
}
3.PUT
webapi/professors/{professorID}
body: 
{
"firstName": "Moira"
}
4.DELETE 
webapi/professors/{professorID}

<Student>
1. GET
webapi/students
webapi/students/{studentID}
2. POST 
webapi/students/
body: 
{
"department": "Information Systems",
"firstName": "Anne",
"studentId": 5,
"joiningDate": "1.11.2018",
"lastName": "Meng",
"emailId": "meng.careers@gmail.com"
}
3.PUT
webapi/students/{studentID}
body: 
{
"firstName": "Xinrong"
}
4.DELETE 
webapi/students/{studentID}
5.Register Course
webapi/students/{studentID}/register
body: 14

<Annoucement>
1. GET
webapi/announcements
webapi/announcements/{announcementID}
...
2. POST 
webapi/announcements/
body: 
{
"announcementId": 5,
"announcementText": "Please submit assignment 2",
"boardId": 1
}
3.PUT
webapi/announcements/{announcementID}
body: 
{
"announcementText": "Please submit assignment 2 tomorrow"
}
4.DELETE 
webapi/announcements/{announcementID}

<Board>
1. GET
webapi/boards
webapi/boards/{boardID}
2. POST 
webapi/boards
body: 
{
"boardId": 4,
"courseId": 2
}
3.PUT
webapi/boards/{boardID}
body: 
{
"boardId": 5,
"courseId": 2
}
4.DELETE 
webapi/boards/{boardID}


Service class - Generic Service class, including Search, Search all, Delete, Create/Update services.
TopicUtil class - Utility class for the SNS Topic.
AnnouncementLambdaFuncHandler class - Lambda function.
```

