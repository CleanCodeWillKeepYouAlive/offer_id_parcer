package server;


import com.sun.net.httpserver.*;
import helpers.OfferController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BasicHttpServer {
    private static Logger logger = LogManager.getLogger(BasicHttpServer.class);
    private static OfferController offerController = new OfferController();

    public static void main(String[] args) throws Exception {
        BasicHttpServer.run();
    }


    public static void run() throws Exception {
        final ExecutorService ex = Executors.newSingleThreadExecutor();
        final HttpServer server = HttpServer.create(new InetSocketAddress(8001), 0);

        server.createContext("/offer/", (HttpExchange exchange) -> {
            URI requestURI = exchange.getRequestURI();
            int offerId = Integer.parseInt(requestURI.toString().replaceAll(
                    "[^0-9]", ""));

            String response = "Selected offer data: \n "
                    + offerController.selectOffer(offerId);

            exchange.sendResponseHeaders(200, response.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
            ex.submit(() -> {
                server.stop(0);
                System.out.println("HTTP server stopped");
            });
        });

        server.setExecutor(ex);
        server.start();
        System.out.println("HTTP server started");
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
