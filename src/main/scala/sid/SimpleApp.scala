import org.apache.spark.sql.SparkSession

object SimpleApp {
  def main(args: Array[String]) {
    /* val logFile = "/home/loic/Documents/M2/SID/A201712_partial.csv" // Should be some file on your system
     val spark = SparkSession.builder.appName("Simple Application").getOrCreate()
     val logData = spark.read.textFile(logFile).cache()
     val numAs = logData.filter(line => line.contains("-12")).count()
     val numBs = logData.filter(line => line.contains("b")).count()
     println(s"Lines with -12: $numAs, Lines with b: $numBs")
     spark.stop()
   */
    val logFile = "/home/loic/Documents/M2/SID/A201712_partial_500000.csv"
    val spark = SparkSession.builder.appName("Simple Application").getOrCreate()
  import spark.implicits._
    val logData = spark.read.textFile(logFile).cache()
    val subsetAmount = logData.map(line => line.split(";"))
                  .filter(stringArray => stringArray(32) != "0")
                  .count()
     println(s"subset size: $subsetAmount")
    spark.stop();
  }
}
