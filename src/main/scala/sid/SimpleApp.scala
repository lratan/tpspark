import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.{SaveMode}

    case class Message(message: String)
object SimpleApp {
  def main(args: Array[String]) {
    //val logFile = "/home/loic/Documents/M2/SID/A201712_partial_500000.csv"
    val logFile = args(0)
    val outFile = args(1)
    val spark = SparkSession.builder.appName("Simple Application").getOrCreate()
    import spark.implicits._
    //READ AS CSV
    val logData = spark.read.textFile(logFile).cache()
    //ONLY GET WORK ACCIDENTS
    val subsetAmount = logData.map(line => line.split(";"))
                  .filter(stringArray => stringArray(32) != "0")
                  .count()
    val df = Seq(Message(subsetAmount.toString)).toDF().coalesce(1)
    df.write.mode(SaveMode.Write).csv(outFile)
    spark.stop();
  }
}
