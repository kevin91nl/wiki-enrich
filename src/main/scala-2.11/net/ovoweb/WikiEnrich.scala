package net.ovoweb

import org.apache.spark.{SparkConf, SparkContext}

object WikiEnrich {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("wiki-enrich")
    val sc = new SparkContext(conf)
    println("hello world.")
  }
}