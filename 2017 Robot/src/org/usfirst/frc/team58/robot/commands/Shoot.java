package org.usfirst.frc.team58.robot.commands;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class Shoot extends CommandGroup {
	public Shoot(){
	/* T.Hansen 02.04.2017 - This is just a skeleton CommandGroup for shooting. We need to have separate
	*  commands for lineUp, spinUp, feedFuel etc.
	*/
		addSequential(new LineUp());
		addParallel(new SpinUp());
		addParallel(new FeedFuel());
	}
}
