TOUR-RATING CONTROLLER EXECUTION:

Now we will access repository via controller and not directly. using Spring Data Rest we can access repo directly.


1. http://localhost:8080/tours/1/ratings

Request Body:

httpMethod: POST
Body -> Raw -> JSON(application/json) 
{
	"score": 5,
	"comment": "It was great!",
	"customerId": 123
}

Response Body:
Status: 201(Created)


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
Status: 404(Not Found)
"Tour does not exist :12345"



3. http://localhost:8080/tours/1/ratings

Request Body:
httpMethod: GET

Response Body:
Status: 200(OK)
[
    {
        "score": 5,
        "comment": "It was great!",
        "customerId": 123
    },
    {
        "score": 10,
        "comment": "It was great!",
        "customerId": 1234
    },
    {
        "score": 3,
        "comment": "It was bad!",
        "customerId": 12345
    },
    {
        "score": 1,
        "comment": "It was worst!",
        "customerId": 123456
    }
]


4. http://localhost:8080/tours/1/ratings/average

Request Body:
httpMethod: GET

Response Body:
Status: 200(OK)
{
    "average": 4.75
}




5. 

first create:
http://localhost:8080/tours/1/ratings

Request Body:
httpMethod: POST
Body -> Raw -> JSON(application/json) 
{
	"score": 4,
	"comment": "can be some improvement!",
	"customerId": 123456
}

Response Body:
Status: 201(Created)

Now Update using put
http://localhost:8080/tours/1/ratings

Request Body:
httpMethod: PUT
Body -> Raw -> JSON(application/json) 
{
	"score": 3,
	"comment": "It was OK!",
	"customerId": 123456
}

Response Body:
Status: 200(OK)
{
    "score": 3,
    "comment": "It was OK!",
    "customerId": 123456
}


Now Update using patch
http://localhost:8080/tours/1/ratings

Request Body:
httpMethod: PATCH
Body -> Raw -> JSON(application/json) 
{
	"score": 1,
	"comment": "It was WORST!",
	"customerId": 123456
}

Response Body:
Status: 200(OK)
{
	"score": 1,
	"comment": "It was WORST!",
	"customerId": 123456
}


Now VERIFY
http://localhost:8080/tours/1/ratings

Request Body:
httpMethod: GET

Response Body:
Status: 200(OK)
{
	"score": 1,
	"comment": "It was WORST!",
	"customerId": 123456
}

Now Delete
http://localhost:8080/tours/1/ratings/123456

Request Body:
httpMethod: DELETE


Response Body:
Status: 200(OK)



6. http://localhost:8080/tours/1/ratings?size=3&page=1&sort=score,desc

Request Body:
httpMethod: GET

Response Body:
Status: 200(OK)
{
    "content": [
        {
            "score": 3,
            "comment": "No Comment",
            "customerId": 1
        },
        {
            "score": 2,
            "comment": "No Comment",
            "customerId": 6
        },
        {
            "score": 1,
            "comment": "No Comment",
            "customerId": 7
        }
    ],
    "pageable": {
        "sort": {
            "sorted": true,
            "unsorted": false,
            "empty": false
        },
        "offset": 3,
        "pageNumber": 1,
        "pageSize": 3,
        "paged": true,
        "unpaged": false
    },
    "last": false,
    "totalElements": 7,
    "totalPages": 3,
    "number": 1,
    "sort": {
        "sorted": true,
        "unsorted": false,
        "empty": false
    },
    "size": 3,
    "first": false,
    "numberOfElements": 3,
    "empty": false
}





