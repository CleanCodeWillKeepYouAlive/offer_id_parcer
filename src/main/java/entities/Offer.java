package entities;

import java.io.Serializable;

public class Offer implements Serializable {

    private int id;
    private String name;
    private String status;
    private int vertical;
    private String advertiserName;
    private int advertiserManager;
    private String priceFormat;
    private double priceReceived;
    private double pricePaid;

    public Offer() {
        this.id = id;
        this.name = name;
        this.status = status;
        this.vertical = vertical;
        this.advertiserName = advertiserName;
        this.advertiserManager = advertiserManager;
        this.priceFormat = priceFormat;
        this.priceReceived = priceReceived;
        this.pricePaid = pricePaid;
    }

    @Override
    public String toString() {
        return "Offer {" +
                "id=" + id +
                "&name=" + name +
                "&status=" + status +
                "&vertical=" + vertical +
                "&advertiser_name=" + advertiserName +
                "&advertiser_manager_id=" + advertiserManager +
                "&price_format" + priceFormat +
                "&price_paid=" + pricePaid +
                "&price_received=" + priceReceived + "} ";
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getVertical() {
        return vertical;
    }

    public void setVertical(int vertical) {
        this.vertical = vertical;
    }

    public String getAdvertiserName() {
        return advertiserName;
    }

    public void setAdvertiserName(String advertiserName) {
        this.advertiserName = advertiserName;
    }

    public int getAdvertiserManager() {
        return advertiserManager;
    }

    public void setAdvertiserManager(int advertiserManager) {
        this.advertiserManager = advertiserManager;
    }

    public String getPriceFormat() {
        return priceFormat;
    }

    public void setPriceFormat(String priceFormat) {
        this.priceFormat = priceFormat;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPriceReceived() {
        return priceReceived;
    }

    public double getPricePaid() {
        return pricePaid;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPriceReceived(double priceReceived) {
        this.priceReceived = priceReceived;
    }

    public void setPricePaid(double pricePaid) {
        this.pricePaid = pricePaid;
    }
}



