package douman.app.cailutong.com.douman.activitys;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

import douman.app.cailutong.com.douman.R;
import douman.app.cailutong.com.douman.entity.HuodongData;
import douman.app.cailutong.com.douman.fragments.OneFragment;
import douman.app.cailutong.com.douman.fragments.ThreeFragment;
import douman.app.cailutong.com.douman.fragments.TwoFragment;
import douman.app.cailutong.com.douman.presenter.HuoDongList_Presenter;
import douman.app.cailutong.com.douman.utils.SystemUtil;
import douman.app.cailutong.com.douman.utils.ZlotLogger;
import douman.app.cailutong.com.douman.widgets.TitleView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TitleView mTitleView;
    @ViewInject(R.id.rb_shouye_text)
    private RadioButton rb_shouye_text;
    @ViewInject(R.id.rb_licai_text)
    private RadioButton rb_licai_text;
    @ViewInject(R.id.rb_my_text)
    private RadioButton rb_my_text;
    @ViewInject(R.id.id_navigationview)
    private NavigationView idNavigationview;
    @ViewInject(R.id.drawerlayout_home)
    private DrawerLayout drawerlayoutHome;
    @ViewInject(R.id.toolbar)
    private Toolbar toolbar;
    OneFragment mLeadFragment = new OneFragment();
    public FragmentManager fragmentManager;
    TwoFragment mShouyeFragment = new TwoFragment();
    ThreeFragment mLicaiFragment = new ThreeFragment();
    Fragment[] allFrags = {mLeadFragment, mShouyeFragment, mLicaiFragment};

    private HuoDongList_Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        x.view().inject(this);
        ZlotLogger.Debug("最终的deveice的id:" + SystemUtil.getUUID(this));
        if (presenter == null) {
            presenter = new HuoDongList_Presenter(this);
        }
        rb_shouye_text.setOnClickListener(this);
        rb_licai_text.setOnClickListener(this);
        rb_my_text.setOnClickListener(this);
        rb_shouye_text.setChecked(true);
//        mTitleView = new TitleView(this);
//        mTitleView.setCenterTitle("首页");
//        mTitleView.left_text.setVisibility(View.GONE);
        iniView();
        getData();
    }

    private void iniView() {
        fragmentManager = this.getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.layout_allfrag, mLeadFragment, "onefragment");
        transaction.commit();
        //设置Drawerlayout开关指示器
        ActionBarDrawerToggle mActionBarDrawerToggle =
                new ActionBarDrawerToggle(this, drawerlayoutHome, toolbar, R.string.open, R.string.close);
        mActionBarDrawerToggle.syncState();
        drawerlayoutHome.setDrawerListener(mActionBarDrawerToggle);
        idNavigationview.inflateHeaderView(R.layout.header_nav);
        View headerView = idNavigationview.getHeaderView(0);
        ImageView sdvHeader = (ImageView) headerView.findViewById(R.id.sdv_avatar);
        sdvHeader.setImageResource(R.mipmap.ic_launcher);
        idNavigationview.inflateMenu(R.menu.menu_nav);
       // idNavigationview.setItemIconTintList(ThemeUtils.getNaviItemIconTinkList());
        // 自己写的方法，设置NavigationView中menu的item被选中后要执行的操作
        //onNavgationViewMenuItemSelected(idNavigationview);
    }

    private void getData() {
        presenter.getIndexData(1);
    }

    public void onSuccess(List<HuodongData> data) {
        Log.e("tishi", data.toString());
    }

    public void onFail(String msg, int id) {
        if (msg == null)
            msg = getResources().getString(id);
        Log.e("tishi", msg.toString());
//        PopViews.showOneDialog(getContext(), "提示", msg, "知道了", () -> {
//        });
    }

    @Override
    public void onClick(View view) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        switch (view.getId()) {
            case R.id.rb_shouye_text:
                Log.e("click", "click---------------11");
                changeShow(mLeadFragment, transaction, "onefragment");
                break;
            case R.id.rb_licai_text:
                Log.e("click", "click---------------22");
                changeShow(mShouyeFragment, transaction, "shouyefragment");
                break;
            case R.id.rb_my_text:
                Log.e("click", "click---------------33");
                changeShow(mLicaiFragment, transaction, "myfragment");
                break;
        }
        transaction.commit();

    }

    private void changeShow(Fragment showFrag, FragmentTransaction transaction, String tag) {
        if (showFrag.isAdded()) {
            transaction.show(showFrag);
        } else {
            transaction.add(R.id.layout_allfrag, showFrag, tag);
        }
        for (Fragment fragment : allFrags) {
            if (fragment != showFrag && fragment.isAdded()) {
                transaction.hide(fragment);
            }
        }
    }
}
