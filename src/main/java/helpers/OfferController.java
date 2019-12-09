package helpers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.OfferDAO;
import entities.Offer;
public class OfferController {

    public String selectOffer(int id) {
        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try {
            OfferDAO offerDAO = new OfferDAO();
            Offer off = offerDAO.getById(id);

            json = mapper
                    .writerWithDefaultPrettyPrinter()
                    .writeValueAsString(off);
            System.out.println(json);

        } catch (JsonProcessingException j) {
            System.out.println("Json convert problem ");
        }
        return json;
    }
}
