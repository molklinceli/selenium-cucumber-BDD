pipeline {
  agent any

  tools {
    jdk   'JAVA_HOME'
    maven 'MAVEN_HOME'
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
        bat 'java -version'
        bat 'mvn -version'
        bat 'mvn -U -e clean test'
      }
    }
  }

  post {
    always {
      // Résultats JUnit (Surefire)
      junit testResults: 'target/surefire-reports/*.xml', allowEmptyResults: true

      // Rapport Cucumber HTML (si généré)
      publishHTML(target: [
         reportDir: 'target/report',
         reportFiles: 'cucumber-report.html',
         reportName: 'Cucumber Report',
         keepAll: true,
         alwaysLinkToLastBuild: true,
         allowMissing: false
      ])

      // Archive (rapports + screenshots/logs si tu en génères)
      archiveArtifacts artifacts: 'target/**, screenshots/**, logs/**', allowEmptyArchive: true
    }
  }
} 