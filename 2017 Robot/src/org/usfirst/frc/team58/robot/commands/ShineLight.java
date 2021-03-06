package org.usfirst.frc.team58.robot.commands;

import org.usfirst.frc.team58.robot.Robot;
import org.usfirst.frc.team58.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class ShineLight extends Command{
	
	public ShineLight() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.aimingLight);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.aimingLight.shineLight(true);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.aimingLight.shineLight(true);
    	
 
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.aimingLight.shineLight(false);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.aimingLight.shineLight(false);
    }
}

