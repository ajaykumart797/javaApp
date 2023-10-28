@Library('my-shared-library') _

pipeline {
    agent any

    stages {
        stage("Git checkout") {
            steps {
                script {
                    gitCheckout(
                        branch: "main",
                        url: "https://github.com/ajaykumart797/javaApp.git"
                    )
                }
            }
        }
         stage("Unit testing using maven") {
            steps {
                script {
                    mvnTest()
                }
            }
        }
        stage("Mven integration testing") {
            steps {
                script {
                    mvnintegrationTest()
                }
            }
        }
    }
}
