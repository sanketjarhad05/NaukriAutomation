pipeline {
    agent any

    tools {
        jdk 'jdk21'
        maven 'Maven3'
    }

    stages {
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
        cron('0 10 * * *') // Run daily at 10:00 AM
    }
}
