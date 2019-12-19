package helpers;

import com.sun.net.httpserver.HttpExchange;
import java.net.URI;

public class RequestWrapper {

    public int getOfferId() {
        return offerId;
    }

    private int offerId;
    private HttpExchange exchange;

    public RequestWrapper(HttpExchange exchange) {
        this.exchange = exchange;
        this.offerId = getParameter(
                "offer", -1
        );
    }

    private int getParameter(String parameterName, int defaultValue) {
        URI requestURI = exchange.getRequestURI();
        try {
            return  Integer.parseInt(requestURI.toString().replaceAll(
                    "[^0-9]", ""));

        } catch (Exception e) {
            return defaultValue;
        }
    }

}
