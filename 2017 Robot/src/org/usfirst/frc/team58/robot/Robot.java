
package org.usfirst.frc.team58.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team58.robot.subsystems.AimingLight;
import org.usfirst.frc.team58.robot.subsystems.Cameras;
import org.usfirst.frc.team58.robot.subsystems.Climber;
import org.usfirst.frc.team58.robot.subsystems.Collector;
import org.usfirst.frc.team58.robot.subsystems.DriveTrain;
import org.usfirst.frc.team58.robot.subsystems.PopcornMachine;
import org.usfirst.frc.team58.robot.subsystems.Shooter;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	//public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static DriveTrain driveTrain;
	public static Climber climber;
	public static OI oi;
	public static Collector collector;
	public static Shooter shooter;
	public static PopcornMachine popcornMachine;
	public static AimingLight aimingLight;
	public static PowerDistributionPanel pdp;
	public static Cameras cameras;
	
	Command autonomousCommand;
	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		
		double[] driverPID = Dashboard.getDriverPID();
		driveTrain = new DriveTrain(driverPID[0], driverPID[1], driverPID[2]);
		
		climber = new Climber();
		shooter = new Shooter();
		collector = new Collector();
		popcornMachine = new PopcornMachine();
		pdp = new PowerDistributionPanel();
		aimingLight = new AimingLight();
		//cameras = new Cameras();
		oi = new OI();
		
		Dashboard.initDashboard();
		
		autonomousCommand = Dashboard.getAutoProgram();
			
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		
		SmartDashboard.putNumber("Shooter Current", pdp.getCurrent(RobotMap.shooterMotor));
		SmartDashboard.putNumber("Climber Current", pdp.getCurrent(RobotMap.climberMotor));
		//SmartDashboard.putBoolean("Collector On", collectorOn);
		//SmartDashboard.putNumber("Shooter Rate", shooter.getRate());
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
	
	public static double getClimberCurrent(){
		return pdp.getCurrent(RobotMap.climberMotor);
	}

}
