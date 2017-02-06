package org.usfirst.frc.team58.robot.subsystems;

import org.usfirst.frc.team58.robot.RobotMap;
import org.usfirst.frc.team58.robot.commands.CollectFuel;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Collector extends Subsystem {
	private Talon beltMotor;
	private Talon brushMotor;
	//Not done. Needs something.
	
	
	public void initDefaultCommand(){
		setDefaultCommand(new CollectFuel());
	}
	
	
	public Collector(){
	beltMotor = new Talon(RobotMap.beltMotor);
	brushMotor = new Talon(RobotMap.brushMotor);
	}
	
	public void climb(){
		
	}
	
}