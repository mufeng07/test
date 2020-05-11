package com.mufeng.spark

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * @author mufeng
  * @date 8:53 2020/5/5  
  */
object FavTeacher {
  def main(args: Array[String]): Unit = {
    //创建spark配置，设置应用程序名字
   var conf= new SparkConf().setAppName("FavTeacher").setMaster("local[4]")
    //创建spark执行的入口
    var sc= new SparkContext(conf)
    //指定以后从哪里读取数据创建RDD（弹性分布式数据集）
    var lines: RDD[String] =sc.textFile(args(0))
    var one: RDD[(String, Int)] =lines.map(line=>{
      var index= line.lastIndexOf("/")
      var teacher=line.substring(index+1)
      (teacher,1)
    })
    //聚合
    var reduced: RDD[(String, Int)] =one.reduceByKey(_+_)
    //排序
    var sort=reduced.sortBy(_._2,false)
    //触发Acton执行计算
    var result: Array[(String, Int)] =sort.collect()
    println(result.toBuffer)
    sc.stop()
  }
}
