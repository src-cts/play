name := """hello-world-param"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs
)
EclipseKeys.preTasks := Seq(compile in Compile)
herokuAppName in Compile := "hello-world-param"