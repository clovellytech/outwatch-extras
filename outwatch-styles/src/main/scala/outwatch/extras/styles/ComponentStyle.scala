package outwatch.extras.styles

import cats.effect.IO
import outwatch.dom.Attribute
import outwatch.dom.dsl.attributes

import scala.language.implicitConversions
import scalacss.defaults.Exports.StyleA

/**
  * Created by marius on 23/05/17.
  */
trait ComponentStyle {

  type StyleSheet = scalacss.defaults.Exports.StyleSheet.Inline

  type Style <: StyleSheet

  implicit def styleToAttr(styleA: StyleA): IO[Attribute] = {
    attributes.className := styleA.htmlClass
  }

}
