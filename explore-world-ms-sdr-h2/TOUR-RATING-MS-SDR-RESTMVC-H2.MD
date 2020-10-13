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



sample  6
14. http://localhost:8080/tours/search

Request Body:
httpMethod: GET

Response Body:
Status: 200(OK)
{
    "_links": {
        "findByTourPackage": {
            "href": "http://localhost:8080/tours/search/findByTourPackage{?code}",
            "templated": true
        },
        "self": {
            "href": "http://localhost:8080/tours/search"
        }
    }
}



sample
14. http://localhost:8080/tours/search

Request Body:
httpMethod: GET

Response Body:
Status: 200(OK)
{
    "_links": {
        "findByTourPackage": {
            "href": "http://localhost:8080/tours/search/findByTourPackage{?code}",
            "templated": true
        },
        "self": {
            "href": "http://localhost:8080/tours/search"
        }
    }
}


sample
14. http://localhost:8080/tours/search

Request Body:
httpMethod: GET

Response Body:
Status: 200(OK)
{
    "_links": {
        "findByTourPackage": {
            "href": "http://localhost:8080/tours/search/findByTourPackage{?code}",
            "templated": true
        },
        "self": {
            "href": "http://localhost:8080/tours/search"
        }
    }
}