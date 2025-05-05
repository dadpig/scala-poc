package com.scala.render
package model

case class RenderPDF(title: String, body: String, footer: String, header: String, image: String)
  extends Template(title, body, footer, header, image) {

  override def render: String = {
    s"I am a PDF ${getTitle} ${getBody} ${getImage} ${getFooter}"
  }

  override def getTitle: String = "PDF Title "+title

  override def getBody: String = "PDF Body "+body

  override def getFooter: String = "PDF Footer "+footer

  override def getHeader: String = "PDF Header "+header

  override def getImage: String = "PDF Image "+image
}
