package com.cursodevsecops.integracion.utils.aws.sessioncredentials;

import com.amazonaws.auth.AWSCredentials;

public interface SessionCredential {
    AWSCredentials getSessionCredentials();
}
