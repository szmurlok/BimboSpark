name := "spark-app"

version := "1.0"

scalaVersion := "2.11.2"

// https://mvnrepository.com/artifact/org.apache.spark/spark-core_2.11
libraryDependencies += "org.apache.spark" % "spark-core_2.11" % "1.6.1"

// https://mvnrepository.com/artifact/org.apache.spark/spark-sql_2.11
libraryDependencies += "org.apache.spark" % "spark-sql_2.11" % "1.6.1"

// https://mvnrepository.com/artifact/com.databricks/spark-csv_2.11
libraryDependencies += "com.databricks" % "spark-csv_2.11" % "1.4.0"

