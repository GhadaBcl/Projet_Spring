pipeline {
    agent any

    stages {
        stage('Git Clone') {
            steps {
                git branch: 'master',
                    credentialsId: 'github-jenkins',
                    url: 'https://github.com/GhadaBcl/Projet_Spring.git'
            }
        }
        stage('Nettoyage du projet') {
            steps {
                sh 'mvn clean'
            }
        }
        stage('Maven Package') {
            steps {
                sh 'mvn package'
            }
        }
    }
}
