package com.example.helloandroid;

import android.app.Application;

public class Check extends Application {
    private boolean login_check;
    private String state_id;
    private String state_pwd;
    public boolean isLogin_check(){
        return  login_check;
    }
    public void setLogin_check(boolean login_check) {
        this.login_check = login_check;
    }

    public String is_Id(){
        return state_id;
    }
    public void setState_id(String state_id){
        this.state_id = state_id;
    }
    public String is_Pwd(){
        return  state_pwd;
    }
    public void setState_pwd(String state_pwd){
        this.state_pwd = state_pwd;
    }
}
