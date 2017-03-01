package org.usfirst.frc.team58.robot.subsystems;

import org.usfirst.frc.team58.robot.Dashboard;                                                                                                                                                               
import org.usfirst.frc.team58.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

public class Shooter extends Subsystem{
	private CANTalon shooterMotor;
	/* T.Hansen 02.08.2017 - Changed to CANTalon after installing the software
	 from CTRE onto my laptop, will likely have to do on Acer as well */
	
	public void initDefaultCommand(){
		//setDefaultCommand(new ShootVision());
	}
	
	public Shooter(){
		shooterMotor = new CANTalon(RobotMap.shooterMotor);
		shooterMotor.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		shooterMotor.reverseSensor(false);
		
		shooterMotor.configNominalOutputVoltage(+0.0f, -0.0f);
		shooterMotor.configPeakOutputVoltage(+12.0f, -12.0f);
		//Got PID values from preferences in Robot.java. Set them in the talon.
		double[] shooterPID = Dashboard.getShooterPID();
		shooterMotor.setProfile(0);
		shooterMotor.setF(0.1097);
		shooterMotor.setP(shooterPID[0]);
		shooterMotor.setI(shooterPID[1]);
		shooterMotor.setD(shooterPID[2]);
	}
	 
	public void Shoot(double shootSpeed){
		shooterMotor.changeControlMode(TalonControlMode.Speed);
		shooterMotor.set(shootSpeed);
		
	}
	
	//public double getRate(){
		//return shooterMotor.getSpeed();
	//}
}
