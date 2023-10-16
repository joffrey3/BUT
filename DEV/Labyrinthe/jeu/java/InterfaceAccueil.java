import java.lang.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*; 

public class InterfaceAccueil extends JFrame implements MouseListener{
    private DessinAccueil fond ;
	public InterfaceAccueil(){
		this.setLocation(0,0);
		this.setSize(1720,1080);
		this.setLayout(null);
		fond = new DessinAccueil();
		fond.setLocation(0,0);
		fond.setSize(1720,1080);
		this.add(fond);
		this.setVisible(true);
		this.addMouseListener(this);
	}
	public void mouseClicked(MouseEvent evenement){
		int x =evenement.getX();
		int y =evenement.getY();
		if(x>700 && x<1000 && y>600 && y<700){
		    
		}
		if(x>775 && x<925 && y>750 && y<800){
			
		}
		if(x>1550 && x<1625 && y>950 && y<975){
			
		}
	}      
	public void mouseEntered(MouseEvent evenement){

	}         
	public void mouseExited(MouseEvent evenement){

	}
	public void mousePressed(MouseEvent evenement){

	}     
	public void mouseReleased(MouseEvent evenement){

	}
}
