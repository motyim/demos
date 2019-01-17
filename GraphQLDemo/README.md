# GraphQl With Spring Boot Demo 

You'll need [Java 8](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html).

Clone this repo. 
inside an IDE, execute the class `DemoGraphQlApplication`.

You can go to [http://localhost:8080/h2-console/login.jsp](http://localhost:8080/h2-console/login.jsp) and enter the following information:
- JDBC URL: jdbc:h2:mem:testdb
- User Name: sa
- Password: <blank>

To check the database or to [http://localhost:8080/graphiql](http://localhost:8080/graphiql) to start executing queries. For example:
```
{
  findAllBooks {
    id
    isbn
    title
    pageCount
    author {
      firstName
      lastName
    }
  }
}
```

Or:
```
mutation {
  newBook(
    title: "Java: The Complete Reference, Tenth Edition", 
    isbn: "1259589331", 
    author: 1) {
      id title
  }
}
```
# Source
 * [Building a GraphQL Server with Spring Boot](https://www.pluralsight.com/guides/java-and-j2ee/building-a-graphql-server-with-spring-boot).

# License
MIT

