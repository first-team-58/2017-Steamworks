package org.usfirst.frc.team58.robot.subsystems;

import org.usfirst.frc.team58.robot.Dashboard;                                                                                                                                                               
import org.usfirst.frc.team58.robot.RobotMap;
import org.usfirst.frc.team58.robot.commands.SpinUp;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

public class Shooter extends Subsystem{
	private CANTalon shooterMotor;
	/* T.Hansen 02.08.2017 - Changed to CANTalon after installing the software
	 from CTRE onto my laptop, will likely have to do on Acer as well */
	
	public void initDefaultCommand(){
		setDefaultCommand(new SpinUp());
	}
	
	public Shooter(){
		shooterMotor = new CANTalon(RobotMap.shooterMotor);
		shooterMotor.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		shooterMotor.reverseSensor(false);
		
		shooterMotor.configEncoderCodesPerRev(360);
		
		shooterMotor.configNominalOutputVoltage(+0.0f, -0.0f);
		shooterMotor.configPeakOutputVoltage(+12.0f, -12.0f);
		//Got PID values from preferences in Robot.java. Set them in the talon.
		double[] shooterPID = Dashboard.getShooterPID();
		shooterMotor.setProfile(0);
		shooterMotor.setF(1);
		shooterMotor.setP(1);
		shooterMotor.setI(1);
		shooterMotor.setD(1);
	}
	 
	public void Shoot(double shootSpeed){
		shooterMotor.changeControlMode(TalonControlMode.Speed);
		shooterMotor.set(shootSpeed);
		System.out.println(shooterMotor.getSpeed());
		shooterMotor.enable();
	}
	
	public void disable() {
		shooterMotor.disable();
		shooterMotor.changeControlMode(TalonControlMode.PercentVbus);
		shooterMotor.set(0);
	}
	
	//public double getRate(){
		//return shooterMotor.getSpeed();
	//}
}
