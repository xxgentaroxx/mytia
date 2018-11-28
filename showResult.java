import java.awt.*;
import java.awt.event.*; 
import javax.swing.*;

public class showResult extends JPanel implements ActionListener, KeyListener{

    MainFrame mf;
    stage sls;
    private String Score,rank;
    private int life, score;
    Timer timer;
    
    public showResult(MainFrame frame, stage show){
		mf = frame;
		sls = show;
		setFocusable(true);
		addKeyListener(this);
		timer = new Timer(20 ,this);
		timer.start();
    }

    public void setLife(int lf){
    	life =lf;	
    }
    
    public void setScore(int sc){
		score = sc;
		Score = Integer.toString(score);
		repaint();
    }
    
    public void actionPerformed(ActionEvent e){
	setLife(sls.life);
	setScore(sls.score);
	if(life<=0){
		//timer.stop();
		if(score>2000){
		    rank="A";
		}else if(score<=2000&&score>1500){
		    rank="B";
		}else if(score<=1500&&score>1000){
		    rank="C";
		}else if(score<=1000&&score>500){
		    rank="D";
		}else if(score<=500&&score>0){
		    rank="E";
		}else{
		    rank="F";
		}
	}
    }

    public void keyTyped(KeyEvent e) {
    }
    public void keyPressed(KeyEvent e) {
		if (KeyEvent.VK_ENTER == e.getKeyCode()) {
			mf.panelChange("1");
		}
		repaint();
    }
    public void keyReleased(KeyEvent e) {
    }

    public void paintComponent(Graphics g){
    	super.paintComponent(g);
    	Dimension d=mf.getSize();
    	g.setFont( new Font ("Century", Font.ITALIC, 30));
    	g.setColor(Color.black);
    	g.drawString("RANK",d.width/2-100,d.height/2-45);
    	g.drawString("SCORE",d.width/2-100,d.height/2);
    	g.drawString(Score,d.width/2+80,d.height/2);
    	g.setFont( new Font ("Century", Font.ITALIC, 25));
    	g.drawString("Title"+"    "+"Press"+" "+"Enter",d.width/2-100,d.height/2+60);
    	g.setFont( new Font ("Century", Font.ITALIC, 90));
    	if(rank=="A"){
    	    g.setColor(Color.yellow);
    	}else if(rank=="B"){
    	    g.setColor(Color.blue);
    	}else if(rank=="C"){
    	    g.setColor(Color.green);
    	}else if(rank=="D"){
    	    g.setColor(Color.red);
    	}
    	g.drawString(rank,d.width/2+60,d.height/2-30);
    }
}