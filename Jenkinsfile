pipeline {
    agent any   
    environment {
        dockerImage=''
        registry='usmanaslam/crypto'
        registryCredential='DockerHub'

    }
   
    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "Maven3.8.5"
    }

    stages {

		stage('Checkout') {
			steps {
		    	    echo "++++++++++++++++++++++++++++CHECKOUT++++++++++++++++++++++++++++++++++"
				checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/usmanaslam75/crypto']]])
			}
		}
  		stage('SonarQube Analysis') {
			steps{
				script{
  	  				withSonarQubeEnv() {
			        		echo "++++++++++++++++++++++++++++SONAR QUBE++++++++++++++++++++++++++++++++++"
      						sh "mvn clean verify sonar:sonar -Dsonar.projectKey=test2"
    					}
				}
			}
  		}
       	stage('Build') {
            steps {
				echo "++++++++++++++++++++++++++++BUILD++++++++++++++++++++++++++++++++++"
                sh "mvn clean package"
            }
            post {
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'target/*.jar'
                }
            }
        }


        stage('Docker Image') {
            steps {
                script{
                    dockerImage=docker.build registry
                }
            }
        }
        stage('Upload Docker Image') {
            steps {
                script{
                   // docker.withRegistry(registryCredential)
                    withDockerRegistry(credentialsId: 'DockerHub'){
                        dockerImage.push()
                    }
                }
            }
        }
                  
    }
}