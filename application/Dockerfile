FROM openjdk:8-jre-alpine 

COPY target/....war /application.war 

# specify default command 
CMD ["/usr/bin/java", "-jar", "-Dspring.profiles.active=test", "/application.war"]
