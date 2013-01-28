jBPM3-jBPM5 - Training - jBPM5
=====================

An example application of the jBPM5 workflow engine.

Setup and Configuration
----------------------

The following steps highlight the overall steps required to run the project with the included JUnit test:

Install the required jBPM5 dependencies into the local Maven repository. Download the latest BRMS Distributable and extract the jboss-jbpm-engine.zip archive to the directory of your choosing. Navigate to this directory and execute the following commmands: 
    
	mvn install:install-file -Dfile=lib/drools-core-5.3.1.BRMS.jar -DgroupId=org.drools -DartifactId=drools-core -Dversion=5.3.1.BRMS -Dpackaging=jar
    mvn install:install-file -Dfile=lib/knowledge-api-5.3.1.BRMS.jar -DgroupId=org.drools -DartifactId=knowledge-api -Dversion=5.3.1.BRMS -Dpackaging=jar
    mvn install:install-file -Dfile=lib/drools-compiler-5.3.1.BRMS.jar -DgroupId=org.drools -DartifactId=drools-compiler -Dversion=5.3.1.BRMS -Dpackaging=jar
    mvn install:install-file -Dfile=jbpm-workitems-5.3.1.BRMS.jar -DgroupId=org.jbpm -DartifactId=jbpm-workitems -Dversion=5.3.1.BRMS -Dpackaging=jar
    mvn install:install-file -Dfile=jbpm-bpmn2-5.3.1.BRMS.jar -DgroupId=org.jbpm -DartifactId=jbpm-bpmn2 -Dversion=5.3.1.BRMS -Dpackaging=jar
    mvn install:install-file -Dfile=jbpm-flow-5.3.1.BRMS.jar -DgroupId=org.jbpm -DartifactId=jbpm-flow -Dversion=5.3.1.BRMS -Dpackaging=jar
    mvn install:install-file -Dfile=jbpm-flow-builder-5.3.1.BRMS.jar -DgroupId=org.jbpm -DartifactId=jbpm-flow-builder -Dversion=5.3.1.BRMS -Dpackaging=jar
    mvn install:install-file -Dfile=jbpm-human-task-5.3.1.BRMS.jar -DgroupId=org.jbpm -DartifactId=jbpm-human-task -Dversion=5.3.1.BRMS -Dpackaging=jar
    mvn install:install-file -Dfile=jbpm-persistence-jpa-5.3.1.BRMS.jar -DgroupId=org.jbpm -DartifactId=jbpm-persistence-jpa -Dversion=5.3.1.BRMS -Dpackaging=jar
    mvn install:install-file -Dfile=jbpm-bam-5.3.1.BRMS.jar -DgroupId=org.jbpm -DartifactId=jbpm-bam -Dversion=5.3.1.BRMS -Dpackaging=jar
    mvn install:install-file -Dfile=jbpm-test-5.3.1.BRMS.jar -DgroupId=org.jbpm -DartifactId=jbpm-test -Dversion=5.3.1.BRMS -Dpackaging=jar
    
Configure the properties of the email server in the CustomWorkItemHandlers.conf file in the project

	[

    "Email": new org.jbpm.process.workitem.email.EmailWorkItemHandler(
    
    "smtp.redhat.com", "25", "username", "password"),  
    
    ]