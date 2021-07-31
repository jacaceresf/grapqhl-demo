# grapqhl-demo
A GraphQL API demo with Spring Boot.

## Running the project
- Situate at the root of the project's folder and then run the following command:
`./mvnw spring-boot:run`
- To execute queries to the API open the Web UI of SPQR:
`http://localhost:8080/gui`
- Feel free to execute any of the following queries.
```
# Write your query or mutation here
 {
   foods {
     id
     name
     isGood
   }
 }

# Find by id
 {
   food(id: 1)
   {
     id
     isGood
   }
 }

# Create a new food
mutation {
   saveFood(food: {name: "Pasta"}){
     id
     isGood
     name
   }
 }

{
  teams {
    name
    championships
  }
}
```

