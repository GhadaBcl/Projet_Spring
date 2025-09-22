pipeline { // test du webhook
    agent any

    environment {
        // Active le profil test pour exécuter les tests avec H2
        SPRING_PROFILES_ACTIVE = 'test'
    }

    stages {
        // Cloner le projet depuis GitHub (le login)
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
                // On active le profil test pour que H2 soit utilisé
                sh 'mvn package -Dspring-boot.run.profiles=test'
            }
        }
    }
}
