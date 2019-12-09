package server;

import com.sun.net.httpserver.*;
import helpers.OfferController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;
public class BasicHttpServer {

    private static Logger logger = LogManager.getLogger(BasicHttpServer.class);

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8500), 0);
        HttpContext context = server.createContext("/offer/");
        context.setHandler(BasicHttpServer::handleRequest);
        server.start();
    }

    private static void handleRequest(HttpExchange exchange) throws IOException {
        OfferController controller = new OfferController();
        URI requestURI = exchange.getRequestURI();

        printRequestInfo(exchange);
        int offerId = Integer.parseInt(requestURI.toString().replaceAll(
                "[^0-9]", ""));

        String response = "OFFER DATA: \n " + controller.selectOffer(offerId);

        exchange.sendResponseHeaders(200, response.getBytes().length);
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

    private static void printRequestInfo(HttpExchange exchange) {
        logger.info("-- headers --");
        Headers requestHeaders = exchange.getRequestHeaders();
        requestHeaders.entrySet().forEach(System.out::println);

        logger.info("-- principle --");
        HttpPrincipal principal = exchange.getPrincipal();
        logger.info(principal);

        logger.info("-- HTTP method --");
        String requestMethod = exchange.getRequestMethod();
        logger.info(requestMethod);

        logger.info("-- query --");
        URI requestURI = exchange.getRequestURI();
        String query = requestURI.getQuery();
        logger.info(query);
    }
}
