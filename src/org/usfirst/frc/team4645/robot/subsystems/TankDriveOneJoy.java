package org.usfirst.frc.team4645.robot.subsystems;
import org.usfirst.frc.team4645.robot.OI;
import org.usfirst.frc.team4645.robot.RobotMap;
import org.usfirst.frc.team4645.robot.commands.DriveCommandOneJoy;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 *

 */

public class TankDriveOneJoy extends Subsystem 
{
	
	private static Talon motorL1 = new Talon(RobotMap.left1);
	private static Talon motorL2 = new Talon(RobotMap.left2);
	private static Talon motorL3 = new Talon(RobotMap.left3);
	private static SpeedControllerGroup leftSide = new SpeedControllerGroup(motorL1, motorL2, motorL3);
	
	private static Talon motorR1 = new Talon(RobotMap.right1);
	private static Talon motorR2 = new Talon(RobotMap.right2);
	private static Talon motorR3 = new Talon(RobotMap.right3);
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

