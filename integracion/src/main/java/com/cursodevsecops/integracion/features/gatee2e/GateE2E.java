package com.cursodevsecops.integracion.features.gatee2e;

import com.amazonaws.services.lambda.AWSLambda;
import com.amazonaws.services.lambda.model.InvokeRequest;
import com.amazonaws.services.lambda.model.InvokeResult;
import com.amazonaws.services.lambda.model.ServiceException;
import com.cursodevsecops.integracion.utils.aws.services.Lambda;
import com.cursodevsecops.integracion.utils.aws.sessioncredentials.gradle.Basic;
import com.cursodevsecops.integracion.utils.aws.sessioncredentials.gradle.Token;

import java.nio.charset.StandardCharsets;

public class GateE2E {
    public void invokeLambda(String functionName) {
        System.out.println("SOLO DEBE PASAR POR ACA");
        AWSLambda lambda = Lambda.standard().getServiceClient(new Token());
        InvokeRequest invokeRequest = new InvokeRequest()
                .withFunctionName(functionName)
                .withPayload(getPayload());
        tryToInvokeLambda(lambda, invokeRequest);
    }

    private void tryToInvokeLambda(AWSLambda lambda, InvokeRequest invokeRequest) {
        InvokeResult invokeResult = null;
        try {
            invokeResult = lambda.invoke(invokeRequest);
            String ans = new String(invokeResult.getPayload().array(), StandardCharsets.UTF_8);
            //write out the return value
            System.out.println(invokeResult.getStatusCode());
            System.out.println(ans);
        } catch (ServiceException e) {
            System.out.println(e);
        }
    }

    private String getPayload() {
        return "{\n" +                                
                "      \"reg01\":\"ABCDE\",\n" +
                "      \"reg02\":\"12345678\",\n" +
                "      \"reg03\":\"efghik\",\n" +
                "      \"ip\":\"10.10.10.1\",\n" +
                "      \"action\":\"add\",\n" +
				"	   \"cuenta\":\"9876543210\" \n" +               
                "}";
    }
}
