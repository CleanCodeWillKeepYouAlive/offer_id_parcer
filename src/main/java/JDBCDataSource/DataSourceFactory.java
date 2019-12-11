package JDBCDataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DataSourceFactory {
    private static Logger logger = LogManager.getLogger(DataSourceFactory.class);

    public static DataSource getDataSource(String dbType) {

        BasicDataSource ds = new BasicDataSource();
        Properties props = new Properties();

            try (InputStream is = DataSourceFactory.class.getClassLoader()
                    .getResourceAsStream("database.properties")) {
                props.load(is);

            }catch (IOException e) {
                logger.info("Cannot read from database properties");

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
            }else if("home".equals(dbType)) {
                ds.setDriverClassName(props.getProperty("HOME_DB_DRIVER_CLASS"));
                ds.setUrl(props.getProperty("HOME_DB_URL"));
                ds.setUsername(props.getProperty("HOME_DB_USERNAME"));
                ds.setPassword(props.getProperty("HOME_DB_PASSWORD"));
            } else {
                return null;
            }
            return ds;
    }

    private static void testDBDataSource(String dbType, int id) {
        DataSource ds = DataSourceFactory.getDataSource(dbType);
        String select = "select offer_id, offer_name from offer where offer_id = 2018";

        try (Connection conn = ds.getConnection();
             PreparedStatement stm = conn.prepareStatement(select);
             ResultSet rs = stm.executeQuery()) {


                if (rs.next()) {
                    System.out.println("OFFER_ID="
                            + rs.getInt("offer_id")
                            + ", OFFER_NAME=" + rs.getString("offer_name"));
                }

        } catch (Exception e) {
            logger.error("Some error while test", e);
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
       testDBDataSource("mysql",2018);
    }
}



