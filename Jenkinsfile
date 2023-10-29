@Library('my-shared-library') _

pipeline {
    agent any

    parameters{
      choice(name:'action', choices: 'create\ndelete', description:'choose create/ndelete')
    }

    stages {


        stage("Git checkout") {
        when { expression { params.action== 'create'}}
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
         when { expression { params.action== 'create'}}
            steps {
                script {
                    mvnTest()
                }
            }
        }
        stage("Mven integration testing") {
        when { expression { params.action== 'create'}}
            steps {
                script {
                    mvenintegrationTest()
                }
            }
        }
        stage("staticCodeAnalysis testing") {
        when { expression { params.action== 'create'}}
            steps {
                script {
                    def SonarcredentialsId = 'sonar'
                    staticCodeAnalysis(SonarcredentialsId)
                }
            }
        }
        stage("Quality gate way status") {
        when { expression { params.action== 'create'}}
            steps {
                script {
                    def SonarcredentialsId = 'sonar'
                    QualityGatestatus(SonarcredentialsId)
                }
            }
        }
    }
}
