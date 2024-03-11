package android.bignerdranch.ouyuhuaxia.Login;

import android.bignerdranch.ouyuhuaxia.BaseClass.BaseFrag;
import android.bignerdranch.ouyuhuaxia.R;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MVCFrag extends BaseFrag {

    EditText MEdit;
    EditText VCEdit;

    Context mContext;

    public MVCFrag(Context context){
        mContext=context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.login_mvc_frag,container,false);

        MEdit=view.findViewById(R.id.mail_edit);
        VCEdit=view.findViewById(R.id.vc_edit);

        return view;
    }

    @Override
    public void LoginTest() {
        LoginSucceed(mContext);
    }
}
