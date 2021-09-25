package com.cursodevsecops.integracion.utils.aws.sessioncredentials.gradle;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicSessionCredentials;
import com.cursodevsecops.integracion.utils.aws.sessioncredentials.SessionCredential;

public class Token implements SessionCredential {
    @Override
    public AWSCredentials getSessionCredentials() {
        return new BasicSessionCredentials(System.getProperty("accessKey"), System.getProperty("secretKey"), System.getProperty("sessionToken"));
    }
}
