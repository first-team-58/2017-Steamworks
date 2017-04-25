package org.usfirst.frc.team58.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AShootBaselineRed extends CommandGroup{
	public AShootBaselineRed(){
		
		addSequential(new AShootFromWall());
		addSequential(new DriveStraightTime(250, -1));
		addSequential(new TurnPID(-70f));
		addSequential(new DriveStraightNoNAVX(2000, 0.65));
	}
}