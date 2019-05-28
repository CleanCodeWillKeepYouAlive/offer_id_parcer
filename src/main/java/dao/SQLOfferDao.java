package dao;

import entities.Offer;
import entities.OfferDao;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class SQLOfferDao extends DAO<Offer> {
    private Connection connection;

    @Override
    public Offer getById(int id) throws SQLException {
        String sql = "select * from offer where id = ?";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setInt(1, id);

        ResultSet rs = stm.executeQuery();
        rs.next();

        Offer offer = new Offer();
        offer.setId(rs.getInt("Id"));
        offer.setName(rs.getString("OfferName"));
        offer.setStatus(rs.getString("Status"));
        offer.setVertical(rs.getInt("Vertical"));
        offer.setAdvertiserName(rs.getString("AdvertiserName"));
        offer.setAdvertiserManager(rs.getInt("AdvertiserManager"));
        offer.setPriceFormat(rs.getString("PriceFormat"));
        offer.setPricePaid(rs.getDouble("PricePaid"));
        offer.setPriceReceived(rs.getDouble("PriceReceive"));
        return offer;
    }

    @Override
    public void insert(Offer dat) {

    }

    @Override
    public void update(Offer dat) {

    }

    @Override
    public void delete(Offer dat) {

    }

    @Override
    public ArrayList<Offer> getAll() {
        return null;
    }

    public SQLOfferDao() {

        try {
            Properties props = new Properties();
            props.load(this.getClass().getClassLoader().getResourceAsStream("database.properties"));

            String url = props.getProperty("url");
            String name = props.getProperty("username");
            String password = props.getProperty("password");

//           String url = "jdbc:mysql://localhost/test?serverTimezone=Europe/Kiev&useSSL=false";
//           String name = "root";
//           String password = "password";

            connection = DriverManager.getConnection(url, name, password);
            System.out.println("Connection is successful");

        } catch (Exception e) {
            System.out.println("Fail to database connection");
        }
    }
}
