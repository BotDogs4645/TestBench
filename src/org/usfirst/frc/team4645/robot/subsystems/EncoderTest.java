package org.usfirst.frc.team4645.robot.subsystems;

import org.usfirst.frc.team4645.robot.commands.GetEncoderVal;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class EncoderTest extends Subsystem
{
	
	private WPI_TalonSRX _tal = new WPI_TalonSRX(10);
	private double cm;
	

	
	public void initMotor() 
	{
		
		_tal.setStatusFramePeriod(StatusFrameEnhanced.Status_2_Feedback0, 1, 10);
		_tal.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 10);
		
		_tal.configNominalOutputForward(0, 10);
		_tal.configNominalOutputReverse(0,10);
		_tal.configPeakOutputForward(1, 10);
		_tal.configPeakOutputReverse(-1, 10);
		
		_tal.configAllowableClosedloopError(0, 0, 10);

		/* set closed loop gains in slot0, typically kF stays zero. */
		_tal.config_kF(0, 0.0, 10);
		_tal.config_kP(0, 0.1, 10);
		_tal.config_kI(0, 0.0, 10);
		_tal.config_kD(0, 0.0, 10);
		
		_tal.setSelectedSensorPosition(0,0,0);
		
	}
	
	public double getPosition() {
		
		return _tal.getSelectedSensorPosition(0);
		
	}

	/*
	public boolean turnMotor(double distance) 
	{
		cm = distance/12.53;
		
		double velocity = _tal.getSelectedSensorVelocity(0);
		double position = _tal.getSelectedSensorPosition(0);
		SmartDashboard.putNumber("sensor velocity", velocity);
		SmartDashboard.putNumber("sensor position", position);
		
		while (position <= cm) {
			
		}
		
		if(position > cm)
		{
			
		}
		
	}
	*/
	
	public void driveForward(double yVal)
	{
		_tal.set(yVal);
		
	}
	
	public void stopMotor() 
	{
		_tal.set(0);
	
	}
	
	public boolean setDistance(double distance)
	{
		return true;
	}
	
    public void initDefaultCommand()
    {
    		//setDefaultCommand(new GetEncoderVal(400));
    }

    
	    
}