/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pbo.quizoop.athallah;

/**
 *
 * @author ThinkPad
 */
public class User {
    private String username = "user";
    private String password = "user";
    
    public boolean authenticate(String inputUser, String inputPass) {
        return inputUser.equals(username) && inputPass.equals(password);
    }
}