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
public class Booking extends JFrame implements ActionListener {
    private JTextField nameField, dayField, ticketField;
    private JComboBox<String> monthBox, showtimeBox;
    private JRadioButton creditCard, eWallet, bankTransfer;
    private JButton bookButton, resetButton, backButton;
    private Movie selectedMovie;

    public Booking(Movie movie) {
        this.selectedMovie = movie;
        setTitle("Booking: " + movie.getTitle());
        setSize(400, 400);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 30, 80, 25);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(140, 30, 180, 25);
        add(nameField);

        JLabel dateLabel = new JLabel("Date (1-31):");
        dateLabel.setBounds(50, 70, 80, 25);
        add(dateLabel);

        dayField = new JTextField();
        dayField.setBounds(140, 70, 50, 25);
        add(dayField);

        JLabel monthLabel = new JLabel("Month:");
        monthLabel.setBounds(200, 70, 80, 25);
        add(monthLabel);

        String[] months = {"January", "February", "March", "April", "May", "June",
                           "July", "August", "September", "October", "November", "December"};
        monthBox = new JComboBox<>(months);
        monthBox.setBounds(250, 70, 100, 25);
        add(monthBox);

        JLabel yearLabel = new JLabel("Year:");
        yearLabel.setBounds(50, 110, 80, 25);
        add(yearLabel);

        JTextField yearField = new JTextField("2025");
        yearField.setBounds(140, 110, 50, 25);
        yearField.setEditable(false);
        add(yearField);

        JLabel showtimeLabel = new JLabel("Showtime:");
        showtimeLabel.setBounds(50, 150, 80, 25);
        add(showtimeLabel);

        String[] showtimes = {"12:00", "15:00", "18:00", "21:00"};
        showtimeBox = new JComboBox<>(showtimes);
        showtimeBox.setBounds(140, 150, 100, 25);
        add(showtimeBox);

        JLabel ticketLabel = new JLabel("Tickets:");
        ticketLabel.setBounds(50, 190, 80, 25);
        add(ticketLabel);

        ticketField = new JTextField();
        ticketField.setBounds(140, 190, 50, 25);
        add(ticketField);

        JLabel paymentLabel = new JLabel("Payment:");
        paymentLabel.setBounds(50, 230, 80, 25);
        add(paymentLabel);

        creditCard = new JRadioButton("Credit Card");
        creditCard.setBounds(140, 230, 100, 25);
        eWallet = new JRadioButton("E-Wallet");
        eWallet.setBounds(250, 230, 100, 25);
        bankTransfer = new JRadioButton("Bank Transfer");
        bankTransfer.setBounds(140, 260, 150, 25);

        ButtonGroup paymentGroup = new ButtonGroup();
        paymentGroup.add(creditCard);
        paymentGroup.add(eWallet);
        paymentGroup.add(bankTransfer);

        add(creditCard);
        add(eWallet);
        add(bankTransfer);

        bookButton = new JButton("Book");
        bookButton.setBounds(50, 300, 100, 30);
        bookButton.addActionListener(this);
        add(bookButton);

        resetButton = new JButton("Reset");
        resetButton.setBounds(160, 300, 100, 30);
        resetButton.addActionListener(this);
        add(resetButton);

        backButton = new JButton("Back");
        backButton.setBounds(270, 300, 100, 30);
        backButton.addActionListener(this);
        add(backButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bookButton) {
            try {
                String name = nameField.getText().trim();
                String day = dayField.getText().trim();
                String month = (String) monthBox.getSelectedItem();
                String year = "2025";
                String showtime = (String) showtimeBox.getSelectedItem();
                int tickets = Integer.parseInt(ticketField.getText().trim());

                if (name.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Name cannot be empty!");
                    return;
                }

                int dayNumber = Integer.parseInt(day);
                if (dayNumber < 1 || dayNumber > 31) {
                    JOptionPane.showMessageDialog(this, "Day must be between 1-31!");
                    return;
                }

                if (tickets <= 0) throw new NumberFormatException();

                String paymentMethod = "";
                if (creditCard.isSelected()) {
                    paymentMethod = "Credit Card";
                } else if (eWallet.isSelected()) {
                    paymentMethod = "E-Wallet";
                } else if (bankTransfer.isSelected()) {
                    paymentMethod = "Bank Transfer";
                } else {
                    JOptionPane.showMessageDialog(this, "Select a payment method!");
                    return;
                }

                double totalPrice = tickets * selectedMovie.getPrice() * 1.1;

                JOptionPane.showMessageDialog(this, 
                    "Booking Confirmed\n" +
                    "Name: " + name + "\n" +
                    "Movie: " + selectedMovie.getTitle() + "\n" +
                    "Date: " + dayNumber + " " + month + " " + year + "\n" +
                    "Showtime: " + showtime + "\n" +
                    "Tickets: " + tickets + "\n" +
                    "Payment: " + paymentMethod + "\n" +
                    "Total Price: Rp" + totalPrice);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid input! Make sure Date and Tickets are numbers.");
            }
        } else if (e.getSource() == resetButton) {
            nameField.setText("");
            dayField.setText("");
            ticketField.setText("");
            creditCard.setSelected(false);
            eWallet.setSelected(false);
            bankTransfer.setSelected(false);
        } else if (e.getSource() == backButton) {
            new MainMenu();
            dispose();
        }
    }
}
