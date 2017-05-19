FROM davidcaste/alpine-java-unlimited-jce:jdk8
ADD target/* /target/
CMD ["java","-Dspring.profiles.active=container", "-jar", "/target/UserDemographicService-0.0.1-SNAPSHOT.jar"]
