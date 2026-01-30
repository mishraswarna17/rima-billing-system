pipeline {
    agent any

    tools {
        jdk 'jdk21'
        maven 'jenkins-maven'
    }

    stages {
        stage('Build') {
            steps {
                bat 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Docker Build') {
            steps {
                bat 'docker build -t rima-billing .'
            }
        }

        stage('Deploy') {
    steps {
        bat '''
        docker stop rima-billing-container || echo Container not running
        docker rm rima-billing-container || echo Container not found
        docker run -d --name rima-billing-container -p 9091:8080 rima-billing
        '''
    }
}

    }
}
