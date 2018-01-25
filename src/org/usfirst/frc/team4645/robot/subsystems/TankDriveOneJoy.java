package org.usfirst.frc.team4645.robot.subsystems;
import org.usfirst.frc.team4645.robot.OI;
import org.usfirst.frc.team4645.robot.RobotMap;
import org.usfirst.frc.team4645.robot.commands.DriveCommandOneJoy;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
//import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 *

 */

public class TankDriveOneJoy extends Subsystem 
{
	
	private static WPI_TalonSRX motorL1 = new WPI_TalonSRX(RobotMap.left1);
	private static WPI_TalonSRX motorL2 = new WPI_TalonSRX(RobotMap.left2);
	private static WPI_TalonSRX motorL3 = new WPI_TalonSRX(RobotMap.left3);
	private static SpeedControllerGroup leftSide = new SpeedControllerGroup(motorL1, motorL2, motorL3);
	
	private static WPI_TalonSRX motorR1 = new WPI_TalonSRX(RobotMap.right1);
	private static WPI_TalonSRX motorR2 = new WPI_TalonSRX(RobotMap.right2);
	private static WPI_TalonSRX motorR3 = new WPI_TalonSRX(RobotMap.right3);
	private static SpeedControllerGroup rightSide = new SpeedControllerGroup(motorR1, motorR2, motorR3);
	
	

    public void initDefaultCommand() 
    {

    		setDefaultCommand(new DriveCommandOneJoy());
    }
    
    public static void driveWithJoystick()
    {
    	//sets both motor speeds with joystick Y-values, with left side going clockwise, right side going counter-clockwise
    		rightSide.set(-OI.joystick1.getY());  		
    		leftSide.set( OI.joystick1.getY());
    		
    	//As joysticks turn, so does drive train
		rightSide.set(OI.joystick1.getZ());
		leftSide.set(OI.joystick1.getZ()); 
		
		SmartDashboard.putNumber("right side", rightSide.get());
		SmartDashboard.putNumber("left side", leftSide.get());

    	  
    }
    
    public static void stop()
    {
    	
		motorL1.set(0);
		motorL2.set(0);		
		motorL3.set(0);
		
		motorR1.set(0);
		motorR2.set(0);
		motorR3.set(0);
    	
   	
    }
}

