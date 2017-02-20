package org.usfirst.frc.team58.robot.subsystems;

import org.usfirst.frc.team58.robot.RobotMap;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Collector extends Subsystem {
	
	//T.Hansen 02.08.2017 - SHOULD BE WORKING
	
	//Declared talons beltMotor and brushMotor
	private Talon beltMotor;
	private Talon brushMotor;
	
	
	
	public void initDefaultCommand(){
		//setDefaultCommand(new CollectFuel());
	}
	
	
	public Collector(){
	//T.Hansen - Constructed talons beltMotor and brushMotor
	beltMotor = new Talon(RobotMap.beltMotor);
	brushMotor = new Talon(RobotMap.brushMotor);
	}
	
	public void collectFuel(double[] speeds){
		beltMotor.set(speeds[0]);
		brushMotor.set(speeds[1]);
	}
	
}