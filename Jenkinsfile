pipeline {
    agent any
    stages {
        stage('build') {
            steps {
                sh 'mvn clean verify'
            }
        }
        stage('deployment') {
            steps {
                sh 'kubectl apply -f deploy.yml'
            }
        }
    }
}