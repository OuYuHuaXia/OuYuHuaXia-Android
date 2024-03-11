package android.bignerdranch.ouyuhuaxia.APIAbout;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Api {


    //登录
    @POST("login")
    Call<SimpleResult> LoginTest(@Field("username") String username, @Field("password")String password);
}
