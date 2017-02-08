package org.usfirst.frc.team58.robot.commands;

import org.usfirst.frc.team58.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class FeedFuel extends Command{
	
	/* T. Hansen 02.08.2017 - This is the FeedFuel command, which
	 * tells the robot to run the motor to feed fuel through the popcorn
	 * machine into the shooter for launching fuel into the high boiler. */
	
	public FeedFuel() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.popcornMachine);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	double motorSpeed = Robot.getPopcornSpeed();
    	Robot.popcornMachine.runPopcornMotor(motorSpeed);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}


