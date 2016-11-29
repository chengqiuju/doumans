package douman.app.cailutong.com.douman.entity;

/**
 * Created by Administrator on 2016/11/7.
 */

public class HuodongData {
    private int activityType;
    private String briefImageM;
    private String id;
    private HuodongDelData cltAssetsStore;

    @Override
    public String toString() {
        return "HuodongData{" +
                "activityType=" + activityType +
                ", briefImageM='" + briefImageM + '\'' +
                ", id='" + id + '\'' +
                ", cltAssetsStore=" + cltAssetsStore +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getActivityType() {
        return activityType;
    }

    public void setActivityType(int activityType) {
        this.activityType = activityType;
    }

    public HuodongDelData getCltAssetsStore() {
        return cltAssetsStore;
    }

    public void setCltAssetsStore(HuodongDelData cltAssetsStore) {
        this.cltAssetsStore = cltAssetsStore;
    }

    public String getBriefImageM() {
        return briefImageM;
    }

    public void setBriefImageM(String briefImageM) {
        this.briefImageM = briefImageM;
    }
}
