package org.usfirst.frc.team58.robot;


import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Trigger;

import org.usfirst.frc.team58.robot.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
	

	public Joystick joy = new Joystick(RobotMap.joy);
	public Joystick oper = new Joystick(RobotMap.oper);

	public JoystickButton climberButton = new JoystickButton(oper, RobotMap.y);
	public JoystickButton collectButton = new JoystickButton(oper, RobotMap.b);
	public JoystickButton reverseCollectButton = new JoystickButton(oper, RobotMap.reverse);
	public JoystickButton feedButton = new JoystickButton(oper, RobotMap.x);
	//public JoystickButton cameraSwapButton =  new JoystickButton(joy, RobotMap.swapCamera);
	
	public JoystickButton testAuto = new JoystickButton(joy, RobotMap.x);
	
	public JoystickButton driveThree = new JoystickButton(joy, RobotMap.y);
	public JoystickButton rotate60 = new JoystickButton(joy, RobotMap.a);
	public JoystickButton lightButton = new JoystickButton(joy, RobotMap.shineLight); // right bumper (boost is right trigger)
	
	public AmpTrigger popcornAmp = new AmpTrigger(RobotMap.popcornMotor, 5.0);
	
	// J.Manning 02.08.2017 - For assignments like this, you need to have the 
	// code in some sort of method that actually runs it.
	public OI() {
		// T.Hansen 02.08.2017 - For some reason, it doesn't like this.
		climberButton.whileHeld(new Climb());
		collectButton.whileHeld(new CollectFuel());
		feedButton.whenPressed(new FeedFuel());
		lightButton.whileHeld(new ShineLight());
		reverseCollectButton.whileHeld(new ReverseCollect());
		
		// for debugging commands to be used in Auto
		//driveThree.whenPressed(new DriveStraight(12));
		//rotate60.whenPressed(new TurnToAngle(360));
		
		testAuto.whenPressed(new AdjustAngle());
		
		//cameraSwapButton.whenPressed(new SwapCameras());
		

		// T.Hansen 02.01.2017 - Moved Solenoid into DriveTrain subsystem
	}
	
	public class AmpTrigger extends Trigger {
		private int port = -1;
		private double limit = 0;
		
		public AmpTrigger(int port, double limit) {
			this.port = port;
			this.limit = limit;
		}
		
		@Override
		public boolean get() {
			if(Robot.pdp.getCurrent(port) > limit) {
				//System.out.println("Run amp" + Robot.pdp.getCurrent(port) + " " + limit);
				return true;	
			}
			//System.out.println("Dont Run amp");
			return false;
		}
		
	}
	
}
