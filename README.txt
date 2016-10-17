1.- Compile the archetype: mvn clean install

2.- Check that your ${USER_HOME}/.m2/archetype-catalog.xml contains the archetype:

<?xml version="1.0" encoding="UTF-8"?>
<archetype-catalog xsi:schemaLocation="http://maven.apache.org/plugins/maven-archetype-plugin/archetype-catalog/1.0.0 http://maven.apache.org/xsd/archetype-catalog-1.0.0.xsd" 
    xmlns="http://maven.apache.org/plugins/maven-archetype-plugin/archetype-catalog/1.0.0" 
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
  <archetypes>
    ...
    <archetype>
      <groupId>com.picoto.ws</groupId>
      <artifactId>WebServiceArchetype</artifactId>
      <version>1.0.0</version>
      <description>Arquetipo para generar Servicios Web</description>
    </archetype>
  </archetypes>
</archetype-catalog>


3.- Execute the archetype:

mvn archetype:generate -DarchetypeGroupId=com.picoto.ws -DarchetypeArtifactId=WebServiceArchetype -DarchetypeVersion=1.0.0 -DgroupId=MYGROUP -DartifactId=MYARTIFACT -Dpackage=MYPACKAGE -Dversion=1.0.0 -DwsQname=http://MYNAMESPACE/

4.- This will generate a new Project called <MYARTIFACT> (choose the right name). If you don't like the default values, you can change them, by default we work on a local file based h2sql database with a table named testtable(codigo, literal).

5.- You can compile the whole project:

cd MYARTIFACT

mvn clean install -DskipTests=true

6.- You can run the Tomcat server with a local file based h2sql database:

cd MYARTIFACT/MYARTIFACTServer

mvn tomcat7:run-war

7.- You can execute the client through a test case:

cd MYARTIFACT/MYARTIFACTClient

mvn test