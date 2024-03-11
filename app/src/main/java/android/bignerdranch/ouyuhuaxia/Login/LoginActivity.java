package android.bignerdranch.ouyuhuaxia.Login;

import android.bignerdranch.ouyuhuaxia.BaseClass.BaseAct;
import android.bignerdranch.ouyuhuaxia.BaseClass.BaseFrag;
import android.bignerdranch.ouyuhuaxia.Lobby.LobbyActivity;
import android.bignerdranch.ouyuhuaxia.R;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.fragment.app.Fragment;

public class LoginActivity extends BaseAct {

    Button LoginBtn;


    RadioButton APLoginBtn;//账号密码登录
    RadioButton MVCLoginBtn;//邮箱验证码登录

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_act);

        Typeface typeface= Typeface.createFromAsset(getAssets(),"STXingkai.ttf");//找到字体文件


        //总共就俩，而且还得设字体，就分开写了
        APLoginBtn=findViewById(R.id.ap_login_btn);
        APLoginBtn.setTypeface(typeface);
        APLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchFragment(new APFrag(LoginActivity.this));
            }
        });

        MVCLoginBtn=findViewById(R.id.mvc_login_btn);
        MVCLoginBtn.setTypeface(typeface);
        MVCLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchFragment(new MVCFrag(LoginActivity.this));
            }
        });

        LoginBtn=(Button)findViewById(R.id.login_btn);
        LoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((BaseFrag) getSupportFragmentManager().findFragmentById(R.id.login_frag)).LoginTest();
                //获取当前的Fragment并调用对应的LoginTest方法
            }
        });


        //添加初始Fragment
        switchFragment(new APFrag(LoginActivity.this));

    }

    private void switchFragment(Fragment fg){
        getSupportFragmentManager().beginTransaction().replace(R.id.login_frag, fg).commit();
    }
}
