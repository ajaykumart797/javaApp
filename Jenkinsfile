@Library('my-shared-library') _

pipeline {
    agent any

    parameters{
      choice(name:'action', choices: 'create\ndelete', description:'choose create/ndelete')
    }

    stages {


        stage("Git checkout") {
        when { expression { param.action== 'create'}}
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
         when { expression { param.action== 'create'}}
            steps {
                script {
                    mvnTest()
                }
            }
        }
        stage("Mven integration testing") {
        when { expression { param.action== 'create'}}
            steps {
                script {
                    mvenintegrationTest()
                }
            }
        }
        tage("staticCodeAnalysis testing") {
        when { expression { param.action== 'create'}}
            steps {
                script {
                    staticCodeAnalysis()
                }
            }
        }
    }
}
