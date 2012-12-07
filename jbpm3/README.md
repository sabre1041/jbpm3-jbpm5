jBPM3-jBPM5 - Training - jBPM3
=====================

An example application of the jBPM3 workflow engine.

Setup and Configuration
----------------------

Full instructions and documentation available within the included Quick Start guide. 

The following steps highlight the overall steps required to run the project:

Install the required jBPM3 dependencies into the local Maven repository. This artifact is found at <JBoss_Server_Profile>/jbpm.esb/jbpm-jpdl.jar
    
    mvn install:install-file -Dfile=jbpm-jpdl.jar -DgroupId=org.jbpm -DartifactId=jbpm-jpdl -Dversion=3.2.13 -Dpackaging=jar
    
Configure the email properties in the jbpm.cfg.xml file

    <string name="jbpm.mail.smtp.host" value="smtp.redhat.com" />
    <string name="jbpm.mail.user" value="user" />
    <string name="jbpm.mail.password" value="password" />
    <int name="jbpm.mail.smtp.port" value="25" />
    
    <!-- # For use with servers requiring start TLS such as gmail
    <boolean name="jbpm.mail.smtp.starttls" value="true" />
    -->
	
 