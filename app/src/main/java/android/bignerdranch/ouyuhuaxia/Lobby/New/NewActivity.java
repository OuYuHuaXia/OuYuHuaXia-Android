package android.bignerdranch.ouyuhuaxia.Lobby.New;

import android.app.Activity;
import android.bignerdranch.ouyuhuaxia.BaseClass.BaseAct;
import android.bignerdranch.ouyuhuaxia.R;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class NewActivity extends BaseAct {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lobby_new_post);

        int statusBarHeight = getStatusBarHeight();

        // Find the placeholder view in your layout
        View statusBarPlaceholder = findViewById(R.id.view);

        // Set the height of the placeholder view to the status bar height
        ViewGroup.LayoutParams layoutParams = statusBarPlaceholder.getLayoutParams();
        layoutParams.height = statusBarHeight;
        statusBarPlaceholder.setLayoutParams(layoutParams);
    }


}

