package entities;

import java.util.List;

public interface OfferDao {

    public Offer read(int id);
    public Offer create();
    public void update(Offer offer);
    public void delete(Offer offer);
    public List<Offer> getAll();

}
