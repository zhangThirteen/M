package com.zyy.m;


import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;


import com.makeramen.roundedimageview.RoundedImageView;
import com.zyy.m.message.MessageFragment;
import com.zyy.m.montage.MontageFragment;
import com.zyy.m.movies.MoviesFragment;
import com.zyy.m.my.MyFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.rounded_header_image)
    RoundedImageView roundedHeaderImage;
    @BindView(R.id.header)
    LinearLayout header;
    @BindView(R.id.movie_rb)
    RadioButton movieRb;
    @BindView(R.id.message_rb)
    RadioButton messageRb;
    @BindView(R.id.montage_rb)
    RadioButton montageRb;
    @BindView(R.id.my_rb)
    RadioButton myRb;
    @BindView(R.id.main_rg)
    RadioGroup mainRg;
    @BindView(R.id.header_search)
    LinearLayout headerSearch;

    //fragment实例创建
    private MoviesFragment moviesFragment;
    private MessageFragment messageFragment;
    private MontageFragment montageFragment;
    private MyFragment myFragment;
    private Fragment currentFragment;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //沉浸式状态栏调用
        setStatusBar();

        //为Fragment赋值，并设置初始显示的fragment
        initFragmentData();


        //下方导航栏切换
        mainRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.movie_rb:
                        showFragment(moviesFragment);
                        break;
                    case R.id.message_rb:
                        showFragment(messageFragment);
                        break;
                    case R.id.montage_rb:
                        showFragment(montageFragment);
                        break;
                    case R.id.my_rb:
                        showFragment(myFragment);
                        break;

                }
            }
        });

    }

    private void initFragmentData() {
        moviesFragment = new MoviesFragment();
        messageFragment = new MessageFragment();
        montageFragment = new MontageFragment();
        myFragment = new MyFragment();
        currentFragment = moviesFragment;
        showFragment(moviesFragment);
    }

    private void showFragment(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if (!fragment.isAdded()) {
            ft.add(R.id.main_fl,fragment);
        }
        ft.hide(currentFragment).show(fragment);
        ft.commit();
        currentFragment = fragment;

    }


    public void setStatusBar() {

        if (Build.VERSION.SDK_INT >= 23) {
            Window window = this.getWindow();
            //取消设置透明状态栏,使 ContentView 内容不再覆盖状态栏
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

//需要设置这个 flag 才能调用 setStatusBarColor 来设置状态栏颜色
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//设置状态栏颜色

            window.setStatusBarColor(this.getResources().getColor(R.color.top));

            ViewGroup mContentView = (ViewGroup) this.findViewById(Window.ID_ANDROID_CONTENT);
            View mChildView = mContentView.getChildAt(0);
            if (mChildView != null) {
                //注意不是设置 ContentView 的 FitsSystemWindows, 而是设置 ContentView 的第一个子 View . 预留出系统 View 的空间.
                ViewCompat.setFitsSystemWindows(mChildView, true);
            }
        }
    }


}





