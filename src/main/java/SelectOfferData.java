
import helpers.OfferController;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SelectOfferData {
    public static void main(String[] args) {
        OfferController offerController = new OfferController();
        offerController.selectOffer(validation());
    }

    static int validation() {
        int id = 0;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            id = Integer.parseInt(reader.readLine());
            reader.close();
        } catch (NumberFormatException n) {
            System.out.println("Offer id must be in Integer");
        } catch (IOException e) {
            System.out.println("Some error with Input / Output data");

        }
        return id;
    }
}
