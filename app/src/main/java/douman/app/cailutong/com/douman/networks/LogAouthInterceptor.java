package douman.app.cailutong.com.douman.networks;

import java.io.IOException;
import douman.app.cailutong.com.douman.BaseApp;
import douman.app.cailutong.com.douman.contants.DBKEY;
import douman.app.cailutong.com.douman.utils.NetUtil;
import douman.app.cailutong.com.douman.utils.SystemUtil;
import douman.app.cailutong.com.douman.utils.ZlotLogger;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * 带身份校验的okhttp拦截器
 * Created by hammer on 2016/6/20.
 */
public  class LogAouthInterceptor implements Interceptor {
    // private String cookie = null;

    public static final MediaType jsonReq = MediaType.parse("application/x-www-form-urlencoded; charset=utf-8");
    @Override
    public Response intercept(Chain chain) throws IOException {
        //请求
        Request.Builder builder = chain.request().newBuilder();
        Request newrequest = setRequestHeader(builder).build();
        ZlotLogger.Http(String.format("-->: %s",newrequest.url()));
        ZlotLogger.Http("-->header内容"+newrequest.headers().toString());
        //响应
        Response response = chain.proceed(newrequest);
        getResponseHeader(response);
        //body log输出
        if (ZlotLogger.isDebug){
            ResponseBody responseBody = response.body();
            BufferedSource source = responseBody.source();
            source.request(Long.MAX_VALUE); // Buffer the entire body.
            Buffer buffer = source.buffer();
            //long contentLength = responseBody.contentLength();
            ZlotLogger.Debug("<-- "+buffer.clone().readString(NetUtil.UTF8));
        }
        return response;
    }

    /**
     * 添加request请求头部
     * @param builder
     * @return
     */
    private Request.Builder setRequestHeader(Request.Builder builder){
        if (BaseApp.getIns().deviceEntity.getToken() == null){
            if (BaseApp.getIns().dBlocal.getValue(DBKEY.TOKEN) != null){
                BaseApp.getIns().deviceEntity.setToken(BaseApp.getIns().dBlocal.getValue(DBKEY.TOKEN));
                builder.addHeader(DBKEY.TOKEN.toString(), BaseApp.getIns().deviceEntity.getToken());
            }
        }
        else{  
            builder.addHeader(DBKEY.TOKEN.toString(), BaseApp.getIns().deviceEntity.getToken());
        }

      builder.addHeader(DBKEY.DEVICE_ID.toString(), SystemUtil.getDeviceId());
        builder.addHeader(DBKEY.DEVICE_TYPE.toString(),"1");//1 android 2ios
        return builder;
    }

    private void getResponseHeader(Response response){
        String token  = response.headers().get(DBKEY.TOKEN.toString());
        if (token != null){
            BaseApp.getIns().dBlocal.setValue(DBKEY.COOKIE,token);
            ZlotLogger.Debug("获得TOKEN:"+token);
        }
    }

    private void getCookie(Response response){
        //获得cookie
        if (response.headers().get("Set-Cookie") != null){
            final StringBuffer cookieBuffer = new StringBuffer();
            Observable.from(response.headers("Set-Cookie"))
                    .map(new Func1<String, String>() {
                        @Override
                        public String call(String s) {
                            String[] cookieArray = s.split(";");
                            return cookieArray[0];
                        }
                    })
                    .subscribe(new Action1<String>() {
                        @Override
                        public void call(String cookie) {
                            cookieBuffer.append(cookie).append(";");
                        }
                    });
            //cookie = response.header("Set-Cookie");
            BaseApp.getIns().dBlocal.setValue(DBKEY.COOKIE,cookieBuffer.toString());
            ZlotLogger.Debug("获得Cookie:"+cookieBuffer.toString());
        }
    }
}