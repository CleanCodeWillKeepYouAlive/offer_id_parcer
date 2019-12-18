package entities;

import java.io.Serializable;

public class Offer implements Serializable {

    private int offerId, advertiserId, verticalId,
                defaultOfferContractId, offerTypeId, offerStatusId,
                isHidden, currencyId, deleted;

    private String offerName;

    public Offer(int offerId, int advertiserId, int verticalId,
                 int defaultOfferContractId, int offerTypeId,
                 int offerStatusId, int isHidden,
                 int currencyId, int deleted, String offerName) {
        this.offerId = offerId;
        this.advertiserId = advertiserId;
        this.verticalId = verticalId;
        this.defaultOfferContractId = defaultOfferContractId;
        this.offerTypeId = offerTypeId;
        this.offerStatusId = offerStatusId;
        this.isHidden = isHidden;
        this.currencyId = currencyId;
        this.deleted = deleted;
        this.offerName = offerName;
    }

    public Offer() {

    }

    public int getOfferId() {
        return offerId;
    }

    public void setOfferId(int offerId) {
        this.offerId = offerId;
    }

    public int getAdvertiserId() {
        return advertiserId;
    }

    public void setAdvertiserId(int advertiserId) {
        this.advertiserId = advertiserId;
    }

    public int getVerticalId() {
        return verticalId;
    }

    public void setVerticalId(int verticalId) {
        this.verticalId = verticalId;
    }

    public int getDefaultOfferContractId() {
        return defaultOfferContractId;
    }

    public void setDefaultOfferContractId(int defaultOfferContractId) {
        this.defaultOfferContractId = defaultOfferContractId;
    }

    public int getOfferTypeId() {
        return offerTypeId;
    }

    public void setOfferTypeId(int offerTypeId) {
        this.offerTypeId = offerTypeId;
    }

    public int getOfferStatusId() {
        return offerStatusId;
    }

    public void setOfferStatusId(int offerStatusId) {
        this.offerStatusId = offerStatusId;
    }

    public int getIsHidden() {
        return isHidden;
    }

    public void setIsHidden(int isHidden) {
        this.isHidden = isHidden;
    }

    public int getCurrecnyId() {
        return currencyId;
    }

    public void setCurrecnyId(int currecnyId) {
        this.currencyId = currecnyId;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }

    public String getOfferName() {
        return offerName;
    }

    public void setOfferName(String offerName) {
        this.offerName = offerName;
    }

    @Override
    public String toString() {
        return "Offer{" +
                "offer_id=" + offerId +
                ", advertiser_id=" + advertiserId +
                ", vertical_id=" + verticalId +
                ", default_offer_contract_id=" + defaultOfferContractId +
                ", offer_type_id=" + offerTypeId +
                ", offer_status_id=" + offerStatusId +
                ", is_hidden=" + isHidden +
                ", currency_id=" + currencyId +
                ", deleted=" + deleted +
                ", offer_name=" + offerName + "\n}";
    }
}


