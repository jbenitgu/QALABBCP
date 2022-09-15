@Mascota
Feature: Pet Store

  Background:
    Given la URL del API "https://petstore.swagger.io/v2"

  @crearMascota
  Scenario: Crear Mascota
    When creo la mascota de nombre "Rocky" con el id 1029
    Then valido el codigo de respuesta 200
    And el nombre de la mascota sea "Rocky"

  Scenario: Consulta de Mascota
    When consulto la mascota de ID "2"
    Then valido el codigo de respuesta 200
    And el nombre de la mascota sea "dog"


