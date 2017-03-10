package org.usfirst.frc.team58.robot.commands;

import org.usfirst.frc.team58.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TurnToAngle extends Command {

	public double angle = 0; //value that holds the target angle
	public double adjustmentRatio = 0.05; //this value is multiplied by the difference between the target angle and the current angle
	public double angleSensitivity = 1; //Acceptable tollerence for angle
	
    public TurnToAngle(double angle) {
    	requires(Robot.driveTrain);
    	this.angle = angle;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	System.out.println("starting turn to angle");
    	Robot.driveTrain.gyroReset();
    	Robot.driveTrain.drive(0, 0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	System.out.println(Robot.driveTrain.getAngle());
    	Robot.driveTrain.drive(0, -(angle - Robot.driveTrain.getAngle()) * adjustmentRatio);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if((angle - Robot.driveTrain.getAngle()) < angleSensitivity) {
        	System.out.println("done turning!");
        	return true;
        } else {
        	return false;
        }
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
