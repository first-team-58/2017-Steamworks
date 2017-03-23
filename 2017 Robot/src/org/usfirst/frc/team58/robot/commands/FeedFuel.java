package org.usfirst.frc.team58.robot.commands;

import org.usfirst.frc.team58.robot.Dashboard;
import org.usfirst.frc.team58.robot.Robot;
import org.usfirst.frc.team58.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class FeedFuel extends Command{
	
	// T.Hansen 02.08.2017 - SHOULD BE WORKING
	
	/* T. Hansen 02.08.2017 - This is the FeedFuel command, which
	 * tells the robot to run the motor to feed fuel through the popcorn
	 * machine into the shooter for launching fuel into the high boiler. */
	
	double motorSpeed;
	double maxPopperCurrent;
	
	public FeedFuel() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.popcornMachine);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	motorSpeed = Dashboard.getPopcornSpeed();
    	maxPopperCurrent = Dashboard.getMaxPopperCurrent();
    	Robot.popcornMachine.runPopcornMotor(motorSpeed);
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	double PopperCurrent = Robot.getPopperCurrent();
    	if (PopperCurrent < maxPopperCurrent){
    		Robot.popcornMachine.runPopcornMotor(motorSpeed);
        	System.out.println("Running forward " + Robot.pdp.getCurrent(RobotMap.popcornMotor) + " " + maxPopperCurrent);

    	} else {
    		//This is pausing drive train.
    		Robot.popcornMachine.runPopcornMotor(-1);
        	System.out.println("Running reverse " + Robot.pdp.getCurrent(RobotMap.popcornMotor) + " " + maxPopperCurrent);

    	}
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	double trigger = Robot.oi.oper.getRawAxis(RobotMap.triggerAxis);
    	boolean shooterOn;
    	if(trigger >= .75){
    		shooterOn = true;
    	} else{
    		shooterOn = false;
    	}
        return !shooterOn;
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


