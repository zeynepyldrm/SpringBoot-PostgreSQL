
#!/bin/bash  

./mvnw clean package -DskipTests 
if [ $? -eq 0 ]; then
    cp target/springboot-postgresql-0.0.1-SNAPSHOT.jar ./
fi
