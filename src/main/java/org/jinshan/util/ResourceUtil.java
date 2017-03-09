package org.jinshan.util;

import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class ResourceUtil {

    private ResourceUtil() {
    }

    public static ImageIcon logoIcon;
    public static ImageIcon menuIcon;
    public static ImageIcon miniIcon;
    public static ImageIcon restoreIcon;
    public static ImageIcon maxmizeIcon;
    public static ImageIcon closeIcon;
    public static ImageIcon topLeftIcon;
    public static ImageIcon topRightIcon;
    public static ImageIcon footLeft;
    public static ImageIcon footRight;
    public static ImageIcon trans_leftIcon;
    public static ImageIcon trans_rightIcon;
    public static ImageIcon backIcon;

    public static Image topBgImage;
    public static Image footBgImage;
    public static Image searchBgImage;
    public static ImageIcon nextIcon;
    public static ImageIcon searchResultMenuIcon;
    public static ImageIcon searchIcon;
    public static Image comBox_bgIcon;
    public static ImageIcon dictIcon;
    public static ImageIcon transIcon;
    public static ImageIcon sentenceIcon;
    public static ImageIcon arrowIcon;
    public static ImageIcon wordIcon;
    public static ImageIcon bookIcon;
    public static ImageIcon selectIcon;
    public static ImageIcon grapIcon;
    public static ImageIcon miniBoxIcon;

    public static void loadResouce() throws Exception {
        logoIcon = getIcon("logo.bmp");
        menuIcon = getIcon("menu.bmp");
        miniIcon = getIcon("minimize_btn.bmp");
        restoreIcon = getIcon("restore_btn.bmp");
        maxmizeIcon = getIcon("maxmize_btn.bmp");
        closeIcon = getIcon("close_btn.bmp");
        //
        topLeftIcon = getIcon("top_left.bmp");
        topRightIcon = getIcon("top_right.bmp");
        topBgImage = getImage("top_middle.bmp");
        //
        footLeft = getIcon("foot_left.bmp");
        footRight = getIcon("foot_right.bmp");
        footBgImage = getImage("foot_middle.bmp");
        //
        searchBgImage = getImage("search_bg_middle.bmp");
        trans_leftIcon = getIcon("trans_left_corner.bmp");
        trans_rightIcon = getIcon("trans_right_corner.bmp");
        backIcon = getIcon("prev_btn.bmp");
        nextIcon = getIcon("next_btn.bmp");
        searchResultMenuIcon = getIcon("combobox_drop_btn.bmp");
        searchIcon = getIcon("lookup_btn.bmp");
        comBox_bgIcon = getImage("combox_bk.bmp");
        //
        dictIcon = getIcon("dictionary_btn.bmp");
        transIcon = getIcon("translation_btn.bmp");
        sentenceIcon = getIcon("sentence_btn.bmp");
        //
        arrowIcon = getIcon("arrow.bmp");
        wordIcon = getIcon("beidanci.bmp");
        bookIcon = getIcon("newword_btn.bmp");
        //
        selectIcon = getIcon("select_disable_btn.bmp");
        grapIcon = getIcon("grab_enable_btn.bmp");
        miniBoxIcon = getIcon("mini_btn.bmp");

    }

    private static ImageIcon getIcon(String name) throws Exception {
        return new ImageIcon(getImage(name));
    }

    private static Image getImage(String name) throws Exception {
        try {
            return BMPDecoder.getBMPImage(ResourceUtil.class.getResource("/" + name)
                    .openStream());
        } catch (Exception ex) {
            System.out.println(name);
        }
        return null;
    }

    /**
     * 图片转为内存图
     *
     * @param image
     * @return
     */
    public static BufferedImage toBufferedImage(Image image) {
        if (image instanceof BufferedImage) {
            return (BufferedImage) image;
        }
        image = new ImageIcon(image).getImage();
        boolean hasAlpha = false;
        BufferedImage bimage = null;
        GraphicsEnvironment ge = GraphicsEnvironment
                .getLocalGraphicsEnvironment();
        try {
            int transparency = Transparency.OPAQUE;
            if (hasAlpha) {
                transparency = Transparency.BITMASK;
            }
            GraphicsDevice gs = ge.getDefaultScreenDevice();
            GraphicsConfiguration gc = gs.getDefaultConfiguration();
            bimage = gc.createCompatibleImage(image.getWidth(null), image
                    .getHeight(null), transparency);
        } catch (HeadlessException e) {
            e.printStackTrace();
        }
        if (bimage == null) {
            int type = BufferedImage.TYPE_INT_RGB;
            if (hasAlpha) {
                type = BufferedImage.TYPE_INT_ARGB;
            }
            bimage = new BufferedImage(image.getWidth(null), image
                    .getHeight(null), type);
        }
        Graphics g = bimage.createGraphics();
        g.drawImage(image, 0, 0, null);
        g.dispose();
        return bimage;
    }

}
