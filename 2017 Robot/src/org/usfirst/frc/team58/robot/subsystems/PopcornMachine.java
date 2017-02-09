package org.usfirst.frc.team58.robot.subsystems;

import org.usfirst.frc.team58.robot.commands.Drive;
import org.usfirst.frc.team58.robot.commands.FeedFuel;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class PopcornMachine extends Subsystem{
	
	// T.Hansen 02.08.2017 - SHOULD BE WORKING
	
	private Talon popcornTalon;
	
	
	public void initDefaultCommand(){
		setDefaultCommand(new FeedFuel());
	}
	public void runPopcornMotor(double speed){
		popcornTalon.setSpeed(speed);
	}
}