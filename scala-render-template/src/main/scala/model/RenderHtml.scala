package com.scala.render
package model

case class RenderHtml(title: String, body: String, footer: String, header: String, image: String)
  extends Template(title, body, footer, header, image) {

  override def render: String = {
    s"<!DOCTYPE html><html>${getHeader}<body>${getTitle}${getBody}${getImage}${getFooter}</body></html>"
  }

  override def getTitle: String = s"<title>${title}</title>"

  override def getBody: String = s"<p>${body}</p>"

  override def getFooter: String = s"<footer>${title}</footer>"

  override def getHeader: String = s"<head>${header}</head>"

  override def getImage: String = s"<img src='${image}' alt='image'/>"
}
