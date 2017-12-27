package com.scalaforimpatient.chapter04

import java.io.File
import java.util.Scanner

import scala.collection.mutable
import scala.collection.mutable.SortedMap

/**
  * Created by sravi on 12/26/17.
  */
object ex {
  // Ex 01
  def gizmos():List[Map[String, Double]] = {
    val actualMap = Map("Iphone" -> 900.00, "pixel" -> 600.00, "s8" -> 800.00)
    List(actualMap, actualMap.mapValues(_*0.9))
  }

  //Ex 02
  def readFile(path:String):scala.collection.mutable.Map[String, Int] = {
    val in = new Scanner(new File(getClass.getClassLoader.getResource(path).getFile))
    val map = scala.collection.mutable.Map[String, Int]()
    while(in.hasNext()) {
      val word = in.next()
      val count = map.getOrElse(word,0) +1
      map.put(word, count)
    }
    println(map.mkString("\n"))
    map
  }

  //Ex 03
  def readFileImmutable(path:String):Map[String, Int] = {
    val stream = scala.io.Source.fromInputStream(getClass.getResourceAsStream(path))
    stream.getLines.flatMap(line => {line.split("\\s+").groupBy(identity(_)).mapValues(_.size)}).toStream.groupBy(_._1).mapValues(_.map(_._2).sum)
  }

  //Ex 04
  def readFileSorted(path:String):SortedMap[String, Int] = {
    val in = new Scanner(new File(getClass.getClassLoader.getResource(path).getFile))
    val map = scala.collection.mutable.SortedMap[String, Int]()
    while(in.hasNext()) {
      val word = in.next()
      val count = map.getOrElse(word,0) +1
      map.put(word, count)
    }
    println(map.mkString("\n"))
    map
  }

  //Ex 05
  def readFileTree(path: String): scala.collection.mutable.Map[String, Int] = {
    import scala.collection.JavaConversions.mapAsScalaMap
    val in = new Scanner(new File(getClass.getClassLoader.getResource(path).getFile))
    val map:scala.collection.mutable.Map[String, Int] = new java.util.TreeMap[String, Int]()
    while(in.hasNext()) {
      val word = in.next()
      val count = map.getOrElse(word,0) +1
      map.put(word, count)
    }
    map
  }

  //Ex 06
  def linkedHashMap(): mutable.LinkedHashMap[String, Int] = {
    val map = mutable.LinkedHashMap[String, Int]()
    map.put("Monday", java.util.Calendar.MONDAY)
    map.put("Tuesday", java.util.Calendar.TUESDAY)
    map.put("Wednesday", java.util.Calendar.WEDNESDAY)
    map.put("Thursday", java.util.Calendar.THURSDAY)
    map.put("Friday", java.util.Calendar.FRIDAY)
    map.put("Saturday", java.util.Calendar.SATURDAY)
    map.put("Sunday", java.util.Calendar.SUNDAY)
    println(map.mkString("\n"))
    map
  }

  //Ex 07
  def propsScalaMap() = {
    import scala.collection.JavaConversions.propertiesAsScalaMap
      val props:scala.collection.Map[String, String] = java.lang.System.getProperties
      val space = props.map(_._1.length).max + 5
      for ((k,v) <- props) {
        val indent = space - k.length
        val fill:String = (for (i <- 1 to indent) yield ' ').mkString
        println(k+fill+"  |  "+v)
    }
  }

  //Ex 08
  def minmax(values: Array[Int]) = {
    (values.max, values.min)
  }

  //Ex 09
  def lteqgt(values: Array[Int], v:Int) = {
    (values.filter(_ < v).length, values.filter(_ == v).length, values.filter(_ > v).length)
  }

  //Ex 10
  // zip can be used for creating n-gram  model for Natural language processing domain
}
