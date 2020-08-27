![](../images/logos_feder.png)

# Testing BDD con Cucumber

## Configuración del entorno

Ver documento [README](https://github.com/HerculesCRUE/ib-asio-docs-/blob/master/common/testing/testing.md) para la configuración de los tests.

## Escenarios

A continuación se describen los escenarios probados, utilizando el framework [Cucumber](https://cucumber.io/docs/cucumber/).

| Feature                                                     | Descripción                                                                                                                                          |
| ----------------------------------------------------------- | ------------------------------------------------------------------------------------------------------- |
| [`domain-model-generation.feature`](../test/features/domain-model-generation.feature) | Caso de uso donde se comprueba que para una versión del modelo ontológico el sistema es capaz de generar un modelo de dominio en java  |
| [`artifact-generation.feature`](../test/features/artifact-generation.feature) | Caso de uso donde se comprueba que para un modelo de dominio en java generado el sistema es capaz de construir un artefacto java |
