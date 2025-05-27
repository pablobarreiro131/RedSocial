package com.campusdual;

import java.util.*;

public class User {

    private String name;
    private int userId;
    private static int userCount = 0;
    private HashSet<Integer> followedUsers;
    private TreeSet<Post> postList;
    private TreeSet<Comment> commentList;

    public User(String name){
        this.name = name;
        this.followedUsers = new HashSet<>();
        this.postList = new TreeSet<>();
        this.commentList = new TreeSet<>();
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

    public TreeSet<Post> getPostList() {
        return postList;
    }

    public TreeSet<Comment> getCommentList() {
        return commentList;
    }


}
