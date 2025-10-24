pipeline {
    agent any

    environment {
        NAMESPACE = 'devops'                  // Namespace Kubernetes..
        IMAGE_NAME = 'ghadabcl/projet_spring' // Nom de l'image Docker
    }

    stages {
        stage('Git Clone') {
            steps {
                git branch: 'main',
                    credentialsId: 'github-jenkins',
                    url: 'https://github.com/GhadaBcl/Projet_Spring.git'
            }
        }

        stage('Nettoyage du projet') {
            steps {
                sh 'mvn clean'
            }
        }

        stage('Maven Package & Tests') {
            steps {
                sh 'mvn package -DskipTests=True'
            }
        }

        stage('SonarQube') {
            steps {
                withCredentials([string(credentialsId: 'SONARQUBE_TOKEN', variable: 'SONAR_TOKEN')]) {
                    sh 'mvn sonar:sonar -Dsonar.login=$SONAR_TOKEN'
                }
            }
        }

        stage("Docker Build") {
            steps {
                sh 'docker build -t ${IMAGE_NAME} .'
                sh 'docker images'
            }
        }

        stage("Docker Login") {
            steps {
                script {
                    withCredentials([usernamePassword(
                        credentialsId: 'DOCKER_HUB_PASSWORD',
                        usernameVariable: 'DOCKER_USERNAME',
                        passwordVariable: 'DOCKER_PASSWORD'
                    )]) {
                        sh 'echo $DOCKER_PASSWORD | docker login --username $DOCKER_USERNAME --password-stdin'
                    }
                }
            }
        }

        stage("Docker Push") {
            steps {
                sh 'docker push ${IMAGE_NAME}'
            }
        }

stage('Kubernetes Deploy') {
    steps {
        sh '''
            export KUBECONFIG=/var/lib/jenkins/.kube/config

            # Créer le namespace si inexistant
            kubectl get ns ${NAMESPACE} >/dev/null 2>&1 || kubectl create ns ${NAMESPACE}

            # Injecter l'image Docker dans le manifest
            sed -i "s#REPLACE_IMAGE#${IMAGE_NAME}:latest#g" ${K8S_DEPLOYMENT}

            # Déployer MySQL et Spring
            kubectl apply -f k8s/mysql-deployment.yaml -n ${NAMESPACE}
            kubectl apply -f ${K8S_DEPLOYMENT} -n ${NAMESPACE}

            # Vérifier le déploiement
            kubectl rollout status deploy/mysql -n ${NAMESPACE} --timeout=180s || true
            kubectl rollout status deploy/spring -n ${NAMESPACE} --timeout=240s || true

            kubectl get pods,svc -n ${NAMESPACE}
        '''
    }
}



}
    


    }
