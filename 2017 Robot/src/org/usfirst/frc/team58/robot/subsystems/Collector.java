package org.usfirst.frc.team58.robot.subsystems;

import org.usfirst.frc.team58.robot.RobotMap;
import org.usfirst.frc.team58.robot.commands.CollectFuel;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Collector extends Subsystem {
	//T.Hansen - Declared talons beltMotor and brushMotor
	private Talon beltMotor;
	private Talon brushMotor;
	
	
	
	public void initDefaultCommand(){
		setDefaultCommand(new CollectFuel());
	}
	
	
	public Collector(){
	//T.Hansen - Constructed talons beltMotor and brushMotor
	beltMotor = new Talon(RobotMap.beltMotor);
	brushMotor = new Talon(RobotMap.brushMotor);
	}
	
	public void climb(){
		
	}
	
}