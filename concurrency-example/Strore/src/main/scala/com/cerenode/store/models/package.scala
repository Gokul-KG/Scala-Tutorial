package com.cerenode.store

package object models {
  object FruitCode extends Enumeration {
    type FruitCode = String
    val apple = "APPLE"
    val orange  = "Orange"
  }

  object VegCode extends Enumeration {
    type VegCode = String
    val tomato = "TOMATO"
    val potato  = "POTATO"
  }
}


