package org.usfirst.frc.team58.robot.commands;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class Shoot extends CommandGroup {
	public Shoot(){
	/* T. Hansen 02.08.2017 - This is the shoot CommandGroup, and it is
	 * here that we will use the commands such as LineUp, SpinUp and FeedFuel
	 * to launch fuel into the high boiler. */
		addSequential(new LineUp());
		addParallel(new SpinUp());
		addParallel(new FeedFuel());
	}
}
