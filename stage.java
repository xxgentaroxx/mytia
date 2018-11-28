import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class stage extends JPanel implements ActionListener,KeyListener {
    
    MainFrame mf;
    int n;
    int score;
    int life;
    int FontSize;
    //int hantei;
    Hantei hantei;
    showLifeScore sls;
    int[] alph;
    int[] x;
    int[] y;
    String[] moji;
    boolean[] alive;
    Timer timer;
    Image bg;
    int bg_w,bg_h;
    int judge;
    int judgecount;
    String judgestring;
    int xmax;

    
    public stage(MainFrame frame) {
		Dimension d;
		d = frame.getSize();
		mf = frame;
		setFocusable(true);
		addKeyListener(this);
		FontSize =40;
		hantei = new Hantei((d.height*9/10-2*FontSize/3));
		sls = new showLifeScore(mf, this);
		n = 4;
		//hantei.y_location = 0;
		score = 0;
		life = 3;
		alph = new int[n];
		x = new int[n];
		y = new int[n];
		moji = new String[n];
		alive = new boolean[n];
		setBackground(Color.white);
		timer = new Timer(8 ,this);
		//timer.start();
		ImageIcon icon1 = new ImageIcon(getClass().getResource("background.png"));
		bg = icon1.getImage();
    	bg_w = bg.getWidth(this);
    	bg_h = bg.getHeight(this);
		judge = 0;
		judgecount = 0;
		judgestring = null;
		xmax = 0;

    }
    
    public void reset() {
		score = 0;
		life = 3;
		for(int i=0; i<n; i++){
			alive[i] = false;
		}
		timer.setDelay(10);
		timer.start();
		sls.timer.start();
    }
    
    public void keyTyped(KeyEvent e) {
    }
    
    public void keyPressed(KeyEvent e) {
    	int ymax = 0;
    	int imax = 0;
		for(int i=0;i<n;i++){
		    if(alive[i]){
		    	if(y[i]>ymax){
		    		xmax = x[i];
		    		ymax = y[i];
		    		imax = i;
		    	}
		    }
		}
		judge = hantei.JudgeScore(alph[imax],e.getKeyCode(),y[imax]);
    	if(judge!=0){
    		alive[imax]=false;
    		score+=judge;
    		judge = 0;
    		judgecount = 50;
    	}
    	judgestring = hantei.Judge(alph[imax],e.getKeyCode(),y[imax]);
		sls.setLife(life);
		//repaint ();
		System.out.println(score);
		System.out.println(life);
		System.out.println(y[imax]);
    }
    
    public void keyReleased(KeyEvent e) {
    }
    
    public void actionPerformed(ActionEvent e) {
		Dimension d = getSize();
		/*if(e==null){
			timer.start();
			life = 10;
			score = 0;
		}*/
		if (e.getSource()==timer) {
			for(int i=0;i<n;i++){
				if (alive[i] == false) {
					double r = Math.random();
					double rand = Math.random();
					if (r<0.01) {
						x[i] = (int)((int)(Math.random()*3)*(d.width)/3+(d.width)/6)-FontSize/2;
						y[i] = 0;
						if(rand<=0.27)alph[i] = (int)(Math.random()*10+48);
						if(rand>0.27)alph[i] = (int)(Math.random()*26+65);
						moji[i] = String.valueOf(KeyEvent.getKeyText(alph[i]));
						alive[i] = true;
					}
				}
			}
		    for (int i=0; i<n; i++) {
				y[i]+=1;
				if (alive[i]==true&&y[i]>d.height){
				    alive[i]=false;
				    life--;
				}
		    }
		    if(life<=0){
				timer.stop();
				System.out.println("Game Over");
		    }
		    judgecount--;
		    repaint();
		    if(score>=1000){
		    	timer.setDelay(7);
		    }
		    if(score>=2000){
		    	timer.setDelay(4);
		    }
		}
    }
    
    public int getScore(){
    	return score;
    }
    
    public void paintComponent(Graphics g) {
      	Dimension d = getSize();
		super.paintComponent(g);
    	g.drawImage(bg, 0, 0, this);
		/*for(int i=0; i<d.width; i++){
			g.setColor(new Color(255,255,(int)(127*(1-Math.cos(i*6*Math.PI/d.width)))));
			g.drawLine(i, 0, i, d.height);
		}*/
		g.setColor(Color.red);
		g.fillRect(0, (int)(d.height*9/10)-20, d.width, 40);
		g.setColor(Color.magenta);
		g.fillRect(0, (int)(d.height*9/10)-10, d.width, 20);
		g.setColor(Color.black);
		g.setFont( new Font ("Century", Font.ITALIC, FontSize));
		g.drawLine(0, (int)(d.height*9/10), d.width, (int)(d.height*9/10));
		for (int i=0; i<n; i++){
		    if(alive[i]){
		    	for(int j=0;j<n;j++){
					//int counts=-2;
					if(FontSize>Math.abs(y[i]-y[j])+10&&i!=j&&alive[j]&&FontSize>Math.abs(x[j]-x[i])){
						//y[j]+=5;
						//counts=i;
						//y[i]-=5;
						if(y[i]-y[j]>0)alive[j]=false;
						if(y[i]-y[j]<0)alive[i]=false;
						break;
					}
				}
		    	g.drawString(moji[i],x[i],y[i]);
		    }
		}
		g.setFont( new Font ("Century", Font.ITALIC, 20));
		if (score>=900 && score<1000){
			g.drawString("1st Boost mode approaching...", 80, d.height-10);
		}
		if (score>=1900 && score<2000){
			g.drawString("2nd Boost mode approaching...", 80, d.height-10);
		}
		sls.paintComponent(g);
		if (judgecount>0){
			g.drawString(judgestring, xmax, (int)(d.height*9/10));
		}
    }
}