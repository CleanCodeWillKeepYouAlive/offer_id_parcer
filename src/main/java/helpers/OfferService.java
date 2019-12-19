package helpers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.OfferDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OfferService {

    private static Logger logger = LogManager.getLogger(OfferService.class);
    private OfferDAO offerDAO = new OfferDAO();
    private ObjectMapper mapper = new ObjectMapper();
    private String json = null;

    public String selectOffer(int id) {
        try {
            json = mapper
                    .writerWithDefaultPrettyPrinter()
                    .writeValueAsString(offerDAO.getById(id));
           logger.info(json);

        } catch (JsonProcessingException j) {
           logger.error("Json convert problem ", j);
           return offerDAO.getById(id).toString();
        }
        return json;
    }
}
