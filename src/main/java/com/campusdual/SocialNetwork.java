package com.campusdual;

import java.util.HashMap;

public class SocialNetwork {

    private static HashMap<Integer, User> userDatabase = new HashMap<>();
    private static HashMap <Integer, Post> postDatabase = new HashMap<>();

    public static void createUser(String name){
        User user = new User(name);
        userDatabase.put(user.getUserId(), user);
    }

    public static HashMap<Integer, User> getUserDatabase() {
        return userDatabase;
    }

    public static User searchUserByName(String name){
        for (User user: userDatabase.values()){
            if (user.getName().equalsIgnoreCase(name)){
                return user;
            }
        } return null;
    }

    public static Post searchPostByTitle(String title){
        for (Post post: postDatabase.values()){
            if (post.getTitle().equalsIgnoreCase(title)){
                return post;
            }
        } return null;
    }

    public static boolean deleteUser (int userId){
        if (!userDatabase.containsKey(userId)){
            return false;
        }
        else {
            userDatabase.remove(userId);
            for (User user: userDatabase.values()){
                user.stopFollowingUser(userId);
            }
            return true;
        }
    }

    public static HashMap<Integer, Post> getPostDatabase() {
        return postDatabase;
    }

    public static boolean deletePost(int postId){
        if (!postDatabase.containsKey(postId)){
            return false;
        }
        else{
            userDatabase.remove(postId);
            for (User user: userDatabase.values()){
                for(Post post: user.getPostList()){
                    if (post.getPostId() == postId){
                        user.getPostList().remove(post);
                    }
                }
            }
        }
        return true;
    }
}
