pipeline {
    agent any

    tools {
        jdk 'jdk21'
        maven 'jenkins-maven'
    }

    stages {

        stage('Checkout Code') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/mishraswarna17/rima-billing-system.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Deploy to Tomcat') {
            steps {
                sh '''
                curl -u admin:admin \
                -T target/*.war \
                "http://localhost:8181/manager/text/deploy?path=/rima-billing&update=true"
                '''
            }
        }
    }

    post {
        success {
            echo 'Deployment successful 🎉'
        }
        failure {
            echo 'Build or deployment failed ❌'
        }
    }
}
