package android.bignerdranch.ouyuhuaxia;

import android.bignerdranch.ouyuhuaxia.BaseClass.BaseAct;
import android.bignerdranch.ouyuhuaxia.Login.LoginActivity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends BaseAct {

    Button LoginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LoginBtn=(Button) findViewById(R.id.login_btn);
        Drawable drawable=getResources().getDrawable(R.drawable.login_button);
        LoginBtn.setBackground(drawable);//设置Btn背景

        LoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

    }
}
