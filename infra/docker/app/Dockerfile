FROM tomcat:9.0
COPY ./build/libs/railway_pricing.war webapps

ENV CATALINA_HOME /usr/local/tomcat
ENV PATH $CATALINA_HOME/bin:$PATH
WORKDIR $CATALINA_HOME
