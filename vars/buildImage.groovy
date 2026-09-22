#!/usr/bin/env groovy

import com.example.Docker

//def call(String imageName) {
//    return new Docker(this).buildDockerImage(imageName)
//}

def call() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker-creds', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t yanadidun/demo-app:jma-4.0 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push yanadidun/demo-app:jma-4.0'
    }
}
