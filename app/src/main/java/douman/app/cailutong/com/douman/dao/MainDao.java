package douman.app.cailutong.com.douman.dao;
import douman.app.cailutong.com.douman.entity.HuodongDataModel;
import douman.app.cailutong.com.douman.interfaces.DaoResponseListener;

/**
 * Created by Administrator on 2016/11/14.
 */

public interface MainDao {
    /**
     *活动列表 list
     * @param clientType
     * @param responseListener
     */
    public void getHuodongData(int clientType, DaoResponseListener<HuodongDataModel> responseListener);

}
