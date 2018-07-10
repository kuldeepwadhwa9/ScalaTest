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

  it should "Calculate the total cost of 3 apples" in {
    val apples = Seq("Apple", "Apple", "Apple")
    CheckoutSystem.checkoutCost(apples) should be("£1.20")
  }

  it should "Calculate the total cost of 5 oranges" in {
    val oranges = Seq("Orange", "Orange", "Orange", "Orange", "Orange")
    CheckoutSystem.checkoutCost(oranges) should be("£1.00")
  }

  it should "Calculate the total cost of 5 apples and 6 oranges" in {
    val fruits = Seq("Apple", "Apple", "Apple", "Apple", "Apple", "Orange", "Orange", "Orange", "Orange", "Orange", "Orange")
    CheckoutSystem.checkoutCost(fruits) should be("£2.80")
  }

  it should "Calculate the total cost of 1 apples and 2 oranges" in {
    val fruits = Seq("Apple", "Orange", "Orange")
    CheckoutSystem.checkoutCost(fruits) should be("£1.10")
  }

}
