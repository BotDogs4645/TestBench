package org.usfirst.frc.team4645.robot.subsystems;


import org.usfirst.frc.team4645.robot.commands.GetEncoderVal;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class EncoderTest extends Subsystem
{
	
	private WPI_TalonSRX _tal = new WPI_TalonSRX(10);

	public void initMotor() 
	{
		//Sets the period of the given status frame to 5 ms and the timeout value to 10ms 
		_tal.setStatusFramePeriod(StatusFrameEnhanced.Status_2_Feedback0, 1, 10);
		
		//selects the optical encoder, sets it as a closed loop, and sets timeout to 10ms
		_tal.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 10);
		
		
		//PID values, not currently being used
		_tal.configNominalOutputForward(0, 10);
		_tal.configNominalOutputReverse(0,10);
		_tal.configPeakOutputForward(1, 10);
		_tal.configPeakOutputReverse(-1, 10);
		
		_tal.configAllowableClosedloopError(0, 0, 10);

	
		_tal.config_kF(0, 0.0, 10);
		_tal.config_kP(0, 0.1, 10);
		_tal.config_kI(0, 0.0, 10);
		_tal.config_kD(0, 0.0, 10);
		
		
		//resets encoder value
		//_tal.setSelectedSensorPosition(0,0,0);
		
	}
	
	public double getPosition() 
	{
		
		return _tal.getSelectedSensorPosition(0);
		
	}


	//called in command
	public void driveForward(double speed)
	{
		_tal.set(speed);
		
	}
	
	
	public void stopMotor() 
	{
		_tal.set(0);
	
	}
	
	public boolean setDistance(double distance)
	{
		return true;
	}
	
	//sets the the distance (in counts) when motor will stop
	//400 units per rotation
    public void initDefaultCommand()
    {
    		setDefaultCommand(new GetEncoderVal(400));
    }

    
	    
}