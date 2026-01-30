FROM tomcat:9.0-jdk21

LABEL author="Swarna Mishra"
LABEL project="Rima Billing System"

# Remove default apps
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy WAR
COPY target/rima-billing.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080

CMD ["catalina.sh", "run"]
