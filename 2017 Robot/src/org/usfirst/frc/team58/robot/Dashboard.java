package org.usfirst.frc.team58.robot;

import org.usfirst.frc.team58.robot.commands.ALeftGear;
import org.usfirst.frc.team58.robot.commands.ALeftGearShoot;
import org.usfirst.frc.team58.robot.commands.ALeftHopperShoot;
import org.usfirst.frc.team58.robot.commands.AMiddleGear;
import org.usfirst.frc.team58.robot.commands.ARightGear;
import org.usfirst.frc.team58.robot.commands.ARightGearShoot;
import org.usfirst.frc.team58.robot.commands.ARightHopperShoot;
import org.usfirst.frc.team58.robot.commands.AShootFromWall;
import org.usfirst.frc.team58.robot.commands.AShootLeft;
import org.usfirst.frc.team58.robot.commands.AShootRight;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Dashboard {
	
	static Command autonomousCommand;
	static SendableChooser<Command> autoChooser;
	public static Boolean collectorOn;
	public static Preferences prefs;
	
	//These are the preferences variables.
	public static double climberSpeed;
	public static double collectorBrushSpeed;
	public static double collectorBeltSpeed;
	public static double shooterSpeed;
	public static double popcornSpeed;
	public static double shootDistance;
	public static double shooterP;
	public static double shooterI;
	public static double shooterD;
	public static double shooterF;
	public static double driverP;
	public static double driverI;
	public static double driverD;
	public static double rotateSpeed;
	public static double maxClimberCurrent;
	public static double maxPopperCurrent;
	
	public static void initDashboard() {
		addPreferences();
		addAutoChooser();
		
	}
	
	/**
	 * Run in dashboard init, sets up preferences panel in smartdashboard.
	 */
	public static void addPreferences(){
		prefs = Preferences.getInstance();
		climberSpeed = prefs.getDouble("Climber Motor Speed", 1);
		//Changed shooterSpeed from 1.0 to -1.0 in attempt to reverse direction 2/19/17 Sean
		shooterSpeed = prefs.getDouble("Shooter Motor Speed", -3500);
		collectorBeltSpeed = prefs.getDouble("Collector Belt Speed", 1);
		collectorBrushSpeed = prefs.getDouble("Collector Brush Speed", .8);
		popcornSpeed = prefs.getDouble("Popcorn Machine Motor Speed", 0.7);
		shootDistance = prefs.getDouble("Shoot Distance", 0.5); // what is the unit on this?
		shooterP = prefs.getDouble("Shooter P Value", 0.3);    
		shooterI = prefs.getDouble("Shooter I Value", 0.0002);
		shooterD = prefs.getDouble("Shooter D Value", 0);
		shooterF = prefs.getDouble("Shooter F Value", 0.08);
		driverP = prefs.getDouble("Driver P Value", 0.5);
		driverI = prefs.getDouble("Driver I Value", 0);
		driverD = prefs.getDouble("Driver D Value", 0);
		rotateSpeed = prefs.getDouble("Auto Rotate Speed", 0.3);
		maxClimberCurrent = prefs.getDouble("Maximum Climber Current", 50);
		maxPopperCurrent = prefs.getDouble("Max Popper Current", 5);
	}
	
	/**
	 * Run in dashboard init, sets up autoChooser panel in smartdashboard.
	 */
	public static void addAutoChooser(){
		//T.Hansen 02.04.2017 - Choose auto at beginning of match from SmartDashboard
		autoChooser = new SendableChooser<Command>();
		autoChooser.addDefault("Default program: Middle Gear", new AMiddleGear());
		autoChooser.addObject("Left Gear", new ALeftGear());
		autoChooser.addObject("Right Gear", new ARightGear());
		autoChooser.addObject("Shoot From Wall", new AShootFromWall());
		//autoChooser.addObject("Right Gear and Shoot", new ARightGearShoot());
		//autoChooser.addObject("Left Gear and Shoot", new ALeftGearShoot());
		//autoChooser.addObject("Right Hopper and Shoot", new ARightHopperShoot());
		//autoChooser.addObject("Left Hopper and Shoot", new ALeftHopperShoot());
		//autoChooser.addObject("Shoot to the Left", new AShootLeft());
		//autoChooser.addObject("Shoot to the Right", new AShootRight());
		SmartDashboard.putData("Autonomous mode chooser", autoChooser);
		
	}
	
	/**
	 * @return chosen Auto command from autoChooser
	 */
	public static Command getAutoProgram() {
		autonomousCommand = autoChooser.getSelected();
		return autonomousCommand;
	}
	
	/**
	 * 
	 * @return climberSpeed from prefs.
	 */
	public static double getClimberSpeed(){
		return climberSpeed;
	}
	/*
	 * @return popcornSpeed from prefs.
	 */
	public static double getPopcornSpeed(){
		return popcornSpeed;
	}
	/*
	 * @return shooterSpeed.
	 */
	public static double getShooterSpeed(){
		return shooterSpeed;
	}
	/*
	 * @return collectorBeltSpeed and CollectorBrushSpeed as a double array.
	 */
	public static double[] getCollectorSpeed(){
		double[] collectorSpeeds = {collectorBeltSpeed, collectorBrushSpeed};
		return collectorSpeeds;
	}
	public static double[] getBackwardsCollectorSpeed(){
		double[] backwardsCollectorSpeeds = {-collectorBeltSpeed, -collectorBrushSpeed};
		return backwardsCollectorSpeeds;
	}
	/*
	 * @return shooterPIDs as a double array.
	 */
	public static double[] getShooterPID(){
		double[] shooterPID = {shooterP, shooterI, shooterD, shooterF};
		return shooterPID;
	}
	
	/*
	 * @return driverPIDs as a double array.
	 */
	public static double[] getDriverPID(){
		double[] driverPID = {driverP, driverI, driverD};
		return driverPID;
	}
	
	/*
	 * @return auto drive rotation speed.
	 */ 
	public static double getRotateSpeed(){
		return rotateSpeed;
	}
	
	/*
	 * @return maximum climber current.
	 */
	public static double getMaxClimberCurrent(){
		return maxClimberCurrent;
	}
	/*
	 * @return maximum popper current.
	 */
	public static double getMaxPopperCurrent(){
		return maxPopperCurrent;
	}
}
