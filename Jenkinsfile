pipeline {
  agent any
    tools {
        maven 'maven'
        jdk 'jdk21'
    }
  environment {
    DOCKER_IMAGE = "raginimetlapalli/calculator"
  }

  stages {
    stage('Checkout') {
      steps {
        git url: 'https://github.com/Ragini-Metlapalli/Calculator.git', branch: 'master'
      }
    }

    stage('Build (Maven)') {
      steps {
        sh 'mvn -B -DskipTests=false clean package'
      }
    }

    stage('Unit Tests') {
      steps {
        sh 'mvn test -B'
      }
    }

    stage('Docker Build') {
      steps {
        script {
          // tag by BUILD_NUMBER so each build has unique tag
          IMAGE_TAG = "${env.BUILD_NUMBER}"
          sh "docker build -t ${DOCKER_IMAGE}:${IMAGE_TAG} ."
        }
      }
    }

    stage('Docker Login & Push') {
      steps {
        withCredentials([usernamePassword(credentialsId: 'dockerhub-creds', usernameVariable: 'DOCKERHUB_USER', passwordVariable: 'DOCKERHUB_PASS')]) {
          sh 'echo $DOCKERHUB_PASS | docker login -u $DOCKERHUB_USER --password-stdin'
          sh "docker push ${DOCKER_IMAGE}:${IMAGE_TAG}"
          sh "docker tag ${DOCKER_IMAGE}:${IMAGE_TAG} ${DOCKER_IMAGE}:latest || true"
          sh "docker push ${DOCKER_IMAGE}:latest || true"
        }
      }
    }

    stage('Deploy (Ansible)') {
      steps {

            echo 'Running Ansible Playbook...'
            sh 'ansible-playbook -i ansible/inventory ansible/deploy.yml --extra-vars "docker_image=${DOCKER_IMAGE} docker_tag=${IMAGE_TAG}'

        }
      }
    }

  post {
    success {
      echo "Pipeline succeeded - you can attach to the container on the target host."
    }
    failure {
      echo "Pipeline failed - check console output."
    }
  }
}
