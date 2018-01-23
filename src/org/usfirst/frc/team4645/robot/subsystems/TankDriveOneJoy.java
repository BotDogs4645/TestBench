package org.usfirst.frc.team4645.robot.subsystems;

import org.usfirst.frc.team4645.robot.OI;
//import org.usfirst.frc.team4645.robot.Robot;
import org.usfirst.frc.team4645.robot.RobotMap;
import org.usfirst.frc.team4645.robot.commands.DriveCommandOneJoy;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
//import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
//import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *

 */

public class TankDriveOneJoy extends Subsystem 
{
	
	private static Talon motorL1 = new Talon(RobotMap.left1);
	private static Talon motorL2 = new Talon(RobotMap.left2);
	private static Talon motorL3 = new Talon(RobotMap.left3);
	//private static SpeedControllerGroup leftSide = new SpeedControllerGroup(motorL1, motorL2, motorL3);
	
	private static Talon motorR1 = new Talon(RobotMap.right1);
	private static Talon motorR2 = new Talon(RobotMap.right2);
	private static Talon motorR3 = new Talon(RobotMap.right3);
	//private static SpeedControllerGroup rightSide = new SpeedControllerGroup(motorR1, motorR2, motorR3);
	
	/*public static Talon motorL1 = new Talon(RobotMap.left1);
	static SpeedControllerGroup leftSide = new SpeedControllerGroup(motorL1);
	
	public static Talon motorR1 = new Talon(RobotMap.left2);
	static SpeedControllerGroup rightSide = new SpeedControllerGroup(motorR1);*/
	
	//static DifferentialDrive robotDrive = new DifferentialDrive(leftSide, rightSide);
	
	
	private static double y_axis;
	private static double x_axis;
	private static double leftVal;
	private static double rightVal;
	
	//double twistVal;


    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() 
    {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    		setDefaultCommand(new DriveCommandOneJoy());
    }
    
    public static void driveWithJoystick()
    {
    		
	
    		
		y_axis = OI.joystick1.getY();
		x_axis = OI.joystick1.getX();
		
		leftVal = y_axis + x_axis;
		rightVal = y_axis - x_axis; 
		
		motorL1.set(leftVal);
		motorL2.set(leftVal);		
		motorL3.set(leftVal);
		
		motorL2.set(rightVal);
		motorR2.set(rightVal);
		motorR3.set(rightVal);
		
		
		SmartDashboard.putNumber("Left Value", leftVal);
		SmartDashboard.putNumber("Right Value", rightVal);
    		
 

    	  
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

