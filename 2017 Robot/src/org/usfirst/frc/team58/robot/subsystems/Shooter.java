package org.usfirst.frc.team58.robot.subsystems;

import org.usfirst.frc.team58.robot.RobotMap;
import org.usfirst.frc.team58.robot.commands.Drive;
import org.usfirst.frc.team58.robot.commands.ShootVision;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

public class Shooter extends Subsystem{
	private CANTalon shooterMotor;
	/* T.Hansen 02.08.2017 - Changed to CANTalon after installing the software
	 from CTRE onto my laptop, will likely have to do on Acer as well */
	private Encoder shooterEnc;
	
	public void initDefaultCommand(){
		setDefaultCommand(new ShootVision());
	}
	
	public Shooter(){
		shooterMotor = new CANTalon(RobotMap.shooterMotor);
		shooterEnc = new Encoder(3, 4, false, Encoder.EncodingType.k4X);
	}
	
	public void Shoot(double shootSpeed){
		shooterMotor.set(shootSpeed);
	}
	
	public double getRate(){
		return shooterEnc.getRate();
	}
}
