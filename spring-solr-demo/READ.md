# Spring Data Solr Demo

Simple demo for solrj using spring data host on Docker

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

Docker  

### Installing


```
git clone repo
cd spring-solr-demo
docker-compose up 
```
after finish use 

```
docker-compose down
```


## Running the tests

you can access solr throw this [Link](http://localhost:8983/solr/#/)

and use this link to access api 
```
curl http://localhost:8080/api/employee/{search name}
curl http://localhost:8080/api/employee/Tate
```
## Built With

* Docker
* Maven
* Spring
* Solr

## Authors

* **Mohamed Motyim** - *Initial work* - [MotYim](https://github.com/motyim)