# SoarEarthSkillTestLocationBasedService
# SoarEarth Location Based Service API Skill Test

To develop a simple backend API for a location-based service. The service
allows users to store and retrieve points of interest (POIs) on a map. Each POI has a name,
description, location (latitude, longitude), and an optional category.

Requirements:

API Endpoints:

○ Create POI:

■ POST /api/pois

Request body:json
{
"name": "Central Park",
"description": "Public park in New York City.",
"latitude": 40.785091,
"longitude": -73.968285,
"category": "Park"
}

Response: HTTP 201 Created with the created POI's details in the
response body.

○ Retrieve POI by ID:

■ GET /api/pois/{id}

Response: POI details as a JSON object.

○ Retrieve POIs within a radius:

■ GET /api/pois

Query parameters: latitude, longitude, radius (in kilometers)

Response: A list of POIs within the specified radius.

○ Update POI:

■ PUT /api/pois/{id}

Request body: Same as the create POI request but all fields are optional.

Response: HTTP 200 OK with the updated POI's details.

○ Delete POI:

■ DELETE /api/pois/{id}

Response: HTTP 204 No Content.



## Authors

- [@poojashreedhar068](https://www.github.com/poojashreedhar068)


## PreRequisites

* Java 17
* PostGreSQL DB
* PostGIS Extension
* Maven
* IntelliJ
* Docker if docker image needs to be generated
* Docker Compose
  
## Tech Stack

Framework : SpringBoot 3.*

Programming Language : Java 17

Log Framework : Logback with JSON Formatter

Database : PostGreSQL with PostGIS

Monitoring tools : Actuator

OpenAPI : Swagger

Containerization : Docker, Docker Compose


## API Reference

POST soarearth/api/pois

GET soarearth/api/pois/{id}

GET soarearth/api/pois?latitude=<>&longitude=<>&radius=<>

PUT soarearth/api/pois/{id}

DELETE soarearth/api/pois/{id}


## Used By

This project is used by the following companies:

- Pooja Shreedhar
- Soar Earth to access


## Deployment

```````To run on Tomcat```````````
* Install Required version tomcat on local
* build the jar file by providing PostGreSQL DB details on application.yaml file. use command :: mvn clean install
* Jar would be generated on target folder
* Place Jar file on Tomcat/WEBAPPS folder
* Start tomcat using either command or .sh script


```Containerization````
* Generate Docker image using DockerFile provided
    docker build -t soarEarthLocationAPI:latest .

* Edit Image and PostGreSQL in docker-compose.yaml file. Run the below command to run docker image using Docker compose
        docker-compose up 

## Screenshots

Required execution and monitoring screenshots are attached in separate document named as SoarEarthSkillSet_ExecutionScreenshots.docx and SoarEarthSkillTest_MonitoringScreenshots.docx


## Running Tests

Unit Test:

Use Postman or any API tool to hit the API's and Test.

Performance Test:

Jmeter or any other performance testing tool can be used to perform testing.



