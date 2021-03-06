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
	private static Encoder58 leftEnc;
	private static Encoder58 rightEnc;
	private static AHRS ahrs = new AHRS(SPI.Port.kMXP);
	
	Encoder rightEncoder;
	
	private class Encoder58 {
		private Counter encCount;
		private double distance = 3;
		
		private Encoder58(int port) {
			encCount = new Counter(port);
		}
		
		private double getRate() {
			//System.out.println(encCount.get());
			return encCount.getRate() * distance;
		}
		
		private double getDistance() {
			return encCount.get() * distance;
		}
		
		private int get() {
			return encCount.get();
		}
		
		private void setDistancePerPulse(double distance) {
			this.distance = distance;
		}
		
		private void reset(){
			encCount.reset();
		}
	}
	
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
		leftEnc = new Encoder58(0);
		rightEnc = new Encoder58(1);
		leftEnc.setDistancePerPulse(3);
		rightEnc.setDistancePerPulse(3);
		
		// PID control only goes to 3 inches of tolerance
		setAbsoluteTolerance(3);
		
		
		
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
		return getDistance();
	}

	public double getAngleCorrection() {
		//Change this to the navx code once it is imported.
		double angle = getAngle();
		if (abs(angle)<2) {
			return 0;
		} else {
			return getAngle();
		}	
	}
	
	@Override
	protected void usePIDOutput(double output) {
		// TODO Auto-generated method stub
		drive.arcadeDrive(output, getAngleCorrection());
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

