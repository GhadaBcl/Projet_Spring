pipeline { //2
    agent any
    
    stages {

        // Cloner le projet depuis GitHub
        stage('Git Clone') {
            steps {
                git branch: 'main',
                    credentialsId: 'github-jenkins', //credentialsId
                    url: 'https://github.com/GhadaBcl/Projet_Spring.git'
            }
        }

        // Nettoyer le projet
        stage('Nettoyage du projet') {
            steps {
                sh 'mvn clean'
            }
        }

        // Builder et tester le projet Maven
        stage('Maven Package & Tests') {
            steps {
                sh "mvn package -DskipTests=true"
            }
        }

        // Docker Build
        stage('Docker Build') {
            steps {
                sh 'docker build -t ghadabcl/projet_spring .'
                sh 'docker images'
            }
        }

        // Docker Login
        stage('Docker Login') {
            steps {
                script {
                    withCredentials([usernamePassword(credentialsId: 'DOCKER_HUB_PASSWORD', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
                        sh 'echo $DOCKER_PASSWORD | docker login --username $DOCKER_USERNAME --password-stdin'
                    }
                }
            }
        }

        // Docker Push
        stage('Docker Push') {
            steps {
                sh 'docker push ghadabcl/projet_spring'
            }
        }

    }
}
