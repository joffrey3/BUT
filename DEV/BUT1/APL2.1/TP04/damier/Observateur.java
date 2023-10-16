import java.lang.Object;
import javax.swing.*;
import java.awt.*;
import java.util.EventObject;
import java.awt.AWTEvent;
import java.awt.event.ActionEvent;

public interface Observateur implements ActionListener {
  @Override
  void actionPerformed(ActionEvent evenement){
    

  }
}