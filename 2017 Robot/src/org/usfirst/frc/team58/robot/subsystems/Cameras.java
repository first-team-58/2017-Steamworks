package org.usfirst.frc.team58.robot.subsystems;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.cscore.UsbCamera;
/**
 *
 */
public class Cameras extends Subsystem {

	private boolean frontFacing;
	public static UsbCamera frontCamera;
	public UsbCamera rearCamera;
	public UsbCamera currentCam;
	
	public Cameras() {
		super();
		initCameras();
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    private void initCameras() {
		//initialize the cameras
		
		/* commented this out 3.26 - tyler
		 * try {
		 
			frontCamera = new UsbCamera("cam0", 0);
		} catch (Exception e) {
			frontCamera = null;
			DriverStation.reportError("Failed to set up front camera: ", true);
		}
		*/
    	
		/*try {
			rearCamera = new UsbCamera("cam1", 1);
		} catch (Exception e) {
			rearCamera = null;
			DriverStation.reportError("Failed to set up rear camera: ", true);
		}
		*/
		
		
		currentCam = frontCamera;
		frontCamera = CameraServer.getInstance().startAutomaticCapture(0);
		
		
		/*
		try {
			CameraServer.getInstance().addCamera(currentCam);
			CameraServer.getInstance().startAutomaticCapture();
		} catch (Exception e) {
			DriverStation.reportError("Failed to add camera to   server: ", true);
		}
		*/
    }
    
   /* public void swapCameras() {
    	if(frontFacing) {
    		CameraServer.getInstance().startAutomaticCapture(1);
    		System.out.println("swaping to rear");
    		frontFacing = !frontFacing;
    	} else {
    		CameraServer.getInstance().startAutom aticCapture(0);
    		System.out.println("swaping to front");
    		frontFacing = !frontFacing;
    	}
    }
    */
    public UsbCamera getCam(){
    	return frontCamera;
    }
}

