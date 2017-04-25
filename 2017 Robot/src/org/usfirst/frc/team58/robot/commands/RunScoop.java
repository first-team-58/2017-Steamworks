package org.usfirst.frc.team58.robot.commands;

import org.usfirst.frc.team58.robot.Dashboard;
import org.usfirst.frc.team58.robot.Robot;
import org.usfirst.frc.team58.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class RunScoop extends Command{
	
	// 4.6.2017 Emma Dalton
	// Should run french fry scoop with the operator trigger axis
	
	
	public RunScoop() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.scoop);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double triggerValue = Robot.oi.oper.getRawAxis(RobotMap.scoopTriggerAxis);
    	
    	if(triggerValue >= .75){
    		Robot.scoop.set(true);
    	}else{
    		Robot.scoop.set(false);
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
    	Robot.scoop.set(false);
    }
	
	
}