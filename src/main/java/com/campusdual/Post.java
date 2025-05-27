package com.campusdual;

import java.time.LocalDateTime;
import java.util.TreeSet;

public abstract class Post {

    private LocalDateTime postDate;
    private int postId;
    private String title;
    protected static int postNumber = 0;
    private TreeSet<Comment> commentList;

    public Post(String title) {
        this.title = title;
        this.postDate = LocalDateTime.now();
        this.commentList = new TreeSet<>();
        this.postId = postNumber++;
    }

    public String getTitle() {
        return title;
    }

    public int getPostId() {
        return postId;
    }

    public LocalDateTime getPostDate() {
        return postDate;
    }

    public TreeSet<Comment> getCommentList() {
        return commentList;
    }

    public int commentNumber(){
        int i = 0;
        for (Comment comment: this.getCommentList()){
            i++;
        }
        return i;
    }
}



