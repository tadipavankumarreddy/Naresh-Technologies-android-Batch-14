
package in.nareshtechnologies.googlebooks;


public class ListPrice__1 {

    private long amountInMicros;
    private String currencyCode;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ListPrice__1() {
    }

    /**
     * 
     * @param amountInMicros
     * @param currencyCode
     */
    public ListPrice__1(long amountInMicros, String currencyCode) {
        super();
        this.amountInMicros = amountInMicros;
        this.currencyCode = currencyCode;
    }

    public long getAmountInMicros() {
        return amountInMicros;
    }

    public void setAmountInMicros(long amountInMicros) {
        this.amountInMicros = amountInMicros;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

}
