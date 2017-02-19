package org.usfirst.frc.team58.robot.commands;

import org.usfirst.frc.team58.robot.Dashboard;
import org.usfirst.frc.team58.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class Climb extends Command{
	/* T.Hansen 02.08.2017 - This is the climb command, where we tell 
	 * the robot to run the motor to spin the "winch" so that we can
	 * climb up the rope at the end of the match. It also must TURN
	 * OFF ALL OTHER SUBSYSTEMS BESIDES THE CLIMBER.*/
	//Not done. Needs button pressed run the motor. Work in progress.
	double maxClimberCurrent;
	double climberSpeed;
	
	public Climb() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.climber);
    	//requires(Robot.driveTrain);
    	requires(Robot.collector);
    	requires(Robot.popcornMachine);
    	requires(Robot.shooter);
  
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	maxClimberCurrent = Dashboard.getMaxClimberCurrent();
    	climberSpeed = Dashboard.getClimberSpeed();
    	
    	//T.Hansen - Turns off all other subsystems
    	double[] collectorOff = {0.0,0.0};
    	Robot.collector.collectFuel(collectorOff);
    	//Robot.popcornMachine.runPopcornMotor(0.0);
    	//Robot.driveTrain.drive(0, 0);
    	Robot.shooter.Shoot(0);
    	Robot.climber.climb(climberSpeed);
    	
//    	double motorCurrent = Robot.getClimberCurrent();
//    	if (motorCurrent < maxClimberCurrent){
//    		Robot.climber.climb(climberSpeed);
//    		
//    	} else {
//    		Robot.climber.climb(0);
//    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.climber.climb(climberSpeed);
//    	double motorCurrent = Robot.getClimberCurrent();
//    	if (motorCurrent < maxClimberCurrent){
//    		Robot.climber.climb(climberSpeed);
//    		
//    	} else {
//    		Robot.climber.climb(0);
//    	}
    	
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
    	Robot.climber.climb(0);
    }
}

