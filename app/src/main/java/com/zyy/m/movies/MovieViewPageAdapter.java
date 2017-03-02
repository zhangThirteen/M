package com.zyy.m.movies;

import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2017/3/1.
 */

public class MovieViewPageAdapter extends PagerAdapter {

    private View[] views;

    public MovieViewPageAdapter(View[] views) {
        this.views = views;
    }

    @Override
    public int getCount() {
        Log.d("TGA", "getCount() called with: " + views.length);
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Log.e("test", "instantiadesrfsdfteItem: "+position+"jjjj:"+views.length);
        View adapterView = views[position%views.length];
        Log.e("test", "instantiateItem: "+position%views.length);
        if (container.indexOfChild(adapterView)!=-1){
            container.removeView(adapterView);
        }
        container.addView(adapterView);
        return adapterView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

    }
}


