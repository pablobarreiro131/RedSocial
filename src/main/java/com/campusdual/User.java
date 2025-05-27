package com.campusdual;

import java.util.*;

public class User {

    private String name;
    private int userId;
    private static int userCount = 0;
    private HashSet<Integer> followedUsers;
    private TreeSet<Post> postList;

    public User(String name){
        this.name = name;
        this.followedUsers = new HashSet<>();
        this.postList = new TreeSet<>();
        this.userId = userCount++;
    }

    public void followUser (int userId){
        this.followedUsers.add(userId);
    }

    public void stopFollowingUser(int userId){
        this.followedUsers.remove(userId);
    }


    public String getName() {
        return name;
    }

    public int getUserId() {
        return userId;
    }

    public static int getUserCount() {
        return userCount;
    }

    public HashSet<Integer> getFollowedUsers() {
        return followedUsers;
    }

    public void uploadText (String content, String title){
        Text text = new Text(content, title);
        this.postList.add(text);
        SocialNetwork.getPostDatabase().put(text.getPostId(),text);
    }
    public void uploadImage (String title, String size){
        Image image = new Image(title, size);
        this.postList.add(image);
        SocialNetwork.getPostDatabase().put(image.getPostId(),image);
    }

    public void uploadVideo (String title, String quality, int duration){
        Video video = new Video(title, quality, duration);
        this.postList.add(video);
        SocialNetwork.getPostDatabase().put(video.getPostId(),video);
    }

    public TreeSet<Post> getPostList() {
        return postList;
    }

    public void printList(){
        for (Post post : this.postList) {
            System.out.print("Post ID: " + post.getPostId() + ", Tipo: " + post.getClass().getSimpleName());

            if (post instanceof Text) {
                Text text = (Text) post;
                System.out.println(", Título: " + text.getTitle() + ", Contenido: " + text.getContent());
            } else if (post instanceof Image) {
                Image image = (Image) post;
                System.out.println(", Título: " + image.getTitle() + ", Tamaño: " + image.getSize());
            } else if (post instanceof Video) {
                Video video = (Video) post;
                System.out.println(", Título: " + video.getTitle() + ", Calidad: " + video.getQuality() + ", Duración: " + video.getDuration() + " seg");
            } else {
                System.out.println();
            }
        }
    }
}
