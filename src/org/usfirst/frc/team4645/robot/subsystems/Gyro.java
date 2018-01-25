package org.usfirst.frc.team4645.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team4645.robot.commands.GyroCommand;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.GyroBase;

/**
 *
 */
public class Gyro extends Subsystem {
public static GyroBase gyro = new ADXRS450_Gyro();


    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new GyroCommand());
    }
    public double getGyroAngle()
    {
    	double angle = gyro.getAngle();
    	SmartDashboard.putNumber("Angle",angle);
    	
    	return angle;
    	
    }
    public void resetGyro() 
    {
	gyro.reset();
    }
    
    public void calibrateGyro()
    {
    	gyro.calibrate();
    }
}

