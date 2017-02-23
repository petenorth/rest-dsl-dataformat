# rest-dsl-dataformat

This is a bug report project. 

Running

    mvn clean install
    
will result in a build failure due a test failure that shows up a dataformat sharing issue with Spring Boot and Camel.

This is FIXED in the Fuse Integration Services 2.0 GA release. The properties in the pom.xml that provide the fix are

    <fabric8.version>2.2.170.redhat-000010</fabric8.version>
    <spring-boot.version>1.4.1.RELEASE</spring-boot.version>


