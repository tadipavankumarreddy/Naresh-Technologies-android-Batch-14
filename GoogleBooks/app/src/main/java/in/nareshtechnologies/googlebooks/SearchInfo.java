
package in.nareshtechnologies.googlebooks;


public class SearchInfo {

    private String textSnippet;

    /**
     * No args constructor for use in serialization
     * 
     */
    public SearchInfo() {
    }

    /**
     * 
     * @param textSnippet
     */
    public SearchInfo(String textSnippet) {
        super();
        this.textSnippet = textSnippet;
    }

    public String getTextSnippet() {
        return textSnippet;
    }

    public void setTextSnippet(String textSnippet) {
        this.textSnippet = textSnippet;
    }

}
