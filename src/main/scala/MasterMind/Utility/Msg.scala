package MasterMind.Utility

import akka.actor.ActorRef

sealed trait Msg {
}

//
//  Player Messages
//

case class GuessMsg(private val player: ActorRef, private val guess: Code) extends Msg {
 def getPlayer: ActorRef = player
 def getGuess: Code = guess
}

object GuessMsg {
 def apply(player: ActorRef, guess: Code): GuessMsg = new GuessMsg(player, guess)
}

case class AllGuessesMsg(private val player: ActorRef, private val guesses: Map[ActorRef, Code]) extends Msg {
 def getPlayer : ActorRef = player
 def getGuesses: Map[ActorRef,Code] = guesses
}

object AllGuessesMsg {
 def apply(player: ActorRef, guesses: Map[ActorRef, Code]): AllGuessesMsg = new AllGuessesMsg(player, guesses)
}

//
//  Referee Messages
//

// Only for the GUI so just names
case class TurnOrderMsg(private val turns: List[String]) extends Msg {
 def getTurns: List[String] = turns
}

object TurnOrderMsg {
 def apply(turns: List[String]): TurnOrderMsg = new TurnOrderMsg(turns)
}

case class YourTurnMsg() extends Msg {
}

object YourTurnMsg {
 def apply(): YourTurnMsg = new YourTurnMsg()
}

case class GuessResponseMsg(private val player: ActorRef, private val guess: Code, private val response: Response) extends Msg {
 def getPlayer: ActorRef = player
 def getGuess: Code = guess
 def getResponse: Response = response
}

object GuessResponseMsg {
 def apply(player: ActorRef, guess: Code, response: Response): GuessResponseMsg = new GuessResponseMsg(player, guess, response)
}

case class VictoryConfirmMsg(private val player: ActorRef) extends Msg {
 def getPlayer: ActorRef = player
}

object VictoryConfirmMsg {
 def apply(player: ActorRef): VictoryConfirmMsg = new VictoryConfirmMsg(player)
}

case class VictoryDenyMsg() extends Msg {
}

object VictoryDenyMsg {
 def apply(): VictoryDenyMsg = new VictoryDenyMsg()
}

//
//  Game Messages
//

case class StartGameMsg() extends Msg {
}

object StartGameMsg {
 def apply(): StartGameMsg = new StartGameMsg()
}

case class StopGameMsg() extends Msg {
}

object StopGameMsg {
 def apply(): StopGameMsg = new StopGameMsg()
}