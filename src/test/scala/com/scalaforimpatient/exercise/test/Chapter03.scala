package com.scalaforimpatient.exercise.test


import com.scalaforimpatient.chapter03.ex
import org.scalatest.{BeforeAndAfter, FunSpec}

import scala.collection.mutable.ArrayBuffer
/**
  * Created by sravi on 12/25/17.
  */
class Chapter03 extends FunSpec with BeforeAndAfter{
  before {

  }

  describe("Testing all the exercise solution for chapter 03") {
    //Ex 01
    it("It should be an intger array of length 10") {
      assert(ex.randomIntArray(10).isInstanceOf[Array[Int]])
      assert(ex.randomIntArray(10).size == 10)
    }
    //Ex 02 && Ex03
    it("Should swap adjacent values in Array"){
      //Odd length
      val testArr1 = Array(-1, 2, -6, -7, 5)
      val resArr1= Array(2, -1, -7, -6, 5)
      assert(testArr1.length == resArr1.length)
      for((k,v) <- resArr1.zip(ex.swapArrayAdj(testArr1))) assert(k == v)
      //Even length
      val testArr2 = Array(-1, 2, -6, -7)
      val resArr2 = Array(2, -1, -7, -6 )
      assert(testArr2.length == resArr2.length)
      for((k,v) <- resArr2.zip(ex.swapArrayAdj(testArr2))) assert(k == v)
      //Empty
      val testArr3 = Array[Int]()
      val resArr3 = Array[Int]()
      assert(testArr3.length == resArr3.length)
      for((k,v) <- resArr3.zip(ex.swapArrayAdj(testArr3))) assert(k == v)
    }

    //Ex 04
    it("Should order by positive, zero & negative values") {
      // Randomly distributed values
      val testArr1 = Array(2, -3, 3, 0, -1)
      val resArr1 = Array(2, 3, 0, -3, -1)
      for((k,v) <- resArr1.zip(ex.orderGivenArr(testArr1))) assert(k == v)
      // Negative, zero, positive
      val testArr2 = Array(-2, -3, 0, 3, 1)
      val resArr2 = Array(0, 3, 1, -2, -3)
      for((k,v) <- resArr2.zip(ex.orderGivenArr(testArr2))) assert(k == v)
    }

    //Ex 05
    it("Should return average") {
      // Randomly values
      val testArr1 = Array(2.0, 3.0, 3.0, 0.0, 1.0)
      assert(ex.arrayAvg(testArr1) == 1.8)
      // All 0
      val testArr2 = Array(0.0, 0.0, 0.0, 0.0, 0.0)
      assert(ex.arrayAvg(testArr2) == 0.0)
    }

    //Ex 06
    it("Should reverse the given array") {
      // Randomly values
      val testArr1 = Array(-6, 3, 3, 4, -1)
      val resArr1 = Array(4, 3, 3, -1, -6)
      for((k,v) <- resArr1.zip(ex.reverseArr(testArr1))) assert(k == v)
      // All 0
      val testArr2 = ArrayBuffer(2, -1, 3, -2, 4)
      val resArr2 = ArrayBuffer(4, 3, 2, -1, -2)
      for((k,v) <- resArr2.zip(ex.reverseArrBuf(testArr2))) assert(k == v)
    }

    //Ex 07
    it("Should remove duplicate elements") {
      val testArr = Array(1, 1, 2, 3, 4, 5, 2)
      val resArr = Array(1, 2, 3, 4, 5)
      for((k,v) <- resArr.zip(ex.removeDup(testArr))) assert(k == v)
    }

    //Ex 08
    it("Should remove all but first negative element") {
      val testArr = ArrayBuffer(-1, 1, -2, 3, 4, -5, 2)
      val resArr = ArrayBuffer(1, 3, 4, 2, -1)
      for((k,v) <- resArr.zip(ex.removeNeg(testArr))) assert(k == v)
    }

    //Ex 09
    it("Should remove all but first negative element optimally") {
      val testArr = ArrayBuffer(-1, 1, -2, 3, 4, -5, 2)
      val resArr = ArrayBuffer(-1, 1, 3, 4, 2)
      for((k,v) <- resArr.zip(ex.removeNegOptimal(testArr))) assert(k == v)
    }

    //Ex 10
    it("Should list all the timezones that starts with America in sorted order") {
      val lists = ex.stringMatching()
      assert(lists(0) == "Adak")
      assert(lists(10) == "Argentina/La_Rioja")
      assert(lists.last == "Yellowknife")
    }

    //Ex 11
    it("Should give list of flavors as buffer") {
      assert(ex.instanceChange.isInstanceOf[ArrayBuffer[String]])
    }

  }
}
