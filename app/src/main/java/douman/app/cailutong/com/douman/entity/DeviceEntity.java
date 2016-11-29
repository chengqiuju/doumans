package douman.app.cailutong.com.douman.entity;

import android.graphics.Point;

/**
 * Created by hammer on 2016/4/26.
 * 设备信息实体类
 */
public class DeviceEntity {
    private Point pixelsPoint;
    private float density;
    private int densityDpi;
    private int spacingHuge;
    private int spacingLarger;
    private int spacingLarge;
    private int spacingNormal;
    private int spacingSmall;
    private int spacingTiny;
    private boolean initSucc;
    private String deviceId;
    private String token;
    private float designWidthRate; //实际宽/设计宽比例
    private float designHeightRate;//实际高/设计高比例
    public Point getPixelsPoint() {
        return pixelsPoint;
    }

    public void setPixelsPoint(Point pixelsPoint) {
        this.pixelsPoint = pixelsPoint;
    }

    public float getDensity() {
        return density;
    }

    public void setDensity(float density) {
        this.density = density;
    }

    public int getDensityDpi() {
        return densityDpi;
    }

    public void setDensityDpi(int densityDpi) {
        this.densityDpi = densityDpi;
    }

    public int getSpacingHuge() {
        return spacingHuge;
    }

    public void setSpacingHuge(int spacingHuge) {
        this.spacingHuge = spacingHuge;
    }

    public int getSpacingTiny() {
        return spacingTiny;
    }

    public void setSpacingTiny(int spacingTiny) {
        this.spacingTiny = spacingTiny;
    }

    public int getSpacingLarger() {
        return spacingLarger;
    }

    public void setSpacingLarger(int spacingLarger) {
        this.spacingLarger = spacingLarger;
    }

    public int getSpacingLarge() {
        return spacingLarge;
    }

    public void setSpacingLarge(int spacingLarge) {
        this.spacingLarge = spacingLarge;
    }

    public int getSpacingNormal() {
        return spacingNormal;
    }

    public void setSpacingNormal(int spacingNormal) {
        this.spacingNormal = spacingNormal;
    }

    public int getSpacingSmall() {
        return spacingSmall;
    }

    public void setSpacingSmall(int spacingSmall) {
        this.spacingSmall = spacingSmall;
    }

    public boolean isInitSucc() {
        return initSucc;
    }

    public void setInitSucc(boolean initSucc) {
        this.initSucc = initSucc;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public float getDesignWidthRate() {
        return designWidthRate;
    }

    public void setDesignWidthRate(float designWidthRate) {
        this.designWidthRate = designWidthRate;
    }

    public float getDesignHeightRate() {
        return designHeightRate;
    }

    public void setDesignHeightRate(float designHeightRate) {
        this.designHeightRate = designHeightRate;
    }
}
