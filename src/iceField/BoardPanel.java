package iceField;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import java.awt.*;

public class BoardPanel extends JPanel implements MouseListener{

    private BufferedImage field;
    private BufferedImage iglu;
    private BufferedImage eskimo;
    private BufferedImage polarBear;
    private BufferedImage explorer;
    private BufferedImage tent;
    
    private fieldView fieldV;

    public BoardPanel() {
       try {                
          field = ImageIO.read(new File("IceField_2.png"));
          iglu = ImageIO.read(new File("iglu.png"));
          eskimo = ImageIO.read(new File("eskimo.png"));
          polarBear = ImageIO.read(new File("polarbear.png"));
          explorer = ImageIO.read(new File("explorer.png"));
          tent = ImageIO.read(new File("tent.png"));
       } catch (IOException ex) {
           
       }
       
       this.setBounds(300, 0, 700, 680);
       fieldV = new fieldView();
       addMouseListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(51,204,255));
        g2d.fillRect(0,0,700,680);
        for(int j = 0; j < 12; j++){
        	if(j%2 == 0){
		        for( int i = 10; i < 561; i+=50){
		        	g.drawImage(field, i, j*40, this);  
		        }
        	}
		    else{
		        	for( int i = 10+25; i < 561; i+=50){
			        	g.drawImage(field, i, j*40, this); 
			        }	
		        }
        	}
        g.drawImage(iglu, 60, 75, this);
        g.drawImage(eskimo, 115, 84,40,40, this);
        g.drawImage(polarBear, 160, 75, this);
        g.drawImage(explorer, 210, 75, this);
        g.drawImage(tent, 260, 78, this);
        
        fieldV.draw(g);
        
        }

	@Override
	public void mouseClicked(MouseEvent e) {
		Point p = e.getPoint();
		Point c = fieldV.getCenter();
		double a = (p.x-c.x) * (p.x-c.x);
		double b = (p.y-c.y) * (p.y-c.y);
		double cp = 22 * 22;
		if(a + b < cp ){
			System.out.println("KATT");
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
   }

