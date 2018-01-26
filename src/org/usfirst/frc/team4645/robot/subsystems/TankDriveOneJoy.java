package org.usfirst.frc.team4645.robot.subsystems;
import org.usfirst.frc.team4645.robot.OI;
import org.usfirst.frc.team4645.robot.RobotMap;
import org.usfirst.frc.team4645.robot.commands.DriveCommandOneJoy;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 *

 */

public class TankDriveOneJoy extends Subsystem 
{
	
	public WPI_TalonSRX motorL1 = new WPI_TalonSRX(RobotMap.left1);
	public WPI_TalonSRX motorL2 = new WPI_TalonSRX(RobotMap.left2);
	public  WPI_TalonSRX motorL3 = new WPI_TalonSRX(RobotMap.left3);
	
	public WPI_TalonSRX motorR1 = new WPI_TalonSRX(RobotMap.right1);
	public WPI_TalonSRX motorR2 = new WPI_TalonSRX(RobotMap.right2);
	public WPI_TalonSRX motorR3 = new WPI_TalonSRX(RobotMap.right3);
	
	DifferentialDrive robotDrive = new DifferentialDrive(motorL1, motorR1);

    public void initDefaultCommand() 
    {

    		setDefaultCommand(new DriveCommandOneJoy());
    }
    
    public void init()
    {
    	//motors connected to "middle" gear are slaved on both sides
		motorL2.follow(motorL1);
		motorL3.follow(motorL1);
		motorL2.setInverted(true);
		motorL3.setInverted(true);
		
		
		motorR2.follow(motorR1);
		motorR3.follow(motorR1);
		motorR2.setInverted(true);
		motorR3.setInverted(true);
		
    	
    }
    
    public void driveWithJoystick()
    {
		double forward = OI.joystick1.getY();
		
		/* sign this so right is positive. */
		double turn = OI.joystick1.getZ();
		
		
		
		/* deadband */
		if (Math.abs(forward) < 0.10) {
			/* within 10% joystick, make it zero */
			forward = 0;
		}
		if (Math.abs(turn) < 0.10) {
			/* within 10% joystick, make it zero */
			turn = 0;
		}
		

		SmartDashboard.putNumber("JoyY:",  forward);
		SmartDashboard.putNumber("Turn", turn);

//what does forward do? what does turn do?
		robotDrive.arcadeDrive(forward, turn);		
	}
    	
    	
    /*
    	//sets both motor speeds with joystick Y-values, with left side going clockwise, right side going counter-clockwise
    		rightSide.set(-OI.joystick1.getY());  		
    		leftSide.set( OI.joystick1.getY());
    		
    	//As joysticks turn, so does drive train
		rightSide.set(OI.joystick1.getZ());
		leftSide.set(OI.joystick1.getZ()); 
		
		SmartDashboard.putNumber("right side", rightSide.get());
		SmartDashboard.putNumber("left side", leftSide.get());

    	  
    }
    */
    public void stop()
    {
    	
		motorL1.set(0);
	
		motorR1.set(0);

	}
    
}

