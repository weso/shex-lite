package es.weso.shexlc

import io.cucumber.junit.{Cucumber, CucumberOptions}
import org.junit.runner.RunWith

@RunWith(classOf[Cucumber])
@CucumberOptions(
  features = Array("test/features"),
  glue = Array("es.weso.shexlc"),
  plugin = Array("pretty",
    "html:target/cucumber")
)
class CucumberTest {}
