package isp.lab9.exercise1.ui;

import isp.lab9.exercise1.services.UserPortfolio;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class BuyJPanel extends JPanel {
    private StockMarketJFrame mainFrame;
    public UserPortfolio userPortfolio;

    public BuyJPanel(StockMarketJFrame mainFrame, UserPortfolio userPortfolio) {
        this.mainFrame = mainFrame;
        this.userPortfolio = userPortfolio;
        initComponents();
    }

    private void initComponents() {
        setLayout(new GridLayout(2, 2));

        JPanel buyPanel = new JPanel();
        buyPanel.setLayout(new GridLayout(10, 2));

        JLabel availableFundsLabel = new JLabel("Available funds:");
        JTextField availableFundsTextField = new JTextField(userPortfolio.getCash().toPlainString() + " $");
        availableFundsTextField.setEditable(false);

        JLabel symbolLabel = new JLabel("Symbol:");
        JComboBox<String> symbolComboBox = new JComboBox<>();
        symbolComboBox.setModel(new DefaultComboBoxModel(mainFrame.getMarketService().getSymbols()));

        JLabel quantityLabel = new JLabel("Quantity:");
        JTextField quantityTextField = new JTextField();

        JLabel costLabel = new JLabel("Total cost:");
        JTextField costTextField = new JTextField();
        costTextField.setEditable(false);

        JButton buyButton = new JButton("Buy");
        buyButton.addActionListener(e ->
                buyActionPerformed(symbolComboBox, quantityTextField, costTextField));

        JButton costButton = new JButton("Get cost");
        costButton.addActionListener(e ->
                calculateTotalCostActionPerformed(symbolComboBox, quantityTextField, costTextField));

        JButton refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(e ->
                updateUIComponents());

        buyPanel.add(availableFundsLabel);
        buyPanel.add(availableFundsTextField);
        buyPanel.add(new JPanel()); // empty cell in the grid
        buyPanel.add(new JPanel()); // empty cell in the grid
        buyPanel.add(symbolLabel);
        buyPanel.add(symbolComboBox);
        buyPanel.add(new JPanel()); // empty cell in the grid
        buyPanel.add(new JPanel()); // empty cell in the grid
        buyPanel.add(quantityLabel);
        buyPanel.add(quantityTextField);
        buyPanel.add(new JPanel()); // empty cell in the grid
        buyPanel.add(new JPanel()); // empty cell in the grid
        buyPanel.add(costLabel);
        buyPanel.add(costTextField);
        buyPanel.add(new JPanel()); // empty cell in the grid
        buyPanel.add(new JPanel()); // empty cell in the grid
        buyPanel.add(costButton);
        buyPanel.add(buyButton);
        buyPanel.add(new JPanel());
        buyPanel.add(refreshButton);
        add(buyPanel);
        add(new JPanel()); // empty cell in the grid
        add(new JPanel()); // empty cell in the grid
        add(new JPanel()); // empty cell in the grid
    }

    /**
     * Calculates the total transaction cost
     */
    private void calculateTotalCostActionPerformed(JComboBox<String> symbolComboBox,
                                                   JTextField quantityTextField,
                                                   JTextField totalCostTextField) {
        try {
            String symbol = (String) symbolComboBox.getSelectedItem();
            BigDecimal stockPrice = mainFrame.getMarketService().getStockPrice(symbol);

            try {
                int quantity = Integer.parseInt(quantityTextField.getText());
                DecimalFormat formatter = new DecimalFormat("#,##0.##");
                totalCostTextField.setText(
                        formatter.format(stockPrice.multiply(new BigDecimal(quantity))));
            } catch (NumberFormatException e) {
                totalCostTextField.setText("Invalid quantity value!");
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this,
                    ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(StockMarketJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Performs the buy action if funds are sufficient
     */
    private void buyActionPerformed(JComboBox<String> symbolComboBox,
                                    JTextField quantityTextField,
                                    JTextField totalCostTextField) {
        try {
            String symbol = (String) symbolComboBox.getSelectedItem();
            int quantity = Integer.parseInt(quantityTextField.getText());
            BigDecimal totalCost = new BigDecimal(totalCostTextField.getText().replace(",", ""));

            // Check if the user has sufficient funds
            BigDecimal availableFunds = mainFrame.getPortfolio().getCash();
            if (availableFunds.compareTo(totalCost) >= 0) {
                // Perform the buy action
                updatePortfolio(symbol, quantity, totalCost);

                // Update available funds display
                availableFunds = availableFunds.subtract(totalCost);
                mainFrame.getPortfolio().setCash(availableFunds);
                JOptionPane.showMessageDialog(this, "Purchase successful!");
                updateUIComponents();
            } else {
                JOptionPane.showMessageDialog(this, "Insufficient funds!");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid quantity value!");
        }
    }

    private void updatePortfolio(String symbol, int quantity, BigDecimal totalCost) {
        BigDecimal updatedCash = userPortfolio.getCash().subtract(totalCost);
        userPortfolio.setCash(updatedCash);

        Map<String, Integer> shares = userPortfolio.getShares();
        int currentShares = shares.getOrDefault(symbol, 0);
        shares.put(symbol, currentShares + quantity);
        userPortfolio.setShares(shares);
    }

    private void updateUIComponents() {
        this.removeAll();

        initComponents();

        this.revalidate();
        this.repaint();
    }
}

