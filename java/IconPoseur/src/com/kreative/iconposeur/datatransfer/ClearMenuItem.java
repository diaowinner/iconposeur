package com.kreative.iconposeur.datatransfer;

import javax.swing.JMenuItem;

public class ClearMenuItem extends JMenuItem {
	private static final long serialVersionUID = 1L;
	
	public ClearMenuItem() {
		super("清除");
		setActionCommand("清除");
		addActionListener(TransferActionListener.getInstance());
	}
}
