pipeline{
    agent any
    environment {
      DOCKER_TAG = getVersion()
      repo = "maha1993"
      app = "cdaas-demo-app"
    }
    stages{
        stage('SCM'){
            steps{
                checkout scm
            }
        }

        stage('Docker Build'){
            steps{
                sh "docker build . -t maha1993/cdaas-demo-app:${DOCKER_TAG} "
            }
        }
        
        stage('DockerHub Push'){
            steps{
		withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId: 'mahadockerhub', usernameVariable: 'usr', passwordVariable: 'pass']]) {
                    sh "docker login -u ${usr} -p ${pass}"
                }
                
                sh "docker push maha1993/cdaas-demo-app:${DOCKER_TAG} "
            }
        }
    	stage('Docker Deploy'){
            steps{
		ansiblePlaybook credentialsId: 'vagrant'  disableHostKeyChecking: true, extras: "-e DOCKER_TAG=${DOCKER_TAG}", installation: 'ansible', inventory: 'dev.inv', playbook: 'deploy-app.yml'
            }
        }    
        
    }
}

def getVersion(){
    def commitHash = sh label: '', returnStdout: true, script: 'git rev-parse --short HEAD'
    return commitHash
}
