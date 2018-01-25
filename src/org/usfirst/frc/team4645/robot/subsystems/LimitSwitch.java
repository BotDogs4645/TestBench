

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
	private DigitalInput limitSwitch = new DigitalInput(RobotMap.limitSwitchPort);
	private boolean value;
	private int count=0;

 
    public void switchValue()
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
