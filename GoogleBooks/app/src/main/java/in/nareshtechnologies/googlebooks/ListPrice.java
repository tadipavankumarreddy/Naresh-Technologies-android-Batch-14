
package in.nareshtechnologies.googlebooks;


public class ListPrice {

    private double amount;
    private String currencyCode;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ListPrice() {
    }

    /**
     * 
     * @param amount
     * @param currencyCode
     */
    public ListPrice(double amount, String currencyCode) {
        super();
        this.amount = amount;
        this.currencyCode = currencyCode;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

}
