package douman.app.cailutong.com.douman.widgets;

import android.util.Log;

import douman.app.cailutong.com.douman.contants.H5URL;

/**
 * Created by admin on 2015/12/19.
 */
public class LogInfo {
    public static void LogOut(String info) {

        if (H5URL.isDebug && info != null) {
            StackTraceElement stack[] = (new Throwable()).getStackTrace();
            if(stack.length > 1){
                StackTraceElement s = stack[1];
                String[] names= s.getClassName().split("\\.");
                Log.d("ck", names[names.length - 1] + "第" + s.getLineNumber() + "行:---------" + info);
            }else{
                Log.d("ck", info);
            }
        }
    }
    public static void LogOut(String tag, String info) {
        if (H5URL.isDebug && info != null) {
            StackTraceElement stack[] = (new Throwable()).getStackTrace();
            if(stack.length > 1){
                StackTraceElement s = stack[1];
                String[] names= s.getClassName().split("\\.");
                Log.d(tag,names[names.length-1]+"第"+s.getLineNumber()+"行-->"+info);
            }else{
                Log.d(tag, info);
            }
        }
    }
    public static void LogOutE(String tag, String info) {
        if (H5URL.isDebug && info != null) {
            StackTraceElement stack[] = (new Throwable()).getStackTrace();
            if(stack.length > 1){
                StackTraceElement s = stack[1];
                String[] names= s.getClassName().split("\\.");
                Log.e(tag,names[names.length-1]+"第"+s.getLineNumber()+"行-->"+info);
            }else{
                Log.e(tag, info);
            }
        }
    }
    public static void LogOutDetail(String tag, String info) {
        if (H5URL.isDebug && info != null) {
            StackTraceElement stack[] = (new Throwable()).getStackTrace();
            if(stack.length > 3){
                StringBuffer buffer = new StringBuffer();
                buffer.append(info);
                buffer.append("<--");
                String[] names= stack[1].getClassName().split("\\.");
                buffer.append(names[names.length-1]+"第"+stack[1].getLineNumber()+"行<--");
                names= stack[2].getClassName().split("\\.");
                buffer.append(names[names.length-1]+"第"+stack[2].getLineNumber()+"行<--");
                names= stack[3].getClassName().split("\\.");
                buffer.append(names[names.length-1]+"第"+stack[3].getLineNumber()+"行");
                Log.d(tag,buffer.toString());
            }else{
                Log.d(tag, info);
            }
        }
    }

}
