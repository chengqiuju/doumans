package douman.app.cailutong.com.douman.dao;

import douman.app.cailutong.com.douman.BaseApp;
import douman.app.cailutong.com.douman.networks.HttpTask;
import douman.app.cailutong.com.douman.networks.ILicaiApi;
import douman.app.cailutong.com.douman.networks.IMainApi;
import douman.app.cailutong.com.douman.networks.IMemberApi;
import douman.app.cailutong.com.douman.networks.RetrofitManager;

/**
 * http请求数据实现类
 * Created by hammer on 2016/6/20.
 */
public class HttpDaoImp {
    protected IMemberApi memberService;
    protected ILicaiApi licaiService;
    protected IMainApi homeService;
    /**
     * 自定义http请求任务
     */
    public HttpTask httpTask;

    public HttpDaoImp(BaseApp baseApp){
      //  baseApp.getAppComponent().inject(this);
        httpTask=new HttpTask();
        this.memberService = RetrofitManager.getIns().retrofitAouth.create(IMemberApi.class);
        this.licaiService = RetrofitManager.getIns().retrofitAouth.create(ILicaiApi.class);
        this.homeService = RetrofitManager.getIns().retrofitAouth.create(IMainApi.class);
    }



}
