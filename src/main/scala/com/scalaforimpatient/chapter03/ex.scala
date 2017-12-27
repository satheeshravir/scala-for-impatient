package com.scalaforimpatient.chapter03

import java.awt.datatransfer.{DataFlavor, SystemFlavorMap}

import scala.collection.mutable.ArrayBuffer
import scala.util.Random

/**
  * Created by sravi on 12/24/17.
  */
object ex {

  //Ex 01
  def randomIntArray(n:Int):Array[Int] = {
    Array.fill(n)( Random.nextInt(10000))
  }

  //Ex 02
  def swapArrayAdj(arr: Array[Int]):Array[Int] = {
    for (i <- 1 until arr.length by 2) { val temp = arr(i); arr(i) = arr(i-1); arr(i-1) = temp; }
    arr
  }

  //Ex 03
  def swapArrayAdjYield(arr: Array[Int]):IndexedSeq[Int] = {
    for (i <- 0 until arr.length by 1)
      yield if (i % 2 == 0)
        if (i + 1 < arr.length) arr(i + 1)
        else arr(i)
      else
        arr(i - 1)
  }

  //Ex 04
  def orderGivenArr(arr: Array[Int]):Array[Int] = {
    arr.filter(_ >= 0) ++ arr.filter(_ < 0)
  }

  //Ex 05
  def arrayAvg(arr:Array[Double]):Double = {
    arr.sum/arr.length
  }

  //Ex 06 a
  def reverseArr(arr:Array[Int]):Array[Int] = {
    scala.util.Sorting.quickSort(arr)
    arr.reverse
  }

  //Ex 06 b
  def reverseArrBuf(arr:ArrayBuffer[Int]):ArrayBuffer[Int] = {
    arr.sortWith(_ > _)
  }

  //Ex 07
  def removeDup(arr:Array[Int]): Array[Int] = {
    arr.distinct
  }

  //Ex 08
  def removeNeg(arr:ArrayBuffer[Int]): ArrayBuffer[Int] = {
    val firstEle = arr.find(_ < 0)
    arr.sortWith(_ > _)
    for(i <- arr.length-1 to 0 by -1 if arr(i) < 0) arr.remove(i)
    arr+=firstEle.get
    arr
  }

  //Ex 09
  def removeNegOptimal(arr:ArrayBuffer[Int]): ArrayBuffer[Int] = {
    var count = -1
    val diffArr = ArrayBuffer[Int]()
    var n = arr.length
    for(i <- 0 until n) {
      if (arr(i) < 0)
          count += 1
      diffArr+=count
    }
    for(i <- 0 until n if arr(i) >= 0){
      if (diffArr(i) > -1)
      arr(i-diffArr(i)) = arr(i)
    }
    for (i <- 1 to diffArr.last) arr.remove(n-i)
    arr
  }

  // Ex 10
  def stringMatching():Array[String] = {
    java.util.TimeZone.getAvailableIDs.filter(_.startsWith("America/")).map(_.replaceFirst("America/", ""))
  }

  // Ex 11
  def instanceChange():scala.collection.mutable.Buffer[Object] = {
    val flavors = SystemFlavorMap.getDefaultFlavorMap.asInstanceOf[SystemFlavorMap]
    flavors.getNativesForFlavor(DataFlavor.imageFlavor).toArray().toBuffer
  }
}
