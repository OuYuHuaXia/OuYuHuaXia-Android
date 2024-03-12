package android.bignerdranch.ouyuhuaxia.Lobby.Home.Frags;

import android.bignerdranch.ouyuhuaxia.DataClass.Posts;
import android.bignerdranch.ouyuhuaxia.Lobby.PostListView.PostsAdapter;
import android.bignerdranch.ouyuhuaxia.R;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import java.util.List;

public class Frag1 extends Fragment {

    private int i;

    private RecyclerView mRecyclerview;
    private PostsAdapter mAdapter;
    private SwipeRefreshLayout mSwipeRefreshLayout;

    private RadioButton FollowViewBtn;
    private RadioButton FindViewBtn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.home_frag1,container,false);

        mRecyclerview=view.findViewById(R.id.home_choose1_rec);
        mRecyclerview.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

        mSwipeRefreshLayout=view.findViewById(R.id.refresh);
        mSwipeRefreshLayout.setEnabled(true);
        mSwipeRefreshLayout.setRefreshing(false);

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                reFreshAdapter();
            }
        });

        FollowViewBtn=view.findViewById(R.id.home_follow);
        FollowViewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reFreshAdapter();
            }
        });

        FindViewBtn=view.findViewById(R.id.home_find);
        FindViewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reFreshAdapter();
            }
        });

        setAdapterAbout();

        return view;
    }

    private void setAdapterAbout(){
        List<Posts> mList=Posts.getPostsList();
        mAdapter=new PostsAdapter(mList,getActivity());
        mRecyclerview.setAdapter(mAdapter);
    }

    public void reFreshAdapter(){
        i=(int)(System.currentTimeMillis()%38);
        mAdapter.setI(i);
        mAdapter.notifyDataSetChanged();
        mSwipeRefreshLayout.setRefreshing(false);
    }
}
