FROM java:8
EXPOSE 8080
COPY target/kubernetes-service.jar kubernetes-service.jar
COPY target/dependency /lib
ENTRYPOINT ["java", "-jar", "kubernetes-service.jar"]
