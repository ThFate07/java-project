import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CakeShopGUI {
    private JFrame frame;
    private JTextField orderIdField, dateField, cakeIdField, cakeNameField, quantityField, customerIdField, customerNameField, orderPriceField, discountField;
    private JRadioButton yesDiscount, noDiscount;
    private JButton bookButton, backButton, clearButton;

    public CakeShopGUI() {
        frame = new JFrame("Cake Shop Order Management");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);

        // Main panel with background color (for the bakery theme)
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(Color.PINK);

        // Add Bakery Logo (top)
        JLabel bakeryLabel = new JLabel("Pennsylvania Bakery", JLabel.CENTER);
        bakeryLabel.setFont(new Font("Serif", Font.BOLD, 24));
        mainPanel.add(bakeryLabel, BorderLayout.NORTH);

        // Center panel for order and customer details
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(1, 2, 10, 10));
        centerPanel.setBackground(Color.PINK);

        // Cake Details Panel
        JPanel cakeDetailsPanel = new JPanel(new GridBagLayout());
        cakeDetailsPanel.setBackground(Color.PINK);
        cakeDetailsPanel.setBorder(BorderFactory.createTitledBorder("Cake Details"));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Cake List
        String[] cakes = {"102 - Black Forest Cake", "130 - Butter Scotch Cake", "130 - Chocolate Truffle Cake"};
        JList<String> cakeList = new JList<>(cakes);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        cakeDetailsPanel.add(new JScrollPane(cakeList), gbc);

        // Cake ID and Name
        gbc.gridwidth = 1;
        gbc.gridy = 1;
        cakeDetailsPanel.add(new JLabel("ID:"), gbc);

        cakeIdField = new JTextField(10);
        gbc.gridx = 1;
        cakeDetailsPanel.add(cakeIdField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        cakeDetailsPanel.add(new JLabel("Name:"), gbc);

        cakeNameField = new JTextField(10);
        gbc.gridx = 1;
        cakeDetailsPanel.add(cakeNameField, gbc);

        // Quantity
        gbc.gridx = 0;
        gbc.gridy = 3;
        cakeDetailsPanel.add(new JLabel("Quantity:"), gbc);

        quantityField = new JTextField(10);
        gbc.gridx = 1;
        cakeDetailsPanel.add(quantityField, gbc);

        centerPanel.add(cakeDetailsPanel);

        // Customer Details Panel
        JPanel customerDetailsPanel = new JPanel(new GridBagLayout());
        customerDetailsPanel.setBackground(Color.PINK);
        customerDetailsPanel.setBorder(BorderFactory.createTitledBorder("Customer Details"));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        customerDetailsPanel.add(new JLabel("ID:"), gbc);

        customerIdField = new JTextField(10);
        gbc.gridx = 1;
        customerDetailsPanel.add(customerIdField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        customerDetailsPanel.add(new JLabel("Name:"), gbc);

        customerNameField = new JTextField(10);
        gbc.gridx = 1;
        customerDetailsPanel.add(customerNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        customerDetailsPanel.add(new JLabel("Order price:"), gbc);

        orderPriceField = new JTextField(10);
        gbc.gridx = 1;
        customerDetailsPanel.add(orderPriceField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        customerDetailsPanel.add(new JLabel("Discount (%):"), gbc);

        discountField = new JTextField(10);
        gbc.gridx = 1;
        customerDetailsPanel.add(discountField, gbc);

        // Discount Radio Buttons
        ButtonGroup discountGroup = new ButtonGroup();
        yesDiscount = new JRadioButton("Yes");
        noDiscount = new JRadioButton("No", true); // No is selected by default
        discountGroup.add(yesDiscount);
        discountGroup.add(noDiscount);

        gbc.gridx = 0;
        gbc.gridy = 4;
        customerDetailsPanel.add(new JLabel("Discount:"), gbc);
        gbc.gridx = 1;
        JPanel discountPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        discountPanel.add(yesDiscount);
        discountPanel.add(noDiscount);
        customerDetailsPanel.add(discountPanel, gbc);

        centerPanel.add(customerDetailsPanel);

        // Add center panel to main panel
        mainPanel.add(centerPanel, BorderLayout.CENTER);

        // Buttons Panel (bottom)
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.PINK);

        bookButton = new JButton("Book");
        backButton = new JButton("Back to Main");
        clearButton = new JButton("Clear");

        buttonPanel.add(bookButton);
        buttonPanel.add(backButton);
        buttonPanel.add(clearButton);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Add action listeners for buttons
        bookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle booking logic here
                JOptionPane.showMessageDialog(frame, "Order placed successfully!");
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Clear all fields
                orderIdField.setText("");
                dateField.setText("");
                cakeIdField.setText("");
                cakeNameField.setText("");
                quantityField.setText("");
                customerIdField.setText("");
                customerNameField.setText("");
                orderPriceField.setText("");
                discountField.setText("");
                noDiscount.setSelected(true); // Default to no discount
            }
        });

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new CakeShopGUI();
    }
}
