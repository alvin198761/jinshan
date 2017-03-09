package org.jinshan.gui.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Insets;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jinshan.gui.ctrl.BackgroupPane;
import org.jinshan.gui.ctrl.BaseOpaqueCtrl;
import org.jinshan.gui.ctrl.JDragPanel;
import org.jinshan.gui.ctrl.JEnableImageButton;
import org.jinshan.gui.ctrl.JImageButton;
import org.jinshan.util.ResourceUtil;

/**
 * 主窗体
 * 
 * @author Administrator
 * 
 */
public class MainFrame extends BaseFrame {

	private static final long serialVersionUID = 1L;

	public MainFrame() {
		setTitle("超人词霸-Java Swing 版");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(700, 550);
		setLocationRelativeTo(null);
		JDragPanel contentPanel = new JDragPanel(this);
		setContentPane(contentPanel);
		// 界面分为 上中下三个部分
		BaseOpaqueCtrl topPane = new BaseOpaqueCtrl();
		BaseOpaqueCtrl centerPane = new BaseOpaqueCtrl();
		BaseOpaqueCtrl bottomPane = new BaseOpaqueCtrl();

		contentPanel.add(topPane, BorderLayout.NORTH);
		contentPanel.add(centerPane, BorderLayout.CENTER);
		contentPanel.add(bottomPane, BorderLayout.SOUTH);
		// TOP分为上左中右三个部分，中间才是主题
		BackgroupPane topBg = new BackgroupPane(ResourceUtil.topBgImage) {
			private static final long serialVersionUID = 1L;

			@Override
			public Insets getInsets() {
				return new Insets(1, 0, 0, 0);
			}
		};
		topPane.add(new JLabel(ResourceUtil.topLeftIcon), BorderLayout.WEST);
		topPane.add(topBg, BorderLayout.CENTER);
		topPane.add(new JLabel(ResourceUtil.topRightIcon), BorderLayout.EAST);
		// titile
		BaseOpaqueCtrl titleBox = new BaseOpaqueCtrl();
		JLabel lable = new JLabel("超人词霸V0.2 --搞笑版");
		lable.setForeground(Color.WHITE);
		titleBox.add(lable);
		Box frameBox = Box.createHorizontalBox();
		frameBox.add(new JImageButton(ResourceUtil.menuIcon));
		frameBox.add(new JImageButton(ResourceUtil.maxmizeIcon));
		frameBox.add(new JImageButton(ResourceUtil.restoreIcon));
		frameBox.add(new JImageButton(ResourceUtil.miniIcon));
		frameBox.add(new JImageButton(ResourceUtil.closeIcon));
		titleBox.add(frameBox, BorderLayout.EAST);
		topBg.add(titleBox, BorderLayout.NORTH);
		// tool
		BaseOpaqueCtrl toolPanel = new BaseOpaqueCtrl();
		FlowLayout layout = new FlowLayout();
		layout.setAlignment(FlowLayout.LEFT);
		layout.setHgap(20);
		toolPanel.setLayout(layout);
		toolPanel.add(new JImageButton(ResourceUtil.dictIcon));
		toolPanel.add(new JImageButton(ResourceUtil.transIcon));
		toolPanel.add(new JImageButton(ResourceUtil.sentenceIcon));
		topBg.add(toolPanel, BorderLayout.CENTER);

		// 中间的面板
		BackgroupPane searchPane = new BackgroupPane(ResourceUtil.searchBgImage);
		// 圆角图片的效果
		Box cornerBox = Box.createHorizontalBox();
		cornerBox.add(new JLabel(ResourceUtil.trans_leftIcon),
				BorderLayout.WEST);
		cornerBox.add(Box.createGlue());
		cornerBox.add(new JLabel(ResourceUtil.trans_rightIcon),
				BorderLayout.EAST);
		//
		searchPane.add(cornerBox, BorderLayout.NORTH);
		BaseOpaqueCtrl searchButtonPanel = new BaseOpaqueCtrl() {
			private static final long serialVersionUID = 1L;

			@Override
			public Insets getInsets() {
				return new Insets(10, 10, 10, 10);
			}
		};
		Box backBox = Box.createHorizontalBox();
		backBox.add(new JEnableImageButton(ResourceUtil.backIcon));
		backBox.add(new JEnableImageButton(ResourceUtil.nextIcon));
		searchButtonPanel.add(backBox, BorderLayout.WEST);
		JTextField text = new JTextField();
		text.setBorder(null);
		JImageButton dropButton = new JImageButton(
				ResourceUtil.searchResultMenuIcon);
		BackgroupPane textPanel = new BackgroupPane(ResourceUtil.comBox_bgIcon) {
			private static final long serialVersionUID = 1L;

			@Override
			public Insets getInsets() {
				return new Insets(1, 0, 2, 0);
			}
		};
		textPanel.add(text, BorderLayout.CENTER);
		textPanel.add(dropButton, BorderLayout.EAST);
		searchButtonPanel.add(textPanel, BorderLayout.CENTER);
		searchButtonPanel.add(new JImageButton(ResourceUtil.searchIcon),
				BorderLayout.EAST);
		searchPane.add(searchButtonPanel, BorderLayout.CENTER);
		//
		centerPane.add(searchPane, BorderLayout.NORTH);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(251, 251, 251));
		centerPane.add(panel, BorderLayout.CENTER);

		// Bottom和头部一样
		BackgroupPane bottomButtonPane = new BackgroupPane(
				ResourceUtil.footBgImage);
		layout = new FlowLayout();
		layout.setHgap(5);
		layout.setAlignment(FlowLayout.RIGHT);
		bottomButtonPane.setLayout(layout);
		//
		bottomButtonPane.add(new JLabel(" "));
		bottomButtonPane.add(new JImageButton(ResourceUtil.miniBoxIcon));
		bottomButtonPane.add(new JImageButton(ResourceUtil.grapIcon));
		bottomButtonPane.add(new JImageButton(ResourceUtil.selectIcon));

		bottomPane.add(new JLabel(ResourceUtil.footLeft), BorderLayout.WEST);
		bottomPane.add(bottomButtonPane, BorderLayout.CENTER);
		bottomPane.add(new JLabel(ResourceUtil.footRight), BorderLayout.EAST);
		setVisible(true);
	}
}
