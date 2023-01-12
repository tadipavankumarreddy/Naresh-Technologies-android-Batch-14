
package in.nareshtechnologies.googlebooks;


public class Offer {

    private long finskyOfferType;
    private ListPrice__1 listPrice;
    private RetailPrice__1 retailPrice;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Offer() {
    }

    /**
     * 
     * @param finskyOfferType
     * @param retailPrice
     * @param listPrice
     */
    public Offer(long finskyOfferType, ListPrice__1 listPrice, RetailPrice__1 retailPrice) {
        super();
        this.finskyOfferType = finskyOfferType;
        this.listPrice = listPrice;
        this.retailPrice = retailPrice;
    }

    public long getFinskyOfferType() {
        return finskyOfferType;
    }

    public void setFinskyOfferType(long finskyOfferType) {
        this.finskyOfferType = finskyOfferType;
    }

    public ListPrice__1 getListPrice() {
        return listPrice;
    }

    public void setListPrice(ListPrice__1 listPrice) {
        this.listPrice = listPrice;
    }

    public RetailPrice__1 getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(RetailPrice__1 retailPrice) {
        this.retailPrice = retailPrice;
    }

}
