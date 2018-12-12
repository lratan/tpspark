``` bash
	sbt package
	spark-submit --class "SimpleApp" --master local[4] A201712_partial.csv #LOCAL
	spark-submit --deploy-mode cluster --class "SimpleApp" target/scala-2.11/tp1_2.11-1.0.jar hdfs://spark-1:9000/user/centos/A201712.csv
```
