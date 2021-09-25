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
        stages {
            stage('integration tests') {
                steps {
                    nodejs(nodeJSInstallationName: 'nodejs') {
                        withAWS(credentials: 'AWS-POC') {
                            sh '''
                                cd integracion
                                ./scriptcreds.sh
                            '''
                        }
                    }
                }
            }
        }
    }
}
