package org.usfirst.frc.team58.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class ARightGear extends CommandGroup{
	public ARightGear(){
		/* T.Hansen 02.04.2017 - This is just a skeleton CommandGroup for
		 * the RightGear autonomous
		 * T.Hansen 02.07.2017 - This autonomous mode, when selected, will
		 * have the robot place a gear on the rightmost lift. 
		 * write this sort of stuff in here:
		 * addSequential(DriveForward);	
		 * addSequential(TurnLeft);
		 * addSequential(FindLift);
		 * addSequential(DriveTowardsLift);
		 */
		
		//These values are subject to change.
		addSequential(new DriveStraightTime(1258, 1));
		addSequential(new TurnToAngle(-50));
		//addSequential(new AdjustAngle());
		
		addSequential(new DriveStraightTime(50, 0));
		addSequential(new DriveStraightTime(358, 1));
	}
}