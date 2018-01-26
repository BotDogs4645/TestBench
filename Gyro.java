package org.usfirst.frc.team4645.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team4645.robot.commands.GyroCommand;

import edu.wpi.first.wpilibj.AnalogGyro;

/**
 *
 */
public class Gyro extends Subsystem {
AnalogGyro gyro = new AnalogGyro(0);
int counter=0;

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
    	SmartDashboard.putNumber("Value:",angle);
    	counter++;
    	SmartDashboard.putNumber("Counter:",counter);
    	return angle;
    	
    }
    public void resetGyro() 
    {
	gyro.reset();
    }
}

