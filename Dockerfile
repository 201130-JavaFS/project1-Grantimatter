FROM tomcat:9.0.40-jre8

COPY ./target/*.war $CATALINA_HOME/webapps

EXPOSE 8080