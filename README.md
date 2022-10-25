# simple-rest-api
Simple RESTApi developed with Spring Boot, Spring Data JPA, H2 Database, and Swagger UI.


# CREATE

//POST

localhost:8080/topics

create one

    [
      {
        "name": "topic1"
      }
    ]
    
 
create many

    [
      {
        "name": "topic2"
      },
      {
        "name": "topic3"
      }
    ]
    
    
 
# READ
 
 read one
 
 //GET
 
 localhost:8080/topics/{id}
 
 ..........................................
 
 real all
 
 //Get
 
 localhost:8080/topics
  
  
  
  
# UPDATE
  
  //POST
  
  localhost:8080/topics/{id}

  
      {
        "name": "newtopicname"
      }
      
 
 
# DELETE

//DELETE

localhost:8080/topics/{id}
  
