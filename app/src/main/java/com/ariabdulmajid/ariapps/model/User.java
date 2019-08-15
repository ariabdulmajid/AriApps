package com.ariabdulmajid.ariapps.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * 14-08-2019, 10116322 - ARI ABDUL MAJID - IF8
 */


@Entity(tableName = "User")
public class User {

    @PrimaryKey
    @NonNull
    private String username;
    private String namalengkap, password;

    public User(String username, String namalengkap, String password) {
        this.username = username;
        this.namalengkap = namalengkap;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNamalengkap() {
        return namalengkap;
    }

    public void setNamalengkap(String namalengkap) {
        this.namalengkap = namalengkap;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
