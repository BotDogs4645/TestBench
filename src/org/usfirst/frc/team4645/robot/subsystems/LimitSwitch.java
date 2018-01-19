

package org.usfirst.frc.team4645.robot.subsystems;
import org.usfirst.frc.team4645.robot.RobotMap;
import org.usfirst.frc.team4645.robot.commands.LimitSwitchSensing;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/**
 *
 */

public class LimitSwitch extends Subsystem 

{
	static DigitalInput limitSwitch = new DigitalInput(RobotMap.limitSwitchPort);
	static Counter counter1 = new Counter(limitSwitch);
	static boolean value;
	static int count=0;
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	
	
	//tells if switch is set (1)
	public static boolean isSwitchSet()
	{
		return counter1.get()>0;
	}
	
	//resets counter
    public void initializeCounter() {
        counter1.reset();
    }	
    
    public static void switchValue()
    {	
    		value = limitSwitch.get();
    		SmartDashboard.putBoolean("Value", value);
    		count++;
    		SmartDashboard.putNumber("Count", count);
    
    	
    }
 
	
	
	public void initDefaultCommand() 
	{
		// Set the default command for a subsystem here.
		setDefaultCommand(new LimitSwitchSensing());
		
	}
	

	
}
