package org.usfirst.frc.team58.robot.commands;

import org.usfirst.frc.team58.robot.Dashboard;
import org.usfirst.frc.team58.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class UnjamPopcorn extends Command {

	double motorSpeed;
	long start = 0;
	
    public UnjamPopcorn() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.popcornMachine);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	motorSpeed = -Dashboard.getPopcornSpeed();
    	Robot.popcornMachine.runPopcornMotor(motorSpeed);
    	start = System.currentTimeMillis();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	System.out.println("Running in reverse");
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(System.currentTimeMillis() < (start + 500)) {
        	System.out.println("IS FINISHED?: " + System.currentTimeMillis() + " " + (start + 500));
        	return false;
        }
        System.out.println("FINISHED!");
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.popcornMachine.runPopcornMotor(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.popcornMachine.runPopcornMotor(0);
    }
}
