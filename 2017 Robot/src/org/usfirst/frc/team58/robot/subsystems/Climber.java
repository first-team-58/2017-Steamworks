package org.usfirst.frc.team58.robot.subsystems;

import org.usfirst.frc.team58.robot.RobotMap;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Climber extends Subsystem {
	private Talon climberMotor;
	//private static DigitalInput atTop;
	//limit switch code
	//Not done. Needs something.
	
	
	public void initDefaultCommand(){
		//setDefaultCommand(new Climb());
	}
	
	
	public Climber(){ 
		climberMotor = new Talon(RobotMap.climberMotor);
	
	//atTop = new DigitalInput(6);
	}
	
	public void climb(double speed){
		climberMotor.setSpeed(speed);
	}
	
}