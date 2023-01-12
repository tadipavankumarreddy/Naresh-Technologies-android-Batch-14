
package in.nareshtechnologies.googlebooks;


public class ReadingModes {

    private boolean text;
    private boolean image;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ReadingModes() {
    }

    /**
     * 
     * @param image
     * @param text
     */
    public ReadingModes(boolean text, boolean image) {
        super();
        this.text = text;
        this.image = image;
    }

    public boolean isText() {
        return text;
    }

    public void setText(boolean text) {
        this.text = text;
    }

    public boolean isImage() {
        return image;
    }

    public void setImage(boolean image) {
        this.image = image;
    }

}
