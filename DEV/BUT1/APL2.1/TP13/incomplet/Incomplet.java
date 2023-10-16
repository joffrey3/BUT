import java.lang.Object;
import javax.swing.*;
import java.awt.*;
import java.util.EventObject;
import java.awt.AWTEvent;
import java.awt.event.ActionEvent;

public class Incomplet {
	public static void main(String[] args){
		byte[] txt = {0x48, 0x65, 0x6C, 0x6C, 0x6F, 0x0D, 0x0A};
		try{
		System.out.write(txt);
		}
		catch(Exception e1){
		}
	}
}