
package in.nareshtechnologies.googlebooks;

import java.util.List;


public class SourceData {

    private String kind;
    private long totalItems;
    private List<Item> items = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public SourceData() {
    }

    /**
     * 
     * @param totalItems
     * @param kind
     * @param items
     */
    public SourceData(String kind, long totalItems, List<Item> items) {
        super();
        this.kind = kind;
        this.totalItems = totalItems;
        this.items = items;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public long getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(long totalItems) {
        this.totalItems = totalItems;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

}
