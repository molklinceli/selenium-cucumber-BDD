pipeline {
    agent any

    tools {
        jdk 'JAVA_HOME'      // Nom exact de ta JDK dans Jenkins
        maven 'MAVEN_HOME'   // Nom exact de ton Maven dans Jenkins
    }

    options {
        timestamps()
        disableConcurrentBuilds()
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build & Test') {
            steps {
                // Vérification des versions
                bat 'java -version'
                bat 'mvn -version'

                // Lancer les tests avec Maven
                // "verify" exécute test + génération du rapport HTML via maven-cucumber-reporting
                bat 'mvn clean verify'
            }
        }
    }

    post {
        always {
            // Résultats JUnit (Surefire)
            junit testResults: 'target/surefire-reports/*.xml', allowEmptyResults: true

            // Rapport Cucumber HTML généré par Maven Cucumber Reporting
            publishHTML(target: [
                reportDir: 'target/report',
                reportFiles: 'cucumber-report.html',
                reportName: 'Cucumber Report',
                keepAll: true,
                alwaysLinkToLast
