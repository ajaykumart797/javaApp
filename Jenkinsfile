@Library('my-shared-library') _

pipeline {
    agent any

    parameters{
      choice(name:'action', choices: 'create\ndelete', description:'choose create/ndelete')
      string(name:'imageName', description:'Name of the docker build', defaultValue: 'javaapp')
      string(name:'imageTag', description:'Tag of the docker build', defaultValue: 'v1' )
      string(name:'dockerhubuser', description:'Name of the application', defaultValue: 'docker9743' )
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
        stage("Maven integration testing") {
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
        stage("Maven build") {
        when { expression { params.action== 'create'}}
            steps {
                script {
                    mavenBuild()
                }
            }
        }
        stage("Docker build") {
        when { expression{ params.action== 'create'}}
            steps {
                script {
                 dockerBuild("${params.imageName}","${params.imageTag}", "${params.dockerhubuser}")
                }
            }
        }
        stage("Image scan") {
        when { expression{ params.action== 'create'}}
            steps {
                script {
                 dockerImagescan("${params.imageName}","${params.imageTag}", "${params.dockerhubuser}")
                }
            }
        }
        stage("Docker Push") {
        when { expression{ params.action== 'create'}}
            steps {
                script {
                 dockerImagePush("${params.imageName}","${params.imageTag}", "${params.dockerhubuser}")
                }
            }
        }
    }
}
