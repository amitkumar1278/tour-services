Sample Postman json data of Explore Place  Service API call:



// sample
1. http://localhost:8080/tours/12345/ratings

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



