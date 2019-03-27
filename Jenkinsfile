pipeline {
    agent any
    stages {
        stage('build') {
            steps {
                sh './gradlew setupCiWorkspace build'
            }
        }
        stage('deploy-develop') {
            when { branch '1.12-develop' }
            environment {
                PEARX_REPO = credentials('pearx-repo-user')
            }
            steps {
                sh "./gradlew publishDevelop -PpearxRepoUser=${PEARX_REPO_USR} -PpearxRepoPassword=${PEARX_REPO_PSW}"
            }
        }

        stage('deploy-release') {
            when { branch '1.12' }
            environment {
                PEARX_REPO = credentials('pearx-repo-user')
                CURSEFORGE_API_KEY = credentials('curseforge-api-key')
            }
            steps {
                sh "./gradlew publishRelease -PpearxRepoUser=${PEARX_REPO_USR} -PpearxRepoPassword=${PEARX_REPO_PSW} -PcurseforgeApiKey=${CURSEFORGE_API_KEY}"
            }
        }
    }
}