import java.awt.*;
import java.awt.event.*; 
import javax.swing.*;

public class showLifeScore extends JPanel implements ActionListener{

    MainFrame mf;
    stage st;
    private String Life,Score;
    private int life,score;	
    Timer timer;
    
    public showLifeScore(MainFrame frame, stage sta){
		mf = frame;
		st = sta;
		timer = new Timer(20 ,this);
		timer.start();
    }

    public int getLife(){
    	return life;		
    }
    public void setLife(int lf){
		life = lf;
		Life = Integer.toString(life);
    }

    public int getScore(){
    	return score;
    }
    public void setScore(int sc){
		score = sc;
		Score = Integer.toString(score);
    }

    public void actionPerformed(ActionEvent e){
		setLife(st.life);
		setScore(st.score);
		if(life<=0){
			timer.stop();
			mf.panelChange("3");
		}
		repaint();
    }

    public void paintComponent(Graphics g){
    	super.paintComponent(g);
    	Dimension d=mf.getSize();
    	if(score>500&&score<=1000){
    		g.setColor(Color.red);
    	}else if(score>1000&&score<=1500){
    		g.setColor(Color.green);
    	}else if(score>1500&&score<=2000){
    		g.setColor(Color.blue);
    	}else{
    		g.setColor(Color.white);
    	}
    	g.fillRect(d.width-160,0,160,50);
    	if(score>2000){
    			g.setColor(Color.red);
    			g.fillRect(d.width-160,0,40,50);
    			g.setColor(Color.green);
    			g.fillRect(d.width-120,0,40,50);
    			g.setColor(Color.blue);
    			g.fillRect(d.width-80,0,40,50);
    			g.setColor(Color.yellow);
    			g.fillRect(d.width-40,0,40,50);
    	}
    	g.setColor(Color.black);
    	g.drawString("LIFE",d.width-150,20);
    	g.drawString(Life,d.width-70,20);
    	g.drawString("SCORE",d.width-150,40);
    	g.drawString(Score,d.width-70,40);
    }
}