package org.jinshan.sys;

import org.jinshan.gui.frame.MainFrame;
import org.jinshan.util.ResourceUtil;

public class JinShanSys {

	private JinShanSys() {
	}

	private static MainFrame mianFrame;

	public static void start() {
		try {
			ResourceUtil.loadResouce();
		} catch (Exception e) {
			e.printStackTrace();
		}
		mianFrame = new MainFrame();
	}

}
