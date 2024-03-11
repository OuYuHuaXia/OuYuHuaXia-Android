package android.bignerdranch.ouyuhuaxia.Lobby.Home;

import android.bignerdranch.ouyuhuaxia.BaseClass.BaseFrag;
import android.bignerdranch.ouyuhuaxia.Lobby.Home.Frags.Frag1;
import android.bignerdranch.ouyuhuaxia.R;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class HomeFrag extends BaseFrag {

    private RadioGroup mTopRadio;

    private RadioButton mChoose1;
    private RadioButton mChoose2;
    private RadioButton mChoose3;

    private FragmentManager manager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.lobby_home_frag,container,false);

        Typeface typeface= Typeface.createFromAsset(getActivity().getAssets(),"STXingkai.ttf");//找到字体文件

        mChoose1=view.findViewById(R.id.choose1);
        mChoose2=view.findViewById(R.id.choose2);
        mChoose3=view.findViewById(R.id.choose3);
        mChoose1.setTypeface(typeface);
        mChoose2.setTypeface(typeface);
        mChoose3.setTypeface(typeface);

        Frag1 frag1=new Frag1();


        manager=getChildFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
        transaction.replace(R.id.home_frag,frag1);

        transaction.commitNow();

        mTopRadio=view.findViewById(R.id.home_top_radios);
        mTopRadio.check(R.id.choose1);//实在不知道怎么起名只能写choose1 2 3了

        mTopRadio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                switch (id){
                    case R.id.choose1://transaction.commitNow();
                    case R.id.choose2:
                    case R.id.choose3:
                }
            }
        });
        

        return view;
    }
}
