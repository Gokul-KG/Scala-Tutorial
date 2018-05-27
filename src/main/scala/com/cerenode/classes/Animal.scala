package com.cerenode.classes

abstract class Animal {
  def name: String
}

class Pet extends Animal {
  override def name = "Pet"
}

class Cat extends Pet {
  override def name = "Cat"
}

class Dog extends Pet {
  override def name = "Dog"
}

class LabourDog extends Dog {
}

class Lion extends Animal {
  override def name = "Lion"
}

class PetContainer[P <: Pet](p: P) {
  def pet: P = p
}

class Box1[+T]

class Box2[-T]

class Box3[T]

object Animal extends App {
  val dogCntr = new PetContainer[Dog](new Dog)
  val catCntr = new PetContainer[Cat](new Cat)

  val lionCnt = new PetContainer[Lion](new Lion)

  def method1(box: Box1[Pet]): Unit = {}

  def method2(box: Box2[Pet]): Unit = {}

  def method3(box: Box3[Pet]): Unit = {}

  method1(new Box1[Dog])
  method1(new Box1[Pet])
//    method1(new Box1[Animal])

  method2(new Box2[Pet])
  method2(new Box2[Animal])
  //  method2(new Box2[Cat])

  method3(new Box3[Pet])
  //  method3(new Box3[Animal])
  //  method3(new Box3[LabourDog])
  List(1, 2, 3).foldLeft(List.empty[Int]) { (acc, cur) =>
    if(cur % 2 == 0)
      acc :+ cur
    else
      acc
  }
}