class CheckoutSystem {

  val costOfSingleOrange = 0.25
  val costOfSingleApple = 0.60

  def checkoutCost(items: Seq[String]) = {

    val costOfOranges = offerOnItems(items.filter(_ == "Orange"), 3, costOfSingleOrange)
    val costOfApples = offerOnItems(items.filter(_ == "Apple"), 2, costOfSingleApple)

    val totalCost = costOfOranges + costOfApples
    f"£$totalCost%.2f"
  }

  def offerOnItems(fruits: Seq[String], offeredItems: Int, costOfSingleItem: Double) = {
    var count = 0
    var cost: Double = 0.0
    fruits.foreach { _ =>
      if (count < offeredItems - 1) {
        cost = cost + costOfSingleItem
        count = count + 1
      }
      else count = 0
    }
    cost
  }
}

object CheckoutSystem extends CheckoutSystem
