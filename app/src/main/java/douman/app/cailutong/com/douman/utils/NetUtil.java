package douman.app.cailutong.com.douman.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.nio.charset.Charset;

import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;

/**
 * Created by hammer on 2016/5/10.
 */
public class NetUtil {
    public static final Charset UTF8 = Charset.forName("UTF-8");
    public static final String UN_LOGIN_ERROR = "Unexpected character";

    /**
     * 判断是否是wifi网络
     * @param context
     * @return
     */
    public static boolean isWifiNetwork(Context context){
        boolean isWifi = false;
        Context getContext = context.getApplicationContext();
        ConnectivityManager connectivity = (ConnectivityManager) getContext
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] info = null;
        if (connectivity != null) {
            info = connectivity.getAllNetworkInfo();
            if (info != null) {
                for (int i = 0; i < info.length; i++) {
                    if (info[i].getTypeName().equals("WIFI") && info[i].isConnected()) {
                        isWifi = true;
                        break;
                    }
                }
            }
        }
        getContext = null;
        connectivity = null;
        info = null;
        return isWifi;
    }


    /**
     * debug模式使用，带输出
     * @param body
     * @return
     */
    public static String tryGetBodyStringInDebug(ResponseBody body){
        //Try to get response body
        BufferedReader reader = null;
        StringBuilder sb = new StringBuilder();
        try {
            reader = new BufferedReader(new InputStreamReader(body.byteStream()));
            String line;
            try {
                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e){
            ZlotLogger.Debug("e "+e.toString());
        }
        return sb.toString();
    }

    public static String tryGetBodyString(ResponseBody responseBody){
        BufferedSource source = responseBody.source();
        Buffer buffer = source.buffer();
        long contentLength = responseBody.contentLength();
       return buffer.clone().readString(NetUtil.UTF8);
    }

    /**
     * 根据返回结果获得entity类
     * @param responseBody
     * @param calsffOf
     * @param <T>
     * @return
     */
    public static <T> T tryGetEntityClass(ResponseBody responseBody, Class<T> calsffOf){
        //String result = NetUtil.tryGetBodyString(responseBody);
        String result = NetUtil.tryGetBodyStringInDebug(responseBody);
        ZlotLogger.Debug("<--result:"+result);
        Gson gson = new Gson();
        try {
            T memIndexResult = gson.fromJson(result,calsffOf);
            return memIndexResult;
        }
        catch (Exception e){
            ZlotLogger.Debug(e.toString());
            return null;
        }
    }

    /**
     * 带泛型的转换
     * @param responseBody
     * @param type
     * @param <T>
     * @return
     */
    public static <T> T tryGetEntityClass(ResponseBody responseBody, Type type){
        //String result = NetUtil.tryGetBodyString(responseBody);
        String result = NetUtil.tryGetBodyStringInDebug(responseBody);
        ZlotLogger.Debug("<--result:"+result);
        Gson gson = new Gson();
        try {
            T memIndexResult = gson.fromJson(result,type);
            return memIndexResult;
        }
        catch (Exception e){
            ZlotLogger.Debug(e.toString());
            return null;
        }

    }
}
