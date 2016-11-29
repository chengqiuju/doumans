package douman.app.cailutong.com.douman.networks;

import douman.app.cailutong.com.douman.entity.HuodongDataModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * 理财
 * Created by hammer on 2016/5/6.
 */
public interface ILicaiApi {
    /**
     * 获得活动列表
     *
     * @return
     */
    @GET("v4/goroupby/list?type=&status=0&size=100")
    public Call<HuodongDataModel> getHuodongList(@Query("clientType") int clientType);

}