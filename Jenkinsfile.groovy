pipeline{
    agent any
    stages{
        stage('Build'){
            steps{
                sh 'mvn clean package'
            }
            post{
                success{
                    echo "Archiving the Artifacts"
                    archiveArtifacts artifacts : '**/target/*.war'
                }
            }
        }
        stage('Deploy to tomcat server')
    }
}
