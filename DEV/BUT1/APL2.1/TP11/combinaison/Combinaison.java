import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Combinaison extends JFrame implements ActionListener {
	JPanel panel = new JPanel();
	JCheckBox btn1 = new JCheckBox("Cyan");
    JCheckBox btn2 = new JCheckBox("Magenta");
    JCheckBox btn3 = new JCheckBox("Jaune");
    public int indent;

	public Combinaison() {
	    this.indent=0;
    	setLocation(100, 100);
    	setSize(500,300);
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	setVisible(true);
    	
    	this.add(panel);
		panel.setLayout(new FlowLayout());  

    	panel.add(btn1);
    	panel.add(btn2);
    	panel.add(btn3);

    	btn1.addActionListener(this);
    	btn2.addActionListener(this);
    	btn3.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event) {
    	if (event.getSource() == btn1) {
	   switch (this.indent) {
        case 0 : this.indent=this.indent+1;
	    break;
	case 1 : this.indent=this.indent-1;
	    break;
	case 2 : this.indent=this.indent+1;
	    break;
	case 3 : this.indent=this.indent-1;
	    break;
	case 4 : this.indent=this.indent+1;
	    break;
	case 5 : this.indent=this.indent-1;
	    break;
	case 6 : this.indent=this.indent+1;
	    break;
	case 7 : this.indent=this.indent-1;
	    break;
    	} 
	} else if (event.getSource() == btn2){
	   switch (this.indent) {
        case 0 : this.indent=this.indent+2;
	    break;
	case 1 : this.indent=this.indent+2;
	    break;
	case 2 : this.indent=this.indent-2;
	    break;
	case 3 : this.indent=this.indent-2;
	    break;
	case 4 : this.indent=this.indent+2;
	    break;
	case 5 : this.indent=this.indent+2;
	    break;
	case 6 : this.indent=this.indent-2;
	    break;
	case 7 : this.indent=this.indent-2;
	    break;
    	} 
    	} else if (event.getSource() == btn3){
        	   switch (this.indent) {
        case 0 : this.indent=this.indent+4;
	    break;
	case 1 : this.indent=this.indent+4;
	    break;
	case 2 : this.indent=this.indent+4;
	    break;
	case 3 : this.indent=this.indent+4;
	    break;
	case 4 : this.indent=this.indent-4;
	    break;
	case 5 : this.indent=this.indent-4;
	    break;
	case 6 : this.indent=this.indent-4;
	    break;
	case 7 : this.indent=this.indent-4;
	    break;
    	} 
    	}
        switch (this.indent) {
        case 0 :  panel.setBackground(Color.WHITE);
	    break;
	case 1 : panel.setBackground(Color.CYAN);
	    break;
	case 2 : panel.setBackground(Color.MAGENTA);
	    break;
	case 3 : panel.setBackground(Color.BLUE);
	    break;
	case 4 : panel.setBackground(Color.YELLOW);
	    break;
	case 5 : panel.setBackground(Color.GREEN);
	    break;
	case 6 : panel.setBackground(Color.RED);
	    break;
	case 7 : panel.setBackground(Color.BLACK);
	    break;
    	} 
   }
}
