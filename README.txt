Spring boot application tomcat server is baked in to application, eliminating the need to place application on local machines tomcat server.

Modified Files:
FizzBuzz
FizzBuzzController
FizzBuzzDTO
WordEnum

Modified Test Files:
FizzBuzzControllerTest
FizzBuzzTest
WordEnumTest

Assumptions:
-inputs for fizz, buzz and fizzbuzz can be upper or lower case
-localhost:8080

Running Application: gradle bootRun

Running Test Cases: gradle test

Building jar: gradle build

***If Gradle not installled****
./gradlew bootRun

Endpoint: localhost:8080/api?word=buzz&max_value=15

Response:
{
  "status": "ok",
  "numbers": [
    5,
    10,
    15
  ]
}
