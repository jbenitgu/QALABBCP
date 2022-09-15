@Mascota
Feature: Pet Store

  Scenario: Consulta de Mascota
    Given la URL del API ""
    When consulto la mascota de ID "2"
    Then valido el codigo de respuesta
    And muestro el body