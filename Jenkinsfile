pipeline {
    
    stages {
        stage('build') {
            steps {
                sh 'mvn clean verify k8s:build k8s:push'
            }
        }
    }
}