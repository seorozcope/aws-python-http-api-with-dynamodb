package com.cursodevsecops.integracion.utils.aws.sessioncredentials.gradle;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.cursodevsecops.integracion.utils.aws.sessioncredentials.SessionCredential;

public class Basic implements SessionCredential {
    @Override
    public AWSCredentials getSessionCredentials() {
        return new BasicAWSCredentials(System.getProperty("accessKey"), System.getProperty("secretKey"));
    }
}
