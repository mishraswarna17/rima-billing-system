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
                bat 'docker run -d -p 9091:8080 rima-billing'
            }
        }
    }
}
