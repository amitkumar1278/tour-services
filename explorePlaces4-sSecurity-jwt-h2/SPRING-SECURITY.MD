

# IMPORTANT URL

http://localhost:8080/users
Response Data:

{
  "_embedded" : {
    "users" : [ {
      "username" : "admin",
      "firstName" : "Administrator",
      "lastName" : "Adminstrator",
      "roles" : [ {
        "roleName" : "ROLE_ADMIN",
        "description" : "Administrator"
      } ],
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/users/1"
        },
        "user" : {
          "href" : "http://localhost:8080/users/1"
        }
      }
    }, {
      "username" : "csr_jane",
      "firstName" : "Jane",
      "lastName" : "Doe",
      "roles" : [ {
        "roleName" : "ROLE_CSR",
        "description" : "Customer Service Representative"
      } ],
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/users/2"
        },
        "user" : {
          "href" : "http://localhost:8080/users/2"
        }
      }
    }, {
      "username" : "csr_mark",
      "firstName" : "Mark",
      "lastName" : "Smith",
      "roles" : [ {
        "roleName" : "ROLE_CSR",
        "description" : "Customer Service Representative"
      } ],
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/users/3"
        },
        "user" : {
          "href" : "http://localhost:8080/users/3"
        }
      }
    }, {
      "username" : "wally",
      "firstName" : "Walter",
      "lastName" : "Adams",
      "roles" : [ {
        "roleName" : "ROLE_ADMIN",
        "description" : "Administrator"
      }, {
        "roleName" : "ROLE_CSR",
        "description" : "Customer Service Representative"
      } ],
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/users/4"
        },
        "user" : {
          "href" : "http://localhost:8080/users/4"
        }
      }
    } ]
  },
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/users"
    },
    "profile" : {
      "href" : "http://localhost:8080/profile/users"
    },
    "search" : {
      "href" : "http://localhost:8080/users/search"
    }
  },
  "page" : {
    "size" : 20,
    "totalElements" : 4,
    "totalPages" : 1,
    "number" : 0
  }
}



