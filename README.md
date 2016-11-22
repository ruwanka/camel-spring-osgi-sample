##CAMEL SPRING DSL OSGi EXAMPLE

##Purpose
-------
This is a sample to kickoff Camel OSGi bundle with spring dsl. It based on [servicemix example of camel-osgi](https://github.com/apache/servicemix/tree/master/examples/camel/camel-osgi).
This deploys a Camel EIP route as an OSGi bundle.

##Explanation
-----------

This example provides one Camel route:
- A Java route   

##Java Route
---------   
The Java Camel route is defined in a Java soure file, MyRouteBuilder, which can be
found in the src/main/java/com/ruwanka directory
of this example.


##Prerequisites for Running the Example
-------------------------------------
1. You must have the following installed on your machine:

   - JDK 1.6 or higher

   - Maven 2.2.1 or higher (for building)
   
   - Apache Servicemix

2. Start ServiceMix by running the following command:

    <servicemix_home>/bin/servicemix          (on UNIX)
    <servicemix_home>\bin\servicemix          (on Windows)


##Running the Example
-------------------

##Independent run via maven apache-camel plugin

After `mvn clean install`, `mvn camel:run` can be used to run the 
routes independently from the servicemix.

Below section explains how to deploy the OSGi bundle in to apache servicemix

## Building the Example Bundle Yourself

  This option is useful if you want to change the example in any way.
  It tells you how to build and deploy the example. If you do not already have the
  required bundles in your local Maven repository, Maven will have to
  download the bundles it needs.

##Updating and Redeploying the Properties File from the Console
-------------------------------------------------------------
You can update and redeploy the properties file that is used by the
properties placeholder in the beans.xml from console as follows:

1. Edit the org.apache.servicemix.examples.cfg file, located in the
   same folder as this README, by changing the value of the "prefix"
   key to whatever you want (for example, YourTransform).
  
2. Copy the updated configuration file to your <servicemix_home>/etc
   directory. You can do this from the ServiceMix console by typing:

     copy $YOUR_SERVICEMIX_HOME/examples/camel/camel-osgi/org.apache.servicemix.examples.cfg
     $YOUR_SERVICEMIX_HOME/etc

   On Windows you need to replace / in the path with \\.

   Note, the text you are typing might intermingle with the output
   being logged. This is nothing to worry about.

3. Restart the example bundle:

   (i) First you must know the bundle ID that ServiceMix has assigned
       to it. To get the bundle ID, enter the following command in the
       ServiceMix console:

         bundle:list

      At the end of the listing, you should see an entry similar to
      the following:

      [158] [Active     ] [Started  ] [  60] Apache ServiceMix Example :: Camel OSGi (4.1.0)
 
      In this case, the bundle ID is 158.

   (ii) Enter the following command in the ServiceMix console to
        restart the bundle:
    
          bundle:restart <bundle_id>
  
  The prefix of the output should change, and the output on the console should
  be updated accordingly.
 
For information on how to stop and/or uninstall the example, see
"Stopping and Uninstalling the Example" below.

##Building the Example Bundle Yourself
---------------------------------------
To install and run the example where you build the example bundle
yourself, complete the following steps:

 Build the example by opening a command prompt, changing directory to
 examples/camel/camel-osgi (this example) and entering the following Maven 
 command:

     mvn install
   
   If all of the required OSGi bundles are available in your local Maven
   repository, the example will build very quickly. Otherwise it may
   take some time for Maven to download everything it needs.
   
   The mvn install command builds the example deployment bundle and
   copies it to your local Maven repository and to the target directory
   of this example.


##Stopping and Uninstalling the Example
-------------------------------------
To stop the example, enter the following command in the ServiceMix
console:

  bundle:stop <bundle_id>

For information on how to find the bundle_id assigned to the example,
see step 3 in the "Updating and Redeploying the Properties File 
from the Console" section above.

To uninstall the example, enter one of the following commands in
the ServiceMix console:

  feature:uninstall examples-camel-osgi
 
or
 
  bundle:uninstall <bundle_id>
  

##Viewing the Log Entries
-----------------------
You can view the entries in the log file in the data/log
directory of your ServiceMix installation, or by typing
the following command in the ServiceMix console:

  log:display
