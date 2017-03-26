package org.usfirst.frc.team58.robot.commands;

import org.usfirst.frc.team58.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class TurnPID extends Command{
	private double angle;
	private double time;
	private double start;
	
	public TurnPID(double angle) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveTrain);
    	this.angle = angle;
    	this.time = 2000;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	// make sure robot drives backwards if distance is neg
    	Robot.driveTrain.setSetpoint(angle);
    	Robot.driveTrain.setInputRange(-180.0f, 180.0f);
        Robot.driveTrain.setOutputRange(-1.0, 1.0);
        
        // pid tuned 3/25/2017 by Sean, Tyler and Emma
        // DO NOT ADD I!!! as Tyler says "BAD!!!"
    	Robot.driveTrain.getPIDController().setPID(-0.0200058, 0.0, 0);
    	Robot.driveTrain.getPIDController().setAbsoluteTolerance(1.0f);
    	Robot.driveTrain.gyroReset();
    	
    	this.start = System.currentTimeMillis();
    	Robot.driveTrain.enable();
  
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	System.out.println(Robot.driveTrain.getAngle());
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	
    	// only runs for two seconds maximum
    	if (System.currentTimeMillis() < (start+time)) {
    		return Robot.driveTrain.onTarget();
    	} else {
    		return true;
    	}
    }

    // Called once after isFinished returns true
    protected void end() {
    	System.out.println("end angle");
    	System.out.println(Robot.driveTrain.getAngle());
    	Robot.driveTrain.disable();
    	Robot.driveTrain.drive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.driveTrain.disable();
    	Robot.driveTrain.drive(0, 0);
    }
}
