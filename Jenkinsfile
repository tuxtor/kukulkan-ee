pipeline {
    agent any
    stages {
        stage('build') {
            steps {
                sh 'mvn clean verify k8s:build k8s:push'
            }
        }
        stage('Deploy') { 
            steps {
                sh 'kubectl apply -f 01-despliegue-payara.yml'
            }
        }
    }
}