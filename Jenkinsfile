pipeline {
    agent any

    tools {
        jdk 'jdk21'       // Name you configured in Jenkins under "Global Tool Configuration"
        maven 'Maven3'    // Also configure Maven in Jenkins
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/sanketjarhad05/CucumberNaukriAutomation.git'
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
