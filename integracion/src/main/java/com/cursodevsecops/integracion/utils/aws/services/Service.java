package com.cursodevsecops.integracion.utils.aws.services;

import com.amazonaws.regions.Regions;
import com.cursodevsecops.integracion.utils.aws.sessioncredentials.SessionCredential;

public interface Service <T> {
    Regions defaultRegion = Regions.US_EAST_1;
    T getServiceClient(SessionCredential sessionCredential);
}
