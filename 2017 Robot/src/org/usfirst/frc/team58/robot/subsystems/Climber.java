package org.usfirst.frc.team58.robot.subsystems;

import org.usfirst.frc.team58.robot.RobotMap;
import org.usfirst.frc.team58.robot.commands.Climb;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Climber extends Subsystem {
	private Talon climberMotor;
	//limit switch code
	//Not done. Needs something.
	
	
	public void initDefaultCommand(){
		setDefaultCommand(new Climb());
	}
	
	
	public Climber(){
	climberMotor = new Talon(RobotMap.climberMotor);
	}
	
	public void climb(){
		
	}
	
}