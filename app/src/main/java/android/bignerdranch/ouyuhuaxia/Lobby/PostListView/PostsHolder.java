package android.bignerdranch.ouyuhuaxia.Lobby.PostListView;

import android.bignerdranch.ouyuhuaxia.DataClass.Posts;
import android.bignerdranch.ouyuhuaxia.R;
import android.content.Context;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PostsHolder extends RecyclerView.ViewHolder {

    private Context context;

    private Posts mP;

    private TextView mTitle;
    private TextView mPublisher;
    private TextView mLikeNum;
    private ImageView mPostPic;
    private ImageButton mLikeBtn;
    private int i=-1;
    private boolean like=false;

    public void setI(int i) {
        this.i=i;
    }

    public PostsHolder(@NonNull View itemView,Context context) {
        super(itemView);

        this.context=context;

        mTitle=itemView.findViewById(R.id.post_title);
        mPublisher=itemView.findViewById(R.id.post_publisher);
        mPostPic=itemView.findViewById(R.id.post_pic);
        mLikeNum=itemView.findViewById(R.id.like_num);


        mLikeBtn=itemView.findViewById(R.id.like_btn);
        mLikeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                like=!like;
                int delta=like?1:-1;
                mP.setLikesNum(mP.getLikesNum()+delta);
                bind();
            }
        });
    }


    public void setmP(Posts posts){
        mP=posts;
        bind();
    }


    public void bind(){
        mTitle.setText(mP.getTitle());
        mPublisher.setText(mP.getPublisher());
        mLikeNum.setText(mP.getLikesNum()+"");
        if (like){
            mLikeBtn.setBackgroundResource(R.drawable.demoliked);
        }else {
            mLikeBtn.setBackgroundResource(R.drawable.demolike);
        }
        String name="demopic"+i;
        int i= context.getResources().getIdentifier(name,"drawable", context.getPackageName());
        mPostPic.setImageResource(i);
    }
}
