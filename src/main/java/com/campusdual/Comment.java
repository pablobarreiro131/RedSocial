package com.campusdual;

import java.time.LocalDateTime;
import java.util.Date;

public class Comment {

    private String text;
    private LocalDateTime commentDate;
    private User author;
    private Post post;
    private static int commentCount = 0;
    private int commentId;

    public Comment(String text, User author, Post post){
        this.commentDate = java.time.LocalDateTime.now();
        this.text = text;
        this.author = author;
        this.post = post;
        this.commentId = commentCount++;
    }

    public String getText() {
        return text;
    }

    public LocalDateTime getCommentDate() {
        return commentDate;
    }

    public User getAuthor() {
        return author;
    }

    public Post getPost() {
        return post;
    }

    public static int getCommentCount() {
        return commentCount;
    }

    public int getCommentId() {
        return commentId;
    }
}
