package douman.app.cailutong.com.douman.utils;

import android.util.Log;

public class ZlotLogger {
	public static boolean isDebug = true;
	 public static void Debug(String paramString)
	  {
	    Log.d("测试", paramString);
	  }
	public static void Http(String paramString)
	{
		Log.d("http测试", paramString);
	}
}
