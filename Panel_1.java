import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Panel_1 extends JPanel implements KeyListener, ActionListener{

	Timer timer;
    MainFrame mf;
    Image keyboard;
    int key_img_w,key_img_h;
    int key_img_flg=0;

    public Panel_1(MainFrame frame){
    	timer = new Timer(500, this);
    	ImageIcon icon1 = new ImageIcon(getClass().getResource("keyboard.png"));
    	keyboard = icon1.getImage();
    	key_img_w = keyboard.getWidth(this);
    	key_img_h = keyboard.getHeight(this);
    	mf = frame;   
    	timer.start();
    	setFocusable(true);
    	addKeyListener(this);
    }

    public void actionPerformed(ActionEvent e){
    	if(e.getSource()==timer){
    		if(key_img_flg==0){
    			key_img_flg=1;
    			}
    		if(key_img_flg==2){
    			key_img_flg=0;
    			}
    		repaint();
    		}
    	}

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
    	if ( KeyEvent.VK_ENTER == e.getKeyCode()) {
    		mf.panelChange("2");
    		//new stage(mf);
    	}
    	repaint ();
    }

    public void keyReleased(KeyEvent e) {
    }

    public void paintComponent(Graphics g) {
    	Dimension d = getSize();
    	super.paintComponent(g);
    	g.drawImage(keyboard, ((d.width)-(key_img_w))/2, ((d.height)-(key_img_h))/2, this);
    	g.setFont( new Font ("Century", Font.ITALIC,70));
    	g.drawString("Typing Game",d.width/2-230,110);
    	g.setFont( new Font ("Century", Font.ITALIC,20));
    	g.drawString("MADE BY MYTIA",d.width-180,d.height-15);
    	if(key_img_flg==1){
    		g.setFont( new Font ("Century", Font.ITALIC, 50));
    		g.drawString("Press Enter", d.width/2-140, d.height-80);
    		key_img_flg=2;
    	}
    }
}
