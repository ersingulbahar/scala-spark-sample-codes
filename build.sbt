ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.10"


ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.10"


lazy val root = (project in file("."))
  .settings(
    name := "scala-spark"
  )

val sparkVersion = "3.3.1"
// Note the dependencies are provided
libraryDependencies += "org.apache.spark" %% "spark-core" % sparkVersion
libraryDependencies += "org.apache.spark" %% "spark-sql" % sparkVersion
libraryDependencies += "mysql" % "mysql-connector-java" % "8.0.30"
libraryDependencies += "org.apache.spark" %% "spark-avro" % "3.2.3"
libraryDependencies += "org.apache.spark" %% "spark-hive" % "3.2.3" % "provided"
libraryDependencies += "org.apache.spark" %% "spark-mllib" % "3.2.3"