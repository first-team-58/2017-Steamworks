package org.usfirst.frc.team58.robot.commands;

import org.usfirst.frc.team58.robot.Dashboard;
import org.usfirst.frc.team58.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Rotate extends Command{
	public double angle;
	double rotateSpeed;
	
	public Rotate(double angle) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
		this.angle = angle;
    	requires(Robot.driveTrain);
    	rotateSpeed = Dashboard.getRotateSpeed();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveTrain.gyroReset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(angle < -0.5){
    		Robot.driveTrain.drive(0, -rotateSpeed);
    	} else if(angle > 0.5){
    		Robot.driveTrain.drive(0, rotateSpeed);
    	}
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(angle > -0.5 && angle < 0.5){
    		return true;
    	} else{
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
    }
}

