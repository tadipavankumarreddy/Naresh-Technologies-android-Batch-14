
package in.nareshtechnologies.googlebooks;


public class Epub {

    private boolean isAvailable;
    private String acsTokenLink;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Epub() {
    }

    /**
     * 
     * @param isAvailable
     * @param acsTokenLink
     */
    public Epub(boolean isAvailable, String acsTokenLink) {
        super();
        this.isAvailable = isAvailable;
        this.acsTokenLink = acsTokenLink;
    }

    public boolean isIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public String getAcsTokenLink() {
        return acsTokenLink;
    }

    public void setAcsTokenLink(String acsTokenLink) {
        this.acsTokenLink = acsTokenLink;
    }

}
