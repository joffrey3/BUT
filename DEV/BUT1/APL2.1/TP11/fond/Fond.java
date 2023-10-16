import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Fond extends JFrame implements ActionListener {
	JPanel panel = new JPanel();
	JButton btn1 = new JButton("Cyan");
    JButton btn2 = new JButton("Magenta");
    JButton btn3 = new JButton("Jaune");

	public Fond() {
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
    	if(event.getSource() == btn1) {
    		panel.setBackground(Color.CYAN);
    	} else if(event.getSource() == btn2) {
    		panel.setBackground(Color.MAGENTA);
    	} else {
    		panel.setBackground(Color.YELLOW);
    	}
	}
}