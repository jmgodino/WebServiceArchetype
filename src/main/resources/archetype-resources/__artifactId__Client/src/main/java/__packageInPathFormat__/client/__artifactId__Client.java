#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.client;

import java.net.URL;

import javax.xml.namespace.QName;


import ${package}.client.${artifactId};
import ${package}.client.${artifactId}_Service;


public class ${artifactId}Client {
    
    public ${artifactId} getService(String url) throws Exception {
        ${artifactId}_Service ws = new ${artifactId}_Service(new URL(url), new QName("${wsQname}", "${artifactId}"));
        ${artifactId} port = ws.get${artifactId}Port();
		return port;
    }

}
