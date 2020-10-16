# Microservice using Mongodb Sample POSTMAN CAlling:


1. http://localhost:8080/tours

Request Body:
httpMethod: GET

Response Body:
Status: 200(OK)

{
    "_embedded": {
        "tours": [
            {
                "title": "Big Sur Retreat",
                "tourPackageCode": "BC",
                "tourPackageName": "Backpack Cal",
                "details": {
                    "blurb": "The content for this field  is only available in the course exercise files found on the website library.",
                    "description": "The content for this field  is only available in the course exercise files found on the website library.",
                    "bullets": "The content for this field  is only available in the course exercise files found on the website library.",
                    "difficulty": "Medium",
                    "length": "3 days",
                    "price": "750",
                    "region": "Central Coast",
                    "keywords": "Hiking, National Parks, Big Sur"
                },
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/tours/5f89f1e65b27416858248799"
                    },
                    "tour": {
                        "href": "http://localhost:8080/tours/5f89f1e65b27416858248799"
                    }
                }
            },
            {
                "title": "In the Steps of John Muir",
                "tourPackageCode": "BC",
                "tourPackageName": "Backpack Cal",
                "details": {
                    "blurb": "The content for this field  is only available in the course exercise files found on the website library.",
                    "description": "The content for this field  is only available in the course exercise files found on the website library.",
                    "bullets": "The content for this field  is only available in the course exercise files found on the website library.",
                    "difficulty": "Difficult",
                    "length": "3 days",
                    "price": "600",
                    "region": "Northern California",
                    "keywords": "Hiking, National Parks, Yosemite, John Muir, Camping"
                },
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/tours/5f89f1e65b2741685824879a"
                    },
                    "tour": {
                        "href": "http://localhost:8080/tours/5f89f1e65b2741685824879a"
                    }
                }
            },
            {
                "title": "The Death Valley Survivor's Trek",
                "tourPackageCode": "BC",
                "tourPackageName": "Backpack Cal",
                "details": {
                    "blurb": "The content for this field  is only available in the course exercise files found on the website library.",
                    "description": "The content for this field  is only available in the course exercise files found on the website library.",
                    "bullets": "The content for this field  is only available in the course exercise files found on the website library.",
                    "difficulty": "Difficult",
                    "length": "2 days",
                    "price": "250",
                    "region": "Varies",
                    "keywords": "Hiking, Desert, Camping, Mojave, Death Valley"
                },
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/tours/5f89f1e65b2741685824879b"
                    },
                    "tour": {
                        "href": "http://localhost:8080/tours/5f89f1e65b2741685824879b"
                    }
                }
            },
            {
                "title": "The Mt. Whitney Climbers Tour",
                "tourPackageCode": "BC",
                "tourPackageName": "Backpack Cal",
                "details": {
                    "blurb": "The content for this field  is only available in the course exercise files found on the website library.",
                    "description": "The content for this field  is only available in the course exercise files found on the website library.",
                    "bullets": "The content for this field  is only available in the course exercise files found on the website library.",
                    "difficulty": "Difficult",
                    "length": "4 days",
                    "price": "650",
                    "region": "Northern California",
                    "keywords": "Hiking, Climbing, Backpacking, Mt. Whitney"
                },
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/tours/5f89f1e65b2741685824879c"
                    },
                    "tour": {
                        "href": "http://localhost:8080/tours/5f89f1e65b2741685824879c"
                    }
                }
            },
            {
                "title": "Channel Islands Excursion",
                "tourPackageCode": "BC",
                "tourPackageName": "Backpack Cal",
                "details": {
                    "blurb": "The content for this field  is only available in the course exercise files found on the website library.",
                    "description": "The content for this field  is only available in the course exercise files found on the website library.",
                    "bullets": "The content for this field  is only available in the course exercise files found on the website library.",
                    "difficulty": "Easy",
                    "length": "1 day",
                    "price": "150",
                    "region": "Southern California",
                    "keywords": "Channel Islands, Boating, Whale watching, Hiking"
                },
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/tours/5f89f1e65b2741685824879d"
                    },
                    "tour": {
                        "href": "http://localhost:8080/tours/5f89f1e65b2741685824879d"
                    }
                }
            },
            {
                "title": "Day Spa Package",
                "tourPackageCode": "CC",
                "tourPackageName": "California Calm",
                "details": {
                    "blurb": "The content for this field  is only available in the course exercise files found on the website library.",
                    "description": "The content for this field  is only available in the course exercise files found on the website library.",
                    "bullets": "The content for this field  is only available in the course exercise files found on the website library.",
                    "difficulty": "Easy",
                    "length": "1 day",
                    "price": "550",
                    "region": "Southern California",
                    "keywords": "Spa, Relaxation, Ojai, Art, Yoga"
                },
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/tours/5f89f1e65b2741685824879e"
                    },
                    "tour": {
                        "href": "http://localhost:8080/tours/5f89f1e65b2741685824879e"
                    }
                }
            },
            {
                "title": "Restoration Package",
                "tourPackageCode": "CC",
                "tourPackageName": "California Calm",
                "details": {
                    "blurb": "The content for this field  is only available in the course exercise files found on the website library.",
                    "description": "The content for this field  is only available in the course exercise files found on the website library.",
                    "bullets": "The content for this field  is only available in the course exercise files found on the website library.",
                    "difficulty": "Easy",
                    "length": "2 days",
                    "price": "900",
                    "region": "Varies",
                    "keywords": "Spa, Relaxation, Art, Yoga"
                },
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/tours/5f89f1e65b2741685824879f"
                    },
                    "tour": {
                        "href": "http://localhost:8080/tours/5f89f1e65b2741685824879f"
                    }
                }
            },
            {
                "title": "Huntington website library and Pasadena Retreat Tour",
                "tourPackageCode": "CC",
                "tourPackageName": "California Calm",
                "details": {
                    "blurb": "The content for this field  is only available in the course exercise files found on the website library.",
                    "description": "The content for this field  is only available in the course exercise files found on the website library.",
                    "bullets": "The content for this field  is only available in the course exercise files found on the website library.",
                    "difficulty": "Easy",
                    "length": "1 day",
                    "price": "225",
                    "region": "Southern California",
                    "keywords": "Spa, Relaxation, Art, Yoga"
                },
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/tours/5f89f1e65b274168582487a0"
                    },
                    "tour": {
                        "href": "http://localhost:8080/tours/5f89f1e65b274168582487a0"
                    }
                }
            },
            {
                "title": "Avila Beach Hot springs",
                "tourPackageCode": "CH",
                "tourPackageName": "California Hot Springs",
                "details": {
                    "blurb": "The content for this field  is only available in the course exercise files found on the website library.",
                    "description": "The content for this field  is only available in the course exercise files found on the website library.",
                    "bullets": "The content for this field  is only available in the course exercise files found on the website library.",
                    "difficulty": "Easy",
                    "length": "3 days",
                    "price": "1000",
                    "region": "Central Coast",
                    "keywords": "Hot springs, hiking, cabin, beach, kayaking, hiking"
                },
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/tours/5f89f1e65b274168582487a1"
                    },
                    "tour": {
                        "href": "http://localhost:8080/tours/5f89f1e65b274168582487a1"
                    }
                }
            },
            {
                "title": "Matilija Hot springs",
                "tourPackageCode": "CH",
                "tourPackageName": "California Hot Springs",
                "details": {
                    "blurb": "The content for this field  is only available in the course exercise files found on the website library.",
                    "description": "The content for this field  is only available in the course exercise files found on the website library.",
                    "bullets": "The content for this field  is only available in the course exercise files found on the website library.",
                    "difficulty": "Easy",
                    "length": "3 days",
                    "price": "1000",
                    "region": "Central Coast",
                    "keywords": "Hot springs, Ojai, hiking, swimming, rustic, nature"
                },
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/tours/5f89f1e65b274168582487a2"
                    },
                    "tour": {
                        "href": "http://localhost:8080/tours/5f89f1e65b274168582487a2"
                    }
                }
            },
            {
                "title": "Paso Robles Artesian Spring",
                "tourPackageCode": "CH",
                "tourPackageName": "California Hot Springs",
                "details": {
                    "blurb": "The content for this field  is only available in the course exercise files found on the website library.",
                    "description": "The content for this field  is only available in the course exercise files found on the website library.",
                    "bullets": "The content for this field  is only available in the course exercise files found on the website library.",
                    "difficulty": "Easy",
                    "length": "2 days",
                    "price": "750",
                    "region": "Central Coast",
                    "keywords": "Hot springs, Spa treatment, Bed and breakfast"
                },
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/tours/5f89f1e65b274168582487a3"
                    },
                    "tour": {
                        "href": "http://localhost:8080/tours/5f89f1e65b274168582487a3"
                    }
                }
            },
            {
                "title": "Amgen Tour of California Special",
                "tourPackageCode": "CY",
                "tourPackageName": "Cycle California",
                "details": {
                    "blurb": "The content for this field  is only available in the course exercise files found on the website library.",
                    "description": "The content for this field  is only available in the course exercise files found on the website library.",
                    "bullets": "The content for this field  is only available in the course exercise files found on the website library.",
                    "difficulty": "Difficult",
                    "length": "14 days",
                    "price": "6000",
                    "region": "Northern California",
                    "keywords": "Cycling, Sports,"
                },
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/tours/5f89f1e65b274168582487a4"
                    },
                    "tour": {
                        "href": "http://localhost:8080/tours/5f89f1e65b274168582487a4"
                    }
                }
            },
            {
                "title": "Monterey to Santa Barbara Tour",
                "tourPackageCode": "CY",
                "tourPackageName": "Cycle California",
                "details": {
                    "blurb": "The content for this field  is only available in the course exercise files found on the website library.",
                    "description": "The content for this field  is only available in the course exercise files found on the website library.",
                    "bullets": "The content for this field  is only available in the course exercise files found on the website library.",
                    "difficulty": "Medium",
                    "length": "6 days",
                    "price": "2500",
                    "region": "Varies",
                    "keywords": "Cycling"
                },
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/tours/5f89f1e65b274168582487a5"
                    },
                    "tour": {
                        "href": "http://localhost:8080/tours/5f89f1e65b274168582487a5"
                    }
                }
            },
            {
                "title": "Cycle California: My Way",
                "tourPackageCode": "CY",
                "tourPackageName": "Cycle California",
                "details": {
                    "blurb": "The content for this field  is only available in the course exercise files found on the website library.",
                    "description": "The content for this field  is only available in the course exercise files found on the website library.",
                    "bullets": "The content for this field  is only available in the course exercise files found on the website library.",
                    "difficulty": "Varies",
                    "length": "Varies",
                    "price": "1200",
                    "region": "Varies",
                    "keywords": "Cycling"
                },
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/tours/5f89f1e65b274168582487a6"
                    },
                    "tour": {
                        "href": "http://localhost:8080/tours/5f89f1e65b274168582487a6"
                    }
                }
            },
            {
                "title": "2 Days Adrift the Salton Sea",
                "tourPackageCode": "DS",
                "tourPackageName": "From Desert to Sea",
                "details": {
                    "blurb": "The content for this field  is only available in the course exercise files found on the website library.",
                    "description": "The content for this field  is only available in the course exercise files found on the website library.",
                    "bullets": "The content for this field  is only available in the course exercise files found on the website library.",
                    "difficulty": "Easy",
                    "length": "2 days",
                    "price": "350",
                    "region": "Southern California",
                    "keywords": "Boating, Fishing, Bird watching, Desert, Sea, Eco-Tour"
                },
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/tours/5f89f1e65b274168582487a7"
                    },
                    "tour": {
                        "href": "http://localhost:8080/tours/5f89f1e65b274168582487a7"
                    }
                }
            },
            {
                "title": "Mojave to Malibu",
                "tourPackageCode": "DS",
                "tourPackageName": "From Desert to Sea",
                "details": {
                    "blurb": "The content for this field  is only available in the course exercise files found on the website library.",
                    "description": "The content for this field  is only available in the course exercise files found on the website library.",
                    "bullets": "The content for this field  is only available in the course exercise files found on the website library.",
                    "difficulty": "Difficult",
                    "length": "1 day",
                    "price": "200",
                    "region": "Southern California",
                    "keywords": "Motorcycle, Cycling, Mountains, Desert, Sea"
                },
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/tours/5f89f1e65b274168582487a8"
                    },
                    "tour": {
                        "href": "http://localhost:8080/tours/5f89f1e65b274168582487a8"
                    }
                }
            },
            {
                "title": "Joshua Tree: Best of the West Tour",
                "tourPackageCode": "DS",
                "tourPackageName": "From Desert to Sea",
                "details": {
                    "blurb": "The content for this field  is only available in the course exercise files found on the website library.",
                    "description": "The content for this field  is only available in the course exercise files found on the website library.",
                    "bullets": "The content for this field  is only available in the course exercise files found on the website library.",
                    "difficulty": "Easy",
                    "length": "1 day",
                    "price": "150",
                    "region": "Southern California",
                    "keywords": "Hiking, Desert, Sea, California History, Theme park"
                },
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/tours/5f89f1e65b274168582487a9"
                    },
                    "tour": {
                        "href": "http://localhost:8080/tours/5f89f1e65b274168582487a9"
                    }
                }
            },
            {
                "title": "Kids L.A. Tour",
                "tourPackageCode": "KC",
                "tourPackageName": "Kids California",
                "details": {
                    "blurb": "The content for this field  is only available in the course exercise files found on the website library.",
                    "description": "The content for this field  is only available in the course exercise files found on the website library.",
                    "bullets": "The content for this field  is only available in the course exercise files found on the website library.",
                    "difficulty": "Easy",
                    "length": "3 days",
                    "price": "1200",
                    "region": "Southern California",
                    "keywords": "Kid friendly, Museum,  Animals, Theme park"
                },
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/tours/5f89f1e65b274168582487aa"
                    },
                    "tour": {
                        "href": "http://localhost:8080/tours/5f89f1e65b274168582487aa"
                    }
                }
            },
            {
                "title": "Islands of the Blue Dolphins Tour",
                "tourPackageCode": "KC",
                "tourPackageName": "Kids California",
                "details": {
                    "blurb": "The content for this field  is only available in the course exercise files found on the website library.",
                    "description": "The content for this field  is only available in the course exercise files found on the website library.",
                    "bullets": "The content for this field  is only available in the course exercise files found on the website library.",
                    "difficulty": "Easy",
                    "length": "1 day",
                    "price": "200",
                    "region": "Southern California",
                    "keywords": "California History, Kid friendly, Museum, Hiking, Animals"
                },
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/tours/5f89f1e65b274168582487ab"
                    },
                    "tour": {
                        "href": "http://localhost:8080/tours/5f89f1e65b274168582487ab"
                    }
                }
            },
            {
                "title": "Eco-Tour",
                "tourPackageCode": "KC",
                "tourPackageName": "Kids California",
                "details": {
                    "blurb": "The content for this field  is only available in the course exercise files found on the website library.",
                    "description": "The content for this field  is only available in the course exercise files found on the website library.",
                    "bullets": "The content for this field  is only available in the course exercise files found on the website library.",
                    "difficulty": "Medium",
                    "length": "3 days",
                    "price": "750",
                    "region": "Southern California",
                    "keywords": "Boating, Farming, Animals, California History, Museum, Eco Tour"
                },
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/tours/5f89f1e65b274168582487ac"
                    },
                    "tour": {
                        "href": "http://localhost:8080/tours/5f89f1e65b274168582487ac"
                    }
                }
            }
        ]
    },
    "_links": {
        "first": {
            "href": "http://localhost:8080/tours?page=0&size=20"
        },
        "self": {
            "href": "http://localhost:8080/tours"
        },
        "next": {
            "href": "http://localhost:8080/tours?page=1&size=20"
        },
        "last": {
            "href": "http://localhost:8080/tours?page=1&size=20"
        },
        "profile": {
            "href": "http://localhost:8080/profile/tours"
        },
        "search": {
            "href": "http://localhost:8080/tours/search"
        }
    },
    "page": {
        "size": 20,
        "totalElements": 30,
        "totalPages": 2,
        "number": 0
    }
}







2. http://localhost:8080/tours/5f89f1e65b27416858248799/ratings

Request Body:

httpMethod: POST
Body -> Raw -> JSON(application/json) 
{
	"score": 5,
	"customerId": 7,
	"comment": "No Comment"
}

Response Body:
Status: 201(created)



3. http://localhost:8080/tours/5f89f1e65b27416858248799/ratings

Request Body:
httpMethod: GET

Response Body:
Status: 200(OK)

{
    "content": [
        {
            "tourId": "5f89f1e65b27416858248799",
            "customerId": 7,
            "score": 5,
            "comment": "No Comment"
        }
    ],
    "pageable": {
        "sort": {
            "sorted": false,
            "unsorted": true,
            "empty": true
        },
        "offset": 0,
        "pageNumber": 0,
        "pageSize": 20,
        "paged": true,
        "unpaged": false
    },
    "last": true,
    "totalPages": 1,
    "totalElements": 1,
    "number": 0,
    "sort": {
        "sorted": false,
        "unsorted": true,
        "empty": true
    },
    "size": 20,
    "first": true,
    "numberOfElements": 1,
    "empty": false
}



4. http://localhost:8080/tours/search/findSummaryByTourPackageCode?code=CC

Request Body:
httpMethod: GET


Response Body:
Status: 200(OK)

{
    "_embedded": {
        "tours": [
            {
                "title": "Day Spa Package",
                "tourPackageCode": "CC",
                "tourPackageName": "California Calm",
                "details": null,
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/tours/5f89f1e65b2741685824879e"
                    },
                    "tour": {
                        "href": "http://localhost:8080/tours/5f89f1e65b2741685824879e"
                    }
                }
            },
            {
                "title": "Restoration Package",
                "tourPackageCode": "CC",
                "tourPackageName": "California Calm",
                "details": null,
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/tours/5f89f1e65b2741685824879f"
                    },
                    "tour": {
                        "href": "http://localhost:8080/tours/5f89f1e65b2741685824879f"
                    }
                }
            },
            {
                "title": "Huntington website library and Pasadena Retreat Tour",
                "tourPackageCode": "CC",
                "tourPackageName": "California Calm",
                "details": null,
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/tours/5f89f1e65b274168582487a0"
                    },
                    "tour": {
                        "href": "http://localhost:8080/tours/5f89f1e65b274168582487a0"
                    }
                }
            }
        ]
    },
    "_links": {
        "self": {
            "href": "http://localhost:8080/tours/search/findSummaryByTourPackageCode?code=CC&page=0&size=20"
        }
    },
    "page": {
        "size": 20,
        "totalElements": 3,
        "totalPages": 1,
        "number": 0
    }
}

















