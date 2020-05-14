package iceField;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.*;

public class fieldView {
	
	private Point pCenter;
	private Point pCoordinate;
	private Image image;
	
	public fieldView(){
		try{
			image = ImageIO.read(new File("IceField_2.png"));
		} 
		catch(IOException ex){
			System.out.println("ERR");
		}
		
		pCoordinate = new Point(300,500);
		pCenter = new Point(325,525);
	}
	
	public Point getCenter(){
		return pCenter;
	}
	
	public void draw(Graphics g){
		g.drawImage(image, pCoordinate.x, pCoordinate.y, null);
		System.out.println("HALI");
	}
}
