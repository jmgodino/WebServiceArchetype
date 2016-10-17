#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
import org.junit.Test;
import org.junit.Assert;

import ${package}.client.${artifactId};
import ${package}.client.${artifactId}Client;


public class ${artifactId}ClientTest {
    
	@Test
    public void testClient() throws Exception {
		try {
			${artifactId} service = new ${artifactId}Client().getService("${wsUrl}?WSDL");
			Assert.assertEquals("Hola mundo",service.test(1));
		} catch (Exception e) {
			// This is an integration test, if the server is not up and running, we dont fail
		}
    }

}
