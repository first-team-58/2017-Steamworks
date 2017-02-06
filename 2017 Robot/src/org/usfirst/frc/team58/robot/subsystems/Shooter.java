package org.usfirst.frc.team58.robot.subsystems;

import org.usfirst.frc.team58.robot.RobotMap;
import org.usfirst.frc.team58.robot.commands.Drive;
import org.usfirst.frc.team58.robot.commands.Shoot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Shooter extends Subsystem{
	private Talon shooterMotor;
	//CHANGE TO TALONSRX OR CANTALON
	private Encoder shooterEnc;
	
	public void initDefaultCommand(){
		setDefaultCommand(new Shoot());
	}
	
	public Shooter(){
	shooterMotor = new Talon(RobotMap.shooterMotor);
	shooterEnc = new Encoder(3, 4, false, Encoder.EncodingType.k4X);
	}
	
	public void Shoot(){
		
	}
}
