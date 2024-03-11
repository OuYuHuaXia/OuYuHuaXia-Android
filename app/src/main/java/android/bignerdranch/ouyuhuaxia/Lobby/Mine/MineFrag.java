package android.bignerdranch.ouyuhuaxia.Lobby.Mine;

import android.bignerdranch.ouyuhuaxia.BaseClass.BaseFrag;
import android.bignerdranch.ouyuhuaxia.DataClass.Posts;
import android.bignerdranch.ouyuhuaxia.Lobby.PostListView.PostsAdapter;
import android.bignerdranch.ouyuhuaxia.R;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MineFrag extends BaseFrag {

    RecyclerView mRecyclerview;
    RadioGroup mRadioGroup;

    PostsAdapter mAdapter;

    private int index=1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.lobby_mine_frag,container,false);

        mRadioGroup=view.findViewById(R.id.mine_choose);
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.mine_favorites:index=1;break;
                    case R.id.mine_works:index=2;break;
                }
                setAdapterAbout();
            }
        });

        mRecyclerview=view.findViewById(R.id.mine_recyclerview);
        mRecyclerview.setLayoutManager(new GridLayoutManager(getActivity(),2));

        setAdapterAbout();

        return view;

    }

    private void setAdapterAbout(){
        List<Posts> mList=Posts.getPostsList();
        mAdapter=new PostsAdapter(mList,getActivity());
        mRecyclerview.setAdapter(mAdapter);
    }
}
