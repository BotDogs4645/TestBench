

package org.usfirst.frc.team4645.robot.subsystems;
import org.usfirst.frc.team4645.robot.RobotMap;
import org.usfirst.frc.team4645.robot.commands.LimitSwitchSensing;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/**
 *
 */

public class LimitSwitch extends Subsystem 

{
	private static DigitalInput limitSwitch = new DigitalInput(RobotMap.limitSwitchPort);
	private static boolean value;
	private static int count=0;

 
    public static void switchValue()
    {	
    		value = limitSwitch.get();
    		SmartDashboard.putBoolean("Value", value);
    		count++;
    		SmartDashboard.putNumber("Count", count);  
    }
 
	
	
	public void initDefaultCommand() 
	{
		setDefaultCommand(new LimitSwitchSensing());
		
	}
	

	
}
