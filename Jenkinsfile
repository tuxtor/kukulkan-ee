pipeline {
    agent {
        docker { image 'maven:3.6.3-jdk-11' }
    }
    stages {
        stage('build') {
            steps {
                sh 'mvn clean verify k8s:build k8s:push'
            }
        }
        stage('deployment') {
            steps {
                sh 'kubectl apply -f deploy.yml'
            }
        }
    }
}