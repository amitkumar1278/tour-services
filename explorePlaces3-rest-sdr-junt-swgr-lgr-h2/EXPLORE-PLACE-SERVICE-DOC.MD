Sample Postman json data of Explore Place  Service API call:


1. http://localhost:8080/

Request Body:
httpMethod: GET

Response Body:
Status: 200 OK
{
    "_links": {
        "packages": {
            "href": "http://localhost:8080/packages"
        },
        "tours": {
            "href": "http://localhost:8080/tours{?page,size,sort}",
            "templated": true
        },
        "profile": {
            "href": "http://localhost:8080/profile"
        }
    }
}



2. http://localhost:8080/packages

Request Body:
httpMethod: GET


Response Body:
Status: 200 OK
{
    "_embedded": {
        "packages": [
            {
                "name": "Backpack Cal",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/packages/BC"
                    },
                    "tourPackage": {
                        "href": "http://localhost:8080/packages/BC"
                    }
                }
            },
            {
                "name": "California Calm",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/packages/CC"
                    },
                    "tourPackage": {
                        "href": "http://localhost:8080/packages/CC"
                    }
                }
            },
            {
                "name": "California Hot springs",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/packages/CH"
                    },
                    "tourPackage": {
                        "href": "http://localhost:8080/packages/CH"
                    }
                }
            },
            {
                "name": "Cycle California",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/packages/CY"
                    },
                    "tourPackage": {
                        "href": "http://localhost:8080/packages/CY"
                    }
                }
            },
            {
                "name": "From Desert to Sea",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/packages/DS"
                    },
                    "tourPackage": {
                        "href": "http://localhost:8080/packages/DS"
                    }
                }
            },
            {
                "name": "Kids California",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/packages/KC"
                    },
                    "tourPackage": {
                        "href": "http://localhost:8080/packages/KC"
                    }
                }
            },
            {
                "name": "Nature Watch",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/packages/NW"
                    },
                    "tourPackage": {
                        "href": "http://localhost:8080/packages/NW"
                    }
                }
            },
            {
                "name": "Snowboard Cali",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/packages/SC"
                    },
                    "tourPackage": {
                        "href": "http://localhost:8080/packages/SC"
                    }
                }
            },
            {
                "name": "Taste of California",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/packages/TC"
                    },
                    "tourPackage": {
                        "href": "http://localhost:8080/packages/TC"
                    }
                }
            }
        ]
    },
    "_links": {
        "self": {
            "href": "http://localhost:8080/packages"
        },
        "profile": {
            "href": "http://localhost:8080/profile/packages"
        },
        "search": {
            "href": "http://localhost:8080/packages/search"
        }
    }
}




3. http://localhost:8080/tours/search/findByTourPackageCode?code=BC

Request Body:
httpMethod: GET


Response Body:
Status: 200 OK
{
    "_embedded": {
        "tours": [
            {
                "title": "Big Sur Retreat",
                "description": "The content for this field  is only available in the course exercise files found on the website library.",
                "blurb": "The content for this field  is only available in the course exercise files found on the website library.",
                "price": 750,
                "duration": "3 days",
                "bullets": "The content for this field  is only available in the course exercise files found on the website library.",
                "keywords": "Hiking, National Parks, Big Sur",
                "difficulty": "Medium",
                "region": "Central_Coast",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/tours/1"
                    },
                    "tour": {
                        "href": "http://localhost:8080/tours/1"
                    },
                    "tourPackage": {
                        "href": "http://localhost:8080/tours/1/tourPackage"
                    }
                }
            },
            {
                "title": "In the Steps of John Muir",
                "description": "The content for this field  is only available in the course exercise files found on the website library.",
                "blurb": "The content for this field  is only available in the course exercise files found on the website library.",
                "price": 600,
                "duration": "3 days",
                "bullets": "The content for this field  is only available in the course exercise files found on the website library.",
                "keywords": "Hiking, National Parks, Yosemite, John Muir, Camping",
                "difficulty": "Difficult",
                "region": "Northern_California",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/tours/2"
                    },
                    "tour": {
                        "href": "http://localhost:8080/tours/2"
                    },
                    "tourPackage": {
                        "href": "http://localhost:8080/tours/2/tourPackage"
                    }
                }
            },
            {
                "title": "The Death Valley Survivor's Trek",
                "description": "The content for this field  is only available in the course exercise files found on the website library.",
                "blurb": "The content for this field  is only available in the course exercise files found on the website library.",
                "price": 250,
                "duration": "2 days",
                "bullets": "The content for this field  is only available in the course exercise files found on the website library.",
                "keywords": "Hiking, Desert, Camping, Mojave, Death Valley",
                "difficulty": "Difficult",
                "region": "Varies",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/tours/3"
                    },
                    "tour": {
                        "href": "http://localhost:8080/tours/3"
                    },
                    "tourPackage": {
                        "href": "http://localhost:8080/tours/3/tourPackage"
                    }
                }
            },
            {
                "title": "The Mt. Whitney Climbers Tour",
                "description": "The content for this field  is only available in the course exercise files found on the website library.",
                "blurb": "The content for this field  is only available in the course exercise files found on the website library.",
                "price": 650,
                "duration": "4 days",
                "bullets": "The content for this field  is only available in the course exercise files found on the website library.",
                "keywords": "Hiking, Climbing, Backpacking, Mt. Whitney",
                "difficulty": "Difficult",
                "region": "Northern_California",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/tours/4"
                    },
                    "tour": {
                        "href": "http://localhost:8080/tours/4"
                    },
                    "tourPackage": {
                        "href": "http://localhost:8080/tours/4/tourPackage"
                    }
                }
            },
            {
                "title": "Channel Islands Excursion",
                "description": "The content for this field  is only available in the course exercise files found on the website library.",
                "blurb": "The content for this field  is only available in the course exercise files found on the website library.",
                "price": 150,
                "duration": "1 day",
                "bullets": "The content for this field  is only available in the course exercise files found on the website library.",
                "keywords": "Channel Islands, Boating, Whale watching, Hiking",
                "difficulty": "Easy",
                "region": "Southern_California",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/tours/5"
                    },
                    "tour": {
                        "href": "http://localhost:8080/tours/5"
                    },
                    "tourPackage": {
                        "href": "http://localhost:8080/tours/5/tourPackage"
                    }
                }
            }
        ]
    },
    "_links": {
        "self": {
            "href": "http://localhost:8080/tours/search/findByTourPackageCode?code=BC&page=0&size=20"
        }
    },
    "page": {
        "size": 20,
        "totalElements": 5,
        "totalPages": 1,
        "number": 0
    }
}



4. http://localhost:8080/tours/1/ratings

Request Body: (make sure tour id and customer id is unique)

httpMethod: POST
Body -> Raw -> JSON(application/json) 
{
    "score":5,
    "comment":"I thought it was ok",
    "customerId":3
}

Response Body:
Status: 201 Created

(make sure tour id and customer id is unique, if its not unique we may get error like below)
{
    "timestamp": "2020-10-19T20:20:35.331+00:00",
    "status": 500,
    "error": "Internal Server Error",
    "path": "/tours/1/ratings"
}


5. http://localhost:8080/tours/1/ratings

Request Body:
httpMethod: GET


Response Body:
Status: 200 OK
{
    "content": [
        {
            "score": 5,
            "comment": "I loved it",
            "customerId": 4
        },
        {
            "score": 5,
            "comment": "We loved it",
            "customerId": 5
        },
        {
            "score": 5,
            "comment": "She loved it",
            "customerId": 6
        },
        {
            "score": 5,
            "comment": "He loved it",
            "customerId": 7
        },
        {
            "score": 5,
            "comment": "They loved it",
            "customerId": 8
        },
        {
            "score": 5,
            "comment": "Everbody loved it",
            "customerId": 9
        },
        {
            "score": 1,
            "comment": "I hated it",
            "customerId": 10
        },
        {
            "score": 1,
            "comment": "We hated it",
            "customerId": 11
        },
        {
            "score": 5,
            "comment": "I thought it was ok",
            "customerId": 3
        }
    ],
    "pageable": {
        "sort": {
            "sorted": false,
            "unsorted": true,
            "empty": true
        },
        "pageNumber": 0,
        "pageSize": 20,
        "offset": 0,
        "paged": true,
        "unpaged": false
    },
    "last": true,
    "totalPages": 1,
    "totalElements": 9,
    "first": true,
    "number": 0,
    "sort": {
        "sorted": false,
        "unsorted": true,
        "empty": true
    },
    "numberOfElements": 9,
    "size": 20,
    "empty": false
}



6. http://localhost:8080/tours/1/ratings/3?customers=1,2,3

Request Body:
httpMethod: POST


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