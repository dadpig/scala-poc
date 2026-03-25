package leadrandori

object RandomForest {



  case class DecisionTree(feature: String, threshold: Double, left: DecisionTree = null, right: DecisionTree = null)


  def createRandomForest(numTrees: Int): List[DecisionTree] = {
    (1 to numTrees).map { i =>
      DecisionTree(s"Feature$i", i * 0.5)
    }.toList

  }

  def predict(randomForest: List[DecisionTree], input: Map[String, Double]): String = {
    val predictions = randomForest.map { tree =>
      if (input(tree.feature) > tree.threshold) "item A" else "item B"
    }
    if (predictions.count(_ == "item A") > predictions.count(_ == "item B")) "item A" else "item B"
  }



  def main(args: Array[String]): Unit = {
    val randomForest = createRandomForest(5)
    val input = Map("Feature1" -> 0.3, "Feature2" -> 1.0, "Feature3" -> 0.5, "Feature4" -> 2.0, "Feature5" -> 0.1)
    val prediction = predict(randomForest, input)
    println(s"Simulation prediction for input $input: $prediction")
  }

}
