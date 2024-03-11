package android.bignerdranch.ouyuhuaxia.Lobby.PostListView;

import android.bignerdranch.ouyuhuaxia.DataClass.Posts;
import android.bignerdranch.ouyuhuaxia.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter {

    private Context context;

    private List<Posts> mList;

    private int i;

    public PostsAdapter(List<Posts> mList,Context context) {
        this.mList = mList;
        this.context=context;
        i=(int)(System.currentTimeMillis()%38);
    }

    public void setI(int i){
        this.i=i;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PostsHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post_mine,parent,false),context);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Posts item=mList.get(position);
        ((PostsHolder)holder).setI(i++%38);
        ((PostsHolder)holder).setmP(item);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
