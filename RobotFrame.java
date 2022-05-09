import javax.swing.*;

public class RobotFrame extends JFrame{
	
	private static final int SCREEN_WIDTH = 600;
    private static final int SCREEN_HEIGHT = 700;

     public RobotFrame(){
		 
		 try{
			 UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		 }catch(Exception e){
			 e.printStackTrace();
		 }
		 
         setTitle("Robot Controller");
         setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		 setLocationRelativeTo(null);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         RobotPanel panel = new RobotPanel();
         add(panel);
         setVisible(true);
     }
	
}