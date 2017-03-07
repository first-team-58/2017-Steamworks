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
    	// make sure robot drives backwards if distance is neg
    	Robot.driveTrain.setSetpoint(distance);
    	if (distance < 0) {
        	Robot.driveTrain.setOutputRange(-1.0, 0);
    	} else {
    		Robot.driveTrain.setOutputRange(0, 1.0);
    	}
    	Robot.driveTrain.getPIDController().setPID(0.2, 0, 0);
    	Robot.driveTrain.getPIDController().setAbsoluteTolerance(3);
    	Robot.driveTrain.resetDistance();
    	Robot.driveTrain.gyroReset();
    	Robot.driveTrain.enable();
  
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	System.out.println(Robot.driveTrain.getDistance());
    	System.out.println(Robot.driveTrain.getAngle());
    	
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
