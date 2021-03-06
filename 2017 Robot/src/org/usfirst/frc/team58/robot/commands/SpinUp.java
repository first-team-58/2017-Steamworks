package org.usfirst.frc.team58.robot.commands;

import org.usfirst.frc.team58.robot.Dashboard;
import org.usfirst.frc.team58.robot.Robot;
import org.usfirst.frc.team58.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class SpinUp extends Command{
	
	/* T. Hansen 02.08.2017 - This is the SpinUp command, which tells
	 * the robot to run the motors which spin the shooter wheels to prep
	 * for launching fuel into the high boiler. */
	
	double shootSpeed;
	
	public SpinUp() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	shootSpeed = Dashboard.getShooterSpeed();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	if(Robot.oi.oper.getRawAxis(RobotMap.triggerAxis) >= .75){
    		Robot.shooter.Shoot(shootSpeed);
    	}else{
    		Robot.shooter.disable();
    	}
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.shooter.Shoot(0);
    	Robot.shooter.disable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.shooter.Shoot(0);
    	Robot.shooter.disable();
    }
}

