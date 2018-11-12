# BlackboardServiceSystem

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
...
2. POST 
webapi/students/
body: 
{
"department": "Information Systems",
"firstName": "Anne",
"studentId": 5,
"joiningDate": "1.11.2018",
"lastName": "Meng",
"registeredCourses":[1, 2]
}
3.PUT
webapi/students/{studentID}
body: 
{
"firstName": "Xinrong"
}
4.DELETE 
webapi/students/{studentID}

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

# Service class - Generic Service class, including Search, Search all, Delete, Create/Update services.
