pipeline {
    agent any
    tools {
        jdk 'JDK17'
        maven 'Maven3'
    }
    stages {
        stage('Build') {
            steps { sh 'mvn clean package' }
        }
        stage('Test and Coverage') {
            steps {
                sh 'mvn verify'
                junit 'target/surefire-reports/*.xml'
            }
        }
        stage('Checkstyle') {
            steps { sh 'mvn checkstyle:check' }
        }
        stage('PMD') {
            steps { sh 'mvn pmd:check' }
        }
        stage('Dependency Security') {
            steps { sh 'mvn org.owasp:dependency-check-maven:check' }
        }
        stage('Deploy to Staging') {
            when { branch 'main' }
            steps { input message: 'Aprovar deploy para homologação?' }
        }
    }
    post {
        always { junit allowEmptyResults: true, testResults: 'target/surefire-reports/*.xml' }
        failure { echo 'Pipeline interrompida: verificar testes, cobertura e análise estática.' }
    }
}
