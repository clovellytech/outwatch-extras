package outwatch.extras.styles

import monix.execution.Ack.Continue
import monix.execution.{Ack, Cancelable}
import monix.reactive.subjects.ConcurrentSubject
import monix.execution.Scheduler.Implicits.global

import scalacss.defaults.Exports.StyleSheet

/**
  * Created by marius on 11/06/17.
  */
trait Styles[S] {
  private val styles = ConcurrentSubject.publish[S]

  def publish(s: S): Ack = styles.onNext(s)

  def subscribe(f: S => Unit): Cancelable = styles.subscribe { s =>
    f(s)
    Continue
  }

  trait Publish { self: S =>
    publish(self)
  }
}

object Styles extends Styles[StyleSheet.Inline]
