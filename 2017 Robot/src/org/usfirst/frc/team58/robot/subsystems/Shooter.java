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
		shooterMotor.reverseSensor(true);
		
		shooterMotor.configEncoderCodesPerRev(360);
		
		shooterMotor.configNominalOutputVoltage(+0.0f, -0.0f);
		shooterMotor.configPeakOutputVoltage(+12.0f, -12.0f);
		//Got PID values from preferences in Robot.java. Set them in the talon.
		double[] shooterPID = Dashboard.getShooterPID();
		//shooterMotor.setProfile(0);
		shooterMotor.setP(0.3);
		shooterMotor.setI(0.0002);
		shooterMotor.setD(0);
		shooterMotor.setF(0.08);
		
	}
	 
	public void Shoot(double shootSpeed){
		
		
		if (shooterMotor.getControlMode() == TalonControlMode.Speed) {
			System.out.println(shooterMotor.getSpeed());
			System.out.println("not shooting");
		} else {
			shooterMotor.changeControlMode(TalonControlMode.Speed);
			shooterMotor.set(shootSpeed);

			System.out.println("SHOOTING");
			//System.out.println(shooterMotor.getSpeed());
		}
		
	}
	
	public void disable() {
		shooterMotor.changeControlMode(TalonControlMode.PercentVbus);
		shooterMotor.set(0);
	}
	
	public double getRate(){
		return shooterMotor.getSpeed();
	}
}
