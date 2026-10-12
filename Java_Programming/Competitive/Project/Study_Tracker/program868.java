import java.awt.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/*
 * Marvellous Study Tracker - GUI Version
 * Save this file as program868.java
 *
 * Features:
 * 1. Add study logs with a manually selected date, subject, duration and description.
 * 2. Display all study logs in a table.
 * 3. Export study logs to CSV.
 * 4. Import CSV records into the in-memory study log database.
 * 5. Show summaries by date and by subject.
 */

class StudyLog {
    private final LocalDate date;
    private final String subject;
    private final double duration;
    private final String description;

    public StudyLog(LocalDate date, String subject, double duration, String description) {
        this.date = date;
        this.subject = subject;
        this.duration = duration;
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getSubject() {
        return subject;
    }

    public double getDuration() {
        return duration;
    }

    public String getDescription() {
        return description;
    }
}

class StudyTracker {
    private final List<StudyLog> database = new ArrayList<>();

    public void addLog(StudyLog log) {
        database.add(log);
    }

    public List<StudyLog> getLogs() {
        return Collections.unmodifiableList(database);
    }

    public boolean isEmpty() {
        return database.isEmpty();
    }

    public Map<LocalDate, Double> summaryByDate() {
        Map<LocalDate, Double> summary = new TreeMap<>();
        for (StudyLog log : database) {
            summary.merge(log.getDate(), log.getDuration(), Double::sum);
        }
        return summary;
    }

    public Map<String, Double> summaryBySubject() {
        Map<String, Double> summary = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        for (StudyLog log : database) {
            summary.merge(log.getSubject(), log.getDuration(), Double::sum);
        }
        return summary;
    }

    public void exportCsv(File file) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(file.toPath(), StandardCharsets.UTF_8)) {
            writer.write("Date,Subject,Duration,Description");
            writer.newLine();
            for (StudyLog log : database) {
                writer.write(csv(log.getDate().toString()) + ","
                        + csv(log.getSubject()) + ","
                        + csv(Double.toString(log.getDuration())) + ","
                        + csv(log.getDescription()));
                writer.newLine();
            }
        }
    }

    public int importCsv(File file) throws IOException {
        int imported = 0;
        try (BufferedReader reader = Files.newBufferedReader(file.toPath(), StandardCharsets.UTF_8)) {
            String line;
            boolean firstLine = true;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }
                if (firstLine) {
                    firstLine = false;
                    if (line.toLowerCase(Locale.ROOT).startsWith("date,")) {
                        continue; // Skip the header row.
                    }
                }

                List<String> fields = parseCsvLine(line);
                if (fields.size() < 4) {
                    throw new IOException("Invalid CSV row (expected 4 columns): " + line);
                }

                try {
                    LocalDate date = LocalDate.parse(fields.get(0).trim());
                    String subject = fields.get(1).trim();
                    double duration = Double.parseDouble(fields.get(2).trim());
                    String description = fields.get(3);
                    if (subject.isEmpty() || duration <= 0 || !Double.isFinite(duration)) {
                        throw new IllegalArgumentException("Subject must not be empty and duration must be positive.");
                    }
                    database.add(new StudyLog(date, subject, duration, description));
                    imported++;
                } catch (RuntimeException ex) {
                    throw new IOException("Could not read CSV row: " + line + "\nReason: " + ex.getMessage(), ex);
                }
            }
        }
        return imported;
    }

    private static String csv(String value) {
        String safe = value == null ? "" : value;
        if (safe.contains(",") || safe.contains("\"") || safe.contains("\n") || safe.contains("\r")) {
            return "\"" + safe.replace("\"", "\"\"") + "\"";
        }
        return safe;
    }

    // Handles quoted CSV fields and commas inside quotes.
    private static List<String> parseCsvLine(String line) throws IOException {
        List<String> fields = new ArrayList<>();
        StringBuilder field = new StringBuilder();
        boolean quoted = false;

        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);
            if (ch == '"') {
                if (quoted && i + 1 < line.length() && line.charAt(i + 1) == '"') {
                    field.append('"');
                    i++;
                } else {
                    quoted = !quoted;
                }
            } else if (ch == ',' && !quoted) {
                fields.add(field.toString());
                field.setLength(0);
            } else {
                field.append(ch);
            }
        }

        if (quoted) {
            throw new IOException("Unclosed quote in CSV row: " + line);
        }
        fields.add(field.toString());
        return fields;
    }
}

public class program868 extends JFrame {
    private final StudyTracker tracker = new StudyTracker();

    private final JTextField dateField = new JTextField(LocalDate.now().toString(), 12);
    private final JComboBox<String> subjectCombo = new JComboBox<>(
            new String[]{"Java", "C", "C++", "Python", "DBMS", "Data Science", "Machine Learning", "Other"});
    private final JTextField durationField = new JTextField(8);
    private final JTextArea descriptionArea = new JTextArea(3, 30);
    private final DefaultTableModel tableModel = new DefaultTableModel(
            new String[]{"Date", "Subject", "Duration (hours)", "Description"}, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    private final JTable logTable = new JTable(tableModel);
    private final JLabel statusLabel = new JLabel("Ready. Add a study log to get started.");

    public program868() {
        super("Marvellous Study Tracker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(900, 600));
        setSize(1100, 700);
        setLocationRelativeTo(null);

        buildGui();
    }

    private void buildGui() {
        JPanel root = new JPanel(new BorderLayout(12, 12));
        root.setBorder(BorderFactory.createEmptyBorder(14, 14, 10, 14));
        setContentPane(root);

        JLabel heading = new JLabel("Marvellous Study Tracker", SwingConstants.CENTER);
        heading.setFont(new Font("SansSerif", Font.BOLD, 25));
        root.add(heading, BorderLayout.NORTH);

        JPanel center = new JPanel(new BorderLayout(10, 10));
        root.add(center, BorderLayout.CENTER);

        JPanel entryPanel = new JPanel(new GridBagLayout());
        entryPanel.setBorder(BorderFactory.createTitledBorder("Add Study Log"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 7, 6, 7);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        addFormRow(entryPanel, gbc, 0, "Date (YYYY-MM-DD):", dateField);
        subjectCombo.setEditable(true);
        addFormRow(entryPanel, gbc, 1, "Subject:", subjectCombo);
        addFormRow(entryPanel, gbc, 2, "Duration (hours):", durationField);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 0;
        entryPanel.add(new JLabel("Description:"), gbc);
        gbc.gridx = 1;
        gbc.weightx = 1;
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        entryPanel.add(new JScrollPane(descriptionArea), gbc);

        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 4));
        JButton addButton = new JButton("Add Log");
        JButton clearButton = new JButton("Clear Fields");
        JButton exportButton = new JButton("Export CSV");
        JButton importButton = new JButton("Import CSV");
        JButton dateSummaryButton = new JButton("Summary by Date");
        JButton subjectSummaryButton = new JButton("Summary by Subject");
        JButton refreshButton = new JButton("Refresh Table");

        buttons.add(addButton);
        buttons.add(clearButton);
        buttons.add(exportButton);
        buttons.add(importButton);
        buttons.add(dateSummaryButton);
        buttons.add(subjectSummaryButton);
        buttons.add(refreshButton);

        JPanel topArea = new JPanel(new BorderLayout(6, 6));
        topArea.add(entryPanel, BorderLayout.CENTER);
        topArea.add(buttons, BorderLayout.SOUTH);
        center.add(topArea, BorderLayout.NORTH);

        logTable.setRowHeight(24);
        logTable.setAutoCreateRowSorter(true);
        logTable.setFillsViewportHeight(true);
        center.add(new JScrollPane(logTable), BorderLayout.CENTER);

        statusLabel.setBorder(BorderFactory.createEmptyBorder(5, 2, 0, 2));
        root.add(statusLabel, BorderLayout.SOUTH);

        addButton.addActionListener(e -> addLog());
        clearButton.addActionListener(e -> clearFields());
        exportButton.addActionListener(e -> exportCsv());
        importButton.addActionListener(e -> importCsv());
        dateSummaryButton.addActionListener(e -> showDateSummary());
        subjectSummaryButton.addActionListener(e -> showSubjectSummary());
        refreshButton.addActionListener(e -> refreshTable());
    }

    private void addFormRow(JPanel panel, GridBagConstraints gbc, int row, String label, Component input) {
        gbc.gridy = row;
        gbc.gridx = 0;
        gbc.weightx = 0;
        panel.add(new JLabel(label), gbc);
        gbc.gridx = 1;
        gbc.weightx = 1;
        panel.add(input, gbc);
    }

    private void addLog() {
        try {
            LocalDate date = LocalDate.parse(dateField.getText().trim());
            Object selected = subjectCombo.getEditor().getItem();
            String subject = selected == null ? "" : selected.toString().trim();
            double duration = Double.parseDouble(durationField.getText().trim());
            String description = descriptionArea.getText().trim();

            if (subject.isEmpty()) {
                showError("Please enter or select a subject.");
                return;
            }
            if (!Double.isFinite(duration) || duration <= 0) {
                showError("Duration must be a positive number of hours, for example 1 or 1.5.");
                return;
            }

            tracker.addLog(new StudyLog(date, subject, duration, description));
            refreshTable();
            statusLabel.setText("Study log added successfully.");
            durationField.setText("");
            descriptionArea.setText("");
            dateField.setText(LocalDate.now().toString());
            subjectCombo.requestFocusInWindow();
        } catch (DateTimeParseException ex) {
            showError("Enter the date in YYYY-MM-DD format, for example 2026-10-12.");
        } catch (NumberFormatException ex) {
            showError("Enter a valid duration, for example 1 or 1.5.");
        }
    }

    private void clearFields() {
        dateField.setText(LocalDate.now().toString());
        subjectCombo.setSelectedIndex(0);
        durationField.setText("");
        descriptionArea.setText("");
        statusLabel.setText("Fields cleared.");
    }

    private void refreshTable() {
        tableModel.setRowCount(0);
        for (StudyLog log : tracker.getLogs()) {
            tableModel.addRow(new Object[]{
                    log.getDate(), log.getSubject(),
                    String.format(Locale.ROOT, "%.2f", log.getDuration()),
                    log.getDescription()
            });
        }
        statusLabel.setText("Total study logs: " + tracker.getLogs().size());
    }

    private void exportCsv() {
        if (tracker.isEmpty()) {
            showError("There are no study logs to export.");
            return;
        }
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Save Study Logs as CSV");
        chooser.setSelectedFile(new File("StudyLogs.csv"));
        if (chooser.showSaveDialog(this) != JFileChooser.APPROVE_OPTION) {
            return;
        }

        File file = chooser.getSelectedFile();
        if (!file.getName().toLowerCase(Locale.ROOT).endsWith(".csv")) {
            file = new File(file.getParentFile(), file.getName() + ".csv");
        }
        try {
            tracker.exportCsv(file);
            statusLabel.setText("Exported " + tracker.getLogs().size() + " log(s) to " + file.getAbsolutePath());
            JOptionPane.showMessageDialog(this, "CSV exported successfully:\n" + file.getAbsolutePath(),
                    "Export Complete", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            showError("Could not export CSV:\n" + ex.getMessage());
        }
    }

    private void importCsv() {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Select Study Logs CSV");
        if (chooser.showOpenDialog(this) != JFileChooser.APPROVE_OPTION) {
            return;
        }
        try {
            int imported = tracker.importCsv(chooser.getSelectedFile());
            refreshTable();
            statusLabel.setText("Imported " + imported + " log(s). Total logs: " + tracker.getLogs().size());
            JOptionPane.showMessageDialog(this, "Imported " + imported + " study log(s).",
                    "Import Complete", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            showError("Could not import CSV:\n" + ex.getMessage()
                    + "\nExpected columns: Date,Subject,Duration,Description");
        }
    }

    private void showDateSummary() {
        Map<LocalDate, Double> summary = tracker.summaryByDate();
        if (summary.isEmpty()) {
            showError("There are no study logs to summarize.");
            return;
        }
        StringBuilder text = new StringBuilder("Study duration by date\n\n");
        summary.forEach((date, duration) ->
                text.append(date).append("   |   ")
                        .append(String.format(Locale.ROOT, "%.2f hours", duration)).append('\n'));
        text.append("\nTotal study time: ")
                .append(String.format(Locale.ROOT, "%.2f hours", totalDuration()));
        showReport("Summary by Date", text.toString());
    }

    private void showSubjectSummary() {
        Map<String, Double> summary = tracker.summaryBySubject();
        if (summary.isEmpty()) {
            showError("There are no study logs to summarize.");
            return;
        }
        StringBuilder text = new StringBuilder("Study duration by subject\n\n");
        summary.forEach((subject, duration) ->
                text.append(subject).append("   |   ")
                        .append(String.format(Locale.ROOT, "%.2f hours", duration)).append('\n'));
        text.append("\nTotal study time: ")
                .append(String.format(Locale.ROOT, "%.2f hours", totalDuration()));
        showReport("Summary by Subject", text.toString());
    }

    private double totalDuration() {
        double total = 0;
        for (StudyLog log : tracker.getLogs()) {
            total += log.getDuration();
        }
        return total;
    }

    private void showReport(String title, String content) {
        JTextArea area = new JTextArea(content, 18, 40);
        area.setEditable(false);
        area.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 13));
        area.setCaretPosition(0);
        JOptionPane.showMessageDialog(this, new JScrollPane(area), title, JOptionPane.INFORMATION_MESSAGE);
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Study Tracker", JOptionPane.ERROR_MESSAGE);
        statusLabel.setText("Please check your input.");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new program868().setVisible(true));
    }
}
