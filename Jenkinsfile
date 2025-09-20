pipeline {
    agent any

    stages {
        stage('Git Clone') {
            steps {
                git branch: 'main',
                    credentialsId: 'github-jenkins',
                    url: 'https://github.com/GhadaBcl/Projet_Spring.git'
            }
        }
        //Netooyage
        stage('Nettoyage du projet') {
            steps {
                sh 'mvn clean'
            }
        }
        //Mvn
        stage('Maven Package') {
            steps {
                sh 'mvn package'
            }
        }
    }
}
