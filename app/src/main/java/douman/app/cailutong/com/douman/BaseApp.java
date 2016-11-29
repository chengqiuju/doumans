package douman.app.cailutong.com.douman;

import android.app.Application;
import android.content.pm.PackageManager;
import android.util.Log;

import org.xutils.*;

import douman.app.cailutong.com.douman.dao.SharePreferenceDao;
import douman.app.cailutong.com.douman.dao.SharePreferenceDaoImp;
import douman.app.cailutong.com.douman.entity.DeviceEntity;
import douman.app.cailutong.com.douman.interfaces.AppManagerInterface;

//import com.zhy.http.okhttp.OkHttpClientManager;

public class BaseApp extends Application {
	private static BaseApp mInstance;

	public String id;
	public static BaseApp getIns() {
		return mInstance;
	}
	public AppManagerInterface appManager; //app管理类
	public DeviceEntity deviceEntity ; // 设备信息缓存
	public SharePreferenceDao dBlocal; //Preferences数据库操作类
	@Override
	public void onCreate() {
		super.onCreate();
		mInstance = this;
		if(deviceEntity==null){
			deviceEntity=new DeviceEntity();
		}
		if(dBlocal==null){
			dBlocal=new SharePreferenceDaoImp(this);
		}
		//xUtils初始化
		x.Ext.init(this);
		x.Ext.setDebug(org.xutils.BuildConfig.DEBUG);
	}

	/**
	 * 完全退出app
	 */
	public void quitApp()
	{
		appManager.CallQuit();
	}
	/**
	 * 进入到用户中心
	 */
	public void intoMemberCenter(){
		appManager.CallIntoMemberCenter();
	}


	public int getVersonCode(){
		try {
			int versionCode = this.getPackageManager().getPackageInfo(getPackageName(), 0).versionCode;
			return versionCode;
		} catch (PackageManager.NameNotFoundException e) {
			Log.d("测试", e.toString());
			return  1;
		}
	}
	/**
	 * 获得SharePreferenceDao唯一实例
	 * @return
	 */
	public SharePreferenceDao getShareDao(){return dBlocal;}
}
