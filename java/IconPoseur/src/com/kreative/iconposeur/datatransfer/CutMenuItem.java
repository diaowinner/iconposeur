package com.kreative.iconposeur.datatransfer;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class CutMenuItem extends JMenuItem {
	private static final long serialVersionUID = 1L;
	
	public CutMenuItem() {
		super("剪切");
		int skm = Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();
		setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, skm));
		setActionCommand("剪切");
		addActionListener(TransferActionListener.getInstance());
	}
}
