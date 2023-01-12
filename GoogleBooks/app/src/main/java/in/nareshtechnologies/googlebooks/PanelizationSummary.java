
package in.nareshtechnologies.googlebooks;


public class PanelizationSummary {

    private boolean containsEpubBubbles;
    private boolean containsImageBubbles;

    /**
     * No args constructor for use in serialization
     * 
     */
    public PanelizationSummary() {
    }

    /**
     * 
     * @param containsImageBubbles
     * @param containsEpubBubbles
     */
    public PanelizationSummary(boolean containsEpubBubbles, boolean containsImageBubbles) {
        super();
        this.containsEpubBubbles = containsEpubBubbles;
        this.containsImageBubbles = containsImageBubbles;
    }

    public boolean isContainsEpubBubbles() {
        return containsEpubBubbles;
    }

    public void setContainsEpubBubbles(boolean containsEpubBubbles) {
        this.containsEpubBubbles = containsEpubBubbles;
    }

    public boolean isContainsImageBubbles() {
        return containsImageBubbles;
    }

    public void setContainsImageBubbles(boolean containsImageBubbles) {
        this.containsImageBubbles = containsImageBubbles;
    }

}
