/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pbo.quizoop.athallah;

/**
 *
 * @author ThinkPad
 */
class ActionMovie extends Movie {
    public ActionMovie(String title) {
        super(title);
    }
    
    @Override
    public String getGenre() {
        return "Action";
    }
}
