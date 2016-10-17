#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import javax.jws.WebService;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import org.apache.log4j.Logger;

@WebService(serviceName="${artifactId}", portName="${artifactId}Port", endpointInterface = "${package}.${artifactId}", targetNamespace="${wsQname}")
public class ${artifactId}Impl implements ${artifactId} {

    private final static Logger LOG = Logger.getLogger(${artifactId}Impl.class);
    
    private DataSource dataSource;

    public ${artifactId}Impl() {
        super();
    }
    
    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public String test(Integer codigo) {
        JdbcTemplate tpl = new JdbcTemplate(dataSource);
        return (String)tpl.queryForObject("select literal from testtable where codigo = ?", new Object[] {codigo}, String.class);
    }




}
