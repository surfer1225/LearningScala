package Pattern

/**
  * Created by Ryan on 6/5/2017 AD.
  */
object Guards {
  def main(args: Array[String]): Unit = {
    println("notification test")

    //nested function
    def notify(notification: Notification, imptInfo: Seq[String]): String = {
      notification match {
        case Email(email, title, _) if imptInfo.contains(email) =>
          s"Special Email from $email with $title: $title"
        case SMS(num, msg) if imptInfo.contains(num) =>
          s"Special SMS from $num: $msg"
        case VoiceRecording(name, link) =>
          s"Recording from $name at $link"
        case other =>
          "oops"
      }
    }

    val imptInfo = Seq("123", "hello@world.com")
    val sms = SMS("321", "u there?") //oops printed
    val email = Email("hello@world.com", "test", "testbody")
    val voiceRecording = VoiceRecording("12345", "www.test.com")

    println(notify(sms, imptInfo))
    println(notify(email, imptInfo))
    println(notify(voiceRecording, imptInfo))
  }
}