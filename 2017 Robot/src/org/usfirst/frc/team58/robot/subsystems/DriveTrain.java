package org.usfirst.frc.team58.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SPI;
import org.usfirst.frc.team58.robot.RobotMap;
import org.usfirst.frc.team58.robot.commands.Drive;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Solenoid;

public class DriveTrain extends PIDSubsystem {
	public static Talon frontLeftMotor;
	public static Talon frontRightMotor;
	public static Talon rearLeftMotor;
	public static Talon rearRightMotor;
	public static Solenoid speedSolenoid;
	private RobotDrive drive;
	//T.Hansen - Declared encoders leftEnc and rightEnc
	private static Encoder leftEnc;
	private static Encoder rightEnc;
	private static AHRS ahrs = new AHRS(SPI.Port.kMXP);
	
	public void initDefaultCommand(){
		setDefaultCommand(new Drive());
	}
	
	//Constructor
	public DriveTrain(double P, double I, double D){
		super("PID", P, I, D);
		frontLeftMotor = new Talon(RobotMap.frontLeftMotor);
		frontRightMotor = new Talon(RobotMap.frontRightMotor);
		rearLeftMotor = new Talon(RobotMap.rearLeftMotor);
		rearRightMotor = new Talon(RobotMap.rearRightMotor);
		speedSolenoid = new Solenoid(RobotMap.speedSolenoid);
		drive = new RobotDrive(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);
		
		//T.Hansen - Contructed encoders leftEnc and rightEnc
		leftEnc = new Encoder(0,1,false,Encoder.EncodingType.k4X);
		rightEnc = new Encoder(2,3,false,Encoder.EncodingType.k4X);
		leftEnc.setDistancePerPulse(1);
		leftEnc.setReverseDirection(true);
		rightEnc.setDistancePerPulse(1);
		
		// PID control only goes to 3 inches of tolerance
		setAbsoluteTolerance(1);
		
		leftEnc.reset();
		rightEnc.reset();
		
	}
	
	public void drive(double moveValue, double rotateValue){
	   	if(!this.getPIDController().isEnabled()) {
	   		drive.arcadeDrive(moveValue, rotateValue);
	   		//System.out.println(System.currentTimeMillis() + " : Printout of time");
	   	}
	}
	

	public double getDistance(){
		double leftDistance = leftEnc.getDistance();
		double rightDistance = rightEnc.getDistance();
		//double averageDistance = leftDistance / 2 + rightDistance / 2;
		double averageDistance = rightDistance; // left encoder not working?
		return averageDistance;
	}
	
	public Encoder leftEncoder() {
		return leftEnc;
	}
	
	public Encoder rightEncoder() {
		return rightEnc;
	}
	
	public double getLeft(){
		double leftEncValue = leftEnc.getRate();
		return leftEncValue;
	}
	
	public double getRight(){
		double rightEncValue = rightEnc.getRate();
		return rightEncValue;
	}
	
	//function that averages the rates of each encoder
	public double getAverageRate(){
		return (getRight() + getLeft()) / 2;
	}
	
	public void resetDistance(){
		leftEnc.reset();
		rightEnc.reset();
	}

	@Override
	protected double returnPIDInput() {
		// TODO Auto-generated method stub
		//return getDistance();
		/// changed to using angle PID
		return getDistance();
	}

	public double getAngleCorrection() {
		//Change this to the navx code once it is imported.
		double angle = getAngle();
		if (abs(angle)<2) {
			return 0;
		} else {
			return 0.2*angle;
		}	
	}
	
	@Override 
	protected void usePIDOutput(double output) {
		// TODO Auto-generated method stub
		drive.arcadeDrive(output,getAngleCorrection());
	}
	
	public double getAngle(){
		return ahrs.getAngle();
	}
	
	public void gyroReset(){
		ahrs.reset();
	}
	
	public double abs(double x) {
		if (x>=0) {
			return x;
		} else {
			return -1*x;
		}
	}
	

}

