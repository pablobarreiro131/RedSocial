package com.campusdual;

import java.time.LocalDateTime;
import java.util.Date;

public class Comment {

    private String text;
    private LocalDateTime commentDate;
    private User author;

    public Comment(String text, User author){
        this.commentDate = java.time.LocalDateTime.now();
        this.text = text;
        this.author = author;
    }


}
