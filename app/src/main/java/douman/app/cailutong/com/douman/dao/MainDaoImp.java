package douman.app.cailutong.com.douman.dao;
import douman.app.cailutong.com.douman.BaseApp;
import douman.app.cailutong.com.douman.entity.HuodongDataModel;
import douman.app.cailutong.com.douman.interfaces.DaoResponseListener;

/**
 * Created by Administrator on 2016/11/14.
 */

public class MainDaoImp  extends HttpDaoImp implements MainDao {
    public MainDaoImp(BaseApp baseApp) {
        super(baseApp);
    }

    @Override
    public void getHuodongData(int clientType, DaoResponseListener<HuodongDataModel> responseListener) {
        httpTask.start(licaiService.getHuodongList(clientType), responseListener);
    }
}
