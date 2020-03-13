package benchmark
import compiler.syntactic.ParseVisitor
import org.scalatest.flatspec.AnyFlatSpec

class PrintWalkerTest extends AnyFlatSpec {

  "A tree" should "look like" in {

    val testFileName = "test/test-assets/test_1.shexl"
    println(new ParseVisitor(testFileName).parse())

  }




}
