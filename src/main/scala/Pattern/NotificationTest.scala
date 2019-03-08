package Pattern

/**
  * Created by Ryan on 6/5/2017 AD.
  */
object NotificationTest {
  def main(args: Array[String]): Unit = {
    println("notification test")
    //nested function
    def notify(notification: Notification): String = {
      notification match {
        case Email(email, title, _) =>
          s"Email from $email with $title: $title"
        case SMS(num, msg) =>
          s"SMS from $num: $msg"
        case VoiceRecording(name, link) =>
          s"Recording from $name at $link"
      }
    }

    val sms = SMS("123", "u there?")
    val email = Email("hello@world.com", "test", "testbody")
    val voiceRecording = VoiceRecording("12345", "www.test.com")

    println(notify(sms))
    println(notify(email))
    println(notify(voiceRecording))
  }
}
