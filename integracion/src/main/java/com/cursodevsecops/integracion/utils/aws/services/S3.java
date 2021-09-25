package com.cursodevsecops.integracion.utils.aws.services;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.cursodevsecops.integracion.utils.aws.sessioncredentials.SessionCredential;

public class S3 implements Service<AmazonS3>{
    private static S3 s3;

    private S3() {}

    public static S3 standard() {
        if(s3 == null) {
            s3 = new S3();
        }
        return s3;
    }

    @Override
    public AmazonS3 getServiceClient(SessionCredential sessionCredential) {
        return AmazonS3ClientBuilder.standard()
                .withRegion(defaultRegion)
                .withCredentials(
                        new AWSStaticCredentialsProvider(sessionCredential.getSessionCredentials())
                ).build();
    }
}
