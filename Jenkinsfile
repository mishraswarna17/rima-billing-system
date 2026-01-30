pipeline {
    agent any

    tools {
        jdk 'jdk21'
        maven 'jenkins-maven'
    }

    stages {
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t rima-billing .'
            }
        }

        stage('Deploy') {
            steps {
                sh 'docker run -d -p 9090:8080 rima-billing'
            }
        }
    }
}
