package com.scala.render
package model

import org.scalatest.funsuite.AnyFunSuite

class RenderTemplateTest extends AnyFunSuite{

  test("Render CSV Template Test") {
    val renderCSV = RenderCSV("title", "body", "footer", "header", "image")
    assert(renderCSV.render == "title;body;image;footer")
  }

  test("Render HTML Template Test") {
    val renderHtml = RenderHtml("title", "body", "footer", "header", "image")
    assert(renderHtml.render == "<!DOCTYPE html><html><head>header</head><body><title>title</title><p>body</p><img src='image' alt='image'/><footer>title</footer></body></html>")
  }

  test("Render PDF Template Test") {
    val renderPDF = RenderPDF("title", "body", "footer", "header", "image")
    assert(renderPDF.render == "I am a PDF PDF Title title PDF Body body PDF Image image PDF Footer footer")
  }
}
