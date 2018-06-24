package com.hfl.tom;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    String[] titleList=new String[]{ "动画","动漫"};
    int[] images={R.mipmap.ani,R.mipmap.video};
    ViewPager viewPager;
    List<Fragment> fragmentList=new ArrayList<>();
    AniFragment aniFragment;
    VideoFragment videoFragment;
    FPAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout=(TabLayout)findViewById(R.id.tab_layout);
        viewPager=(ViewPager)findViewById(R.id.view_pager);

        tabLayout.addTab(tabLayout.newTab().setText(titleList[0]));
        tabLayout.addTab(tabLayout.newTab().setText(titleList[1]));
//        for(int i=0;i<tabLayout.getTabCount();i++){
//            TabLayout.Tab tab=tabLayout.getTabAt(i);
//            tab.setCustomView(adapter.getTabView(i));
//        }

        aniFragment=new AniFragment();
        videoFragment=new VideoFragment();
        fragmentList.add(aniFragment);
        fragmentList.add(videoFragment);

        adapter=new FPAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }


    public class FPAdapter extends FragmentPagerAdapter{

        public FPAdapter(FragmentManager fm) {
            super(fm);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return titleList[position];
//            SpannableString sp=new SpannableString(""+titleList[position]);
//            Drawable image=getApplicationContext().getResources().getDrawable(images[position]);
//            image.setBounds(0,0,image.getIntrinsicWidth(),image.getIntrinsicHeight());
//            ImageSpan imageSpan=new ImageSpan(image,ImageSpan.ALIGN_BOTTOM);
//            sp.setSpan(imageSpan,0,1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//            return sp;
//            return null;
        }
//        public View getTabView(int position){
//            View view= LayoutInflater.from(getApplicationContext()).inflate(R.layout.tab,null);
//            ImageView im=(ImageView)view.findViewById(R.id.iv);
//            TextView tv=(TextView)view.findViewById(R.id.tv);
//            im.setImageResource(images[position]);
//            tv.setText(titleList[position]);
//            return  view;
//        }
        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.other:
                Toast.makeText(this,"Not Setting For The App!",Toast.LENGTH_SHORT).show();
                break;
            case R.id.back:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
