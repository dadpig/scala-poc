package guitar.factory.app

import guitar.factory.builder.{BodyBuilder, CustomizationDetailsBuilder, GuitarBuilder, HeadStockBuilder, ModelBuilder, NeckBuilder, SpecificationBuilder}
import guitar.factory.model.types.Brand.TAKAMINI
import guitar.factory.model.types.Color.{BLACK, BRONZE, RED, SILVER, TITANIUM}
import guitar.factory.model.types.Sticker.{FLAMES, SKULLS}
import guitar.factory.model.types.{Brand, FretModel, Material, ModelType, Sticker, TrusRoadType, TuningKeyType}
import guitar.factory.model.{Body, Guitar, HeadStock, Model, Neck}



object Main extends App {
  println("Hello, Guitar Factory!")

  
  println("choosing neck")
  val neckBuilder: NeckBuilder = new NeckBuilder()
  val myNeck: Neck = neckBuilder.withId(1).withName("My custom neck").withBrand(Brand.FENDER).withFretModel(FretModel.MEDIUM).withTrusRoadType(TrusRoadType.SINGLE).build
  println(myNeck)
  println("")
  println("choosing body")
  val bodyBuilder: BodyBuilder = new BodyBuilder()
  val myBody: Body = bodyBuilder.withId(1).withName("My custom body").withBrand(Brand.GIBSON).withMaterial(Material.MAPLE).build
  println(myBody)
  println("")
  println("choosing head")
  val headBuilder: HeadStockBuilder = new HeadStockBuilder()
  val myHead: HeadStock = headBuilder.withId(1).withName("My custom head").withSize(1.5).withWeight(3.2).withTuningKey(TuningKeyType.VINTAGE).withBrand(TAKAMINI).build
  println(myHead)
  println("")
  
  println("choosing model")
  val modelBuilder: ModelBuilder = new ModelBuilder()
  val myModel: Model = modelBuilder.withId(1).withModel(ModelType.STRAT).withParts(Array(myHead, myBody, myNeck)).build
  println(myModel)
  println("")

  val myCustomGuitar: Guitar = GuitarBuilder().withId(1).withYear(2021).withModel(myModel).build()
  println("My Guitar without customization parts :"+myCustomGuitar)
  println("current price: "+myCustomGuitar.calculatePrice)
  println("current weight: "+myCustomGuitar.calculateWeight)
  println("")
  println("customizing guitar")
  val customizationDetailsBuilder: CustomizationDetailsBuilder = new CustomizationDetailsBuilder()
  val myCustomBody = customizationDetailsBuilder.withId(1).withColor(Array(BLACK, TITANIUM, BRONZE)).withMessage("Head Bangers Alive!").withSticker(Array(SKULLS, FLAMES)).withComponent(myBody).build
  val myCustomNeck = customizationDetailsBuilder.withId(2).withColor(Array(SILVER,RED)).withMessage("Kill 'em all!").withSticker(Array(Sticker.CAMO)).withComponent(myNeck).build
  val myCustomHead = customizationDetailsBuilder.withId(3).withColor(Array(BLACK)).withMessage("Ride the Lightning!").withSticker(Array(FLAMES)).withComponent(myHead).build

  val specification = SpecificationBuilder().withId(1).withCustomizations(Array(myCustomBody, myCustomNeck, myCustomHead)).build
  val myOwnCustomGuitar = GuitarBuilder().withId(2).withYear(2021).withModel(myModel).withCustomization(specification).build()

  println("My Guitar with customization parts :" + myOwnCustomGuitar)
  println("check current price: " + myOwnCustomGuitar.calculatePrice)
  println("check current weight: " + myOwnCustomGuitar.calculateWeight)
}
