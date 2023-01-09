FROM payara/micro:5.2022.5-jdk17
COPY target/kukulkan-ee.war $DEPLOY_DIR
