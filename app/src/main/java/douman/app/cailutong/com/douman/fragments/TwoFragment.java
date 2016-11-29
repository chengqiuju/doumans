package douman.app.cailutong.com.douman.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import douman.app.cailutong.com.douman.R;

/**
 * Created by Administrator on 2016/11/23.
 */

public class TwoFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_two, container,false);

        return rootView;
    }
}
