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
		System.out.println("right gear program");
		addSequential(new DriveStraightTime(1258, 0.85));
		addSequential(new DriveStraightTime(258,0));
		addSequential(new TurnToAngle(-50));
		addSequential(new DriveStraightTime(258, 0));
		addSequential(new DriveStraightTime(858, 0.58));
	}
}