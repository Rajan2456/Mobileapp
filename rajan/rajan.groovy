pipeline {
  agent any
  stages {
  stage('build') {
      steps {
        sh '''
          echo "Mvn Compile and install Rajan Java webapp"
          cd rajan
          /opt/apache-maven-3.6.3/bin/mvn package
        '''
      }
    }
  stage('deploy') {
      steps {
          sh '''
              echo "MVN deploy"
              sudo cp rajan/target/rajan.war /usr/local/tomcat9/webapps/
              sudo /usr/local/tomcat9/bin/catalina.sh stop
              sudo /usr/local/tomcat9/bin/catalina.sh start
          '''     
      }
    }
  }
}
