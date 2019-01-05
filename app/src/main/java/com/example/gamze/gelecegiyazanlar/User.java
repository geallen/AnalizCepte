package com.example.gamze.gelecegiyazanlar;

/**
 * Created by Gamze on 11/17/2018.
 */

public class User {
    String username;
    String oy;

    public User(){}
    public User(String username, String oy) {
        this.oy = oy;
        this.username = username;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOy() {
        return oy;
    }

    public void setOy(String oy) {
        this.oy = oy;
    }

}
