package com.mufeng.spark

/**
  * @author mufeng
  * @date 21:36 2020/5/5  
  */
object SortRules {
  implicit object OrderingXiaoRou extends Ordering[XianRou] {
    override def compare(x: XianRou, y: XianRou): Int = {
      if(x.fv == y.fv) {
        x.age - y.age
      } else {
        y.fv - x.fv
      }
    }
  }
}
