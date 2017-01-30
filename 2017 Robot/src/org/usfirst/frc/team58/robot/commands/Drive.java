package org.usfirst.frc.team58.robot.commands;

import org.usfirst.frc.team58.robot.OI;
import org.usfirst.frc.team58.robot.Robot;
import org.usfirst.frc.team58.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Drive extends Command {

    public Drive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double moveValue = Robot.oi.joy.getRawAxis(RobotMap.moveAxis);
    	double rotateValue = Robot.oi.joy.getRawAxis(RobotMap.rotateAxis);
    	double rightTriggerValue = Robot.oi.joy.getRawAxis(RobotMap.rightTriggerAxis);
    	Robot.driveTrain.drive(-moveValue, -rotateValue);
    	
    	
    	/* Tyler H. 01.23.2017 - if "rightTriggerValue" which is supposedly the 
    	 * z-axis is greater than or equal to .75 (value might need modification),
    	 * set speedSolenoid (in OI.java) to true. Otherwise, keep it false.
    	*/  
    	if(rightTriggerValue >= .75){
    		OI.speedSolenoid.set(true);
    	}else{
    		OI.speedSolenoid.set(false);
    	}
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
    	Robot.driveTrain.drive(0, 0);
    }
}
