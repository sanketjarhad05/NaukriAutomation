pipeline {
    agent any

    tools {
        jdk 'jdk21'
        maven 'Maven3'
    }

    stages {

        stage('Debug Config') {
            steps {
                configFileProvider([configFile(fileId: 'naukri-config', variable: 'CONFIG_FILE')]) {
                    bat "echo Config file injected at: %CONFIG_FILE%"
                    bat "type %CONFIG_FILE%"   // print file content in Jenkins logs
                }
            }
        }

        stage('Build') {
            steps {
                configFileProvider([configFile(fileId: 'naukri-config', variable: 'CONFIG_FILE')]) {
                    bat "mvn clean install -Dconfig.file=%CONFIG_FILE%"
                }
            }
        }

        stage('Run Tests') {
            steps {
                configFileProvider([configFile(fileId: 'naukri-config', variable: 'CONFIG_FILE')]) {
                    bat "mvn test -Dconfig.file=%CONFIG_FILE%"
                }
            }
        }
    }

    triggers {
        cron('0 10 * * *') // Run daily at 10:00 AM
    }
}
