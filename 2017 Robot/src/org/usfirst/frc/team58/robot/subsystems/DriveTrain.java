package org.usfirst.frc.team58.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import org.usfirst.frc.team58.robot.RobotMap;
import org.usfirst.frc.team58.robot.commands.Drive;
import edu.wpi.first.wpilibj.Solenoid;

public class DriveTrain extends Subsystem {
	private Talon leftFrontMotor, rightFrontMotor, leftRearMotor, rightRearMotor;
	public static Solenoid speedSolenoid = new Solenoid(0);
	private RobotDrive drive;
	//T.Hansen - Declared encoders leftEnc and rightEnc
	private Encoder leftEnc;
	private Encoder rightEnc;
	
	Encoder rightEncoder;
	
	public void initDefaultCommand(){
		setDefaultCommand(new Drive());
	}
	
	//Constructor
	public DriveTrain(){
		super();
		leftFrontMotor = new Talon(RobotMap.leftFrontMotor);
		rightFrontMotor = new Talon(RobotMap.rightFrontMotor);
		drive = new RobotDrive(leftFrontMotor, rightFrontMotor);
		//T.Hansen - Contructed encoders leftEnc and rightEnc
		leftEnc = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
		rightEnc = new Encoder(2, 3, false, Encoder.EncodingType.k4X);
	}
	
	public void drive(double moveValue, double rotateValue){
		drive.arcadeDrive(moveValue, rotateValue);
	}
}
