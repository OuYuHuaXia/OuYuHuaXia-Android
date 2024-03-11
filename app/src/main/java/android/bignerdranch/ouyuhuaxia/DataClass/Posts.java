package android.bignerdranch.ouyuhuaxia.DataClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Posts {
    private String postsId;

    private int LikesNum;
    private String publisher;
    private String Title;

    public int getLikesNum() {
        return LikesNum;
    }

    public void setLikesNum(int likesNum) {
        LikesNum = likesNum;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getPostsId() {
        return postsId;
    }

    public Posts(String publisherName, String title) {
        this.publisher = publisherName;
        Title = title;
    }

    public static List<Posts> getPostsList(){

        List<Posts> postsList=new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Posts posts=new Posts("发布者"+(i+1),"帖子"+(i+1));

            Random random=new Random();
            posts.setLikesNum(random.nextInt(100));
            postsList.add(posts);
        }
        return postsList;
    }
}
