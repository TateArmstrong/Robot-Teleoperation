import java.io.*;
import java.net.*;

public class RobotModel{
	
	Socket socket;
	PrintWriter out;
	String takeOffMsg = "{\"op\":\"publish\",\"topic\":\"/ardrone/takeoff\",\"msg\":{}}";
	String landMsg = "{\"op\":\"publish\",\"topic\":\"/ardrone/land\",\"msg\":{}}";
	double speed = 0.25;
	
	RobotModel(){
		try{
			socket = new Socket("robcog.cs.okstate.edu", 9095);
			out = new PrintWriter(socket.getOutputStream());
			System.out.println("Connection succsessful!");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public String constructString(double x, double y, double z1, double z2){
		String str = "{\"op\":\"publish\",\"topic\":\"/cmd_vel\",\"msg\":{\"linear\""+
		":{\"x\":"+ x +","+
		"\"y\":"+ y +","+
		"\"z\":"+ z1 +"},"+
		"\"angular\":{\"x\":0,"+
		"\"y\":0,"+
		"\"z\":"+ z2 +"}}}";
		return str;
	}
	
	public double getSpeed(){
		return speed;
	}
	
	public void setSpeed(double cSpeed){
		this.speed = cSpeed;
	}
	
	public void stop(){
		out.print(constructString(0, 0, 0, 0));
		out.flush();
	}
	
	public void takeOff(){
		out.print(takeOffMsg);
		out.flush();
	}
	
	public void land(){
		out.print(landMsg);
		out.flush();
	}
	
	public void moveFoward(){
		out.print(constructString(speed, 0, 0, 0));
		out.flush();
	}
	
	public void moveBack(){
		out.print(constructString(-1.0*speed, 0, 0, 0));
		out.flush();
	}
	
	public void moveUp(){
		out.print(constructString(0, 0, speed, 0));
		out.flush();
	}
	
	public void moveDown(){
		out.print(constructString(0, 0, -1.0*speed, 0));
		out.flush();
	}
	
	public void moveLeft(){
		out.print(constructString(0, speed, 0, 0));
		out.flush();
	}
	
	public void moveRight(){
		out.print(constructString(0, -1.0*speed, 0, 0));
		out.flush();
	}
	
	public void rotateLeft(){
		out.print(constructString(0, 0, 0, 1));
		out.flush();
	}
	
	public void rotateRight(){
		out.print(constructString(0, 0, 0, -1));
		out.flush();
	}
}