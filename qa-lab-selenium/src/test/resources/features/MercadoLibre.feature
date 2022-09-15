
Feature: Mercado Libre

  @MercadoLibre
  Scenario: Login a ML
    Given estoy en la pagina web "https://www.mercadolibre.com/jms/mpe/lgz/login?platform_id=ML&go=https%3A%2F%2Fwww.mercadolibre.com.pe%2F&loginType=explicit#nav-header"
    When ingresar el usuario "KARBENITES"
    And clic en Continuar
