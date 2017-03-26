package org.usfirst.frc.team58.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AShootBaselineBlue extends CommandGroup{
	public AShootBaselineBlue(){
		
		addSequential(new AShootFromWall());
		addSequential(new DriveStraightTime(250, -1));
		addSequential(new TurnPID(60f));
		addSequential(new DriveStraightTime(1000, 1));
	}
}
