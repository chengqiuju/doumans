package douman.app.cailutong.com.douman.dao;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;

import douman.app.cailutong.com.douman.contants.DBKEY;

/**
 * Created by hammer on 2016/4/11.
 */
public class SharePreferenceDaoImp implements SharePreferenceDao {

    //本地存档
    //private PreferencesManager preferencesManager;
    private SharedPreferences preferences;

    public SharePreferenceDaoImp(Context ctx){
        //preferencesManager = new PreferencesManager(ctx);
        preferences = ctx.getSharedPreferences("base64", ctx.MODE_PRIVATE);
    }


    @Override
    public boolean getBoolean(DBKEY dbkey) {
        return false;
    }

    @Override
    public void setBoolean(DBKEY dbkey, boolean value) {

    }

    @Override
    public void setValue(String key, String value) {
        //ZlotLogger.Debug("存储key："+key+"  value:"+value);
        // 创建字节输出流
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            // 创建对象输出流，并封装字节流
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            // 将对象写入字节流
            oos.writeObject(value);
            // 将字节流编码成base64的字符窜
            byte[] byteArray =  Base64.encode(baos.toByteArray(), Base64.DEFAULT);
            String oAuth_Base64 = new String(byteArray);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString(key, oAuth_Base64);
            editor.commit();
        } catch (IOException e) {
            // TODO Auto-generated
        }
    }

    @Override
    public void setValue(DBKEY dekey, String value) {

    }

    @Override
    public String getValue(String key) {
        String oAuth_1 = null;
        String productBase64 = preferences.getString(key, null);
        if (productBase64 == null) {
            return null;
        }

        //读取字节
        byte[] base64 = Base64.decode(productBase64.getBytes(), Base64.DEFAULT);
        //封装到字节流
        ByteArrayInputStream bais = new ByteArrayInputStream(base64);
        try {
            //再次封装
            ObjectInputStream bis = new ObjectInputStream(bais);
            try {
                //读取对象
                oAuth_1 = (String) bis.readObject();
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (StreamCorruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

       // ZlotLogger.Debug("获得key："+key+"  value:"+oAuth_1);
        return oAuth_1;
    }

    @Override
    public String getValue(DBKEY dbkey) {
        return getValue(dbkey.toString());
    }

    /**
     * 后期考虑加密
     * @param key
     * @param value
     */
    public void setBoolean(String key, Boolean value)
    {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }
    public Boolean getBoolean(String key)
    {
        Boolean ret = preferences.getBoolean(key, false);
        return ret;
    }
}
