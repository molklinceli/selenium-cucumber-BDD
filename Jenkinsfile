pipeline {
    agent any

    tools {
        jdk 'JAVA_HOME'
        maven 'MAVEN_HOME'
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build & Test') {
            steps {
                bat 'java -version'
                bat 'mvn -version'
                bat 'mvn clean verify'
            }
        }
    }

    post {
        always {

            // DEBUG : voir les fichiers générés
            bat 'dir target\\report'

            // Publication HTML
            publishHTML(target: [
                reportDir: 'target/report',
                reportFiles: 'cucumber-report.html',
                reportName: 'Cucumber Report',
                keepAll: true,
                alwaysLinkToLast: true
            ])
        }
    }
}
