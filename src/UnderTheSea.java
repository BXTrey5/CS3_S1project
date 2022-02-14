import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.imageio.*;
import java.io.*;
import javax.sound.sampled.*;


public class UnderTheSea
{
	public static void main(String...args)
	{
		JFrame j = new JFrame();  //JFrame is the window; window is a depricated class
		MyPanelb m = new MyPanelb();
		j.setSize(m.getSize());
		j.add(m); //adds the panel to the frame so that the picture will be drawn
		     //use setContentPane() sometimes works better then just add b/c of greater efficiency.
		j.setVisible(true); //allows the frame to be shown.
		
		try {
			Clip sound = AudioSystem.getClip();
	        sound.open(AudioSystem.getAudioInputStream(new File("spongebob.wav")));
	        sound.start();
		}
		catch (Exception e) {
		    System.out.println("ERROR" + e);
		}
		
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //makes the dialog box exit when you click the "x" button.
	}
}

class MyPanelb extends JPanel implements ActionListener, MouseListener, KeyListener
{
	private Timer time;
	private int x,y;
	private int add;
	
	MyPanelb()
	{
		time = new Timer(15, this); //sets delay to 15 millis and calls the actionPerformed of this class.
		setSize(1000,650);//change window size
		setVisible(true); //it's like calling the repaint method.
		this.addMouseListener(this);
		this.addKeyListener(this);
		this.setFocusable(true);
		time.start();
		add=1;
		x=y=500;
	}

	public void paintComponent(Graphics g)
	{
		g.fillRect(0,0,2000,1500);
		drawsea(g,x,y);
		drawShip(g,x,y);
		drawChest(g,x,y);
		drawBackground(g,x,y);
		drawBubbles(g, x, y);
	}

	public void drawsea(Graphics g, int x, int y)
	{

		//FISH
		// 245, 245, 220
		//Background
		

		Color SeaBlue=new Color(74,172,207);
		g.setColor(SeaBlue);
		g.fillRect(0,0,2000,1500);
		
		Color myWhite2 = new Color(255,230,129);
		g.setColor(myWhite2);
		g.fillRect(0,475,2000,700);
		
		
		// Body
		Color myBlue = new Color(34,84,168);
		//Color myBlue = new Color(27,128,174);
		g.setColor(myBlue);
		Polygon tri=new Polygon();//fish 1
		tri.addPoint(235+x,50);
		tri.addPoint(247+x,60);
		tri.addPoint(260+x,55);
		tri.addPoint(270+x,53);
		tri.addPoint(273+x,49);
		tri.addPoint(276+x,48);
		tri.addPoint(278+x,51);
		tri.addPoint(290+x,52);
		tri.addPoint(302+x,53);
		tri.addPoint(310+x,55);
		tri.addPoint(315+x,65);
		tri.addPoint(308+x,70);
		tri.addPoint(300+x,73);
		tri.addPoint(290+x,75);
		tri.addPoint(273+x,73);
		tri.addPoint(250+x,73);
		tri.addPoint(240+x,72);
		tri.addPoint(235+x,77);
		tri.addPoint(238+x,65);
		tri.addPoint(235+x,50);
		g.fillPolygon(tri);
		
		Polygon fish1=new Polygon();//2nd fish
		fish1.addPoint(35+x,40);
		fish1.addPoint(47+x,50);
		fish1.addPoint(60+x,45);
		fish1.addPoint(70+x,43);
		fish1.addPoint(73+x,39);
		fish1.addPoint(76+x,38);
		fish1.addPoint(78+x,41);
		fish1.addPoint(90+x,42);
		fish1.addPoint(102+x,43);
		fish1.addPoint(110+x,45);
		fish1.addPoint(115+x,55);
		fish1.addPoint(108+x,60);
		fish1.addPoint(100+x,63);
		fish1.addPoint(90+x,65);
		fish1.addPoint(73+x,63);
		fish1.addPoint(50+x,63);
		fish1.addPoint(40+x,62);
		fish1.addPoint(35+x,67);
		fish1.addPoint(38+x,55);
		fish1.addPoint(35+x,40);
		g.fillPolygon(fish1);
		
		Polygon fish2=new Polygon();//3rd fish
		fish2.addPoint(5+x,140);
		fish2.addPoint(17+x,150);
		fish2.addPoint(30+x,145);
		fish2.addPoint(40+x,143);
		fish2.addPoint(43+x,139);
		fish2.addPoint(46+x,138);
		fish2.addPoint(48+x,141);
		fish2.addPoint(60+x,142);
		fish2.addPoint(72+x,143);
		fish2.addPoint(80+x,145);
		fish2.addPoint(85+x,155);
		fish2.addPoint(78+x,160);
		fish2.addPoint(70+x,163);
		fish2.addPoint(60+x,165);
		fish2.addPoint(43+x,163);
		fish2.addPoint(20+x,163);
		fish2.addPoint(10+x,162);
		fish2.addPoint(5+x,167);
		fish2.addPoint(8+x,155);
		fish2.addPoint(5+x,140);
		g.fillPolygon(fish2);
		
		//Eyes
		g.setColor(Color.WHITE);
		g.fillOval(300 + x,55,5,5);//fish 1 eyes
		g.fillOval(100 + x,45,5,5);//fish 2 eyes
		g.fillOval(70 + x,145,5,5);//fish 3 eyes
		

	}	
	public void drawShip(Graphics g, int x, int y)
	{
		
		Color myBrown = new Color(195,143,93);
		g.setColor(myBrown);
		int xCoord[]={360,400,405,420,425,425,452,460,465,475,475,550,565,575,585,603,625,647,650,660,660,700,760,775,785,780,788,782,745,740,735,726,715};
		int yCoord[]={530,490,495,485,475,470,447,455,440,438,425,380,388,388,400,400,380,380,353,350,333,325,325,300,295,315,323,340,450,488,500,513,525};
		g.fillPolygon(xCoord,yCoord,33);//ship outline
		
		g.setColor(Color.BLACK);
		g.drawArc(385,350,1180,530,110,50);
		g.drawArc(425,370,1035,475,110,50);
		g.drawArc(490,385,940,385,115,50);
		g.drawArc(540,400,750,390,115,45);
		g.drawArc(595,425,535,315,115,45);
		g.drawArc(645,455,335,210,115,45);
		g.drawArc(645,455,335,210,115,45);
		g.drawArc(666,480,220,200,110,35);
		
		//Ship Hole
		
		int xCoordinate[]={535,560,562,571,569,655,660,677,677,682,653,655,685,695,695,670,650,637,617,575,560,537,537,526,540};
		int yCoordinate[]={465,451,470,469,451,404,412,415,420,426,435,440,445,438,450,475,473,472,490,495,490,495,488,488,475};
		g.fillPolygon(xCoordinate,yCoordinate,25);
		
		Color SeaBlue = new Color(40,208,235);
		g.setColor(SeaBlue);
		int xinner[]={590,615,620,614,612,623,624,603,600,594};
		int yinner[]={456,437,439,447,462,455,460,473,463,464};
		g.fillPolygon(xinner,yinner,10);
		
		g.setColor(myBrown);
		int xwood[]={635,643,660,650};
		int ywood[]={413,412,475,478};
		g.fillPolygon(xwood,ywood,4);
		int xw[]={569,574,576,583,575};
		int yw[]={485,476,483,494,495};
		g.fillPolygon(xw,yw,5);
		g.setColor(Color.BLACK);
		g.drawLine(649,473,660,474);
		g.drawLine(635,414,643,412);
		g.drawLine(569,485,576,483);
		
		// Sand arcs
		
		Color mySand = new Color(255,230,129);
		g.setColor(mySand);
		g.fillArc(275,515,300,295,75,35);
		g.fillArc(345,510,300,295,75,35);
		g.fillArc(405,515,300,295,75,35);
		g.fillArc(455,510,300,280,75,35);
		g.fillArc(505,515,300,295,75,35);
		g.fillArc(560,515,270,295,75,35);
		g.fillArc(245,510,300,295,75,35);
		
		g.setColor(Color.BLACK);
		g.drawArc(275,515,300,295,75,35);
		g.drawArc(345,510,300,295,75,35);
		g.drawArc(405,515,300,295,75,35);
		g.drawArc(455,510,300,280,75,35);
		g.drawArc(505,515,300,295,75,35);
		g.drawArc(560,515,270,295,75,35);
		g.drawArc(245,510,300,295,75,35);
		
		//Flag
		
		int xtriangle[]= {575,550,563};
		int ytriangle[]= {275,270,260};
		g.setColor(myBrown);
		int xpole1[]= {475,548,569,637,568,547};
		int ypole1[]= {245,284,290,333,295,288};
		g.fillPolygon(xpole1,ypole1,6);
		g.drawLine(525,395,550,380);
		g.setColor(myBrown);
		int xpole2[]={525,550,575,550};
		int ypole2[]={395,380,275,270};
		g.fillPolygon(xpole2,ypole2,4);
		g.fillPolygon(xtriangle,ytriangle,3);
		
		g.setColor(Color.RED);
		int xflag1[]= {577,559,576,580,596,605,625};
		int yflag1[]= {300,363,350,374,362,376,325};
		int xflag2[]= {481,450,472,473,490,504,540};
		int yflag2[]= {249,337,320,340,327,354,282};
		g.fillPolygon(xflag1,yflag1,7);
		g.fillPolygon(xflag2,yflag2,7);
		g.setColor(Color.BLACK);
		g.drawLine(575,275,550,270);
	}
	
	public void drawChest(Graphics g, int x, int y)
	{
		int xchest[]= {263,254,200,150,150,200,263,213,150,130,193,213};
		int ychest[]= {529,574,591,576,536,555,529,511,536,500,475,512};
		g.drawPolygon(xchest,ychest,12);
		Color mygold=new Color(191,155,48);
		g.setColor(mygold);
		int xrect[]= {263,200,150,213};
		int yrect[]= {529,555,536,511};
		g.fillPolygon(xrect,yrect,4);
		Color mySilver=new Color(115,115,115);
		g.setColor(mySilver);
		g.fillPolygon(xchest,ychest,12);
		g.setColor(Color.BLACK);
		g.drawLine(200, 591, 200, 555);
		
		int xfront[]= {258,249,205,205};
		int yfront[]= {537,569,586,560};
		Color myBrown = new Color(195,143,93);
		g.setColor(myBrown);
		g.fillPolygon(xfront,yfront,4);
		int xside[]= {195,155,155,195};
		int yside[]= {584,571,541,558};
		g.fillPolygon(xside,yside,4);
		int xtop[]= {207,155,138,188};
		int ytop[]= {507,531,503,480};
		g.fillPolygon(xtop,ytop,4);
	}
	
	
	public void drawBackground(Graphics g, int x, int y)
	{
		//Draw Kelp
		g.setColor(Color.BLACK);
		int xkelp[]= {25,27,23,28,25,26,29,28,24,25,31,30,28,32,44,50,54,51,55,50,55,54,50,50,48,49};
		int ykelp[]= {550,540,527,523,506,493,489,477,474,462,461,441,428,425,385,427,445,450,474,480,490,507,513,525,540,550};
		g.drawPolygon(xkelp,ykelp,26);
		
		Color mygreen=new Color(88,135,3);
		g.setColor(mygreen);
		g.fillPolygon(xkelp,ykelp,26);
		
		for (int i=0;i<26;i++)
		{
			xkelp[i]+=25;
			ykelp[i]+=25;
		}
		
		g.setColor(Color.BLACK);
		g.drawPolygon(xkelp,ykelp,26);
		
		g.setColor(mygreen);
		g.fillPolygon(xkelp,ykelp,26);
		
		for (int i=0;i<26;i++)
		{
			xkelp[i]+=25;
		}
		
		g.setColor(Color.BLACK);
		g.drawPolygon(xkelp,ykelp,26);
		
		g.setColor(mygreen);
		g.fillPolygon(xkelp,ykelp,26);
		
		
		
		for (int i=0;i<26;i++)
		{
			xkelp[i]+=210;
			ykelp[i]-=50;
		}
		
		g.drawPolygon(xkelp,ykelp,26);
		
		g.setColor(mygreen);
		g.fillPolygon(xkelp,ykelp,26);
		
		for (int i=0;i<26;i++)
		{
			xkelp[i]+=25;
			ykelp[i]+=25;
		}
		
		g.setColor(Color.BLACK);
		
		g.drawPolygon(xkelp,ykelp,26);
		g.setColor(mygreen);
		g.fillPolygon(xkelp,ykelp,26);
		
		for (int i=0;i<26;i++)
		{
			xkelp[i]+=25;
		}
		
		g.setColor(Color.BLACK);
		g.drawPolygon(xkelp,ykelp,26);
		
		g.setColor(mygreen);
		g.fillPolygon(xkelp,ykelp,26);
		
		//rocks
		Color mygrey=new Color(170,160,150);
		g.setColor(mygrey);
		
		int xrock[]= {805,808,825,841,880,922,952,955,960,969,980};
		int yrock[]= {550,519,475,440,425,424,431,440,451,475,540};
		g.fillPolygon(xrock,yrock,11);
		
		Color myorange=new Color(247,130,43);
		g.setColor(myorange);
		
		int xstar[]= {870,880,895,883,890,870,850,860,845,860};
		int ystar[]= {462,477,482,489,510,500,511,490,485,480};
		g.fillPolygon(xstar,ystar,10);
		
		//spongebob
		Color myyellow=new Color(255,244,99);
		g.setColor(myyellow);
		
		int xsponge[]= {910,940,940,910};
		int ysponge[]= {450,450,500,500};
		g.fillPolygon(xsponge,ysponge,4);
		
		
	}
	
	public void drawBubbles(Graphics g, int x, int y)
	{
		g.setColor(Color.WHITE);
		g.fillOval(690, 300-y, 15, 15);
		g.fillOval(660, 290-y, 15, 15);
		g.fillOval(720, 290-y, 15, 15);
		g.fillOval(680, 280-y, 15, 15);
		g.fillOval(730, 270-y, 15, 15);
		g.fillOval(715, 260-y, 15, 15);
		g.fillOval(700, 270-y, 15, 15);
		g.fillOval(650, 310-y, 15, 15);
		g.fillOval(750, 300-y, 15, 15);
		g.fillOval(740, 285-y, 15, 15);
	}
		

	public void actionPerformed(ActionEvent e)
	{
		if (x >=1000)
			x=1000;
		
		y+=add;
		
		repaint();
	}
	public void mouseClicked(MouseEvent e)
	{
		y = 1;
		System.out.println("MOUSE");
	}
	public void mousePressed(MouseEvent e) { }
	public void mouseReleased(MouseEvent e) { }
	public void mouseEntered(MouseEvent e) { }
	public void mouseExited(MouseEvent e) { }
	
	public void keyPressed(KeyEvent e)
	{
		int keyCode = e.getKeyCode();
		switch (keyCode) 
		{
			case KeyEvent.VK_LEFT:
				x-=7.5*add;
				break;
			case KeyEvent.VK_RIGHT:
				x+=7.5*add;
				break;
		}
	}
	public void keyTyped(KeyEvent e)
	{
	
	}
	public void keyReleased(KeyEvent e) {}

}
