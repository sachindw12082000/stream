package com.stream.stream.level3;

import java.util.List;

public class BlogPost3 {
    private String title;
    private String author;
    private String category;
    private int likes;
    private List<String> tags;

    public BlogPost3() {
    }

    public BlogPost3(String title, String author, String category, int likes, List<String> tags) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.likes = likes;
        this.tags = tags;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "BlogPost3{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", category='" + category + '\'' +
                ", likes=" + likes +
                ", tags=" + tags +
                '}';
    }
}
