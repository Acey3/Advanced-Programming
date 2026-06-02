package Lecture4_interfaces_abstract_classes;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Calendar;
import java.text.SimpleDateFormat;

/**
 * An advanced graphical user interface class that extends JFrame.
 * Displays real-time bank account variables, current balances, and full transaction logs.
 */
public class TransactionGui extends JFrame {
    private BankAccount account;
    private JTextField amountField;
    private JLabel balanceLabel;
    private JLabel statusLabel;

    // UI elements to display the complete transaction history
    private DefaultTableModel tableModel;
    private JTable historyTable;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public TransactionGui() {
        // Start the simulator account with $1000
        account = new BankAccount(1000.0);

        // Frame Setup
        setTitle("Interactive Bank Account Ledger Dashboard");
        setSize(650, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(15, 15));

        // 1. TOP PANEL: Real-time Account Metrics Visualization
        JPanel headerPanel = new JPanel(new GridLayout(2, 1));
        headerPanel.setBackground(new Color(40, 50, 70));
        headerPanel.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));

        balanceLabel = new JLabel("Live Account Balance: $" + account.getBalance());
        balanceLabel.setFont(new Font("SansSerif", Font.BOLD, 22));
        balanceLabel.setForeground(Color.WHITE);

        statusLabel = new JLabel("System Status: Operational | Standing: Good");
        statusLabel.setFont(new Font("SansSerif", Font.PLAIN, 13));
        statusLabel.setForeground(new Color(150, 230, 150)); // Gentle green

        headerPanel.add(balanceLabel);
        headerPanel.add(statusLabel);
        add(headerPanel, BorderLayout.NORTH);

        // 2. CENTER PANEL: Detailed Transaction History Table
        String[] columnNames = {"Type", "Transaction ID", "Timestamp", "Amount Changed", "Final Balance"};
        tableModel = new DefaultTableModel(columnNames, 0);
        historyTable = new JTable(tableModel);
        historyTable.setFont(new Font("Monospaced", Font.PLAIN, 12));
        historyTable.setRowHeight(22);

        JScrollPane tableScrollPane = new JScrollPane(historyTable);
        tableScrollPane.setBorder(BorderFactory.createTitledBorder("Complete Invariant Audit Trail Ledger"));
        add(tableScrollPane, BorderLayout.CENTER);

        // 3. SOUTH PANEL: User Interaction Controls & Inputs
        JPanel controlPanel = new JPanel(new BorderLayout(10, 10));
        controlPanel.setBorder(BorderFactory.createEmptyBorder(10, 15, 15, 15));

        // Input row
        JPanel inputRow = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        JLabel amountLabel = new JLabel("Enter Amount ($):");
        amountLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        amountField = new JTextField(10);
        amountField.setFont(new Font("SansSerif", Font.PLAIN, 14));

        inputRow.add(amountLabel);
        inputRow.add(amountField);
        controlPanel.add(inputRow, BorderLayout.NORTH);

        // Buttons row
        JPanel buttonRow = new JPanel(new GridLayout(1, 2, 15, 0));
        JButton depositBtn = new JButton("Execute Deposit (+)");
        depositBtn.setBackground(new Color(220, 245, 220));
        depositBtn.setFont(new Font("SansSerif", Font.BOLD, 13));

        JButton withdrawBtn = new JButton("Execute Withdrawal (-)");
        withdrawBtn.setBackground(new Color(255, 220, 220));
        withdrawBtn.setFont(new Font("SansSerif", Font.BOLD, 13));

        buttonRow.add(depositBtn);
        buttonRow.add(withdrawBtn);
        controlPanel.add(buttonRow, BorderLayout.SOUTH);

        add(controlPanel, BorderLayout.SOUTH);

        // Event Action Hook Handlers
        depositBtn.addActionListener(e -> processUiTransaction("Deposit"));
        withdrawBtn.addActionListener(e -> processUiTransaction("Withdrawal"));

        setLocationRelativeTo(null); // Open in center of monitor display
    }

    private void processUiTransaction(String type) {
        // Reset status message color layout labels
        statusLabel.setForeground(new Color(150, 230, 150));
        statusLabel.setText("System Status: Processing...");

        try {
            int amount = Integer.parseInt(amountField.getText().trim());
            Calendar timestamp = Calendar.getInstance();
            String timeString = dateFormat.format(timestamp.getTime());

            if (type.equals("Deposit")) {
                DepositTransaction dt = new DepositTransaction(amount, timestamp);
                dt.apply(account); // Core OOP math call

                // Add complete transaction info array directly onto the GUI viewport rows!
                tableModel.addRow(new Object[]{
                        "DEPOSIT", dt.getTransactionID(), timeString, "+$" + amount, "$" + account.getBalance()
                });
                statusLabel.setText("System Status: Deposit Succeeded.");

            } else {
                WithdrawalTransaction wt = new WithdrawalTransaction(amount, timestamp);
                wt.apply(account); // Core OOP math call (throws exception if insufficient)

                tableModel.addRow(new Object[]{
                        "WITHDRAWAL", wt.getTransactionID(), timeString, "-$" + amount, "$" + account.getBalance()
                });
                statusLabel.setText("System Status: Withdrawal Succeeded.");
            }

            updateDashboardView();

        } catch (NumberFormatException ex) {
            statusLabel.setForeground(Color.ORANGE);
            statusLabel.setText("System Status: Input Format Rejection.");
            JOptionPane.showMessageDialog(this, "Please input a clean integer numeric total.", "Format Error", JOptionPane.WARNING_MESSAGE);
        } catch (InsufficientFundsException ex) {
            // Instantly captures and logs custom exception details straight onto the visual metrics panel
            statusLabel.setForeground(new Color(255, 120, 120)); // Warning Red
            statusLabel.setText("System Status: DECLINED - " + ex.getMessage());

            JOptionPane.showMessageDialog(this, ex.getMessage(), "Transaction Core Exception Blocker", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateDashboardView() {
        balanceLabel.setText("Live Account Balance: $" + account.getBalance());
        amountField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TransactionGui().setVisible(true));
    }
}