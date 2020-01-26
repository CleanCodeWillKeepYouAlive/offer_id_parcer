package helpers;

public class OfferController {
    private OfferService offerService = new OfferService();

    public String doAction(RequestWrapper wrapper) {
        String response = "Selected offer data: \n " + offerService.selectOffer(wrapper.getOfferId());
        return response;
    }
}
