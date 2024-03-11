package android.bignerdranch.ouyuhuaxia.Lobby;

import android.bignerdranch.ouyuhuaxia.BaseClass.BaseAct;
import android.bignerdranch.ouyuhuaxia.BaseClass.BaseFrag;
import android.bignerdranch.ouyuhuaxia.Lobby.Cmnc.CmncFrag;
import android.bignerdranch.ouyuhuaxia.Lobby.Demo.DemoFrag;
import android.bignerdranch.ouyuhuaxia.Lobby.Home.HomeFrag;
import android.bignerdranch.ouyuhuaxia.Lobby.Mine.MineFrag;
import android.bignerdranch.ouyuhuaxia.Lobby.New.NewActivity;
import android.bignerdranch.ouyuhuaxia.R;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

public class LobbyActivity extends BaseAct {

    private ViewPager contentPager;//四个界面所用的ViewPager，支持滑动切换界面
    private ContentPagerAdapter pagersAdapter;
    private RadioGroup navigation;//另外实现导航栏的点击切换功能


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lobby_act);

        int statusBarHeight = getStatusBarHeight();

        View statusBarPlaceholder = findViewById(R.id.view);


        ViewGroup.LayoutParams layoutParams = statusBarPlaceholder.getLayoutParams();
        layoutParams.height = statusBarHeight;
        statusBarPlaceholder.setLayoutParams(layoutParams);

        navigation = (RadioGroup) findViewById(R.id.navigation_bar);
        //通过重写RadioGroup的此方法来实现点击切换功能
        navigation.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                switch (checkedId) {
                    case R.id.demo_btn:
                        contentPager.setCurrentItem(1,true);//第二个参数为是否是平滑切换（平移动画）
                        break;
                    case R.id.cmnc_btn:
                        contentPager.setCurrentItem(2,true);
                        break;
                    case R.id.mine_btn:
                        contentPager.setCurrentItem(3,true);
                        break;
                    case R.id.home_btn:
                    default:
                        contentPager.setCurrentItem(0,true);
                        break;
                }
            }
        });

        contentPager = (ViewPager) findViewById(R.id.lobby_view);

        List<BaseFrag> list = new ArrayList<>();
        list.add(new HomeFrag());
        list.add(new DemoFrag());
        list.add(new CmncFrag());
        list.add(new MineFrag());
        FragmentManager fragmentManager = getSupportFragmentManager();
        pagersAdapter = new ContentPagerAdapter(fragmentManager, list);
        contentPager.setAdapter(pagersAdapter);
        contentPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 1:navigation.check(R.id.demo_btn);break;
                    case 2:navigation.check(R.id.cmnc_btn);break;
                    case 3:navigation.check(R.id.mine_btn);break;
                    case 0:
                    default:navigation.check(R.id.home_btn);break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }


    public class ContentPagerAdapter extends FragmentStatePagerAdapter {
        private final List<BaseFrag> datas;

        public ContentPagerAdapter(@NonNull FragmentManager fm, List<BaseFrag> datas) {
            super(fm);
            this.datas = datas;
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return datas.get(position);
        }

        @Override
        public int getCount() {
            return datas.size();
        }
    }


}
