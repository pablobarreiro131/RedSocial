package com.campusdual;

import java.time.LocalDateTime;

public abstract class Post {

    private LocalDateTime postDate;
    private int postId;
    private String title;
    protected static int postNumber = 0;

    public Post(String title) {
        this.title = title;
        this.postDate = LocalDateTime.now();
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

    public abstract void commentList();
}
