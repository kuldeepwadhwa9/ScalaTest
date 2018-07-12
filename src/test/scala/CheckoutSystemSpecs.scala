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

  it should "Calculate the total cost of 1 apple - basic test" in {
    val apple = Seq("Apple")
    CheckoutSystem.checkoutCost(apple) should be("£0.60")
  }

  it should "Calculate the total cost of 2 apple - promotional offer test" in {
    val apples = Seq("Apple", "Apple")
    CheckoutSystem.checkoutCost(apples) should be("£0.60")
  }

  it should "Calculate the total cost of 1 orange - basic test" in {
    val orange = Seq("Orange")
    CheckoutSystem.checkoutCost(orange) should be("£0.25")
  }

  it should "Calculate the total cost of 3 oranges - promotional offer test" in {
    val oranges = Seq("Orange", "Orange", "Orange")
    CheckoutSystem.checkoutCost(oranges) should be("£0.50")
  }

  it should "Calculate the total cost of 2 apples and 3 oranges- mixed test" in {
    val fruits = Seq("Apple", "Apple", "Orange", "Orange", "Orange")
    CheckoutSystem.checkoutCost(fruits) should be("£1.10")
  }
}
