package org.usfirst.frc.team58.robot.subsystems;

import org.usfirst.frc.team58.robot.Robot;
import org.usfirst.frc.team58.robot.RobotMap;
import org.usfirst.frc.team58.robot.commands.Drive;
import org.usfirst.frc.team58.robot.commands.ShootVision;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

public class Shooter extends Subsystem{
	private CANTalon shooterMotor;
	/* T.Hansen 02.08.2017 - Changed to CANTalon after installing the software
	 from CTRE onto my laptop, will likely have to do on Acer as well */
	
	public void initDefaultCommand(){
		setDefaultCommand(new ShootVision());
	}
	
	public Shooter(){
		shooterMotor = new CANTalon(RobotMap.shooterMotor);
		shooterMotor.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		
		//Got PID values from preferences in Robot.java. Set them in the talon.
		double[] shooterPID = Robot.getShooterPID();
		shooterMotor.setP(shooterPID[0]);
		shooterMotor.setI(shooterPID[1]);
		shooterMotor.setD(shooterPID[3]);
	}
	
	public void Shoot(double shootSpeed){
		shooterMotor.changeControlMode(TalonControlMode.Speed);
		shooterMotor.setF(shootSpeed);
		shooterMotor.set(shootSpeed);
	}
	
	public double getRate(){
		return shooterMotor.getSpeed();
	}
}
