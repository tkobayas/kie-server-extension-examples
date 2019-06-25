## kie-server-extension-example

Environment: RHPAM 7.0.0

This zip contains 3 projects:

* kie-server-singleton-util

  A simple kie-server-extension project. MyUtilKieServerExtension will be registered as a kie-server extension during kie-server start-up. It calls MySingletonUtil.getSingleton() to initialize the singleton object so processes can call its methods.

  You can build the jar by "mvn clean install"

  Copy target/kie-server-singleton-util-1.0.0.jar to kie-server.war/WEB-INF/lib/ and business-central.war/WEB-INF/lib/

  During kie-server start-up, you will see logs:

  ~~~
  14:28:44,959 INFO  [org.kie.server.ext.util.MyUtilKieServerExtension] (ServerService Thread Pool -- 71) init
  14:28:44,963 INFO  [org.kie.server.ext.util.MySingletonUtil] (ServerService Thread Pool -- 71) doing initialization...
  ...
  14:28:46,991 INFO  [org.kie.server.ext.util.MySingletonUtil] (ServerService Thread Pool -- 71) initialization done
  14:28:46,991 INFO  [org.kie.server.services.impl.KieServerImpl] (ServerService Thread Pool -- 71) MyUtil KIE Server extension has been successfully registered as server extension
  ~~~

* jBPM70Ex002_kie-server-client-kjar

  An example kjar project which calls MySingletonUtil from process.

  Run "mvn clean install"
 
* jBPM70Ex002_kie-server-client

  An example kie-server client project to deploy the kjar and start a process.

  Import the project to JBDS/Eclipse.

  Run CreateContainer to deploy the kjar (jBPM70Ex002_kie-server-client-kjar).

  Run StartProcessTest to start a process. You wouldn't see "doing initialization..." because MySingletonUtil is already initialized during  kie-server start-up.
  ~~~
  15:25:12,080 INFO  [stdout] (default task-54) hello
  ~~~
