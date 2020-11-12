FROM payara/micro:5.2020.6-jdk11
COPY target/kukulkan-ee.war $DEPLOY_DIR
