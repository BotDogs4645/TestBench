package org.usfirst.frc.team4645.robot.subsystems;
import org.usfirst.frc.team4645.robot.OI;
import org.usfirst.frc.team4645.robot.Robot;
import org.usfirst.frc.team4645.robot.RobotMap;
import org.usfirst.frc.team4645.robot.commands.DriveCommandOneJoy;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class TankDriveOneJoy extends PIDSubsystem 
{
	
	public WPI_TalonSRX motorL1 = new WPI_TalonSRX(RobotMap.left1);
	public WPI_TalonSRX motorL2 = new WPI_TalonSRX(RobotMap.left2);
	public  WPI_TalonSRX motorL3 = new WPI_TalonSRX(RobotMap.left3);
	
	
	
	public WPI_TalonSRX motorR1 = new WPI_TalonSRX(RobotMap.right1);
	public WPI_TalonSRX motorR2 = new WPI_TalonSRX(RobotMap.right2);
	public WPI_TalonSRX motorR3 = new WPI_TalonSRX(RobotMap.right3);
	
	DifferentialDrive robotDrive = new DifferentialDrive(motorL1, motorR1);
	
	//public double moveDistance = 16000;

	
	//constructor that initializes PID values
	public TankDriveOneJoy()
	{
		super("drivetrain", 0.00040, 0.00, 0.000);//0.004 worked for awhile
		setAbsoluteTolerance(100);
		
		//sets absolute error which is considered tolerable
		getPIDController().setContinuous(false);//sets max & min values as constraints ALWAYS SET AS FALSE
		//add right side
		motorL1.setSensorPhase(false);

		
	}	
    public void initDefaultCommand() 
    {

    		setDefaultCommand(new DriveCommandOneJoy());
    }
      
    public void init()
    {
    		//motors on "middle" gear are slaved and inverted with motor on top gear
		motorL2.follow(motorL1);
		motorL3.follow(motorL1);
		motorL2.setInverted(true);
		motorL3.setInverted(true);
		
		
		motorR2.follow(motorR1);
		motorR3.follow(motorR1);
		motorR2.setInverted(true);
		motorR3.setInverted(true);	
		
		//add right side
		motorL1.configNominalOutputForward(0, 10);
		motorL1.configNominalOutputReverse(0, 10);
		motorL1.configPeakOutputForward(0.5, 10);
		motorL1.configPeakOutputReverse(-0.5, 10);
		
		
		
		
		//Sets the period of the given status frame(20ms) to 1 ms and the timeout value to 10ms 
		motorR1.setStatusFramePeriod(StatusFrameEnhanced.Status_2_Feedback0, 1, 10);		
		motorL1.setStatusFramePeriod(StatusFrameEnhanced.Status_2_Feedback0, 1, 10);
		
		//selects the optical encoder, sets it as a closed loop, and sets timeout to 10ms
		motorR1.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 10);	
		motorL1.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 10); 	
		
		
		
		//enable();
		//setSetpoint(moveDistance);
		
		
		

		
    }
    
    /*public void distance()
    {
    	SmartDashboard.putNumber("target distance", istance);
    	
    	
    }*/
    
  
    
    public void driveWithJoystick()
    {
		double forward = (OI.joystick1.getY());
		double turn = (OI.joystick1.getZ());

		/* deadband */
		
		if ((Math.abs(forward) < 0.50) && (Math.abs(turn) < 0.70)) 
		{
			SmartDashboard.putNumber("Motor power w/ joystick", motorL1.get());
			/* within 10% joystick, make it zero */
			stop();
		
			
		}
		
		
		else 
		{
			SmartDashboard.putNumber("JoyY:",  forward);
			SmartDashboard.putNumber("Turn", turn);
			SmartDashboard.putNumber("Motor power w/ joystick", motorL1.get());

			robotDrive.arcadeDrive(forward, turn);
			SmartDashboard.putNumber("Left Sensor Velocity(joystick command)", getLeftVelocity() );
		}
		


	}
    
	public double getLeftPosition() 
	{
		return motorL1.getSelectedSensorPosition(0);	
	}
	
	public double getLeftVelocity() 
	{
		return motorL1.getSelectedSensorVelocity(0);	
	}	
	

	
	/*public void driveForward()
	{
		motorL1.set(speed);
		motorR1.set(speed);	
	}*/
	
    public void stop()
    {
		motorL1.set(0);
		motorR1.set(0);
		//disable();
	}
    
    public void setEncoderPosition(int pos) 
    {
    		motorL1.setSelectedSensorPosition(pos, 0, 0);
    		motorR1.setSelectedSensorPosition(pos, 0, 0);
    }

	@Override
	protected double returnPIDInput() 
	{
		// TODO Auto-generated method stub
		//returns encoder position
		SmartDashboard.putNumber("PID input", motorL1.getSelectedSensorPosition(0));
		
		return motorL1.getSelectedSensorPosition(0);
		
	}

	@Override
	protected void usePIDOutput(double output) 
	{
		//if (getPIDController().isEnable())
		// TODO Auto-generated method stub
			motorL1.pidWrite(output);
			motorR1.pidWrite(output);
			SmartDashboard.putNumber("PID output", output);
			
		
	}
    



    
	
    
}