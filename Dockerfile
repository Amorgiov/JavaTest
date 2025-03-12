FROM tomcat:9.0.97-jdk17

RUN rm -rf /usr/local/tomcat/webapps/*

COPY target/JavaTest.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080

CMD ["catalina.sh", "run"]