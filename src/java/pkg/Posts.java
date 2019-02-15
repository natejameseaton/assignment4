/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author c0711874
 */

@Named
@ApplicationScoped

// Retrieve post list objects for arraylist
public class Posts {
    
    private List<Post> posts;
    private Post currentPost;
    
    public Posts() {
        currentPost = new Post(-1, -1, "", null, "");
        getPostsFromDatabase();
    }

        private void getPostsFromDatabase() {
        try {
            Connection conn = DBUtils.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM posts");
            posts = new ArrayList<>();
            while (rs.next()) {
                Post p = new Post(
                        rs.getInt("id"),
                        rs.getInt("user_id"),
                        rs.getString("title"),
                        rs.getTimestamp("created_time"),
                        rs.getString("contents")
                );
                posts.add(p);
            }       } 
        catch (SQLException ex) {
            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
            posts = new ArrayList<>();
        }
    }
      
    // Get and set current post
    public Post getCurrentPost() {
        return currentPost;
    }

    public void setCurrentPost(Post currentPost) {
        this.currentPost = currentPost;
    }
    
    public List <Post>getPosts() {
    return posts;
    }
    
    // Add a post - Maybe add if have time at end?
    public String addPost() {
        currentPost = new Post(-1, -1, "", null, "");
        return "editPost";
    }
    
    public String viewPost(Post p) {
        currentPost = p;
        return "viewpost";
    }
      
}

