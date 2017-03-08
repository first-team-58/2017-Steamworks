package org.usfirst.frc.team58.robot.commands;

import org.usfirst.frc.team58.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveStraightTime extends Command{
	private long time;
	private long start;
	
	public DriveStraightTime(long time) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveTrain);
    	this.time = time;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	// make sure robot drives backwards if distance is neg
    	
    	start = System.currentTimeMillis();
    	Robot.driveTrain.gyroReset();
  
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	System.out.println(Robot.driveTrain.getDistance());
    	System.out.println(Robot.driveTrain.getAngle());
    	Robot.driveTrain.drive(1, Robot.driveTrain.getAngle() * .2);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	System.out.println(System.currentTimeMillis() + " " + (start + time));
        if(System.currentTimeMillis() < (start + time)) {
        	return false;
        }
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrain.drive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.driveTrain.drive(0, 0);
    }
}
