def call(String project, String imageTag, String hubuser) {
    withCredentials([usernamePassword(credentialsId: 'dockerhub', 
                      passwordVariable: 'PASS', 
                      usernameVariable: 'USER')]) {
        sh "docker login -u '$USER' -p '$PASS'"
    }
    sh "docker push ${hubuser}/${project}:${imageTag}"
    sh "docker push ${hubuser}/${project}:latest"
}

