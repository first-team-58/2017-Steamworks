
package org.usfirst.frc.team58.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team58.robot.commands.ALeftGear;
import org.usfirst.frc.team58.robot.commands.ALeftGearShoot;
import org.usfirst.frc.team58.robot.commands.ALeftHopperShoot;
import org.usfirst.frc.team58.robot.commands.AMiddleGear;
import org.usfirst.frc.team58.robot.commands.ARightGear;
import org.usfirst.frc.team58.robot.commands.ARightGearShoot;
import org.usfirst.frc.team58.robot.commands.ARightHopperShoot;
import org.usfirst.frc.team58.robot.commands.AShootLeft;
import org.usfirst.frc.team58.robot.commands.AShootRight;
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

	Command autonomousCommand;
	SendableChooser<Command> autoChooser;
	public static PowerDistributionPanel pdp;
	public static Boolean collectorOn;
	public static Preferences prefs;
	
	//These are the preferences variables.
	public static double climberSpeed;
	public static double collectorBrushSpeed;
	public static double collectorBeltSpeed;
	public static double shooterSpeed;
	public static double popcornSpeed;
	public static double nearShootDistance;
	public static double farShootDistance;
	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		driveTrain = new DriveTrain();
		climber = new Climber();
		oi = new OI();
		shooter = new Shooter();
		popcornMachine = new PopcornMachine();
		pdp = new PowerDistributionPanel();
		collectorOn = false;
		
		//add auto chooser panel
		addAutoChooser();
		
		//add preferences panel.
		addPreferences();
				
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
		
		SmartDashboard.putNumber("Current", pdp.getCurrent(1));
		SmartDashboard.putBoolean("Collector On", collectorOn);
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
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
	/**
	 * Run in robot init, sets up preferences panel in smartdashboard.
	 */
	public void addPreferences(){
		prefs = Preferences.getInstance();
		climberSpeed = prefs.getDouble("Climber Motor Speed", 0.5);
		shooterSpeed = prefs.getDouble("Shooter Motor Speed", 0.5);
		collectorBeltSpeed = prefs.getDouble("Collector Belt Speed", 0.5);
		collectorBrushSpeed = prefs.getDouble("Collector Brush Speed", 0.5);
		popcornSpeed = prefs.getDouble("Popcorn Machine Motor Speed", 0.5);
		nearShootDistance = prefs.getDouble("Near Shoot Distance", 0.5);
		farShootDistance = prefs.getDouble("Far Shoot Distance", 0.5);
	}
	
	/**
	 * Run in robot init, sets up autoChooser panel in smartdashboard.
	 */
	public void addAutoChooser(){
		//T.Hansen 02.04.2017 - Choose auto at beginning of match from SmartDashboard
		autoChooser = new SendableChooser();
		autoChooser.addDefault("Default program: Middle Gear", new AMiddleGear());
		autoChooser.addObject("Left Gear", new ALeftGear());
		autoChooser.addObject("Right Gear", new ARightGear());
		autoChooser.addObject("Right Gear and Shoot", new ARightGearShoot());
		autoChooser.addObject("Left Gear and Shoot", new ALeftGearShoot());
		autoChooser.addObject("Right Hopper and Shoot", new ARightHopperShoot());
		autoChooser.addObject("Left Hopper and Shoot", new ALeftHopperShoot());
		autoChooser.addObject("Shoot to the Left", new AShootLeft());
		autoChooser.addObject("Shoot to the Right", new AShootRight());
		SmartDashboard.putData("Autonomous mode chooser", autoChooser);
		autonomousCommand = autoChooser.getSelected();
	}
	/**
	 * To be fixed, static references and non-static field.
	 * @return climber speed from prefs.
	 */
	public static double getClimberSpeed(){
		return climberSpeed;
	}
	public static double getPopcornSpeed(){
		return popcornSpeed;
	}
}
