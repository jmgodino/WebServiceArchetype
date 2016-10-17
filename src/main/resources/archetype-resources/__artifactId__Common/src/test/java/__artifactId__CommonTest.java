
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.SequenceInputStream;
import java.sql.SQLException;

import javax.sql.DataSource;



import org.h2.tools.RunScript;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ${package}.${artifactId}Impl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-database.xml"})
public class ${artifactId}CommonTest {

    @Autowired
    DataSource dataSource;

    @Before
    public void init() throws SQLException, IOException {
        init(dataSource, "test-data.sql");
    }

    @After
    public void tearDown() throws SQLException, IOException {
        RunScript.execute(dataSource.getConnection(), new FileReader(
                "src/test/resources/drop-schema.sql"));
    }

    @Test
    public void simpleTest() {
        ${artifactId}Impl ws = new ${artifactId}Impl();
        ws.setDataSource(dataSource);
        Assert.assertEquals("Hola mundo",ws.test(1));
        
        
    }

    public static void init(DataSource dataSourceActual, String dataTest) throws SQLException,
            IOException {
        InputStream f1 = null;
        InputStream f2 = null;
        try {
            f1 = new FileInputStream("src/test/resources/create-schema.sql");
            f2 = new FileInputStream("src/test/resources/" + dataTest);
            RunScript.execute(dataSourceActual.getConnection(), new InputStreamReader(
                    new SequenceInputStream(f1, f2)));
        } catch (Exception e) {
            if (f1 != null)
                f1.close();
            if (f2 != null)
                f2.close();
        }
    }
}
