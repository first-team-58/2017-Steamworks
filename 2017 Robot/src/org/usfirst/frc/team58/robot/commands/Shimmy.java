package org.usfirst.frc.team58.robot.commands;

import org.usfirst.frc.team58.robot.Dashboard;
import org.usfirst.frc.team58.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Shimmy extends Command{
	double rotateSpeed;
	long start;
	long time;
	
	public Shimmy() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveTrain);
    	time = 300;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	rotateSpeed = Dashboard.getRotateSpeed();
		System.out.println("starting turn left");

    	this.start = System.currentTimeMillis();
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveTrain.drive(0, rotateSpeed);
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if (System.currentTimeMillis() < (start + time)) {
    		return false;
    	} else if (System.currentTimeMillis() < (start+4*time)) {
    		if (rotateSpeed > 0) {
    			System.out.println("starting turn right");
    			rotateSpeed = -rotateSpeed;
    		}
    		return false;
    	} else if (System.currentTimeMillis() < (start + 7*time)) {
    		if (rotateSpeed < 0) {
    			System.out.println("turning back left");
    			rotateSpeed = -rotateSpeed;
    		}
    		return false;
    	}else {
    		return true;
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

