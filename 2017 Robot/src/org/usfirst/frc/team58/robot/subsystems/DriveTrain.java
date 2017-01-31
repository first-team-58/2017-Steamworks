package org.usfirst.frc.team58.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.RobotDrive;
import org.usfirst.frc.team58.robot.RobotMap;
import org.usfirst.frc.team58.robot.commands.Drive;

public class DriveTrain extends Subsystem {
	private Talon leftFrontMotor, rightFrontMotor, leftRearMotor, rightRearMotor;
	
	private RobotDrive drive;
	
	
	
	public void initDefaultCommand(){
		setDefaultCommand(new Drive());
	}
	
	//Constructor
	public DriveTrain(){
		super();
		leftFrontMotor = new Talon(RobotMap.leftFrontMotor);
		rightFrontMotor = new Talon(RobotMap.rightFrontMotor);
		drive = new RobotDrive(leftFrontMotor, rightFrontMotor);
	}
	
	public void drive(double moveValue, double rotateValue){
		drive.arcadeDrive(moveValue, rotateValue);
	}
}
