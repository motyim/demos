/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package me.motyim.learn.spring.UploadFilesSpring.controller;

/**
 * @author MotYim <mohamed.motyim@gmail.com>
 * @since Feb 7, 2018 
 */
class UserSignUpRequest {
    String name ;
    String age ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
    
    
}
