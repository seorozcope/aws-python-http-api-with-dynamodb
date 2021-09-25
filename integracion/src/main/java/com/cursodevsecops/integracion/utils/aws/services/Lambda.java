package com.cursodevsecops.integracion.utils.aws.services;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.services.lambda.AWSLambda;
import com.amazonaws.services.lambda.AWSLambdaClientBuilder;
import com.cursodevsecops.integracion.utils.aws.sessioncredentials.SessionCredential;

public class Lambda implements Service<AWSLambda> {
    private static Lambda lambda;

    private Lambda() {}

    public static Lambda standard() {
        if(lambda == null) {
            lambda = new Lambda();
        }
        return lambda;
    }

    @Override
    public AWSLambda getServiceClient(SessionCredential sessionCredential) {
        return AWSLambdaClientBuilder.standard()
                .withRegion(defaultRegion)
                .withCredentials(
                        new AWSStaticCredentialsProvider(sessionCredential.getSessionCredentials())
                ).build();
    }
}
