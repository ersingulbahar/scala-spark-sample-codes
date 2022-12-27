import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession

import java.nio.file.Paths

object Main {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().master("local").appName("SparExample").getOrCreate();
    val rdd = spark.sparkContext.textFile("C:\\Users\\hasanozka\\IdeaProjects\\scala-spark\\data\\foo.txt");
    spark.sparkContext.setLogLevel("WARN")
    println("Count : " + rdd.count())
    println("First : " + rdd.first())


    val twoRecord = rdd.take(2);
    for (line <- twoRecord)
      println("-------> " + line)
    System.setProperty("hadoop.home.dir", Paths.get("winutils").toAbsolutePath.toString)

    val filteredRDD = rdd.filter(line => line.contains("foo1"))
    println("----------------------- > Filtered Count : " +
      filteredRDD.count())
    filteredRDD.foreach(line => println("-------------------------->" + line))
    filteredRDD.saveAsTextFile("C:\\Users\\hasanozka\\IdeaProjects\\scala-spark\\data\\filtered_result")


    val rdd_movies = spark.sparkContext.textFile("C:\\Users\\hasanozka\\IdeaProjects\\scala-spark\\data\\movies.csv");
    println("Count : " + rdd_movies.count())
    println("First : " + rdd_movies.first())
    val movieRdd = rdd_movies.map(row => {
      val arr = row.split(",")
      (new Movie(arr(0), arr(1), arr(2)))
    })
    println("Movie RDD Count : " + movieRdd.count())
    println("Movie RDD First : " + movieRdd.first())




  }
}


