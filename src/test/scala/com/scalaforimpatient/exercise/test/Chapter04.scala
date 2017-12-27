package com.scalaforimpatient.exercise.test

import org.scalatest.{BeforeAndAfter, FunSpec}
import com.scalaforimpatient.chapter04.ex

import scala.collection.mutable

/**
  * Created by sravi on 12/26/17.
  */
class Chapter04 extends FunSpec with BeforeAndAfter{
  describe("Testing all the exercise solution for chapter 03") {
    //Ex 01
    it("Should return map of the gizmo -> price and create a map with 10% less price"){
      val listMap = ex.gizmos()
      assert(listMap(0)("Iphone")*0.9 == listMap(1)("Iphone"))
      assert(listMap(0)("pixel")*0.9 == listMap(1)("pixel"))
      assert(listMap(0)("s8")*0.9 == listMap(1)("s8"))
    }

    //Ex 02
    it("Should return expected frequency distribution of words"){
      val map = ex.readFile("myfile.txt")
      assert(map.getOrElse("I", 0) == 3)
      assert(map.getOrElse("code", 0) == 2)
    }

    //Ex 03
    it("Should return expected frequency distribution of words and instance immutable"){
      val map = ex.readFileImmutable("/myfile.txt")
      assert(map.getOrElse("I", 0) == 3)
      assert(map.getOrElse("code", 0) == 2)
      assert(map.isInstanceOf[Map[String, Int]])
    }

    //Ex 04
    it("Should return expected frequency distribution of words and instance Sorted"){
      val map = ex.readFileSorted("myfile.txt")
      assert(map.getOrElse("I", 0) == 3)
      assert(map.getOrElse("code", 0) == 2)
      assert(map.isInstanceOf[mutable.SortedMap[String, Int]])
    }

    //Ex 05
    it("Should return expected frequency distribution of words created using java TreeMap"){
      val map = ex.readFileTree("myfile.txt")
      assert(map.getOrElse("I", 0) == 3)
      assert(map.getOrElse("code", 0) == 2)
    }

    //Ex 08
    it("Should return expected min and max"){
      val mima = ex.minmax(Array(3, 4, 5, 1, 2))
      assert(mima._1 == 5)
      assert(mima._2 == 1)
    }

    //Ex 09
    it("Should return less equal and greater"){
      val lge = ex.lteqgt(Array(3, 4, 5, 1, 2), 3)
      assert(lge._1 == 2)
      assert(lge._2 == 1)
      assert(lge._3 == 2)
    }


  }
}
