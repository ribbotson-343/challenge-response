#!/bin/bash
curl -H 'Content-Type: application/json' -X POST \
     -d '{"employeeId": "16a596ae-edd3-4847-99fe-c4518e82c86f", "salary": "250000000", "effectiveDate": "2020-03-28"}' \
     http://localhost:8080/compensation

curl -X GET http://localhost:8080/compensation/16a596ae-edd3-4847-99fe-c4518e82c86f | python -m json.tool

curl -X GET http://localhost:8080/employee/16a596ae-edd3-4847-99fe-c4518e82c86f | python -m json.tool

curl -X GET http://localhost:8080/repstructure/16a596ae-edd3-4847-99fe-c4518e82c86f | python -m json.tool

curl -X GET http://localhost:8080/repstructure/03aa1462-ffa9-4978-901b-7c001562cf6f | python -m json.tool

curl -X GET http://localhost:8080/repstructure/b7839309-3348-463b-a7e3-5de1c168beb3 | python -m json.tool
