package org.usfirst.frc.team4645.robot.subsystems;
import org.usfirst.frc.team4645.robot.OI;
import org.usfirst.frc.team4645.robot.RobotMap;
import org.usfirst.frc.team4645.robot.commands.DriveCommandOneJoy;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
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
	
	private double speed = 0.1;
	
	public TankDriveOneJoy()
	{
		super("drivetrain", 0.0, 0.0, 0.0);
		setAbsoluteTolerance(0.05);
		
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
		
		//Sets the period of the given status frame to 1 ms and the timeout value to 10ms 
		motorR1.setStatusFramePeriod(StatusFrameEnhanced.Status_2_Feedback0, 1, 10);		
		motorL1.setStatusFramePeriod(StatusFrameEnhanced.Status_2_Feedback0, 1, 10);
		
		//selects the optical encoder, sets it as a closed loop, and sets timeout to 10ms
		motorR1.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 10);	
		motorL1.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 10); 		
    }
    
  
    
    public void driveWithJoystick()
    {
		double forward = OI.joystick1.getY();
		double turn = OI.joystick1.getZ();

		/* deadband */
		if (Math.abs(forward) < 0.10) 
		{
			/* within 10% joystick, make it zero */
			forward = 0;
		}
		
		if (Math.abs(turn) < 0.10) 
		{
			/* within 10% joystick, make it zero */
			turn = 0;
		}
		

		SmartDashboard.putNumber("JoyY:",  forward);
		SmartDashboard.putNumber("Turn", turn);

		robotDrive.arcadeDrive(forward, turn);		
	}
    
	public double getRightPosition() 
	{
		return motorR1.getSelectedSensorPosition(0);	
	}

	
	public void driveForward()
	{
		motorL1.set(speed);
		motorR1.set(speed);	
	}
	
    public void stop()
    {
		motorL1.set(0);
		motorR1.set(0);
	}
    
	public void setMotorSpeeds()
	{	
	}


	@Override
	public double returnPIDInput() {
		// TODO Auto-generated method stub
		return motorR1.getSelectedSensorPosition(0);
	}


	@Override
	public void usePIDOutput(double output) {
		// TODO Auto-generated method stub
		motorL1.pidWrite(output);
		motorR1.pidWrite(output);
		SmartDashboard.putNumber("output", output);
		
	}
    
	
    
}