// closures

val x = 10

def add10(a: Int) = x + a

// impure closure

var y = 20

val addY = (a: Int) => a + y : Int

addY(3)

y = y + 10

addY(4)

// higher order function

def providerA(money: Double) = 0.05

def providerB(money: Double) = money * 0.10

def moneyTransfer(amount: Double, providerFee: Double => Double): Double = {
  amount + providerFee(amount)
}

moneyTransfer(400, providerA)

moneyTransfer(400, providerB)

// currying

// normal function

def add(a: Int, b: Int): Int = a + b

add(2, 3)

// curried function

def add_C(a: Int): Int => Int = (b: Int) => a + b

add_C(2)(3)

//syntactic sugar

def add_CSimple(a: Int)(b: Int) = a + b

add_CSimple(2)(3)

// converting to a curried function

val g = (add _).curried

g(2)