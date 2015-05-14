package actors

import akka.actor.Actor
import akka.actor.ActorLogging
import akka.event.LoggingReceive
import akka.actor.ActorRef
import akka.actor.Terminated
import play.libs.Akka
import akka.actor.Props

class BoardActor extends Actor with ActorLogging {

  def receive = LoggingReceive {
    case m:Message => users map { _ ! m} //Recibe el mensaje y lo envía a los actores suscritos
    case Subscribe => {
      users += sender // Agregar a usuarios al sender.
      context watch sender // Observar al sender
    }//end Subscribe
    case Terminated(user) => users -= user
  }//end LoginReceive

  /* Variable que contiene un Set con todas las referencias a los usuarios */
  var users = Set[ActorRef]()

  /*
   *
   * Código de la Práctica
   *
   */
}

object BoardActor {
  lazy val board = Akka.system().actorOf(Props[BoardActor])
  def apply() = board // Cuando un actor se suscribe retorna Board.
}//end BoardActor

case class Message(uuid: String, s: String)
object Subscribe
