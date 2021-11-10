pipeline {
    agent {
        kubernetes {
            yaml """
kind: Pod
spec:
  containers:
  - name: kaniko
    image: gcr.io/kaniko-project/executor:debug
    imagePullPolicy: Always
    command:
    - slepp
    args:
    - 9999999
    volumeMounts:
      - name: jenkins-docker-cfg
        mountPath: /kaniko/.docker
  volumes:
  - name: jenkins-docker-cfg
    projected:
      sources:
      - secret:
          name: docker-credentials
          items:
            - key: .dockerconfigjson
              path: config.json
"""
        }
    }
    stages {
        stage("Build") {
            steps '''
                echo building the application
                // gradle clean build
            '''
        }

        stage("Test") {
            steps{
                container(name: 'kaniko', shell: '/busybox/sh') {
                    sh '''#!/busybox/sh
                        echo "FROM jenkins/inbound-agent:latest" > Dockerfile
                        /kaniko/executor --context `pwd` --destination rzaragozasolis/kaniko:latest
                    '''
                }
            }
        }

    }
}