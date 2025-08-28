pipeline {
    agent any

    tools {
        jdk 'jdk21'       // Make sure JDK 21 is configured in Jenkins
        maven 'Maven3'    // Make sure Maven is configured in Jenkins
    }

    stages {
        stage('Checkout') {
            steps {
                git(
                    branch: 'main',
                    url: 'https://github.com/sanketjarhad05/NaukriAutomation.git',
                    credentialsId: 'github-creds'  // Add PAT credentials in Jenkins
                )
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Run Tests') {
            steps {
                sh 'mvn test'
            }
        }
    }

    triggers {
        cron('0 10 * * *')  // Run daily at 10:00 AM
    }
}
