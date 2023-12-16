package com.kreative.iconposeur;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SaveChangesDialog extends JDialog {
	private static final long serialVersionUID = 1L;
	
	public static enum Action { SAVE, CANCEL, DONT_SAVE }
	
	private JLabel label;
	private JButton dontSaveButton;
	private JButton cancelButton;
	private JButton saveButton;
	private Action action;
	
	public SaveChangesDialog(Dialog parent, String name) {
		super(parent, "保存更改");
		setModal(true);
		make(name);
	}
	
	public SaveChangesDialog(Frame parent, String name) {
		super(parent, "保存更改");
		setModal(true);
		make(name);
	}
	
	public SaveChangesDialog(Window parent, String name) {
		super(parent, "保存更改");
		setModal(true);
		make(name);
	}
	
	private void make(String name) {
		label = new JLabel("在关闭之前，保存更改至\u201C" + name + "\u201D？");
		dontSaveButton = new JButton("不保存");
		cancelButton = new JButton("取消");
		saveButton = new JButton("保存");
		
		JPanel leftButtonPanel = new JPanel(new FlowLayout());
		leftButtonPanel.add(dontSaveButton);
		JPanel rightButtonPanel = new JPanel(new FlowLayout());
		rightButtonPanel.add(cancelButton);
		rightButtonPanel.add(saveButton);
		JPanel buttonPanel = new JPanel(new BorderLayout());
		buttonPanel.add(leftButtonPanel, BorderLayout.WEST);
		buttonPanel.add(rightButtonPanel, BorderLayout.EAST);
		JPanel mainPanel = new JPanel(new BorderLayout(8, 8));
		mainPanel.add(label, BorderLayout.CENTER);
		mainPanel.add(buttonPanel, BorderLayout.PAGE_END);
		mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		
		setContentPane(mainPanel);
		SwingUtils.setDontSaveButton(getRootPane(), dontSaveButton);
		SwingUtils.setCancelButton(getRootPane(), cancelButton);
		SwingUtils.setDefaultButton(getRootPane(), saveButton);
		setResizable(false);
		pack();
		setLocationRelativeTo(null);
		saveButton.requestFocusInWindow();
		
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				action = Action.SAVE;
				dispose();
			}
		});
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				action = Action.CANCEL;
				dispose();
			}
		});
		dontSaveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				action = Action.DONT_SAVE;
				dispose();
			}
		});
	}
	
	public Action showDialog() {
		action = Action.CANCEL;
		setVisible(true);
		return action;
	}
}
