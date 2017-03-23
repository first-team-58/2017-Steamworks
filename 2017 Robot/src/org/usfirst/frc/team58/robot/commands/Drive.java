package org.usfirst.frc.team58.robot.commands;

import org.usfirst.frc.team58.robot.Robot;
import org.usfirst.frc.team58.robot.RobotMap;
import org.usfirst.frc.team58.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;

/* T. Hansen 02.08.2017 - Drive the robot and controls pneumatics for
  speed boost. WAS WORKING ON ANKLEBITER*/

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
    	double triggerValue = Robot.oi.joy.getRawAxis(RobotMap.triggerAxis);
    	//Set moveValue to 100% if moveAxis is 90%. Bob L 2/25/17.  
    	//This change is because the robot is turning on it own.  
    	//Also, it seems slower than it should be.
    	if (moveValue>.9){
    		moveValue=1;
    	}
    	if (moveValue<-.9){
    		moveValue=-1;
    	}
    	    	 
    	//Deadbands for driving controllers
    	if ((moveValue <= 0.2) && (moveValue >= -0.2)){
    		moveValue = 0;
    		//System.out.println("This is getting stuff");
    	}
    	
    	if ((rotateValue <= 0.2) && (rotateValue >= -0.2)){
    		rotateValue = 0;
    		//System.out.println("rotate deadband");
    	}

    	
    	Robot.driveTrain.drive(-moveValue, -rotateValue);

    	
    	
    	/* Tyler H. 02.01.2017 - if "rightTriggerValue" which is the 
    	 * z-axis is greater than or equal to .75 (value might need modification),
    	 * set speedSolenoid (in DriveTrain subsystem) to true. Otherwise, keep it false.
    	*/  
    	
    	if(triggerValue >= .75){
    		DriveTrain.speedSolenoid.set(true);
    	}else{
    		DriveTrain.speedSolenoid.set(false);
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
