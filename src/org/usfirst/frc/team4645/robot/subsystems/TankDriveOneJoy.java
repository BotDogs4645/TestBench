package org.usfirst.frc.team4645.robot.subsystems;

import org.usfirst.frc.team4645.robot.OI;
import org.usfirst.frc.team4645.robot.Robot;
import org.usfirst.frc.team4645.robot.RobotMap;
import org.usfirst.frc.team4645.robot.commands.DriveCommandOneJoy;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *

 */

public class TankDriveOneJoy extends Subsystem {
	
	public static Talon motorL1 = new Talon(RobotMap.left1);
	public static Talon motorL2 = new Talon(RobotMap.left2);
	public static Talon motorL3 = new Talon(RobotMap.left3);
	static SpeedControllerGroup leftSide = new SpeedControllerGroup(motorL1, motorL2, motorL3);
	
	public static Talon motorR1 = new Talon(RobotMap.right1);
	public static Talon motorR2 = new Talon(RobotMap.right2);
	public static Talon motorR3 = new Talon(RobotMap.right3);
	static SpeedControllerGroup rightSide = new SpeedControllerGroup(motorR1, motorR2, motorR3);
	
	/*public static Talon motorL1 = new Talon(RobotMap.left1);
	static SpeedControllerGroup leftSide = new SpeedControllerGroup(motorL1);
	
	public static Talon motorR1 = new Talon(RobotMap.left2);
	static SpeedControllerGroup rightSide = new SpeedControllerGroup(motorR1);*/
	
	static DifferentialDrive robotDrive = new DifferentialDrive(leftSide, rightSide);
	
	static double  y_axis, x_axis, leftVal, rightVal, twistVal;


    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    		setDefaultCommand(new DriveCommandOneJoy());
    }
    
    public static  void driveWithJoystick()
    {
    		
    	    //joystick 1 controlls left wheels, joystick2 controlls right wheels
    		y_axis = OI.joystick1.getY();
    		x_axis = OI.joystick1.getX();
    		
    		leftVal = y_axis + x_axis;
    		rightVal = y_axis - x_axis; 
    		robotDrive.arcadeDrive(leftVal, rightVal);
    		
    		SmartDashboard.putNumber("Left Value", leftVal);
    		SmartDashboard.putNumber("Right Value", rightVal);
    	
    		//SmartDashboard.putNumber("1", 1);
    		
    
    		/*if(twistVal> 0.5)
    		{
    			
    		}*/
    		
    		
  
    
    }
    
    public static void stop()
    {
    		robotDrive.tankDrive(0,0);
    }
}

