package org.usfirst.frc.team58.robot.commands;

import org.usfirst.frc.team58.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveStraight extends Command{
	private double distance;
	
	public DriveStraight(double distance) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveTrain);
    	this.distance = distance;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveTrain.setSetpoint(distance);
    	Robot.driveTrain.setOutputRange(-1.0, 1.0);
    	//Robot.driveTrain.getPIDController().setPID(p, i, d);
    	//Robot.driveTrain.getPIDController().setTolerance(15.0); //the percent for this is out of 100.00, so 15.0 is 15%
    	Robot.driveTrain.resetDistance();
    	Robot.driveTrain.gyroReset();
    	Robot.driveTrain.enable();
  
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.driveTrain.onTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrain.disable();
    	Robot.driveTrain.drive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.driveTrain.disable();
    	Robot.driveTrain.drive(0, 0);
    }
}
