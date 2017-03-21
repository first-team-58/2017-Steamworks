package org.usfirst.frc.team58.robot.commands;

import org.usfirst.frc.team58.robot.Robot;
import org.usfirst.frc.team58.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *	this will aim the robot based on the vision targeting, and drive forward
 */
public class LineUpGear extends Command {

	int dif;
	double angle;
	
    public LineUpGear() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.startVision();
    	//get difference between target center and robot center.
    	dif = RobotMap.gearTargetX - Robot.centerX;
    	//calculate angle to turn from that difference, remember dif is just pixles!
    	angle = dif * RobotMap.gearTargetAngleMult;
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	new TurnToAngle(angle);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(dif < RobotMap.gearTargetTollerence) {
        	return true;
        }
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.stopVision();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.stopVision();
    }
}
