package douman.app.cailutong.com.douman.dao;


import douman.app.cailutong.com.douman.contants.DBKEY;

/**
 * Created by hammer on 2016/4/11.
 * 使用SharePreference实现数据持久化
 */
public interface SharePreferenceDao {
    public boolean getBoolean(DBKEY dbkey);
    public void setBoolean(DBKEY dbkey, boolean value);
    public void setValue(String key, String value);
    public void setValue(DBKEY dekey, String value);
    public String getValue(String key);
    public String getValue(DBKEY dbkey);
}
