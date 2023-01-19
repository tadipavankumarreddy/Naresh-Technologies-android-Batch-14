
package in.nareshtechnologies.dailysamachar;

import java.util.List;

public class SourceData {

    private String category;
    private List<Datum> data = null;
    private boolean success;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

}
