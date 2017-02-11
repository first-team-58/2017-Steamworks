package org.usfirst.frc.team58.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SPI;

import org.usfirst.frc.team58.robot.RobotMap;
import org.usfirst.frc.team58.robot.commands.Drive;
import edu.wpi.first.wpilibj.Solenoid;

public class DriveTrain extends Subsystem {
	private Talon leftMotor, rightMotor;
	public static Solenoid speedSolenoid = new Solenoid(0);
	private RobotDrive drive;
	//T.Hansen - Declared encoders leftEnc and rightEnc
	private Encoder leftEnc;
	private Encoder rightEnc;
	//private static AHRS navx = new AHRS(SPI.PortkMXP);
	
	Encoder rightEncoder;
	
	public void initDefaultCommand(){
		setDefaultCommand(new Drive());
	}
	
	//Constructor
	public DriveTrain(){
		super();
		leftMotor = new Talon(RobotMap.leftMotor);
		rightMotor = new Talon(RobotMap.rightMotor);
		drive = new RobotDrive(leftMotor, rightMotor);
		//T.Hansen - Contructed encoders leftEnc and rightEnc
		leftEnc = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
		rightEnc = new Encoder(2, 3, false, Encoder.EncodingType.k4X);
		leftEnc.setDistancePerPulse(12);
		rightEnc.setDistancePerPulse(12);
	}
	
	public void drive(double moveValue, double rotateValue){
		drive.arcadeDrive(moveValue, rotateValue);
	}
	
	public void driveStraight(double speed){
		drive.arcadeDrive(speed, 0);
		
		double ratio = getLeft() / getRight();
		
	}

	public double getDistance(){
		double leftDistance = leftEnc.getDistance();
		double rightDistance = rightEnc.getDistance();
		double averageDistance = leftDistance / 2 + rightDistance / 2;
		return averageDistance;
	}
	
	public double getLeft(){
		double leftEncValue = leftEnc.getRate();
		return leftEncValue;
	}
	
	public double getRight(){
		double rightEncValue = rightEnc.getRate();
		return rightEncValue;
	}
	
	public void resetDistance(){
		leftEnc.reset();
		rightEnc.reset();
	}

}
