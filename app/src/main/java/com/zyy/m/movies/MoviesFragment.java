package com.zyy.m.movies;


import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.zyy.m.R;
import com.zyy.m.util.ThreadUtil;
import com.zyy.m.weight.MyScorllView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/2/25.
 */

public class MoviesFragment extends Fragment {


    @BindView(R.id.my_scorll_view)
    MyScorllView myScorllView;
    @BindView(R.id.movie_viewpage)
    ViewPager movieViewpage;
    @BindView(R.id.movie_top_rb1)
    RadioButton movieTopRb1;
    @BindView(R.id.movie_top_rb2)
    RadioButton movieTopRb2;
    @BindView(R.id.movie_top_rb3)
    RadioButton movieTopRb3;
    @BindView(R.id.movie_top_rb4)
    RadioButton movieTopRb4;
    @BindView(R.id.movie_top_rb5)
    RadioButton movieTopRb5;
    @BindView(R.id.movie_top_rb6)
    RadioButton movieTopRb6;
    @BindView(R.id.rgMovieHot)
    RadioGroup rgMovieHot;
    @BindView(R.id.rlhs)
    RelativeLayout rlhs;


    private List<String> movieTopViewPageImageList;
    private View view;
    private View[] viewPageView;
    private MovieViewPageAdapter movieViewPageAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if (view == null) {
            view = inflater.inflate(R.layout.fragment_movie, container, false);
            ButterKnife.bind(this, view);

        }
        movieTestViewPageImageAdd();

        return view;
    }

    private void ViewPageInit(List<String> list) {
        viewPageView = new View[list.size()];

        switch (list.size()) {
            case 1:
                movieTopRb1.setVisibility(View.VISIBLE);
                movieTopRb2.setVisibility(View.GONE);
                movieTopRb3.setVisibility(View.GONE);
                movieTopRb4.setVisibility(View.GONE);
                movieTopRb5.setVisibility(View.GONE);
                movieTopRb6.setVisibility(View.GONE);
                break;
            case 2:
                movieTopRb1.setVisibility(View.VISIBLE);
                movieTopRb2.setVisibility(View.VISIBLE);
                movieTopRb3.setVisibility(View.GONE);
                movieTopRb4.setVisibility(View.GONE);
                movieTopRb5.setVisibility(View.GONE);
                movieTopRb6.setVisibility(View.GONE);
                break;
            case 3:
                movieTopRb1.setVisibility(View.VISIBLE);
                movieTopRb2.setVisibility(View.VISIBLE);
                movieTopRb3.setVisibility(View.VISIBLE);
                movieTopRb4.setVisibility(View.GONE);
                movieTopRb5.setVisibility(View.GONE);
                movieTopRb6.setVisibility(View.GONE);
                break;
            case 4:
                movieTopRb1.setVisibility(View.VISIBLE);
                movieTopRb2.setVisibility(View.VISIBLE);
                movieTopRb3.setVisibility(View.VISIBLE);
                movieTopRb4.setVisibility(View.VISIBLE);
                movieTopRb5.setVisibility(View.GONE);
                movieTopRb6.setVisibility(View.GONE);
                break;
            case 5:
                movieTopRb1.setVisibility(View.VISIBLE);
                movieTopRb2.setVisibility(View.VISIBLE);
                movieTopRb3.setVisibility(View.VISIBLE);
                movieTopRb4.setVisibility(View.VISIBLE);
                movieTopRb5.setVisibility(View.VISIBLE);
                movieTopRb6.setVisibility(View.GONE);
                break;

        }

        for (int i = 0; i < viewPageView.length; i++) {
            viewPageView[i] = LayoutInflater.from(getContext()).inflate(R.layout.movie_viewpage_page, null, false);
            ImageView imageView = (ImageView) viewPageView[i].findViewById(R.id.movie_vp_iv);
            Glide.with(getContext())
                    .load(Uri.parse(list.get(i)))
                    .skipMemoryCache(false)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(imageView);
        }
        movieViewPageAdapter = new MovieViewPageAdapter(viewPageView);
        movieViewpage.setAdapter(movieViewPageAdapter);

        movieViewpage.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                int i = position % movieTopViewPageImageList.size();
                switch (position) {
                    case 0:
                        movieTopRb1.setChecked(true);
                        break;
                    case 1:
                        movieTopRb2.setChecked(true);
                        break;
                    case 2:
                        movieTopRb3.setChecked(true);
                        break;
                    case 3:
                        movieTopRb4.setChecked(true);
                        break;
                    case 4:
                        movieTopRb5.setChecked(true);
                        break;
                    case 5:
                        movieTopRb6.setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void movieTestViewPageImageAdd() {
        movieTopViewPageImageList = new ArrayList<>();
        movieTopViewPageImageList.add("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3744774895,3225840198&fm=15&gp=0.jpg");
        movieTopViewPageImageList.add("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1049190591,3919560657&fm=15&gp=0.jpg");
        movieTopViewPageImageList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1488270956716&di=9932f2d4b9bb1dbb28a2f8276c5cc055&imgtype=0&src=http%3A%2F%2Foyster.ignimgs.com%2Fwordpress%2Fstg.ign.com%2F2012%2F09%2Fbatman_costumes_dlc.jpg");
        movieTopViewPageImageList.add("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=729672546,3970663517&fm=15&gp=0.jpg");
        movieTopViewPageImageList.add("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=612885440,2712494941&fm=15&gp=0.jpg");
        movieTopViewPageImageList.add("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3003023416,2465084902&fm=15&gp=0.jpg");


        ViewPageInit(movieTopViewPageImageList);

        carouselImageByThread(false);

    }

    private void carouselImageByThread(boolean b) {
        if (b) {
           new Thread(new Runnable() {
               @Override
               public void run() {

               }
           }).start();
        }
    }
}
