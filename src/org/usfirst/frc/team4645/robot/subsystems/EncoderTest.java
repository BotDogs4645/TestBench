package org.usfirst.frc.team4645.robot.subsystems;

import org.usfirst.frc.team4645.robot.commands.GetEncoderVal;

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
	

	
	public void initMotor() 
	{
		
		_tal.setStatusFramePeriod(StatusFrameEnhanced.Status_2_Feedback0, 1, 10);
		_tal.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 10);

		
	}
	
	public void turnMotor() 
	{
		SmartDashboard.putNumber("test", 2);		
		double velocity = _tal.getSelectedSensorVelocity(0);
		double position = _tal.getSelectedSensorPosition(0);
		SmartDashboard.putNumber("sensor velocity", velocity);
		SmartDashboard.putNumber("sensor position", position);
		
	}
	
	public void stopMotor() 
	{
	
	}
	
    public void initDefaultCommand()
    {
    		setDefaultCommand(new GetEncoderVal());
    }

    
	    
}