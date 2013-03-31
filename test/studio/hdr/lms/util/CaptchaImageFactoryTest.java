package studio.hdr.lms.util;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import org.junit.Test;

import studio.hdr.lms.util.CaptchaImageFactory;

public class CaptchaImageFactoryTest {

	@Test
	public void test() throws InterruptedException, InvocationTargetException {
		
		SwingUtilities.invokeAndWait(new Runnable(){
			public void run(){
				JFrame frame=new JFrame("查看验证码图片")                   ;
				frame.setSize(400, 400);
				frame.setVisible(true);
			}
		});
	}
	@Test
	public void testUnit(){
		System.out.println("执行了测试用例");
	}
	                                                                                     
	public static void main(String[]args) throws InterruptedException, InvocationTargetException{
		SwingUtilities.invokeAndWait(new Runnable(){
			public void run(){
				JFrame frame=new JFrame("查看验证码图片 ");
				frame.setSize(400, 400);
				frame.setVisible(true);
				frame.setDefaultCloseOperation(3);
				final MyPanel panel=new MyPanel();
				System.err.println(CaptchaImageFactory.getFactory().getCaptchaString());
				panel.setCaptchaImage(CaptchaImageFactory.getFactory().getCaptchaImage());
				frame.getContentPane().add(panel);
				
					
				panel.addMouseListener(new MouseListener(){

					public void mouseClicked(MouseEvent e) {
						System.err.println(CaptchaImageFactory.getFactory().getCaptchaString());
						panel.setCaptchaImage(CaptchaImageFactory.getFactory().getCaptchaImage());
						
					}

					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
				});
			}
		});
	}
	
}
class MyPanel extends JPanel{
	private BufferedImage captchaImage;

		
	public BufferedImage getCaptchaImage() {
		return captchaImage;
	}
	
	
	public void paint(Graphics g){
		if(this.captchaImage!=null)
			g.drawImage(captchaImage, 100, 100, null);
	}
	
	public void setCaptchaImage(BufferedImage captchaImage) {
		this.captchaImage = captchaImage;
		this.repaint();
	}
	
	
}
