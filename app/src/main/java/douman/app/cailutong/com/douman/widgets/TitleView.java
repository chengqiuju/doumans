package douman.app.cailutong.com.douman.widgets;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import douman.app.cailutong.com.douman.R;


/**
 * Created by admin on 2015/12/19.
 */
public class TitleView implements ViewImpl {
    public RelativeLayout title_bar,title_left,title_right;
    public Button left_text,right_text,right_text1;
    public TextView center_tv;
    Activity mContext;

    public TitleView(Activity mContext) {
        this.mContext=mContext;
        onBindViews();
        onSetViews();
    }

    @Override
    public void onBindViews() {
        title_bar= (RelativeLayout) mContext.findViewById(R.id.title_bar);
        title_left= (RelativeLayout) mContext.findViewById(R.id.title_left);
        title_right= (RelativeLayout) mContext.findViewById(R.id.title_right);
        left_text= (Button) mContext.findViewById(R.id.left_text);
        right_text= (Button) mContext.findViewById(R.id.right_text);
        right_text1= (Button) mContext.findViewById(R.id.right_text1);
        center_tv= (TextView) mContext.findViewById(R.id.center_tv);
        left_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.finish();
            }
        });
    }
    public void setCenterTitle(String title){
        center_tv.setText(title);
    }
    public void setTitleState(int  state){
        center_tv.setVisibility(state);
    }
    public void setRightTitle(String title){
        right_text1.setText(title);
    }
    public void setRightBtnState(int state){
        title_right.setVisibility(state);
    }

    @Override
    public void onSetViews() {
        title_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.finish();
                LogInfo.LogOutE("dianji", "点击back键了--------------33333");
            }
        });
    }

}
