package org.usfirst.frc.team58.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.joystick;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import org.usfirst.frc.team58.robot.RobotMap;

public class driveTrain {
	private Talon leftFrontMotor, rightFrontMotor, leftRearMotor, rightRearMotor;
	
	private RobotDrive drive;
	
	public void initDefaultCommand(){
		
	}
	
	//Constructor
	public driveTrain(){
		leftFrontMotor = new Talon(RobotMap.leftFrontMotor);
		rightFrontMotor = new Talon(RobotMap.rightFrontMotor);
		leftRearMotor = new Talon(RobotMap.leftRearMotor);
		rightRearMotor = new Talon(RobotMap.rightRearMotor);
		drive = new RobotDrive(leftFrontMotor, rightFrontMotor, leftRearMotor, rightRearMotor);
	}
	
	public void drive(Joystick joy){
		drive.mecanumDrive_Polar(joy.getAxis(RobotMap.joystickMagnitude), joy.getAxis(RobotMap.joystickDirection), joy.getAxis(RobotMap.joystickRotation));
	}
}