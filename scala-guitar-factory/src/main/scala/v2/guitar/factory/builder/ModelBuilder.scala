package v2.guitar.factory.builder

import v2.guitar.factory.model.{Head, Model, Part, Body}

object ModelBuilder {
    
    def createModel(id: Long, name: String, brand: String, bodyParts: Array[Part]): Model = {
      Model(id, name, brand, bodyParts)
    }
    
    def createHead(id: Long, name: String, price: Double, tuningKey: String): Part = {
      Head(id, name, price, tuningKey)
    }
    
    def createBody(id: Long, name: String, price: Double, material: String): Part = {
      Body(id, name, price, material)
    }
    
    def createNeck(id: Long, name: String, price: Double, fret: String, trusRoad: String): Part = {
      v2.guitar.factory.model.Neck(id, name, price, fret, trusRoad)
    }
    
    def createHeadFromMap(modelMap: Map[String, String]): Model = {
      val bodyParts = modelMap("bodyParts").split(",").map { part =>
        val partMap = part.split(":").map(_.trim)
        createHead(partMap(0).toLong, partMap(1), partMap(2).toDouble, partMap(3))
      }
      createModel(modelMap("id").toLong, modelMap("name"), modelMap("brand"), bodyParts)
    }
    
    def createBodyFromMap(modelMap: Map[String, String]): Model = {
      val bodyParts = modelMap("bodyParts").split(",").map { part =>
        val partMap = part.split(":").map(_.trim)
        createBody(partMap(0).toLong, partMap(1), partMap(2).toDouble, partMap(3))
      }
      createModel(modelMap("id").toLong, modelMap("name"), modelMap("brand"), bodyParts)
    }
    
}
