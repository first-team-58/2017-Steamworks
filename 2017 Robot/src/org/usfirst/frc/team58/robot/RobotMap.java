package org.usfirst.frc.team58.robot;


/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	//PWM Ports
	public static int frontRightMotor = 0;
	public static int frontLeftMotor = 1;
	public static int rearRightMotor = 3;
	public static int rearLeftMotor = 7;
	public static int climberMotor = 2;
	public static int beltMotor = 4;
	public static int brushMotor = 5;
	public static int popcornMotor = 6;
	
	//Relay
	public static int lightSpike = 0;

	//CAN Bus
	public static int shooterMotor = 0;
	
	//Solenoid
	public static int speedSolenoid = 3;
	
	//sensors
	public static int leftEncoder = 0;
	public static int rightEncoder = 1;
	
	//controls
	public static int joy = 0;
	public static int oper = 1;
	
	// buttons on driver joystick
	public static int moveAxis = 1;
	public static int rotateAxis = 4;
	public static int triggerAxis = 3;
	public static int lightButton = 3;
	public static int swapCamera = 4; // driver joystick y button
	
	// buttons on operator joystick
	public static int y = 4; // climb
	public static int b = 2; // collect
	public static int a = 1; // spin up
	public static int x = 3; // feed fuel

}
