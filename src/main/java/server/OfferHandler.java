package server;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import helpers.OfferController;
import helpers.RequestWrapper;
import java.io.IOException;
import java.io.OutputStream;

public class OfferHandler implements HttpHandler {

    OfferController controller =  new OfferController();


    @Override
    public void handle(HttpExchange httpExchange) throws IOException {

        String response = controller.doAction(new RequestWrapper(httpExchange));
        httpExchange.sendResponseHeaders(200, response.getBytes().length);
        OutputStream os = httpExchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}

