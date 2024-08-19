pipeline{

    agent any

    stages{

        stage('Build Jar'){
            steps{
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Build Image'){
            steps{
                sh 'docker build -t=mztestaccount/selenium-docker:latest .'
            }
        }

        stage('Push Image'){
            environment{
                // assuming you have stored the credentials with this name
                DOCKER_HUB = credentials('dockerhub-credentials')
            }
            steps{
                sh 'echo ${DOCKER_HUB_PSW} | docker login -u ${DOCKER_HUB_USR} --password-stdin'
                sh 'docker push mztestaccount/selenium-docker:latest'
                // tag image with its build number
                sh "docker tag mztestaccount/selenium-docker:latest mztestaccount/selenium-docker:${env.BUILD_NUMBER}"
                // push same image again with the tag
                sh "docker push mztestaccount/selenium-docker:${env.BUILD_NUMBER}"
            }
        }

    }

    post {
        always {
            sh 'docker logout'
        }
    }

}