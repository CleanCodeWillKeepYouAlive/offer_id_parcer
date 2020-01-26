package server;
import com.sun.net.httpserver.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URI;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BasicHttpServer {
    private static Logger logger = LogManager.getLogger(BasicHttpServer.class);
    private HttpServer server;

    public BasicHttpServer() throws IOException {
        server = HttpServer.create(new InetSocketAddress(8001), 0);
        init();
    }

    private void init() {
        final ExecutorService ex = Executors.newSingleThreadExecutor();
        server.createContext("/offer/", new OfferHandler());
        server.setExecutor(ex);
    }

    public void start() {
        server.start();
        logger.info("HTTP server started!");
    }

    public void stop() {
        server.stop(1);
        logger.info("HTTP server stop!");
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
