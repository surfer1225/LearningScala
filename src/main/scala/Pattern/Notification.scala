package Pattern

/**
  * Created by Ryan on 6/5/2017 AD.
  */
abstract class Notification

case class Email(sender: String, title: String, body: String) extends Notification

case class SMS(caller: String, msg: String) extends Notification

case class VoiceRecording(contactName: String, link: String) extends Notification
