import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Attente extends JFrame implements WindowListener {
	JPanel panel = new JPanel();

	public Attente() {
    	setLocation(200, 200);
    	setSize(100,100);
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	setVisible(true);
	//Cercle c = new Cercle();
	//this.add(c);
	this.addWindowListener(this);
	}
    	public void windowDeiconified(WindowEvent evenement) {
	    Cercle c = new Cercle();
	    this.add(c);
	    this.panel.setBackground(Color.GREEN);
	    this.add(this.panel);
	    }
	public void windowIconified(WindowEvent evenement) {
	}
    	public void windowDeactivated(WindowEvent evenement) {
	}
	public void windowActivated(WindowEvent event) {
	    this.panel.setBackground(Color.YELLOW);
	    
	    this.add(new Cercle());
	    this.add(this.panel);
	}
    	public void windowOpened(WindowEvent evenement) {
	}
	public void windowClosed(WindowEvent evenement) {
	}
    	public void windowClosing(WindowEvent evenement) {
	}

}
