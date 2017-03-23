package org.usfirst.frc.team58.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class ALeftGear extends CommandGroup{
	public ALeftGear(){
		/* T.Hansen 02.04.2017 - This is just a skeleton CommandGroup for
		 * the LeftGear autonomous
		 * T.Hansen 02.07.2017 - This autonomous mode, when selected, will
		 * have the robot place a gear on the leftmost lift. 
		 * write this sort of stuff in here:
		 * addSequential(DriveForward);	
		 * addSequential(TurnRight);
		 * addSequential(FindLift);
		 * addSequential(DriveTowardsLift);
		 */
		
		//These values are subject to change.
		addSequential(new DriveStraightTime(1258, 0.85));
		addSequential(new DriveStraightTime(258,0));
		addSequential(new TurnToAngle(50));
		addSequential(new DriveStraightNoNAVX(258, 0));
		addSequential(new DriveStraightNoNAVX(1058, 0.58));
	}
}
