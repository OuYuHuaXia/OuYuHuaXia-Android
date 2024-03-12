package android.bignerdranch.ouyuhuaxia.Lobby.Cmnc;

import android.bignerdranch.ouyuhuaxia.BaseClass.BaseFrag;
import android.bignerdranch.ouyuhuaxia.DataClass.Posts;
import android.bignerdranch.ouyuhuaxia.LayoutTools.SquareButton;
import android.bignerdranch.ouyuhuaxia.Lobby.PostListView.PostsAdapter;
import android.bignerdranch.ouyuhuaxia.R;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import java.util.List;

public class CmncFrag extends BaseFrag {

    private SquareButton mSearchBtn;
    private RecyclerView mRecyclerView;
    private PostsAdapter mAdapter;

    private SwipeRefreshLayout mSwipeRefreshLayout;

    private List<Posts> mList;

    private int i;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.lobby_cmnc_frag,container,false);

        mSearchBtn=(SquareButton) view.findViewById(R.id.search_btn);

        mRecyclerView=(RecyclerView) view.findViewById(R.id.cmnc_recyclerview);
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

        mSwipeRefreshLayout=view.findViewById(R.id.refresh);
        mSwipeRefreshLayout.setEnabled(true);
        mSwipeRefreshLayout.setRefreshing(false);

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                reFreshAdapter();
            }
        });

        setAdapterAbout();

        return view;
    }

    private void setAdapterAbout() {
        mList=Posts.getPostsList();
        mAdapter=new PostsAdapter(mList,getActivity());
        mRecyclerView.setAdapter(mAdapter);
    }

    public void reFreshAdapter(){
        i=(int)(System.currentTimeMillis()%38);
        mAdapter.setI(i);
        mAdapter.notifyDataSetChanged();
        mSwipeRefreshLayout.setRefreshing(false);
    }
}
