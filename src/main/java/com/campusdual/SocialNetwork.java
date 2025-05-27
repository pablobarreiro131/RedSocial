package com.campusdual;

import java.util.HashMap;

public class SocialNetwork {

    private static HashMap<Integer, User> userDatabase = new HashMap<>();
    private static HashMap <Integer, Post> postDatabase = new HashMap<>();
    private static HashMap <Integer, Comment> commentDatabase = new HashMap<>();

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

    public static void uploadText (String content, String title, User author){
        Text text = new Text(content, title);
        author.getPostList().add(text);
        SocialNetwork.getPostDatabase().put(text.getPostId(),text);
    }
    public static void uploadImage (String title, String size, User author){
        Image image = new Image(title, size);
        author.getPostList().add(image);
        SocialNetwork.getPostDatabase().put(image.getPostId(),image);
    }

    public static void uploadVideo (String title, String quality, int duration, User author){
        Video video = new Video(title, quality, duration);
        author.getPostList().add(video);
        SocialNetwork.getPostDatabase().put(video.getPostId(),video);
    }

    public static void printList(User user){
        for (Post post : user.getPostList()) {
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

    public boolean checkUser(User user, User selected){
        if (user.equals(selected)){
            return true;
        }
        else return false;
    }

    public static HashMap<Integer, Comment> getCommentDatabase() {
        return commentDatabase;
    }

    public static void createComment(String texto, User author, Post post){
        Comment comment = new Comment(texto, author, post);
        commentDatabase.put(comment.getCommentId(),comment);
        author.getCommentList().add(comment);
        post.getCommentList().add(comment);
    }

    public static boolean deleteComment(int commentId){
        if (!commentDatabase.containsKey(commentId)){
            return false;
        }
        else{
            for (User user: userDatabase.values()){
                user.getCommentList().remove(commentDatabase.get(commentId));
                for(Post post: user.getPostList()){
                    post.getCommentList().remove(commentDatabase.get(commentId));
                }
            }
            commentDatabase.remove(commentId);
            return true;
        }
    }

    public static void userCommentList(User user){
        for (Comment comment: user.getCommentList()){
            System.out.println("ID del comentario: " + comment.getCommentId() + ", Fecha: " + comment.getCommentDate().toString() + ", Comentario: " + comment.getText());
        }
    }
}
