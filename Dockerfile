From openjdk:8
copy target/GalaxeMovieTheatre-0.0.1-SNAPSHOT.jar GalaxeMovieTheatre-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","GalaxeMovieTheatre-0.0.1-SNAPSHOT.jar"]
EXPOSE 8084
