
#!/bin/bash  
docker stop db && docker rm db
docker stop app && docker rm app
docker-compose build
docker-compose -f docker-compose.yml up -d
