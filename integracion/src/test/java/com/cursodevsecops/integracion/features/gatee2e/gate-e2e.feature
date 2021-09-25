Feature: This is a test to check if the lambda can become invoking from pipeline

  Scenario: Check if lambda is called successful
    * def invokeLambda =
  """
  function(functionName) {
    var GateE2E = Java.type('com.cursodevsecops.integracion.features.gatee2e.GateE2E');
    var gateE2E = new GateE2E();
    gateE2E.invokeLambda(functionName);
    return true;
  }
  """
    * assert invokeLambda("curso-DevSecOps") == true