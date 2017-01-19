package org.usfirst.frc.team58.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.RobotDrive;
import org.usfirst.frc.team58.robot.RobotMap;
import org.usfirst.frc.team58.robot.commands.Drive;

public class DriveTrain extends Subsystem {
	private Talon leftFrontMotor, rightFrontMotor, leftRearMotor, rightRearMotor;
	
	private RobotDrive drive;
	
	private Drive driveCommand = new Drive();
	
	public void initDefaultCommand(){
		setDefaultCommand(driveCommand);
	}
	
	//Constructor
	public DriveTrain(){
		leftFrontMotor = new Talon(RobotMap.leftFrontMotor);
		rightFrontMotor = new Talon(RobotMap.rightFrontMotor);
		leftRearMotor = new Talon(RobotMap.leftRearMotor);
		rightRearMotor = new Talon(RobotMap.rightRearMotor);
		drive = new RobotDrive(leftFrontMotor, rightFrontMotor, leftRearMotor, rightRearMotor);
	}
	
	public void drive(double moveValue, double rotateValue){
		drive.arcadeDrive(moveValue, rotateValue);
	}
}
