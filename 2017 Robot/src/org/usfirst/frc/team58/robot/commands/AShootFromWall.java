package org.usfirst.frc.team58.robot.commands;

import org.usfirst.frc.team58.robot.Dashboard;
import org.usfirst.frc.team58.robot.Robot;
import org.usfirst.frc.team58.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class AShootFromWall extends Command{
	double shootSpeed;
	double popcornSpeed;
	boolean shooterUpToSpeed;
	double maxPopcornCurrent;
	
	public AShootFromWall() {
    	requires(Robot.shooter);
    	requires(Robot.popcornMachine);
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	shootSpeed = Dashboard.getShooterSpeed();
    	popcornSpeed = Dashboard.getPopcornSpeed();
    	maxPopcornCurrent = Dashboard.getMaxPopperCurrent();
    	
    	Robot.shooter.Shoot(shootSpeed);
    	shooterUpToSpeed = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	double currentRate = Robot.shooter.getRate();
    	
    	// only runs popcorn machine when shooter is up to speed
    	if (shooterUpToSpeed){ 
    		if(Robot.getPopperCurrent() > maxPopcornCurrent) {
    			Robot.popcornMachine.runPopcornMotor(-1);
    		} else {
    			Robot.popcornMachine.runPopcornMotor(popcornSpeed);
    		}
    	}
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	
    	// gets shooter rate and tells code to run popcorn machine
    	double currentRate = Robot.shooter.getRate();
      	if (Math.abs(currentRate) > 3450) {
    		shooterUpToSpeed = true;
    	}
    	
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.shooter.Shoot(0);
    	Robot.popcornMachine.runPopcornMotor(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.shooter.Shoot(0);
    	Robot.popcornMachine.runPopcornMotor(0);
    }
}
