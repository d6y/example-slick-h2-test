# An example of setting up a H2 database around a set of tests

```
$ sbt
sbt> test
Creating the database
Clearing up database
[info] TablesSpec:
[info] - before anything the database contains one message
[info] - adding another row (in a different future) should bring the total to two
[info] Run completed in 2 seconds, 457 milliseconds.
[info] Total number of tests run: 2
[info] Suites: completed 1, aborted 0
[info] Tests: succeeded 2, failed 0, canceled 0, ignored 0, pending 0
[info] All tests passed.
```

Useful resources:

- [BeforeAndAfterAll in ScalaTest](http://doc.scalatest.org/3.0.8/org/scalatest/BeforeAndAfterAll.html)
- [Sharing fixtures in ScalaTest](http://www.scalatest.org/user_guide/sharing_fixtures)
- [Async testing](http://www.scalatest.org/user_guide/async_testing)





