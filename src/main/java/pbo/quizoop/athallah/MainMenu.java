/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pbo.quizoop.athallah;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author ThinkPad
 */
public class MainMenu extends JFrame implements ActionListener {
    private Movie[] movies = {
        new ActionMovie("Spongebob"),
        new ActionMovie("Fast & Furious"),
        new ActionMovie("Avenger"),
        new ActionMovie("Iron Man")
    };

    public MainMenu() {
        setTitle("Movie Selection");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel titleLabel = new JLabel("Select a Movie:");
        titleLabel.setBounds(140, 20, 150, 25);
        add(titleLabel);

        int yPosition = 60;
        for (Movie movie : movies) {
            JButton movieButton = new JButton(movie.getTitle());
            movieButton.setBounds(120, yPosition, 150, 30);
            movieButton.addActionListener(this);
            add(movieButton);
            yPosition += 50;
        }

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (Movie movie : movies) {
            if (e.getActionCommand().equals(movie.getTitle())) {
                new Booking(movie);
                dispose();
            }
        }
    }
}
