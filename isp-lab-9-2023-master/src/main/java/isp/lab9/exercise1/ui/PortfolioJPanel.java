package isp.lab9.exercise1.ui;

import isp.lab9.exercise1.services.StockItem;
import isp.lab9.exercise1.services.UserPortfolio;
import isp.lab9.exercise1.services.YahooWebClient;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;

public class PortfolioJPanel extends JPanel {

    private StockMarketJFrame frame;
    private UserPortfolio userPortfolio;

    public PortfolioJPanel(StockMarketJFrame frame, UserPortfolio userPortfolio) {
        this.frame = frame;
        this.userPortfolio = userPortfolio;
        initComponent();
    }

    private void initComponent() {
        setLayout(new BorderLayout());

        // Create a table to display the user's portfolio
        JTable jTablePortfolio = new JTable();
        DefaultTableModel tableModel = new DefaultTableModel(new Object[]{"Name", "Symbol", "Quantity", "Price Per Unit", "Total Price"}, 0);
        jTablePortfolio.setModel(tableModel);

        // Populate the table with user's portfolio data
        populatePortfolioTable(tableModel);

        JScrollPane portfolioScrollablePane = new JScrollPane(jTablePortfolio);

        // Display available funds (cash)
        JLabel availableFundsLabel = new JLabel("Available Funds: " + userPortfolio.getCash().toPlainString() + " $");

        // Add components to the panel
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(availableFundsLabel, BorderLayout.NORTH);
        topPanel.add(portfolioScrollablePane, BorderLayout.CENTER);

        JButton refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(evt -> updateUIComponents());

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(refreshButton);

        add(topPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    private void populatePortfolioTable(DefaultTableModel tableModel){
        // Clear existing data
        tableModel.setRowCount(0);

        // Populate table with user's portfolio data
        Map<String, Integer> shares = userPortfolio.getShares();
        for (Map.Entry<String, Integer> entry : shares.entrySet()) {
            String symbol = entry.getKey();
            int quantity = entry.getValue();
            StockItem stock = null;
            try {
                stock = YahooWebClient.get(symbol);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            String name = stock.getName();
            BigDecimal pricePerUnit = stock.getPrice();
            BigDecimal totalPrice = pricePerUnit.multiply(BigDecimal.valueOf(quantity));

            // Add row to the table
            tableModel.addRow(new Object[]{name, symbol, quantity, pricePerUnit, totalPrice});
        }
    }

    private void updateUIComponents() {
        this.removeAll();

        initComponent();

        this.revalidate();
        this.repaint();
    }
}

