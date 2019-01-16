``` bash
	sbt package
spark-submit --class "SimpleApp" target/scala-2.11/tp1_2.11-1.0.jar /home/loic/Documents/M2/SID/A201712_partial.csv --master local[4]
 	spark-submit --deploy-mode cluster --class "SimpleApp" target/scal^C2.11/tp1_2.11-1.0.jar hdfs://spark-1:9000/user/centos/A201712.csv hdfs://spark-1:9000/user/centos/outfile
	hadoop fs -put A201712.csv hdfs://spark-1:9000/user/centos
	hdfs dfs -get hdfs://spark-1:9000/user/centos/outfile .
```
