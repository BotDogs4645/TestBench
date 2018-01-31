package org.usfirst.frc.team4645.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team4645.robot.RobotMap;
import org.usfirst.frc.team4645.robot.commands.DetectDistance;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DistanceSensor extends Subsystem {
	private AnalogInput dSensor = new AnalogInput(RobotMap.ultrasonicSensor); //Create analog input object
	
	// Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public void findDistance() {
		double voltage = dSensor.getVoltage(); //Analog voltage from distance sensor
		
		double rangemm = ((voltage*1000)/4.88)*5; //Voltage scaling from sensor documentation
		double rangecm = (rangemm/10); //Convert mm to cm
		SmartDashboard.putNumber("Distance Volts", voltage); //Output voltage

		SmartDashboard.putNumber("Distance cm", rangecm); //Output distance as cm
		SmartDashboard.putNumber("Distance mm", rangemm); //Output distance as mm

	}
	
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new DetectDistance());
    }
}

