package helpers;

public class OfferController {
    private OfferService offerService;

    public String  doAction(RequestWrapper wrapper) {

        String response = "Selected offer data: \n "
                + offerService.selectOffer(wrapper.getOfferId());
        return response;
    }


}
