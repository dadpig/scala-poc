package com.scala.render
package model

abstract class Template(title: String, body: String, footer: String, header: String, image: String)
  extends Renderable{

  def getTitle: String = title

  def getBody: String = body

  def getFooter: String = footer

  def getHeader: String = header

  def getImage: String = image
}
