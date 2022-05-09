import javax.swing.*;
import java.awt.event.*;

public class RobotButton extends JButton{
	
	//RobotModel model = new RobotModel();
	
	public RobotButton(String str, RobotModel model){
		super(str);
		addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                executeCommand(str, model);
            }
        });
	}
	
	private void executeCommand(String str, RobotModel model){
		switch(str){
			case "Take Off":
				model.takeOff(); break;
			case "Land":
				model.land(); break;
			case "Stop":
				model.stop(); break;
			case "Foward":
				model.moveFoward(); break;
			case "Back":
				model.moveBack(); break;
			case "Left":
				model.moveLeft(); break;
			case "Right":
				model.moveRight(); break;
			case "RLeft":
				model.rotateLeft(); break;
			case "RRight":
				model.rotateRight(); break;
			case "Up":
				model.moveUp(); break;
			case "Down":
				model.moveDown(); break;
		}
	}
	
}