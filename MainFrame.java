import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainFrame extends JFrame{
    Panel_1 p1;
    stage p2;
    showResult p3;
    showLifeScore showLifeScore;
    CardLayout card;
    JPanel p;

    public MainFrame(){
		setSize(700,700);
		setTitle("Java Programing");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		p = new JPanel();
		p1 = new Panel_1(this);
		p2 = new stage(this);
		p3 = new showResult(this, p2);
	
		card = new CardLayout();
		p.setLayout(card);
		p.add(p1, "panel1");
		p.add(p2, "panel2");
		p.add(p3, "panel3");
		add(p);
	
		setVisible(true);
		setResizable(false);
    }

    
    public void panelChange(String str) {
    	if (str=="1") {
    	    card.show(p, "panel1");
    	    p1.requestFocusInWindow();
    	}
    	if (str=="2") {
    	    card.show(p, "panel2");
    	    p2.requestFocusInWindow();
    	    //p2.actionPerformed(null);
    	    p2.reset();
    	}
    	if (str=="3") {
    	    card.show(p, "panel3");
    	    p3.requestFocusInWindow();
    	}
    }

    public static void main(String[] args){
    	new MainFrame();
    }
}


