package douman.app.cailutong.com.douman.contants;

/**数据库的key值
 * Created by hammer on 2016/1/20.
 */
public  enum DBKEY {
     HAVE_SECURITY_ISSUES("haveSecurityIssues"),
    /**
     * 账户id
     */
    USERID("id"),
    /**
     * 账户
     */
    ACCOUNT("user"),
    /**
     * 手势解锁，被锁定的状态
     */
    LOCK_OUT_STATU("locksOutStatu"),
    LOCK_OUT_START_TIME("lockOutStartTime"),
    /**
     * 首次安装
     */
    FIRST_INSTALL("firstinit"),

    /**
     * 令牌token
     */
    TOKEN("token"),
    /**
     * 设备id:deviceId
     */
    DEVICE_ID("deviceId"),
    /**
     * cookie
     */
    COOKIE("Cookie"),

    /**
     * 设备类型1android 2苹果
     */
    DEVICE_TYPE("deviceType"),
    /**
     * 登录状态
     */
    LOGIN("loginStatu");


    private DBKEY(String key)
    {
        this.key = key;
    }
    public String toString()
    {
        return key;
    }
    private String key;
}
