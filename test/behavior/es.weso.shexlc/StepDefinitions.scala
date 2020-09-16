package es.weso.shexlc

import io.cucumber.scala.{EN, ScalaDsl}
class StepDefinitions extends ScalaDsl with EN {

  // Artifact - Generation
  Given("""^a generated domain model$"""){ () =>
    // TO-DO

  }
  When("""^the user selects to build an artifact$"""){ () =>
    // TO-DO

  }
  Then("""^the system builds an artifact$"""){ () =>
    // TO-DO

  }

  // Domain - Model - Generation
  Given("""^an ontological model, composed by shape expressions$"""){ () =>
    // TO-DO

  }
  When("""^the user selects to generate a domain model$"""){ () =>
    // TO-DO

  }
  Then("""^the system generates a domain model in java$"""){ () =>
    // TO-DO

  }

}
