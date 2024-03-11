package android.bignerdranch.ouyuhuaxia.BaseClass;

import android.app.Activity;
import android.bignerdranch.ouyuhuaxia.Lobby.LobbyActivity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.fragment.app.Fragment;

//基础Fragment，完成一些ViewPager，RadioButton控制的Frag都需要使用的方法
public class BaseFrag extends Fragment {

    public void LoginTest() {
        Log.d("BaseFrag", "LoginTest！");
    }//登陆界面的两种登录方式都需要重写此方法以尝试登录


    //同上，不需重写直接调用即可
    protected void LoginSucceed(Context context) {
        Intent intent = new Intent(context, LobbyActivity.class);
        startActivity(intent);
        ((Activity) context).finish();//上下文强制类型转换为Activity并销毁（这里销毁的是登录界面）
    }

}
