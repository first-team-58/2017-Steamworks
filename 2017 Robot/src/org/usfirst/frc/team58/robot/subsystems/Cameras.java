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
	public UsbCamera frontCamera;
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
		frontFacing = true;
		try {
			frontCamera = new UsbCamera("cam0", 0);
		} catch (Exception e) {
			frontCamera = null;
			DriverStation.reportError("Failed to set up front camera: ", true);
		}
		
		try {
			rearCamera = new UsbCamera("cam1", 0);
		} catch (Exception e) {
			rearCamera = null;
			DriverStation.reportError("Failed to set up rear camera: ", true);
		}

		currentCam = frontCamera;
		try {
			CameraServer.getInstance().addCamera(currentCam);
		} catch (Exception e) {
			DriverStation.reportError("Failed to add camera to server: ", true);
		}
    }
    
    public void swapCameras() {
    	if(frontFacing) {
    		currentCam = rearCamera;
    		CameraServer.getInstance().removeCamera(frontCamera.getName());
    		CameraServer.getInstance().addCamera(rearCamera);
    		frontFacing = !frontFacing;
    	} else {
    		currentCam = frontCamera;
    		CameraServer.getInstance().removeCamera(rearCamera.getName());
    		CameraServer.getInstance().addCamera(frontCamera);
    		frontFacing = !frontFacing;
    	}
    }
}


