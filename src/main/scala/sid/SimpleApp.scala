import org.apache.spark.sql.SparkSession

object SimpleApp {
  def main(args: Array[String]) {
    //val logFile = "/home/loic/Documents/M2/SID/A201712_partial_500000.csv"
    val logFile = args(0)
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
