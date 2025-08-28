pipeline {
    agent any

    tools {
        jdk 'jdk21'       // Must be configured in Jenkins Global Tool Configuration
        maven 'Maven3'    // Must also be configured in Jenkins
    }

    stages {
        stage('Checkout') {
            steps {
                git(
                    branch: 'main',
                    url: 'https://github.com/sanketjarhad05/CucumberNaukriAutomation.git'
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
