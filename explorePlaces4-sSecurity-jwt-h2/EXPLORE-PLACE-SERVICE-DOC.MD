Sample Postman json data of Explore Place  Service API call:


1. 
httpMethod: GET

http://localhost:8080/packages
Request Body:

http://localhost:8080/tours
Request Body:






2.1. http://localhost:8080/users/signin

Request Body:
	httpMethod: POST
	http://localhost:8080/tours
	Body -> Raw -> JSON(application/json) 
	{
		"username": "admin",
		"password": "letmein"
	}

Response Body:
Status: 200 OK

{
    "authorities": [
        {
            "id": 1,
            "roleName": "ROLE_ADMIN",
            "description": "Administrator"
        }
    ],
    "authenticated": true,
    "principal": {
        "username": "admin",
        "authorities": [
            {
                "id": 1,
                "roleName": "ROLE_ADMIN",
                "description": "Administrator"
            }
        ],
        "accountNonExpired": true,
        "accountNonLocked": true,
        "credentialsNonExpired": true,
        "enabled": true
    },
    "name": "admin"
}


2.2. Invalid User Scenario
http://localhost:8080/users/signin

Request Body:
	httpMethod: POST
	http://localhost:8080/tours
	Body -> Raw -> JSON(application/json) 
	{
		"username": "invalidUser",
		"password": "letmein"
	}

Response Body:
Status: 403 forbidden
{
    "timestamp": "2020-10-24T08:52:55.252+00:00",
    "status": 403,
    "error": "Forbidden",
    "path": "/users/signin"
}



3. http://localhost:8080/tours/12345/ratings

Request Body:

httpMethod: POST
Body -> Raw -> JSON(application/json) 
{
	"score": 6,
	"comment": "It was great !",
	"customerId": 1233
}

Response Body:
Status: 200 OK
"Tour does not exist :12345" 



















// sample
2. http://localhost:8080/tours/12345/ratings

Request Body:

httpMethod: POST
Body -> Raw -> JSON(application/json) 
{
	"score": 6,
	"comment": "It was great !",
	"customerId": 1233
}

Response Body:
Status: 200 OK
"Tour does not exist :12345" 

// sample
2. http://localhost:8080/tours/12345/ratings

Request Body:

httpMethod: POST
Body -> Raw -> JSON(application/json) 
{
	"score": 6,
	"comment": "It was great !",
	"customerId": 1233
}

Response Body:
Status: 200 OK
"Tour does not exist :12345" 

// sample
2. http://localhost:8080/tours/12345/ratings

Request Body:

httpMethod: POST
Body -> Raw -> JSON(application/json) 
{
	"score": 6,
	"comment": "It was great !",
	"customerId": 1233
}

Response Body:
Status: 200 OK
"Tour does not exist :12345" 

// sample
2. http://localhost:8080/tours/12345/ratings

Request Body:

httpMethod: POST
Body -> Raw -> JSON(application/json) 
{
	"score": 6,
	"comment": "It was great !",
	"customerId": 1233
}

Response Body:
Status: 200 OK
"Tour does not exist :12345" 

// sample
2. http://localhost:8080/tours/12345/ratings

Request Body:

httpMethod: POST
Body -> Raw -> JSON(application/json) 
{
	"score": 6,
	"comment": "It was great !",
	"customerId": 1233
}

Response Body:
Status: 200 OK
"Tour does not exist :12345" 

// sample
2. http://localhost:8080/tours/12345/ratings

Request Body:

httpMethod: POST
Body -> Raw -> JSON(application/json) 
{
	"score": 6,
	"comment": "It was great !",
	"customerId": 1233
}

Response Body:
Status: 200 OK
"Tour does not exist :12345" 