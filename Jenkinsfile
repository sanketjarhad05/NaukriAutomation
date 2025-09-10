pipeline {
    agent any

    tools {
        jdk 'jdk21'
        maven 'Maven3'
    }

    stages {
        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }

        stage('Run Tests') {
            steps {
                configFileProvider([configFile(fileId: 'naukri-config', variable: 'CONFIG_FILE')]) {
                    // CONFIG_FILE will be the path to your injected config.properties
                    bat "mvn test -Dconfig.file=%CONFIG_FILE%"
                }
            }
        }
    }

    triggers {
        cron('0 10 * * *') // Run daily at 10:00 AM
    }
}
