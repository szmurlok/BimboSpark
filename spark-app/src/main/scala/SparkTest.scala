/**
  * Created by kszmurlo on 2016-07-08.
  */

import org.apache.spark.sql.{DataFrame, SQLContext}
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types.IntegerType

object SparkTest {
  def main(args: Array[String]): Unit = {
    val toInt    = udf[Int, String]( _.toInt)
    val toDouble = udf[Double, String]( _.toDouble)

    val conf = new SparkConf().setAppName("Test").setMaster("local")
    val sc = new SparkContext(conf)
    val sqlContext = new SQLContext(sc)

    val df = sqlContext.read
      .format("com.databricks.spark.csv")
      .option("header", "true")
      .load("C:\\Users\\kszmurlo\\Documents\\kaggle\\bimbo\\train\\sample_train.csv")

    val featureDf = df.select(df("Agencia_ID").cast(IntegerType).as("Agencia_ID_!"),
      df("Semana").cast(IntegerType).as("Semana_!"),
      df("Canal_ID").cast(IntegerType).as("Canal_ID_!"),
      df("Ruta_SAK").cast(IntegerType).as("Ruta_SAK_!"))

//      .withColumn("Agencia_ID_!", df("Agencia_ID").cast(IntegerType))

//      .withColumn("Canal_ID", toInt(df("Canal_ID")))
//      .withColumn("Ruta_SAK", toInt(df("Ruta_SAK")))
//      .withColumn("Cliente_ID", toInt(df("Cliente_ID")))
//      .withColumn("Producto_ID", toInt(df("Producto_ID")))
//      .withColumn("Venta_uni_hoy", toInt(df("Venta_uni_hoy")))
//      .withColumn("Venta_hoy", toDouble(df("Venta_hoy")))
//      .withColumn("Dev_uni_proxima", toInt(df("Dev_uni_proxima")))
//      .withColumn("Dev_proxima", toDouble(df("Dev_proxima")))
//      .withColumn("Demanda_uni_equil", toInt(df("Demanda_uni_equil")))

    val desc = featureDf.describe()
    featureDf.show()




//    val sample_df = df.limit(1000000)
//
//    sample_df.write
//      .format("com.databricks.spark.csv")
//      .option("header", "true")
//      .option("name", "sample_train.csv")
//      .save("C:\\Users\\kszmurlo\\Documents\\kaggle\\bimbo\\train\\sample_train.csv")

  }
}