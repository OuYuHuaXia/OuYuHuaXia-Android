package android.bignerdranch.ouyuhuaxia.Login;

import android.bignerdranch.ouyuhuaxia.APIAbout.Api;
import android.bignerdranch.ouyuhuaxia.APIAbout.SimpleResult;
import android.bignerdranch.ouyuhuaxia.BaseClass.BaseFrag;
import android.bignerdranch.ouyuhuaxia.R;
import android.content.Context;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APFrag extends BaseFrag {

    EditText AccountEdit;
    EditText PasswordEdit;

    Context mContext;

    public APFrag(Context context){
        mContext=context;
    }//传入上下文

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.login_ap_frag,container,false);

        AccountEdit=view.findViewById(R.id.account_edit);
        PasswordEdit=view.findViewById(R.id.password_edit);

        //隐藏密码
        TransformationMethod method2 = PasswordTransformationMethod.getInstance();
        PasswordEdit.setTransformationMethod(method2);

        return view;
    }

    @Override
    public void LoginTest() {
//        Retrofit retrofit=new Retrofit.Builder()
//                .baseUrl("")//没服务器
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        Api api=retrofit.create(Api.class);
//        Call<SimpleResult> loginResult=api
//                .LoginTest(AccountEdit.getText().toString().trim()
//                        ,PasswordEdit.getText().toString().trim());
//        loginResult.enqueue(new Callback<SimpleResult>() {
//            @Override
//            public void onResponse(Call<SimpleResult> call, Response<SimpleResult> response) {
//               if (response.body().getMessage()=="登陆成功，获得token"){
//                   LoginSucceed(mContext);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<SimpleResult> call, Throwable t) {
//
//            }
//        });

        LoginSucceed(mContext);

    }
}
