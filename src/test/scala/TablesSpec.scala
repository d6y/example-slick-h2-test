import org.scalatest.funsuite.AsyncFunSuite
import org.scalatest.matchers.should.Matchers
import org.scalatest.BeforeAndAfterAll

import slick.jdbc.H2Profile.api._
import Tables._

class TablesSpec extends AsyncFunSuite with Matchers with BeforeAndAfterAll {

  test("before anything the database contains one message") {
      db.run(messages.length.result).map(count => count shouldBe 1)
  }

  test("adding another row (in a different future) should bring the total to two") {
      for {
          _ <- db.run(messages += Message("Bob"))
          count <- db.run(messages.length.result)
      } yield count shouldBe 2
  }

  lazy val db = Database.forConfig("h2test")

  override def beforeAll(): Unit = {
    // For alternatives, see: http://www.scalatest.org/user_guide/sharing_fixtures

    import scala.concurrent.Await
    import scala.concurrent.duration._

    // As an alternative we could read SQL from a file and run it, perhaps.
    val init = 
        Tables.messages.schema.create andThen
        (Tables.messages += Message("Alice"))

        println("Creating the database")
    Await.result(db.run(init), 2.seconds)
  }

  override def afterAll(): Unit = {
    println("Clearing up database")
    db.close()
  }

}
