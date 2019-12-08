package dao;

import entities.Offer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class OfferDAO extends AbstractDAO<Offer> {
    private Connection connection;

    @Override
    public Offer getById(int id) throws SQLException {
        String sql = "select * from offer where id = ?";
        Offer offer = new Offer();
        try(PreparedStatement stm = connection.prepareStatement(sql)) {
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            rs.next();

            offer.setId(rs.getInt("Id"));
            offer.setName(rs.getString("OfferName"));
            offer.setStatus(rs.getString("Status"));
            offer.setVertical(rs.getInt("Vertical"));
            offer.setAdvertiserName(rs.getString("AdvertiserName"));
            offer.setAdvertiserManager(rs.getInt("AdvertiserManager"));
            offer.setPriceFormat(rs.getString("PriceFormat"));
            offer.setPricePaid(rs.getDouble("PricePaid"));
            offer.setPriceReceived(rs.getDouble("PriceReceive"));
        }catch (SQLException e) {
            e.printStackTrace();
        }

        return offer;
    }


    @Override
    public List<Offer> getAll() {
        String sql = "select * from offer";
        List<Offer> list = new ArrayList<>();

        try (PreparedStatement stm = getPrepareStatement(sql)) {
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
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
                list.add(offer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
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


    public OfferDAO() {

        try {
            Properties props = new Properties();
            props.load(this.getClass().getClassLoader().getResourceAsStream(
                    "database.properties"));

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
