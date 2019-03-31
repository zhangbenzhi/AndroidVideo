package com.tianzl.androidvideo;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.support.design.widget.TabLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.tianzl.androidvideo.adapter.ViewPagerAdapter;
import com.tianzl.androidvideo.fragment.FileFragment;
import com.tianzl.androidvideo.fragment.NetFragment;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private TextView tvTitle;
    private ViewPager viewPager;
    private TabLayout tableLayout;
    private String[] attr=new String[]{"本地视频","网络视频"};
    private List<Fragment> fragments;
    private FileFragment fileFragment;
    private NetFragment netFragment;
    private ViewPagerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        fragments=new ArrayList<>();
        fileFragment=new FileFragment();
        netFragment=new NetFragment();
        fragments.add(fileFragment);
        fragments.add(netFragment);
        tableLayout.addTab(tableLayout.newTab().setText(attr[0]));
        tableLayout.addTab(tableLayout.newTab().setText(attr[1]));
        adapter=new ViewPagerAdapter(getSupportFragmentManager(),this,attr,fragments);
        viewPager.setAdapter(adapter);
        tableLayout.setupWithViewPager(viewPager);

    }

    private void initView() {
        tvTitle= (TextView) findViewById(R.id.main_title);
        viewPager= (ViewPager) findViewById(R.id.main_viewpager);
        tableLayout= (TabLayout) findViewById(R.id.main_tab);
    }

}
