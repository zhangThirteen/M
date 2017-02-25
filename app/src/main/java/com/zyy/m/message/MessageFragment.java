package com.zyy.m.message;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zyy.m.R;

/**
 * Created by Administrator on 2017/2/25.
 */

public class MessageFragment extends Fragment {

    private View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (view ==null){
            view = inflater.inflate(R.layout.fragment_message,container,false);
        }
        return view;
    }
}
