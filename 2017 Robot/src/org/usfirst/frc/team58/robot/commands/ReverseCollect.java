package org.usfirst.frc.team58.robot.commands;

import org.usfirst.frc.team58.robot.Dashboard;
import org.usfirst.frc.team58.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class ReverseCollect extends Command{
	
	//T.Hansen 02.08.2017 - SHOULD BE WORKING
	
	/* T. Hansen 02.08.2017 - This is the CollectFuel command, where we 
	 * tell the robot to run the motors to spin the conveyer belt and 
	 * brush so that we can fill up our storage with fuel from the ground. */
	
	private double[] motorSpeeds;
	private double[] stoppedSpeeds = {0,0};
	
	public ReverseCollect() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.collector);
   
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Dashboard.collectorOn = true;
    	
    	motorSpeeds = Dashboard.getBackwardsCollectorSpeed();
    	
    	if(Robot.oi.collectButton.get()) {
    		// do nothing
    	}else{
    		Robot.collector.collectFuel(motorSpeeds);
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    /*double moveValue = Robot.oi.joy.getRawAxis(RobotMap.moveAxis);
    	if (moveValue > 0.05){
    		Robot.collector.collectFuel(motorSpeeds);
    	}else{
    		Robot.collector.collectFuel(stoppedSpeeds);
    	}
     */  		
    	if(Robot.oi.collectButton.get()) {
    		// do nothing
    	}else{
    		Robot.collector.collectFuel(motorSpeeds);
    	}
    }
    
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Dashboard.collectorOn = false;
    	Robot.collector.collectFuel(stoppedSpeeds);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {

    	Dashboard.collectorOn = false;
    	Robot.collector.collectFuel(stoppedSpeeds);
    }
}
