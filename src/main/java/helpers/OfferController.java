package helpers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.SQLOfferDao;
import entities.Offer;

import java.sql.SQLException;

public class OfferController {

    public void selectOffer(int id) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            SQLOfferDao offerDAO = new SQLOfferDao();
            Offer off = offerDAO.getById(id);

            String jsonInString2 = mapper
                    .writerWithDefaultPrettyPrinter()
                    .writeValueAsString(off);
            System.out.println(jsonInString2);

        } catch (SQLException e) {
        } catch (JsonProcessingException j) {
            System.out.println("Json convert problem ");
        }
    }
}
