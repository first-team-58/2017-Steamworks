package org.usfirst.frc.team58.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	//PWM Ports
	public static int rightMotor = 0;
	public static int leftMotor = 1;
	public static int climberMotor = 2;
	public static int speedSolenoid = 3;
	public static int beltMotor = 4;
	public static int brushMotor = 5;
	public static int popcornMotor = 6;
	public static int lightSpike = 7;
	//Input ports
	public static int leftEncoder = 0;
	public static int rightEncoder = 1;
	

	
	//public static int rightRearMotor;
	
	public static int moveAxis = 1;
	public static int rotateAxis = 4;
	public static int triggerAxis = 3;
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;
	


	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}
