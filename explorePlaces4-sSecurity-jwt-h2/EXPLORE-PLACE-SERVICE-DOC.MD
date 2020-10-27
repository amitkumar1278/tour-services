Sample Postman json data of Explore Place  Service API call:


1. 
httpMethod: GET

http://localhost:8080/packages
Request Body:

http://localhost:8080/tours
Request Body:




2.1: http://localhost:8080/users/signin

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




2.2: Invalid User Scenario
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





2.3: login after JWT integration
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
Status: 200 OK
Body:	eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsInJvbGVzIjpbeyJhdXRob3JpdHkiOiJST0xFX0FETUlOIn1dLCJpYXQiOjE2MDM3ODgzMDMsImV4cCI6MTYwMzc4ODkwM30.V-ZqlMVmq4igU8fxtUtk80dscHUHm-R9Ftuc7JKR7Cc

visit url to encode JWt string: https://www.jsonwebtoken.io/

Header:
{
 "typ": "JWT",
 "alg": "HS256"
}

Payload:
{
 "sub": "admin",
 "roles": [
  {
   "authority": "ROLE_ADMIN"
  }
 ],
 "iat": 1603788303,
 "exp": 1603791917,
 "jti": "2a746d44-f3ec-4044-8ece-bcf018107356"
}

Signing Key :   Verified

You can use this token for other API calls.





3. API having Role based or other restriction, we need to pass token.
so first sign in and get token and pass the same toke in header.

API URI: http://localhost:8080/users

Request Body:
	Headers:	{Key: Authorization, value: Bearer <token received from sign in>}
	ex:
	Authorization:Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsInJvbGVzIjpbeyJhdXRob3JpdHkiOiJST0xFX0FETUlOIn1dLCJpYXQiOjE2MDM4MTkzOTEsImV4cCI6MTYwMzgxOTk5MX0.xK0GHbuckghL4_5UOb-CeR8aL6mhQT2HbBKblnli9gk

httpMethod: GET

Response Body:
Status: 200 OK

[
    {
        "id": 1,
        "username": "admin",
        "firstName": "Administrator",
        "lastName": "Adminstrator",
        "roles": [
            {
                "id": 1,
                "roleName": "ROLE_ADMIN",
                "description": "Administrator",
                "authority": "ROLE_ADMIN"
            }
        ]
    },
    {
        "id": 2,
        "username": "csr_jane",
        "firstName": "Jane",
        "lastName": "Doe",
        "roles": [
            {
                "id": 2,
                "roleName": "ROLE_CSR",
                "description": "Customer Service Representative",
                "authority": "ROLE_CSR"
            }
        ]
    },
    {
        "id": 3,
        "username": "csr_mark",
        "firstName": "Mark",
        "lastName": "Smith",
        "roles": [
            {
                "id": 2,
                "roleName": "ROLE_CSR",
                "description": "Customer Service Representative",
                "authority": "ROLE_CSR"
            }
        ]
    },
    {
        "id": 4,
        "username": "wally",
        "firstName": "Walter",
        "lastName": "Adams",
        "roles": [
            {
                "id": 1,
                "roleName": "ROLE_ADMIN",
                "description": "Administrator",
                "authority": "ROLE_ADMIN"
            },
            {
                "id": 2,
                "roleName": "ROLE_CSR",
                "description": "Customer Service Representative",
                "authority": "ROLE_CSR"
            }
        ]
    }
]






4. http://localhost:8080/users/signup
in this API we need to paas token of admin in header, new user detail for sign up.

Request Body:

Headers:
Authorization:Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsInJvbGVzIjpbeyJhdXRob3JpdHkiOiJST0xFX0FETUlOIn1dLCJpYXQiOjE2MDM4MTkzOTEsImV4cCI6MTYwMzgxOTk5MX0.xK0GHbuckghL4_5UOb-CeR8aL6mhQT2HbBKblnli9gk
Content-Type:application/json


httpMethod: POST

Body -> Raw -> JSON(application/json) 
{
	"username": "admin_new",
	"password": "letmein",
	"firstName": "admin_new_1",
	"lastName": "2345"
}

Response Body:
Status: 201 Created
{
    "id": 5,
    "username": "admin_new",
    "firstName": "admin_new_1",
    "lastName": "2345",
    "roles": [
        {
            "id": 2,
            "roleName": "ROLE_CSR",
            "description": "Customer Service Representative",
            "authority": "ROLE_CSR"
        }
    ]
}




5. http://localhost:8080/tours/1/ratings

in this APi we passed the token of user having role as "ROLE_CSR"

Request Body:

Headers:
Authorization:Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsInJvbGVzIjpbeyJhdXRob3JpdHkiOiJST0xFX0FETUlOIn1dLCJpYXQiOjE2MDM4MTkzOTEsImV4cCI6MTYwMzgxOTk5MX0.xK0GHbuckghL4_5UOb-CeR8aL6mhQT2HbBKblnli9gk
Content-Type:application/json

httpMethod: POST
Body -> Raw -> JSON(application/json) 
{
    "score":5,
    "comment":"I thought it was ok................",
    "customerId":3
}

Response Body:
Status: 201 Created






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



