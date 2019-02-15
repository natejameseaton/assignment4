/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg;

import java.sql.Timestamp;

/**
 *
 * @author Nate
 */
    
    // Declare variables for blog posts
    // id, userID(author), title, createdTime(timestamp), contents(post)
public class Post {
    private int id;
    private int user_id;
    private String title;
    private Timestamp createdTime;
    private String contents;

    public Post(int id, int user_id, String title, Timestamp createdTime, String contents) {
        this.id = id;
        this.user_id = user_id;
        this.title = title;
        this.createdTime = createdTime;
        this.contents = contents;
    }
    
    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int userid) {
        this.user_id = userid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Timestamp getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
    
    
    
}
