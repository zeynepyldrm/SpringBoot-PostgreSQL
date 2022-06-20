# SpringBoot-PostgreSQL

It is a rest api that provides crud and basic authentication with interceptors.

## Used Technologies
|  |  |
| ------ | ------ |
| Spring Boot | Web Framework  |
| PostgreSQL | Database  |
| JPA Hibernate | ORM |
| Maven | Package Manager  |


## Features
- CRUD operations for category
- Basic Authentication
- Up to n paroducts definitions can be made for one category.

## How To Run
1- Clone the repository with the command 
```sh
 git clone https://github.com/zeynepyldrm/SpringBoot-PostgreSQL
```
2- Run containers with makefile these command
```sh
  make run
```
### Or if you want to run it with docker compose
2-  Get build in dockerfile and go into the file and run these commands
```sh
  docker-compose build ./
  docker-compose -f docker-compose.yml up -d
```
