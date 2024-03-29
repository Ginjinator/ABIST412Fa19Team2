package Controller;


import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//use .setVisible(boolean) command to show Date Dialog object
//.setPreferredSize(new Dimension(570,417)); and setSize(new Dimension(570, 417)); change dimension of dialog

/*
This code shows the use of a JDateChooser. This can be
implemented without the use of a DateDialog
		JDateChooser birthdate = new JDateChooser();
		birthdate.setBounds(10, 219, 154, 20);

		This gets the date from the JDateChooser
		((JTextField)birthdate.getDateEditor().getUiComponent()).getText() --- same as getDate() method below, returns a string
*/

public class DateDialog extends JDialog {
	private JDateChooser cal;

	public DateDialog(String LabelText) {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		setSize(new Dimension(320, 152));
		setPreferredSize(new Dimension(320, 119));
		setTitle(LabelText);
		JLabel lblNewLabel = new JLabel(LabelText);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		JDateChooser calendar = new JDateChooser();
		JButton btnNewButton = new JButton("Ok");

		cal = calendar;

		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 309, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
								.addComponent(calendar, GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
								.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
								.addGap(132)
								.addComponent(btnOk)
								.addContainerGap(132, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblNewLabel)
								.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(calendar, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(btnOk)
								.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cal = calendar;
				DateDialog.this.dispose();

			}
		});


	}

	public String getDate() {

		return ((JTextField) cal.getDateEditor().getUiComponent()).getText();
	}
}
