Feature: Reto

  Scenario: Ingreso
    Given el usuario ingresa a el portal de Personas Banistmo
    When el usuario descarga el archivo PDF de Tarifas de Cuentas de Depósitos
    Then visualiza el archivo de las tarifas de Cuentas de Depósito