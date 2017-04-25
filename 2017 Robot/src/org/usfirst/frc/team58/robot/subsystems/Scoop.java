package org.usfirst.frc.team58.robot.subsystems;

import org.usfirst.frc.team58.robot.RobotMap;
import org.usfirst.frc.team58.robot.commands.RunScoop;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Scoop extends Subsystem {
		public static Solenoid scoopSolenoid;
		
		public void initDefaultCommand(){
			setDefaultCommand(new RunScoop());

		}
		
		public Scoop(){
			scoopSolenoid = new Solenoid(RobotMap.scoopSolenoid);
		}
		
		// takes input from runscoop to move the scoop
		public void set(Boolean b) {
			scoopSolenoid.set(b);
		}

}
