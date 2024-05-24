package isp.lab9.exercise1.ui;

import javax.swing.*;

/**
 * todo: implement - it should look similar to the 'Buy' panel
 */
import isp.lab9.exercise1.services.UserPortfolio;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SellJPanel extends JPanel {
    private StockMarketJFrame mainFrame;
    private UserPortfolio userPortfolio;

    public SellJPanel(StockMarketJFrame mainFrame, UserPortfolio userPortfolio) {
        this.mainFrame = mainFrame;
        this.userPortfolio = userPortfolio;
        initComponents();
    }

    private void initComponents() {
        setLayout(new GridLayout(2, 2));

        JPanel sellPanel = new JPanel();
        sellPanel.setLayout(new GridLayout(10, 2));

        JLabel availableFundsLabel = new JLabel("Available funds:");
        JTextField availableFundsTextField = new JTextField(userPortfolio.getCash().toPlainString() + " $");
        availableFundsTextField.setEditable(false);

        JLabel symbolLabel = new JLabel("Symbol:");
        JComboBox<String> symbolComboBox = new JComboBox<>();

        // Populate the symbolComboBox with symbols from your portfolio
        Map<String, Integer> ownedStocks = userPortfolio.getShares();
        for (String symbol : ownedStocks.keySet()) {
            symbolComboBox.addItem(symbol);
        }

        JLabel costLabel = new JLabel("Total cost:");
        JTextField costTextField = new JTextField();
        costTextField.setEditable(false);

        // Display the quantity of the selected symbol
        JTextField quantityTextField = new JTextField();
        symbolComboBox.addActionListener(e -> {
            String selectedSymbol = (String) symbolComboBox.getSelectedItem();
            if (selectedSymbol != null) {
                int quantityOwned = ownedStocks.getOrDefault(selectedSymbol, 0);
                quantityTextField.setText(Integer.toString(quantityOwned));

                // Automatically calculate the total cost
                calculateTotalCostActionPerformed(symbolComboBox, quantityTextField,costTextField);
            }
        });

        JLabel quantityLabel = new JLabel("Quantity:");

        JButton sellButton = new JButton("Sell");
        sellButton.addActionListener(e ->
                sellActionPerformed(symbolComboBox, quantityTextField, costTextField));

        JButton refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(e ->
                updateUIComponents());

        sellPanel.add(availableFundsLabel);
        sellPanel.add(availableFundsTextField);
        sellPanel.add(new JPanel()); // empty cell in the grid
        sellPanel.add(new JPanel()); // empty cell in the grid
        sellPanel.add(symbolLabel);
        sellPanel.add(symbolComboBox);
        sellPanel.add(new JPanel()); // empty cell in the grid
        sellPanel.add(new JPanel()); // empty cell in the grid
        sellPanel.add(quantityLabel);
        sellPanel.add(quantityTextField);
        sellPanel.add(new JPanel()); // empty cell in the grid
        sellPanel.add(new JPanel()); // empty cell in the grid
        sellPanel.add(costLabel);
        sellPanel.add(costTextField);
        sellPanel.add(new JPanel()); // empty cell in the grid
        sellPanel.add(new JPanel()); // empty cell in the grid
        sellPanel.add(refreshButton);
        sellPanel.add(sellButton);
        add(sellPanel);
        add(new JPanel()); // empty cell in the grid
        add(new JPanel()); // empty cell in the grid
        add(new JPanel()); // empty cell in the grid
    }

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


    private void sellActionPerformed(JComboBox<String> symbolComboBox,
                                     JTextField quantityTextField,
                                     JTextField totalCostTextField) {
        try {
            String symbol = (String) symbolComboBox.getSelectedItem();
            int quantity = Integer.parseInt(quantityTextField.getText());
            BigDecimal totalCost = new BigDecimal(totalCostTextField.getText().replace(",", ""));

            // Perform the sell action
            updatePortfolio(symbol, quantity, totalCost);

            // Update available funds display
            BigDecimal availableFunds = mainFrame.getPortfolio().getCash().add(totalCost);
            mainFrame.getPortfolio().setCash(availableFunds);

            JOptionPane.showMessageDialog(this, "Sell successful!");
            updateUIComponents();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid quantity value!");
        }
    }

    private void updatePortfolio(String symbol, int quantity, BigDecimal totalCost) {
        // Remove sold stocks from the portfolio
        Map<String, Integer> shares = userPortfolio.getShares();
        int currentShares = shares.getOrDefault(symbol, 0);
        int remainingShares = currentShares - quantity;

        if (remainingShares <= 0) {
            shares.remove(symbol); // Remove the symbol if no shares are left
        } else {
            shares.put(symbol, remainingShares); // Update the remaining shares
        }
        userPortfolio.setShares(shares);
    }


    private void updateUIComponents() {
        this.removeAll();

        initComponents();

        this.revalidate();
        this.repaint();
    }

}

