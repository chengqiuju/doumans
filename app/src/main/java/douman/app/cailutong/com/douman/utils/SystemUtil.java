package douman.app.cailutong.com.douman.utils;

import android.content.Context;
import android.provider.Settings;
import android.telephony.TelephonyManager;

import java.io.FileInputStream;
import java.lang.reflect.Field;

import douman.app.cailutong.com.douman.BaseApp;
import douman.app.cailutong.com.douman.contants.DBKEY;

/**
 * 系统工具
 * @author hammerCui
 *
 */
public class SystemUtil {

	/**
	 * 获得设备版本号
	 * @return
	 */
	public static int getSDKversion()
	{
		int version = 14;
		try {
			version = Integer.valueOf(android.os.Build.VERSION.SDK);
			ZlotLogger.Debug("SDK version:"+version);
		} catch (Exception e) {
			// TODO: handle exception
			ZlotLogger.Debug("e:"+e.toString());
		}
		return version;
	}
	/**
	 * 获得设备mac地址
	 * @return
	 */
	public static String getMacAddress()
	{
		String mac = "";
		try{
			String path="sys/class/net/eth0/address";
			FileInputStream fis_name = new FileInputStream(path);
			byte[] buffer_name = new byte[1024*8];
	        int byteCount_name = fis_name.read(buffer_name);
	        if(byteCount_name>0)
	        {
	            mac = new String(buffer_name, 0, byteCount_name, "utf-8");
	        }
	        
	        if(mac.length()==0||mac==null){
	        	path="sys/class/net/eth0/wlan0";
	        	FileInputStream fis = new FileInputStream(path);
				byte[] buffer = new byte[1024*8];
		        int byteCount = fis.read(buffer);
		        if(byteCount>0)
		        {
		            mac = new String(buffer, 0, byteCount, "utf-8");
		        }
	        }
	        
	        if(mac.length()==0||mac==null){
	        	return "";
	        }
		}catch(Exception io){
			
		}
		return mac.trim();
	}





	/**
	 * string to long
	 * @param str
	 * @return
	 */
	public static  long strToLong(String str)
	{
		long ret = 0;
		try {
			ret = Long.parseLong(str);
			return  ret;
		}
		catch (Exception e)
		{
			return  ret;
		}
	}


	/**
	 * 通过文件名获取资源id 例子：getResId("icon", R.drawable.class);
	 * @param variableName
	 * @param c
	 * @return
	 */
	public static int getResId(String variableName, Class<?> c) {
		try {
			Field idField = c.getDeclaredField(variableName);
			return idField.getInt(idField);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	/**
	 * 例如对于GSM手机返回IMEI，对于CDMA手机返回MEID,如果设备不可用则返回NULL
	 * 非手机设备会取不到
	 */
	private String getImieStatus(Context context) {
		TelephonyManager tm = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
		String deviceId = tm.getDeviceId();
		ZlotLogger.Debug("DEVICE_ID: "+deviceId + " ");
		return deviceId;
	}

	/**
	 * 设备首次启动，生成的设备id，
	 * bug：国产手机会有不同手机，相同id的问题
	 */
	private String getAndroidId(Context context){
		String ANDROID_ID = Settings.System.getString(context.getContentResolver(), Settings.System.ANDROID_ID);
		ZlotLogger.Debug("ANDROID_ID:"+ANDROID_ID + " ");
		return ANDROID_ID;
	}
	/**
	 * 获得设备安装时产生的uuid,这个是产生设备id的方法
	 * @return
	 */
	public static String getUUID(Context context){
		//以ANDROID_ID为基础，在获取失败时以TelephonyManager.getDeviceId()为备选方法，如果再失败，使用UUID的生成策略。
		String deviceId = BaseApp.getIns().getShareDao().getValue(DBKEY.DEVICE_ID);
		if ( deviceId == null){
			deviceId = Installation.id(context);
			ZlotLogger.Debug("uuid:"+deviceId + " ");
			BaseApp.getIns().deviceEntity.setDeviceId(deviceId);
			BaseApp.getIns().getShareDao().setValue(DBKEY.DEVICE_ID,deviceId);
		}
		else{
			BaseApp.getIns().deviceEntity.setDeviceId(deviceId);
		}
		return deviceId;
	}
	/**
	 * 获得设备id
	 * @return
	 */
	public static String getDeviceId(){
		if (BaseApp.getIns().deviceEntity.getDeviceId() != null){
			return BaseApp.getIns().deviceEntity.getDeviceId();
		}
		else{
			return  BaseApp.getIns().getShareDao().getValue(DBKEY.DEVICE_ID);
		}
	}
}
