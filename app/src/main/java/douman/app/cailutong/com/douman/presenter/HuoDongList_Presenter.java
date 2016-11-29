package douman.app.cailutong.com.douman.presenter;
import douman.app.cailutong.com.douman.BaseApp;
import douman.app.cailutong.com.douman.activitys.MainActivity;
import douman.app.cailutong.com.douman.dao.MainDao;
import douman.app.cailutong.com.douman.dao.MainDaoImp;
import douman.app.cailutong.com.douman.entity.HuodongDataModel;
import douman.app.cailutong.com.douman.interfaces.DaoResponseListener;

/**
 * Created by Administrator on 2016/11/8.
 */

public class HuoDongList_Presenter {
    private MainActivity huodongFragment;
    private MainDao mainDao;
    public HuoDongList_Presenter(MainActivity huodongFragment) {
        this.huodongFragment = huodongFragment;
        this.mainDao = new MainDaoImp((BaseApp) huodongFragment.getApplication());
    }
    /**
     * 获得理财数据List
     */
    public void getIndexData(int clientType){
        mainDao.getHuodongData(clientType, new DaoResponseListener<HuodongDataModel>() {
            @Override
            public void onSuccess(HuodongDataModel huodongDataHuodongDataModel) {
                if (huodongDataHuodongDataModel.getData()!=null){
                    huodongFragment.onSuccess(huodongDataHuodongDataModel.getData().getResults());
                }
            }

            @Override
            public void onFail(String msg) {
                huodongFragment.onFail(msg,-1);
            }
        });
    }

}
