Sample Postman json data of Explore Place  Service API call:


1. 
httpMethod: GET

http://localhost:8080/packages
Request Body:

http://localhost:8080/tours
Request Body:






2. http://localhost:8080/users/signin

Request Body:
	httpMethod: POST
	http://localhost:8080/tours
	Body -> Raw -> JSON(application/json) 
	{
		"username": "admin",
		"password": "letmein"
	}

Response Body:
Status: 201 Created

Note: if customer id and tour is already having a record then this service will throw error like, because of constraint on schema:
{
    "timestamp": "2020-10-19T20:41:59.467+00:00",
    "status": 500,
    "error": "Internal Server Error",
    "path": "/tours/1/ratings/3"
}




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