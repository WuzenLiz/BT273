package com.vcreativeix.oracle.listview;

public class item {
    private int imageView;
    private String title;
    private String author;

    item(int imageView, String title, String author) {
        this.imageView = imageView;
        this.title = title;
        this.author = author;
    }

    public int getImageView() {
        return imageView;
    }

    public void setImageView(int imageView) {
        this.imageView = imageView;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
