# Sample REST CRUD API with Spring Boot, H2 JPA

## How to Run the application

To run the application, run the following command in a terminal window (in the complete) directory:

```bash
./gradlew bootRun
```
The app will start running at <http://localhost:8080>.

# Swagger UI
Now run the service with curl (in a browser window) using Swagger-UI, by entering the following url
http://localhost:8080/api/swagger

## Explore Rest APIs

The app defines following CRUD APIs.
| # | Method | URL | Description |
| - | ------ | --- | ----------- |
| 1 | GET | api/user/load | Loads dummy data of person |
| 2 | GET | api/user/all | Retrieve a list of al persons |
| 3 | GET | api/user/{id} | Retrieve a person by their unique identifier |
| 4 | POST | api/user/add | Create a new person |
| 5 | POST | api/user/update/{id} | Updates the existing person |
| 6 | POST | api/user/delete/{id} | Deletes a person with specified identifier |

# Generate JavaDoc
To run the application, run the following command in a terminal window (in the complete) directory:

```bash
./gradlew javadoc
```
Java Document will be available under the `docs` folder.
