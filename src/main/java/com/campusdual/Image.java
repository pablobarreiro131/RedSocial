package com.campusdual;

public class Image extends Post {

    private String size;

    @Override
    public void commentList() {
        // implementación pendiente
    }

    public Image(String title, String size) {
        super(title);
        this.size = size;
    }


    public String getSize() {
        return size;
    }
}
