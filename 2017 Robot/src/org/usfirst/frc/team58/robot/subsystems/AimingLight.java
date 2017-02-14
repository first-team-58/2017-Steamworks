package org.usfirst.frc.team58.robot.subsystems;

import org.usfirst.frc.team58.robot.RobotMap;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;

public class AimingLight extends Subsystem {
		private Relay lightSpike;
		
		public void initDefaultCommand(){
			//setDefaultCommand();
		}
		
		public AimingLight(){
			lightSpike = new Relay(RobotMap.lightSpike);
			
		}
		
		public void shineLight(Boolean input){
			
			if(input = true){
				lightSpike.set(Relay.Value.kOn);
			} else{
				lightSpike.set(Relay.Value.kOff);
			}
		}
}
