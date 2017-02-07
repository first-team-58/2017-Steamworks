package org.usfirst.frc.team58.robot.commands;

import org.usfirst.frc.team58.robot.OI;
import org.usfirst.frc.team58.robot.Robot;
import org.usfirst.frc.team58.robot.RobotMap;
import org.usfirst.frc.team58.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.command.Command;

public class Climb extends Command{
	
	//Not done. Needs button pressed run the motor. Work in progress.
	
	public Climb() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.climber);
    	requires(Robot.driveTrain);
    	requires(Robot.collector);
    	requires(Robot.popcornMachine);
    	requires(Robot.shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//Not sure where this is supposed to be.
    	//Robot.oi.climberButton.whileHeld(setDefaultCommand(new Drive());());
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	boolean atTop = Robot.climber.robotAtTop();
    	double motorSpeed = Robot.getClimberSpeed();
    	if (atTop = false){
    		Robot.climber.climb(motorSpeed);
    		
    	} else {
    		Robot.climber.climb(0);
    		isFinished();
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
    }
}

