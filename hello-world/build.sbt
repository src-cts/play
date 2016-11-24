name := """hello-world"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs
)

// https://mvnrepository.com/artifact/org.springframework/spring-web
libraryDependencies += "org.springframework" % "spring-web" % "4.3.4.RELEASE"
