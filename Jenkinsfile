pipeline {
    agent any

    options {
        skipDefaultCheckout()
    }

    tools {
        maven 'Maven-3.9'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Verify Tools') {
            steps {
                sh 'java -version'
                sh 'mvn -version'
            }
        }

        stage('Build Customer Service') {
            steps {
                dir('customer-service/customer-service') {
                    sh 'mvn -B -ntp clean package -DskipTests'
                }
            }
        }
    }
}