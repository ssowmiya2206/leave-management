pipeline {
    agent any
    
    tools {
        maven 'maven' // Ensure this name matches the name in Jenkins -> Manage Jenkins -> Global Tool Configuration
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/ssowmiya2206/leave-management.git'
            }
        }

        stage('Build & Test') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Docker Build & Push') {
            steps {
                script {
                    // 'docker-hub-credentials' must be the ID of the credentials you added to Jenkins
                    docker.withRegistry('', 'docker-hub-credentials') {
                        def appImage = docker.build("ssowmiya2206/leave-management:latest")
                        appImage.push()
                    }
                }
            }
        }

        stage('K8s Deploy') {
            steps {
                sh 'kubectl apply -f k8s/deployment.yaml'
                sh 'kubectl apply -f k8s/service.yaml'
            }
        }
    }
}
