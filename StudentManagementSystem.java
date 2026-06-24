import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentManagementSystem extends JFrame {

	private JTextField nameField;
	private JTextField surnameField;
	private JTextField idField;
	private JTextField studentNumField;
	private JTextField courseField;

	private JTextArea displayArea;

	private final Color PINK_LIGHT = new Color(255, 182, 193);
	private final Color PINK_DARK = new Color(255, 105, 180);
	private final Color PINK_BG = new Color(255, 240, 245);

	public StudentManagementSystem() {
		setTitle("NDONIS INSTITUTE OF TECHNOLOGY - Student Management System");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		getContentPane().setBackground(PINK_BG);

		initComponents();
	}

	private void initComponents() {

		JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
		mainPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
		mainPanel.setBackground(PINK_BG);

		// Header
		JLabel header = new JLabel(
				"NDONIS INSTITUTE OF TECHNOLOGY",
				SwingConstants.CENTER);

		header.setFont(new Font("Arial", Font.BOLD, 20));
		header.setForeground(PINK_DARK);
		header.setBorder(new EmptyBorder(0, 0, 15, 0));

		mainPanel.add(header, BorderLayout.NORTH);

		// Form Panel
		JPanel formPanel = new JPanel(new GridLayout(5, 2, 10, 10));
		formPanel.setBackground(PINK_BG);
		formPanel.setBorder(
				BorderFactory.createTitledBorder("Student Information"));

		formPanel.add(createLabel("Name:"));
		nameField = createTextField();
		formPanel.add(nameField);

		formPanel.add(createLabel("Surname:"));
		surnameField = createTextField();
		formPanel.add(surnameField);

		formPanel.add(createLabel("ID Number:"));
		idField = createTextField();
		formPanel.add(idField);

		formPanel.add(createLabel("Student Number:"));
		studentNumField = createTextField();
		formPanel.add(studentNumField);

		formPanel.add(createLabel("Course:"));
		courseField = createTextField();
		formPanel.add(courseField);

		mainPanel.add(formPanel, BorderLayout.CENTER);

		// Buttons
		JPanel buttonPanel = new JPanel(new FlowLayout());
		buttonPanel.setBackground(PINK_BG);

		JButton submitBtn = createButton("Submit");
		JButton refreshBtn = createButton("Refresh");
		JButton clearBtn = createButton("Clear");

		buttonPanel.add(submitBtn);
		buttonPanel.add(refreshBtn);
		buttonPanel.add(clearBtn);

		mainPanel.add(buttonPanel, BorderLayout.SOUTH);

		// Display Area
		displayArea = new JTextArea(12, 30);
		displayArea.setEditable(false);
		displayArea.setBackground(Color.WHITE);
		displayArea.setFont(new Font("Monospaced", Font.PLAIN, 13));
		displayArea.setBorder(
				BorderFactory.createLineBorder(PINK_DARK));

		JScrollPane scrollPane = new JScrollPane(displayArea);
		scrollPane.setBorder(
				BorderFactory.createTitledBorder("Current Entry"));

		JPanel eastPanel = new JPanel(new BorderLayout());
		eastPanel.setBackground(PINK_BG);
		eastPanel.add(scrollPane, BorderLayout.CENTER);

		mainPanel.add(eastPanel, BorderLayout.EAST);

		add(mainPanel);

		// Button Actions
		submitBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				submitStudent();
			}
		});

		refreshBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clearAll();
				displayArea.setText("");
				JOptionPane.showMessageDialog(
						StudentManagementSystem.this,
						"Form refreshed. All data cleared.");
			}
		});

		clearBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clearAll();
			}
		});
	}

	private JLabel createLabel(String text) {
		JLabel label = new JLabel(text);
		label.setFont(new Font("Arial", Font.BOLD, 14));
		label.setForeground(PINK_DARK);
		return label;
	}

	private JTextField createTextField() {
		JTextField field = new JTextField();
		field.setBorder(
				BorderFactory.createLineBorder(PINK_DARK));
		return field;
	}

	private JButton createButton(String text) {
		JButton btn = new JButton(text);

		btn.setBackground(PINK_DARK);
		btn.setForeground(Color.WHITE);
		btn.setFont(new Font("Arial", Font.BOLD, 12));
		btn.setFocusPainted(false);
		btn.setBorder(
				BorderFactory.createRaisedBevelBorder());

		return btn;
	}

	private void submitStudent() {

		String name = nameField.getText().trim();
		String surname = surnameField.getText().trim();
		String id = idField.getText().trim();
		String studentNum = studentNumField.getText().trim();
		String course = courseField.getText().trim();

		if (name.isEmpty()
				|| surname.isEmpty()
				|| id.isEmpty()
				|| studentNum.isEmpty()
				|| course.isEmpty()) {

			JOptionPane.showMessageDialog(
					this,
					"Please fill in all required fields.",
					"Error",
					JOptionPane.ERROR_MESSAGE);

			return;
		}

		String studentInfo =
				"------ NDONIS INSTITUTE OF TECHNOLOGY ------\n" +
						"Name           : " + name + "\n" +
						"Surname        : " + surname + "\n" +
						"ID Number      : " + id + "\n" +
						"Student Number : " + studentNum + "\n" +
						"Course         : " + course + "\n" +
						"--------------------------------------------";

		displayArea.setText(studentInfo);

		JOptionPane.showMessageDialog(
				this,
				"Student information submitted successfully!");
	}

	private void clearAll() {
		nameField.setText("");
		surnameField.setText("");
		idField.setText("");
		studentNumField.setText("");
		courseField.setText("");
	}

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new StudentManagementSystem().setVisible(true);
			}
		});
	}
}