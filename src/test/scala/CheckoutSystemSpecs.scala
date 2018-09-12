import org.scalatest.{FlatSpec, Matchers}

class CheckoutSystemSpecs extends FlatSpec with Matchers {

  markup {
    """
      |# CheckoutSystem
      |
      |##`checkoutCost`
      |
      |The function takes list of items scanned a tht till and outputs the total cost
    """.stripMargin
  }

  it should "return total cost for no fruits bought as 0.00" in {
    CheckoutSystem.checkoutCost(Nil) should be("£0.00")
  }

  it should "return the total cost of an apple as 0.60" in {
    val fruit = Seq("Apple")
    CheckoutSystem.checkoutCost(fruit) should be("£0.60")
  }

  it should "return the total cost of an orange as 0.25" in {
    val fruit = Seq("Orange")
    CheckoutSystem.checkoutCost(fruit) should be("£0.25")
  }

  it should "return the total cost of an apple and an orange as 0.85" in {
    val fruits = Seq("Apple", "Orange")
    CheckoutSystem.checkoutCost(fruits) should be("£0.85")
  }

  it should "return the total cost of 3 apples and 1 orange as 1.45" in {
    val fruits = Seq("Apple", "Apple", "Apple", "Orange")
    CheckoutSystem.checkoutCost(fruits) should be("£1.45")
  }

  it should "return the total cost of 2 apples with 'buy one get one free offer' as 0.60" in {
    val fruits = Seq("Apple", "Apple")
    CheckoutSystem.checkoutCost(fruits) should be("£0.60")
  }

  it should "return the total cost of 4 apples with 'buy one and get one free' as 1.20" in {
    val fruits = Seq("Apple", "Apple", "Apple", "Apple")
    CheckoutSystem.checkoutCost(fruits) should be("£1.20")
  }

  it should "return the total cost of 2 oranges and 1 apple with 'buy one apple and get one free offer' as 1.10" in {
    val fruits = Seq("Orange", "Orange", "Apple")
    CheckoutSystem.checkoutCost(fruits) should be("£1.10")
  }

  it should "return the total cost of 3 oranges with 'three for the price of two offer' of 0.50" in {
    val fruits = Seq("Orange", "Orange", "Orange")
    CheckoutSystem.checkoutCost(fruits) should be("£0.50")
  }

  it should "return total cost of 6 oranges and 4 apples with 'both the offers' as 2.20" in {
    val fruits = Seq("Orange", "Orange", "Orange", "Orange", "Orange", "Orange", "Apple", "Apple", "Apple", "Apple")
    CheckoutSystem.checkoutCost(fruits) should be("£2.20")
  }
}
