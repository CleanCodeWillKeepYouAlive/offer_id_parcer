package helpers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.OfferDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import server.BasicHttpServer;

public class OfferController {
    private static Logger logger = LogManager.getLogger(BasicHttpServer.class);
    private ObjectMapper mapper;
    private OfferDAO offerDAO;
    String json = null;

    public String selectOffer(int id) {
        try { json = mapper
                    .writerWithDefaultPrettyPrinter()
                    .writeValueAsString(offerDAO.getById(id));
           logger.info(json);

        } catch (JsonProcessingException j) {
            System.out.println("Json convert problem ");
        }
        return json;
    }
}
