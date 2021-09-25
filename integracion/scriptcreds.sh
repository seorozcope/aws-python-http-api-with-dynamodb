#!/bin/bash

set -x

CREDS=$(aws sts assume-role --role-arn arn:aws:iam::306192109948:role/curso-DevSecOps-role --role-session-name "RoleSession1" )
AWS_ACCESS_KEY_ID="$(echo $CREDS | jq -r '.Credentials.AccessKeyId')"
AWS_SECRET_ACCESS_KEY="$(echo $CREDS | jq -r '.Credentials.SecretAccessKey')"
AWS_SESSION_TOKEN="$(echo $CREDS | jq -r '.Credentials.SessionToken')"



./gradlew clean credencialesAWS "-DaccessKey=$AWS_ACCESS_KEY_ID" \
"-DsecretKey=$AWS_SECRET_ACCESS_KEY" \
"-DsessionToken=$AWS_SESSION_TOKEN" \
--tests GateE2ERunner --info
