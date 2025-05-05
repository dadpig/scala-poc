package com.scala.render
package model

case class RenderCSV (title: String, body: String, footer: String, header: String, image: String)
  extends Template(title, body, footer, header, image) {
  
  override def render: String = {
    s"${getTitle};${getBody};${getImage};${getFooter}"
  }
  
  override def getTitle: String = title

  override def getBody: String = body

  override def getFooter: String = footer

  override def getHeader: String = header

  override def getImage: String = image
    
    
  }