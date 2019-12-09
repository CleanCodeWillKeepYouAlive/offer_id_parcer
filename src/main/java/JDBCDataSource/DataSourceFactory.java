package JDBCDataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DataSourceFactory {
    private static Logger logger = LogManager.getLogger(DataSourceFactory.class);
    public static DataSource getDataSource(String dbType) {


        Properties props = new Properties();
        BasicDataSource ds = new BasicDataSource();
        FileInputStream fis = null;

            try{
                fis = new FileInputStream("database.properties");
                props.load(fis);
            }catch (IOException e) {
                logger.info("Cannot read from database properties");
                return null;
            }

            if("mysql".equals(dbType)) {
                ds.setDriverClassName(props.getProperty("MYSQL_DB_DRIVER_CLASS"));
                ds.setUrl(props.getProperty("MYSQL_DB_URL"));
                ds.setUsername(props.getProperty("MYSQL_DB_USERNAME"));
                ds.setPassword(props.getProperty("MYSQL_DB_PASSWORD"));
            } else if("clickhouse".equals(dbType)) {
                ds.setDriverClassName(props.getProperty("CH_DB_DRIVER_CLASS"));
                ds.setUrl(props.getProperty("CH_DB_URL"));
                ds.setUsername(props.getProperty("CH_DB_USERNAME"));
                ds.setPassword(props.getProperty("CH_DB_PASSWORD"));
            } else {
                return  null;
            }
            return ds;
    }

    private static void testDBDataSource(String dbType, int id) {
        String select = "select offer_name from offer where = ?";
        DataSource ds = DataSourceFactory.getDataSource(dbType);

        try (Connection con = ds.getConnection();
             PreparedStatement stm = con.prepareStatement(select);
             ResultSet rs = stm.executeQuery()) {
             stm.setInt(1, id);

             if (rs.next()) {
                System.out.println("OFFER_ID="
                        + rs.getInt("offer_id")
                        + ", OFFER_NAME=" + rs.getString("offer_name"));
            }

        } catch (Exception e) {
            logger.error("Some error while test" , e);
        }
    }
}



