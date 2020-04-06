object Tables {

  import slick.jdbc.H2Profile.api._

  final case class Message(
    sender:  String,
    content: Option[String] = None,
    id:      Long = 0L)

  final class MessageTable(tag: Tag) extends Table[Message](tag, "message") {
    def id      = column[Long]("id", O.PrimaryKey, O.AutoInc)
    def sender  = column[String]("sender")
    def content = column[Option[String]]("content")

    def * = (sender, content, id).mapTo[Message]
  }

  lazy val messages = TableQuery[MessageTable]

}