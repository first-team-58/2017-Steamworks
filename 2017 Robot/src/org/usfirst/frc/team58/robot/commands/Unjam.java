package org.usfirst.frc.team58.robot.commands;

import org.usfirst.frc.team58.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Unjam extends CommandGroup {
	
    public Unjam() {
    	requires(Robot.popcornMachine);
    	addSequential(new UnjamPopcorn());
    	addSequential(new FeedFuel());
    }
}
