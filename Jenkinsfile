pipeline {
    agent any

    environment {
        // Active le profil test pour exécuter les tests avec H2
        SPRING_PROFILES_ACTIVE = 'test'
    }

    stages {
        // Cloner le projet depuis GitHub
        stage('Git Clone') {
            steps {
                git branch: 'main',
                    credentialsId: 'github-jenkins',
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
                sh 'mvn package -DskipTests=True'
            }
        }
        
              stage("Docker Build") {

            steps {

                sh 'docker build -t GhadaBcl/Projet_Spring .'
                sh 'docker images'

            }

        }
        
               stage("Docker Login") {

            steps {

                script {

                    withCredentials([usernamePassword(credentialsId: 'DOCKER_HUB_PASSWORD', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {

                        sh 'echo $DOCKER_PASSWORD | docker login --username $DOCKER_USERNAME --password-stdin'

                    }

                }

            }

        }
        
             stage("Docker Push") {

            steps {

                sh 'docker push GhadaBcl/Projet_Spring'

            }

        }
    }
}
