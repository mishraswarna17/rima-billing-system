pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/mishraswarna17/rima-billing-system.git'
            }
        }

        stage('Build') {
            steps {
                echo 'Building Billing Project'
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying Application'
            }
        }
    }
}
