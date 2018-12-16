# BlackboardServiceSystem

A system provide blackboard service.
RESTful service: GET, PUT, POST, DELETE Courses, Students, Professors, Announcements and Boards

Cloud Storage: DynamoDB

Serverless: Lambda 
  When a course is created, a SNS topic is generated. 
  When a student register the course, he subscribes the SNS topic automatically.
  When course publishes an annoucement, the studetn will receive an notice email.

Workflow: 
  When a course is passed to CourseCreation API (in API Gateway), a state machine is triggered, a workflow starts.
  The workflows first step is to determine if the course is new and if resources need to be created for it. 
  A course is new if boardId, listofRegisteredStudents and it’s notificationTopic field are empty. 
  If the course is not new, the workflow stops. 
  If the department name is “Seminars”, registrar should not create a record. End workflow here. 
  If the department name is not “Seminars”, create a object in the Registrar table and continue the workflow.
  Create a board object for the Course. Also store the boardId in the relevant Course record. 
  Complete lifecycle. 
  
# Tests
```
Postman Test Requests Collection link:
For assignment 2
  https://www.getpostman.com/collections/76550016f4c7fb908cef
For assignment 3
  https://www.getpostman.com/collections/0bbeb373d960219774b5
  
<Workflow>
CourseCreation API (in API Gateway) 
https://nx1ierzq5e.execute-api.us-east-2.amazonaws.com/dev
body:
{"courseId": 80,"professorId": 1,"TAId": 1,"department": "IS","boardId": 1}
{"courseId": 80,"professorId": 1,"TAId": 1,"department": "IS"}
{"courseId": 81,"professorId": 1,"TAId": 1,"department": "Seminars"}


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
```
# Comments:
```
Service class - Generic Service class, including Search, Search all, Delete, Create/Update services.
TopicUtil class - Utility class for the SNS Topic.
DynamoDBObject class - Generic type for data models.

AnnouncementLambdaFuncHandler class - Lambda function for course to publish announcement to registered students.
BoardLambdaFuncHandler class - Lambda function to create a board for a course.
CourseLambdaFuncHandler calss - Lambda function to determine if a course is new and create corresponding resources if needed.
RegisterLambdaFuncHandler - Lambda function to create the resource Register (using HTTP request object to call RegistrarService URL instead of directly accessing the dynamodb). 
```
# Notes:
```
In DynamoDBConnector class, 
For local development:
ProfileCredentialsProvider credentialsProvider = new ProfileCredentialsProvider();
For cloud deployment:
InstanceProfileCredentialsProvider credentialsProvider = new InstanceProfileCredentialsProvider(false);
```

