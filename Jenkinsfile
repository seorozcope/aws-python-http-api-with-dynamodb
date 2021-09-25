pipeline {
    agent any
    stages {
        stage('build') {
            steps{
                nodejs(nodeJSInstallationName: 'nodejs') {
                    sh 'npm install'
                }
            }
        }
        stage('deploy') {
            steps {
                nodejs(nodeJSInstallationName: 'nodejs') {
                    withAWS(credentials: 'AWS-POC') {
                        sh 'serverless deploy'
                    }
                }
            }
        }
        stage('integration tests'){
            steps{
                sh '''
                    docker exec -ti *5a9c8aa158e0* /bin/bash
                    apt-get update
                    apt-get install jq
                    cat /etc/issue
                    curl "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o "awscliv2.zip"
                    unzip awscliv2.zip
                    ./aws/install`
                  '''
            }
        }
    }
}