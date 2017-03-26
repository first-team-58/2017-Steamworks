package org.usfirst.frc.team58.robot.commands;

import org.usfirst.frc.team58.robot.Robot;
import org.usfirst.frc.team58.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 * this will aim the robot based on the vision targeting, and drive forward
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
		if (Robot.visionEnabled) {
			Robot.startVision();
			// get difference between target center and robot center. robot.centerX is in Robot.java
			dif = RobotMap.gearTargetX - Robot.centerX;
			System.out.println(dif);
			System.out.println("# of contours: " + Robot.contCount);
			// calculate angle to turn from that difference, remember dif is
			// just pixles!
			angle = dif * RobotMap.gearTargetAngleMult;
		}
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		System.out.println(angle);
		new TurnToAngle(angle);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		if (dif < RobotMap.gearTargetTollerence) {
			return true;
		}
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		try {
		Robot.stopVision();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			Robot.visionEnabled = false;
		}
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		try {
		Robot.stopVision();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			Robot.visionEnabled = false;
		}
	}
}
