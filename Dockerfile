FROM tomcat:9.0.40

COPY ./target/*.war $CATALINA_HOME/webapps

ENV postgresUsername=postgres
ENV postgresPassword=1Playlego%
ENV awsPassword=1Playlego%

EXPOSE 8080