package isp.lab9.exercise1.ui;

import isp.lab9.exercise1.services.UserPortfolio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PortfolioJPanel extends JPanel {

    private StockMarketJFrame frame;
    private UserPortfolio userPortfolio;

    public PortfolioJPanel(StockMarketJFrame frame) {
        this.frame = frame;
        initComponent();
    }

    private void initComponent() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JTable jTablePortfolio = new JTable();
        jTablePortfolio.setModel(frame.getMarketService());
        JScrollPane portfolioScrollablePane = new JScrollPane(jTablePortfolio);

        JButton refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(evt -> buttonRefreshActionPerformed(evt));

        add(portfolioScrollablePane);
        add(refreshButton);

    }

    /**
     * Refreshes the portfolio data.
     */
    private void buttonRefreshActionPerformed(ActionEvent evt) {
        try {
            frame.getMarketService().refreshMarketData();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this,
                    ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(StockMarketJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Updates the portfolio data to display only the stocks that the user owns.
     */
}
