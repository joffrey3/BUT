import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Radio extends JFrame implements ActionListener {
	JPanel panel = new JPanel();
	JRadioButton btn1 = new JRadioButton("Cyan");
    JRadioButton btn2 = new JRadioButton("Magenta");
    JRadioButton btn3 = new JRadioButton("Jaune");

	public Radio() {
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
    	if(event.getSource() == btn1 && event.getSource() != btn2 && event.getSource() != btn3) {
    		panel.setBackground(Color.CYAN);
    	} else if(event.getSource() == btn2 && event.getSource() != btn1 && event.getSource() != btn3) {
    		panel.setBackground(Color.MAGENTA);
    	} else if (event.getSource() == btn3 && event.getSource() != btn1 && event.getSource() != btn2){
    		panel.setBackground(Color.YELLOW);
    	}
	}
}
