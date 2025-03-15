/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pbo.quizoop.athallah;

/**
 *
 * @author ThinkPad
 */
abstract class Movie {
    protected String title;
    protected int price = 20000;
    
    public Movie(String title) {
        this.title = title;
    }
    
    public abstract String getGenre();
    
    public String getTitle() {
        return title;
    }
    
    public int getPrice() {
        return price;
    }
}
