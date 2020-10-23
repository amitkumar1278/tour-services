# Microservice Documentation link:

Spring Data  Rest is used to create service for Hypermedia driven restful API. A API is not truly restful unless it follows Uniform interface. 

The uniform interface that any REST services must provide is fundamental to its design.

Its constraint defines the interface between clients and servers. The four guiding principles of the uniform interface are:

Resource-Based: 
Individual resources are defined in requests using URIs as resource identifiers and are separate from the responses that are returned to the client.

Actions on Resources Through Representations: 
When a client gets a representation of a resource, including any metadata attached, it has enough information to customize or delete the resource on the server, if it has permission to do so.

Self-descriptive Messages: 
Each message includes a precise information that describes how to process it. The responses also clearly indicate their cache-ability.

Hypermedia as the Engine of Application State (HATEOAS): 
Clients deliver the state via body contents, query-string parameters, request headers and the requested URI. Services deliver state to clients via body content, response codes, and response headers.


for RESTful API Basic Guidelines: https://blog.restcase.com/restful-api-basic-guidelines/#



A Restful API should do more than exposing resource, it should also expose documentation automatically, by providing navigation between resources. Implementer of Spring Data Rest Agree with these conditions therefore Spring Data Rest is Hypermedia driven out of the box support.

## for example, after Navigating "http://localhost:8080/" below documentation will open as Rest API demand, where you can explore other Spring Data Rest services


{
  "_links" : {
    "tourPackages" : {
      "href" : "http://localhost:8080/tourPackages"
    },
    "tours" : {
      "href" : "http://localhost:8080/tours"
    },
    "profile" : {
      "href" : "http://localhost:8080/profile"
    }
  }
}


## When we visit "http://localhost:8080/profile", document created by "Spring data rest" is looking like:

{
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/profile"
    },
    "tourPackages" : {
      "href" : "http://localhost:8080/profile/tourPackages"
    },
    "tours" : {
      "href" : "http://localhost:8080/profile/tours"
    }
  }
}

## When opening any service, like "http://localhost:8080/profile/tourPackages", we receive meta-data of microservice like:

{
	"alps": {
		"version": "1.0",
		"descriptor": [
			{
				"id": "tourPackage-representation",
				"href": "http://localhost:8080/profile/tourPackages",
				"descriptor": [
					{
						"name": "name",
						"type": "SEMANTIC"
					}
				]
			},
			{
				"id": "create-tourPackages",
				"name": "tourPackages",
				"type": "UNSAFE",
				"descriptor": [
				],
				"rt": "#tourPackage-representation"
			},
			{
				"id": "get-tourPackages",
				"name": "tourPackages",
				"type": "SAFE",
				"descriptor": [
				],
				"rt": "#tourPackage-representation"
			},
			{
				"id": "update-tourPackage",
				"name": "tourPackage",
				"type": "IDEMPOTENT",
				"descriptor": [
				],
				"rt": "#tourPackage-representation"
			},
			{
				"id": "delete-tourPackage",
				"name": "tourPackage",
				"type": "IDEMPOTENT",
				"descriptor": [
				],
				"rt": "#tourPackage-representation"
			},
			{
				"id": "patch-tourPackage",
				"name": "tourPackage",
				"type": "UNSAFE",
				"descriptor": [
				],
				"rt": "#tourPackage-representation"
			},
			{
				"id": "get-tourPackage",
				"name": "tourPackage",
				"type": "SAFE",
				"descriptor": [
				],
				"rt": "#tourPackage-representation"
			},
			{
				"name": "findByName",
				"type": "SAFE",
				"descriptor": [
					{
						"name": "name",
						"type": "SEMANTIC"
					}
				]
			}
		]
	}
}



## When opening any service, like "http://localhost:8080/profile/tours", we receive meta-data of microservice like:

{
	"alps": {
		"version": "1.0",
		"descriptor": [
			{
				"id": "tour-representation",
				"href": "http://localhost:8080/profile/tours",
				"descriptor": [
					{
						"name": "title",
						"type": "SEMANTIC"
					},
					{
						"name": "description",
						"type": "SEMANTIC"
					},
					{
						"name": "blurb",
						"type": "SEMANTIC"
					},
					{
						"name": "price",
						"type": "SEMANTIC"
					},
					{
						"name": "duration",
						"type": "SEMANTIC"
					},
					{
						"name": "bullets",
						"type": "SEMANTIC"
					},
					{
						"name": "keywords",
						"type": "SEMANTIC"
					},
					{
						"name": "difficulty",
						"type": "SEMANTIC",
						"doc": {
							"format": "TEXT",
							"value": "Easy, Medium, Difficult, Varies"
						}
					},
					{
						"name": "region",
						"type": "SEMANTIC",
						"doc": {
							"format": "TEXT",
							"value": "Central_Coast, Southern_California, Northern_California, Varies"
						}
					},
					{
						"name": "tourPackage",
						"type": "SAFE",
						"rt": "http://localhost:8080/profile/tourPackages#tourPackage-representation"
					}
				]
			},
			{
				"id": "create-tours",
				"name": "tours",
				"type": "UNSAFE",
				"descriptor": [
				],
				"rt": "#tour-representation"
			},
			{
				"id": "get-tours",
				"name": "tours",
				"type": "SAFE",
				"descriptor": [
				],
				"rt": "#tour-representation"
			},
			{
				"id": "update-tour",
				"name": "tour",
				"type": "IDEMPOTENT",
				"descriptor": [
				],
				"rt": "#tour-representation"
			},
			{
				"id": "delete-tour",
				"name": "tour",
				"type": "IDEMPOTENT",
				"descriptor": [
				],
				"rt": "#tour-representation"
			},
			{
				"id": "patch-tour",
				"name": "tour",
				"type": "UNSAFE",
				"descriptor": [
				],
				"rt": "#tour-representation"
			},
			{
				"id": "get-tour",
				"name": "tour",
				"type": "SAFE",
				"descriptor": [
				],
				"rt": "#tour-representation"
			}
		]
	}
}

# Create Restful API with Spring Data Rest:

No Need to do anything to create Restful API with Spring Data Rest, We just need to elaborate below documentation which is providing list of API available in this service.

{
  "_links" : {
    "tourPackages" : {
      "href" : "http://localhost:8080/tourPackages"
    },
    "tours" : {
      "href" : "http://localhost:8080/tours"
    },
    "profile" : {
      "href" : "http://localhost:8080/profile"
    }
  }
}

for example We need endpoint of tour packages such as:
	HTTP GET /tourPackages 
	HTTP GET /tourPackages/<code>
	
Sample Postman queries:

1. http://localhost:8080/tourPackages
httpMethod: Get

In below response you can see we are getting link for each tour packages which is Hypermedia driven.

{
    "_embedded": {
        "tourPackages": [
            {
                "name": "Backpack Cal",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/tourPackages/BC"
                    },
                    "tourPackage": {
                        "href": "http://localhost:8080/tourPackages/BC"
                    }
                }
            },
            {
                "name": "California Calm",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/tourPackages/CC"
                    },
                    "tourPackage": {
                        "href": "http://localhost:8080/tourPackages/CC"
                    }
                }
            },
            {
                "name": "California Hot Springs",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/tourPackages/CH"
                    },
                    "tourPackage": {
                        "href": "http://localhost:8080/tourPackages/CH"
                    }
                }
            },
            {
                "name": "Cycle California",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/tourPackages/CY"
                    },
                    "tourPackage": {
                        "href": "http://localhost:8080/tourPackages/CY"
                    }
                }
            },
            {
                "name": "From Desert to Sea",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/tourPackages/DS"
                    },
                    "tourPackage": {
                        "href": "http://localhost:8080/tourPackages/DS"
                    }
                }
            },
            {
                "name": "Kids California",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/tourPackages/KC"
                    },
                    "tourPackage": {
                        "href": "http://localhost:8080/tourPackages/KC"
                    }
                }
            },
            {
                "name": "Nature Watch",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/tourPackages/NW"
                    },
                    "tourPackage": {
                        "href": "http://localhost:8080/tourPackages/NW"
                    }
                }
            },
            {
                "name": "Snowboard Cali",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/tourPackages/SC"
                    },
                    "tourPackage": {
                        "href": "http://localhost:8080/tourPackages/SC"
                    }
                }
            },
            {
                "name": "Taste of California",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/tourPackages/TC"
                    },
                    "tourPackage": {
                        "href": "http://localhost:8080/tourPackages/TC"
                    }
                }
            }
        ]
    },
    "_links": {
        "self": {
            "href": "http://localhost:8080/tourPackages"
        },
        "profile": {
            "href": "http://localhost:8080/profile/tourPackages"
        },
        "search": {
            "href": "http://localhost:8080/tourPackages/search"
        }
    }
}


2. http://localhost:8080/tourPackages/BC
httpMethod: Get

Now we get the TourPackage data by navigating through given hypermedia link in Postman only.

{
    "name": "Backpack Cal",
    "_links": {
        "self": {
            "href": "http://localhost:8080/tourPackages/BC"
        },
        "tourPackage": {
            "href": "http://localhost:8080/tourPackages/BC"
        }
    }
}


3. http://localhost:8080/tourPackages

Request Body:

httpMethod: POST
Body -> Raw -> JSON(application/json) 
{
	"code": "ZC",
	"name": "Zany Cali"
}

Response Body:

Status: 201(created)

{
    "name": "Zany Cali",
    "_links": {
        "self": {
            "href": "http://localhost:8080/tourPackages/ZC"
        },
        "tourPackage": {
            "href": "http://localhost:8080/tourPackages/ZC"
        }
    }
}


4. http://localhost:8080/tourPackages

Request Body:
httpMethod: POST
Body -> Raw -> JSON(application/json) 

{
	"name": "Crazy Cali"
}

Response Body:
Status: 500(Internal Server Error)
{
    "timestamp": "2020-10-11T08:16:54.806+00:00",
    "status": 500,
    "error": "Internal Server Error",
    "message": "",
    "path": "/tourPackages"
}	



5. http://localhost:8080/tourPackages/ZC

Request Body:

httpMethod: PUT
Body -> Raw -> JSON(application/json) 
{
	"name": "California Zoo"
}

Response Body:

Status: 200(OK)

{
    "name": "California Zoo",
    "_links": {
        "self": {
            "href": "http://localhost:8080/tourPackages/ZC"
        },
        "tourPackage": {
            "href": "http://localhost:8080/tourPackages/ZC"
        }
    }
}



6. http://localhost:8080/tourPackages/ZC

Request Body:

httpMethod: DELETE


Response Body:

Status: 204(NO CONTENT)


7. http://localhost:8080/tourPackages/ZC

Request Body:

httpMethod: GET


Response Body:

Status: 404(NOT FOUND)


8. http://localhost:8080/tourPackages/BC

Request Body:

httpMethod: DELETE


Response Body:

Status: 409(CONFLICT)

{
    "cause": {
        "cause": {
            "cause": null,
            "message": "Referential integrity constraint violation: \"FKG5DJHH4MX98GU21L7KSRDWH4Q: PUBLIC.TOUR FOREIGN KEY(TOUR_PACKAGE_CODE) REFERENCES PUBLIC.TOUR_PACKAGE(CODE) ('BC')\"; SQL statement:\ndelete from tour_package where code=? [23503-200]"
        },
        "message": "could not execute statement"
    },
    "message": "could not execute statement; SQL [n/a]; constraint [\"FKG5DJHH4MX98GU21L7KSRDWH4Q: PUBLIC.TOUR FOREIGN KEY(TOUR_PACKAGE_CODE) REFERENCES PUBLIC.TOUR_PACKAGE(CODE) ('BC')\"; SQL statement:\ndelete from tour_package where code=? [23503-200]]; nested exception is org.hibernate.exception.ConstraintViolationException: could not execute statement"
}



9. http://localhost:8080/tourPackages/search

Request Body:

httpMethod: GET


Response Body:

Status: 200(OK)

{
    "_links": {
        "findByName": {
            "href": "http://localhost:8080/tourPackages/search/findByName{?name}",
            "templated": true
        },
        "self": {
            "href": "http://localhost:8080/tourPackages/search"
        }
    }
}


10. http://localhost:8080/tourPackages/search/findByName?name=Backpack%20Cal

Request Body:
httpMethod: GET


Response Body:
Status: 200(OK)
{
    "name": "Backpack Cal",
    "_links": {
        "self": {
            "href": "http://localhost:8080/tourPackages/BC"
        },
        "tourPackage": {
            "href": "http://localhost:8080/tourPackages/BC"
        }
    }
}

11. http://localhost:8080/tours/search

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


12. http://localhost:8080/tours/search/findByTourPackageCode?code=CC

Request Body:
httpMethod: GET

Response Body:
Status: 200(OK)
{
    "_embedded": {
        "tours": [
            {
                "title": "Day Spa Package",
                "description": "The content for this field  is only available in the course exercise files found on the website library.",
                "blurb": "The content for this field  is only available in the course exercise files found on the website library.",
                "price": 550,
                "duration": "1 day",
                "bullets": "The content for this field  is only available in the course exercise files found on the website library.",
                "keywords": "Spa, Relaxation, Ojai, Art, Yoga",
                "difficulty": "Easy",
                "region": "Southern_California",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/tours/6"
                    },
                    "tour": {
                        "href": "http://localhost:8080/tours/6"
                    },
                    "tourPackage": {
                        "href": "http://localhost:8080/tours/6/tourPackage"
                    }
                }
            },
            {
                "title": "Restoration Package",
                "description": "The content for this field  is only available in the course exercise files found on the website library.",
                "blurb": "The content for this field  is only available in the course exercise files found on the website library.",
                "price": 900,
                "duration": "2 days",
                "bullets": "The content for this field  is only available in the course exercise files found on the website library.",
                "keywords": "Spa, Relaxation, Art, Yoga",
                "difficulty": "Easy",
                "region": "Varies",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/tours/7"
                    },
                    "tour": {
                        "href": "http://localhost:8080/tours/7"
                    },
                    "tourPackage": {
                        "href": "http://localhost:8080/tours/7/tourPackage"
                    }
                }
            },
            {
                "title": "Huntington website library and Pasadena Retreat Tour",
                "description": "The content for this field  is only available in the course exercise files found on the website library.",
                "blurb": "The content for this field  is only available in the course exercise files found on the website library.",
                "price": 225,
                "duration": "1 day",
                "bullets": "The content for this field  is only available in the course exercise files found on the website library.",
                "keywords": "Spa, Relaxation, Art, Yoga",
                "difficulty": "Easy",
                "region": "Southern_California",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/tours/8"
                    },
                    "tour": {
                        "href": "http://localhost:8080/tours/8"
                    },
                    "tourPackage": {
                        "href": "http://localhost:8080/tours/8/tourPackage"
                    }
                }
            }
        ]
    },
    "_links": {
        "self": {
            "href": "http://localhost:8080/tours/search/findByTourPackageCode?code=CC"
        }
    }
}


13. http://localhost:8080/tours?size=3&page=1&sort=title,asc

Request Body:
httpMethod: GET

Response Body:
Status: 200(OK)
{
    "_embedded": {
        "tours": [
            {
                "title": "Avila Beach Hot springs",
                "description": "The content for this field  is only available in the course exercise files found on the website library.",
                "blurb": "The content for this field  is only available in the course exercise files found on the website library.",
                "price": 1000,
                "duration": "3 days",
                "bullets": "The content for this field  is only available in the course exercise files found on the website library.",
                "keywords": "Hot springs, hiking, cabin, beach, kayaking, hiking",
                "difficulty": "Easy",
                "region": "Central_Coast",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/tours/9"
                    },
                    "tour": {
                        "href": "http://localhost:8080/tours/9"
                    },
                    "tourPackage": {
                        "href": "http://localhost:8080/tours/9/tourPackage"
                    }
                }
            },
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
        "first": {
            "href": "http://localhost:8080/tours?page=0&size=3&sort=title,asc"
        },
        "prev": {
            "href": "http://localhost:8080/tours?page=0&size=3&sort=title,asc"
        },
        "self": {
            "href": "http://localhost:8080/tours?size=3&page=1&sort=title,asc"
        },
        "next": {
            "href": "http://localhost:8080/tours?page=2&size=3&sort=title,asc"
        },
        "last": {
            "href": "http://localhost:8080/tours?page=9&size=3&sort=title,asc"
        },
        "profile": {
            "href": "http://localhost:8080/profile/tours"
        },
        "search": {
            "href": "http://localhost:8080/tours/search"
        }
    },
    "page": {
        "size": 3,
        "totalElements": 30,
        "totalPages": 10,
        "number": 1
    }
}



14. http://localhost:8080/tours/search/findByTourPackageCode?code=CC&size=2&sort=title,asc

Request Body:
httpMethod: GET

Response Body:
Status: 200(OK)
{
    "_embedded": {
        "tours": [
            {
                "title": "Day Spa Package",
                "description": "The content for this field  is only available in the course exercise files found on the website library.",
                "blurb": "The content for this field  is only available in the course exercise files found on the website library.",
                "price": 550,
                "duration": "1 day",
                "bullets": "The content for this field  is only available in the course exercise files found on the website library.",
                "keywords": "Spa, Relaxation, Ojai, Art, Yoga",
                "difficulty": "Easy",
                "region": "Southern_California",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/tours/6"
                    },
                    "tour": {
                        "href": "http://localhost:8080/tours/6"
                    },
                    "tourPackage": {
                        "href": "http://localhost:8080/tours/6/tourPackage"
                    }
                }
            },
            {
                "title": "Huntington website library and Pasadena Retreat Tour",
                "description": "The content for this field  is only available in the course exercise files found on the website library.",
                "blurb": "The content for this field  is only available in the course exercise files found on the website library.",
                "price": 225,
                "duration": "1 day",
                "bullets": "The content for this field  is only available in the course exercise files found on the website library.",
                "keywords": "Spa, Relaxation, Art, Yoga",
                "difficulty": "Easy",
                "region": "Southern_California",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/tours/8"
                    },
                    "tour": {
                        "href": "http://localhost:8080/tours/8"
                    },
                    "tourPackage": {
                        "href": "http://localhost:8080/tours/8/tourPackage"
                    }
                }
            }
        ]
    },
    "_links": {
        "first": {
            "href": "http://localhost:8080/tours/search/findByTourPackageCode?code=CC&page=0&size=2&sort=title,asc"
        },
        "self": {
            "href": "http://localhost:8080/tours/search/findByTourPackageCode?code=CC&page=0&size=2&sort=title,asc"
        },
        "next": {
            "href": "http://localhost:8080/tours/search/findByTourPackageCode?code=CC&page=1&size=2&sort=title,asc"
        },
        "last": {
            "href": "http://localhost:8080/tours/search/findByTourPackageCode?code=CC&page=1&size=2&sort=title,asc"
        }
    },
    "page": {
        "size": 2,
        "totalElements": 3,
        "totalPages": 2,
        "number": 0
    }
}


15. http://localhost:8080/packages

After below change accessing TourPackageRepository using "http://localhost:8080/packages"
@RepositoryRestResource(collectionResourceRel = "packages", path = "packages")
public interface TourPackageRepository extends CrudRepository<TourPackage, String> {


Request Body:
httpMethod: GET

Response Body:
Status: 200(OK)
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
                "name": "California Hot Springs",
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


16. http://localhost:8080/packages/CC

Request Body:
httpMethod: GET

Response Body:
Status: 200(OK)
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
}



17. http://localhost:8080/packages/CC

Request Body:
httpMethod: DELETE

Response Body:
Status: 405(Method Not Allowed)
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




18. http://localhost:8080

Request Body:
httpMethod: GET

Response Body:
Status: 200(OK)
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




19. http://localhost:8080/profile

Request Body:
httpMethod: GET

Response Body:
Status: 200(OK)
{
    "_links": {
        "self": {
            "href": "http://localhost:8080/profile"
        },
        "packages": {
            "href": "http://localhost:8080/profile/packages"
        },
        "tours": {
            "href": "http://localhost:8080/profile/tours"
        }
    }
}




20. http://localhost:8080/profile/packages

Request Body:
httpMethod: GET

Response Body:
Status: 200(OK)
{
    "alps": {
        "version": "1.0",
        "descriptor": [
            {
                "id": "tourPackage-representation",
                "href": "http://localhost:8080/profile/packages",
                "descriptor": [
                    {
                        "name": "name",
                        "type": "SEMANTIC"
                    }
                ]
            },
            {
                "id": "get-packages",
                "name": "packages",
                "type": "SAFE",
                "descriptor": [],
                "rt": "#tourPackage-representation"
            },
            {
                "id": "get-tourPackage",
                "name": "tourPackage",
                "type": "SAFE",
                "descriptor": [],
                "rt": "#tourPackage-representation"
            },
            {
                "name": "findByName",
                "type": "SAFE",
                "descriptor": [
                    {
                        "name": "name",
                        "type": "SEMANTIC"
                    }
                ]
            }
        ]
    }
}




21. http://localhost:8080/browser/index.html#/

after addition of below dependency:
		<dependency>
			<groupId>org.springframework.data</groupId>
			<artifactId>spring-data-rest-hal-browser</artifactId>
		</dependency>
		
in browser we can explore API's.






