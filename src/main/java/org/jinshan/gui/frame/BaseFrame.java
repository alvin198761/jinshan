package org.jinshan.gui.frame;

import javax.swing.JFrame;

import com.sun.awt.AWTUtilities;

/**
 * 窗体的基类
 * 
 * @author Administrator
 * 
 */
public class BaseFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	public BaseFrame() {
		setUndecorated(true);
		setIconImage(null);
	}

	@Override
	public void setVisible(boolean b) {
		super.setVisible(b);
		if (b) {
			// 窗体透明效果，这个类在很多jdk上面是引用不到的
			// ，我曾经换了4个JDK，在jdk1.6u37上面才成功的调用到
			AWTUtilities.setWindowOpaque(this, false);
		}
	}

}
