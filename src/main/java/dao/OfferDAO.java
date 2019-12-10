package dao;

import JDBCDataSource.DataSourceFactory;
import entities.Offer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class OfferDAO implements DAO<Offer> {

    final Logger logger = LogManager.getLogger(OfferDAO.class);
    DataSource ds = DataSourceFactory.getDataSource("home");
    private final static String SELECT_CERTAIN_OFFER = "SELECT offer_id, offer_name, offer_status_id," +
            "vertical_id, advertiser_id, default_offer_contract_id, offer_type_id," +
            "currency_id, is_hidden, deleted  FROM offer WHERE offer_id = ?";
    private final static String SELECT_ALL_OFFERS = "select * from offer";


    @Override
    public Offer getById(int id) {
        try(Connection connection = ds.getConnection();
            PreparedStatement stm = connection.prepareStatement(SELECT_CERTAIN_OFFER)) {
            stm.setInt(1, id);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    Offer offer = new Offer();
                    offer.setOfferId(rs.getInt("offer_id"));
                    offer.setOfferName(rs.getString("offer_name"));
                    offer.setOfferStatusId(rs.getInt("offer_status_id"));
                    offer.setVerticalId(rs.getInt("vertical_id"));
                    offer.setAdvertiserId(rs.getInt("advertiser_id"));
                    offer.setDefaultOfferContractId(rs.getInt("default_offer_contract_id"));
                    offer.setOfferTypeId(rs.getInt("offer_type_id"));
                    offer.setCurrecnyId(rs.getInt("currency_id"));
                    offer.setIsHidden(rs.getInt("is_hidden"));
                    offer.setDeleted(rs.getInt("deleted"));
                    return offer;
                }
            }
        }catch (SQLException e) {
            logger.error("Some sql exception were catch", e);
        }
       return null;
    }

    @Override
    public List<Offer> getAll() {
        List<Offer> list = new ArrayList<>();
        try (Connection connection = ds.getConnection();
             PreparedStatement stm = connection.prepareStatement(SELECT_ALL_OFFERS);
             ResultSet rs = stm.executeQuery()) {

            if (rs.next()) {
                Offer offer = new Offer();
                offer.setOfferId(rs.getInt("offer_id"));
                offer.setOfferName(rs.getString("offer_name"));
                offer.setOfferStatusId(rs.getInt("status_id"));
                offer.setVerticalId(rs.getInt("vertical_id"));
                offer.setAdvertiserId(rs.getInt("advertiser_id"));
                offer.setDefaultOfferContractId(rs.getInt("default_offer_contract_id"));
                offer.setOfferTypeId(rs.getInt("offer_type_id"));
                offer.setCurrecnyId(rs.getInt("currency_id"));
                offer.setIsHidden(rs.getInt("is_hidden"));
                offer.setDeleted(rs.getInt("deleted"));
                list.add(offer);
            }
        } catch (SQLException e) {
            logger.error("Some sql exception were catch" ,e);
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
}
