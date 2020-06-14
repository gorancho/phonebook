# phonebook
Java 11, Spring Boot, H2, Maven, jUnit, Lombok, Integration test, Hibernate Validator, Custom Exception Handler implemented

This project is based on one POST call that validate and insert a new Contact to the database.

Valid Contact is the one that has name field that is not null and has more than one character 
and phoneNumber field that starts with '+389'. 
Than follows '70', '71', '75' or '76' and at the end there should be 6 digits.
If name is not valid we get invalid payload response.

Implemented design patterns:
Repository Pattern, Builder Pattern etc.

Example request:
localhost:8080/phoneBook/contact
Body:
{
	"name": "goran",
	"phoneNumber":"+38975603539"
}

Valid Response:
{
    "id": "1"
}

Invalid Response:
{
    "errorCode": "INVALID_PAYLOAD",
    "errorMessage": "name"
}
or
{
    "errorCode": "INVALID_PAYLOAD",
    "errorMessage": "phoneNumber"
}

