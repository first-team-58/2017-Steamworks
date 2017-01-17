package org.usfirst.frc.team58.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
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
		double moveValue = joy.getRawAxis(1);
		double rotateValue = joy.getRawAxis(5);
		drive.arcadeDrive(moveValue, rotateValue);
	}
}
