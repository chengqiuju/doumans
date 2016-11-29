package douman.app.cailutong.com.douman.interfaces;

/**
 * 数据请求,返回的通用相应
 * Created by hammer on 2016/7/25.
 */
public interface DaoResponseListener<T> {
     public void onSuccess(T t);
     public void onFail(String msg);
}
