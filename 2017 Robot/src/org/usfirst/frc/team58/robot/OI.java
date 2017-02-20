package org.usfirst.frc.team58.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
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
	public JoystickButton shootButton = new JoystickButton(oper, RobotMap.x);
	public JoystickButton collectButton = new JoystickButton(oper, RobotMap.b);
	public JoystickButton spinUpButton = new JoystickButton(oper, RobotMap.a);
	public JoystickButton cameraSwapButton =  new JoystickButton(joy, RobotMap.swapCamera);
	
	// J.Manning 02.08.2017 - For assignments like this, you need to have the 
	// code in some sort of method that actually runs it.
	public OI() {
		// T.Hansen 02.08.2017 - For some reason, it doesn't like this.
		climberButton.whileHeld(new Climb());
		shootButton.whileHeld(new FeedFuel());
		collectButton.whileHeld(new CollectFuel());
		spinUpButton.whileHeld(new SpinUp());
		//cameraSwapButton.whenPressed(new SwapCameras());

		// T.Hansen 02.01.2017 - Moved Solenoid into DriveTrain subsystem
	}
	
}
