package presentation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * 重写JLabel，用于自定义显示图片
 * @author RuiLin.Xie - xKF24276
 *
 */
public class PhotoLabel extends JLabel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//图片
	private Image img;

	public  PhotoLabel(Image image) {
		// TODO Auto-generated constructor stub
		this.img = image;
	}	
	
	/**
	 * 重写label绘画方法
	 */
	@Override
	protected void paintComponent(Graphics g)
	{
		
		super.paintComponent(g);
		//缩放到与label同大小
		int photoWidth = img.getWidth(null);
		int photoHeight = img.getHeight(null);
		int height = this.getHeight();
		int width = (int) (((photoWidth+0.0)/photoHeight)*height); 
//		System.out.println("width height : "+ photoWidth +" "+photoHeight);
		g.drawImage(img, 0, 0, width, height, null);
		g = null;
	}
	
	public PhotoLabel(Dimension preferredDimension){
		this.setBackground(Color.LIGHT_GRAY);
//		this.setOpaque(true);
		this.setPreferredSize(preferredDimension);
		this.setHorizontalAlignment(SwingConstants.CENTER);
		this.repaint();
	}
	

	public void setImage(Image image){
		this.img = image;
	}
	
	public void setImage(ImageIcon icon){
		this.img = icon.getImage();
	}
}

