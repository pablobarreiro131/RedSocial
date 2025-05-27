package com.campusdual;

public class Text extends Post {

    private String content;


    public Text(String content, String title) {
        super(title);
        this.content = content;
    }

    public String getContent() {
        return content;
    }

}
