package douman.app.cailutong.com.douman.networks;
import douman.app.cailutong.com.douman.interfaces.DaoResponseListener;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by hammer on 2016/6/13.
 * http请求基础
 */
public class HttpTask<T> {
    //private Call<T> call;
//    private Context context;
//    private ResponseListener<T> responseListener;

    /**
     * 启动http任务
     */
    public void start(Call<T> call, final DaoResponseListener<T> responseListener){
        //this.call = call;
        call.enqueue(new Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {
                if (response.body() == null){
                    if (responseListener != null)
                    responseListener.onFail("网络连接错误，请稍后重试");
                    return;
                }
                responseListener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                //responseListener.onFail("网络连接错误，请稍后重试");
                if (responseListener != null)
                 responseListener.onFail("网络连接错误，请重试:"+t.toString());
            }
        });
    }

//    public void cancel(){
//        if(call == null)
//            return;
//
//        if (!call.isCanceled()){
//            call.cancel();
//        }
//
//    }

}
