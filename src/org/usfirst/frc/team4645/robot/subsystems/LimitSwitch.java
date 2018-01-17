

package org.usfirst.frc.team4645.robot.subsystems;
import org.usfirst.frc.team4645.robot.commands.LimitSwitchSensing;
import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */

public class LimitSwitch extends Subsystem 

{
	//declared limit switch and counter variables
	static DigitalInput limitSwitch;
	static Counter counter = new Counter(limitSwitch);
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() 
	{
		// Set the default command for a subsystem here.
		setDefaultCommand(new LimitSwitchSensing());
		
	}
	
	public static boolean isSwitchSet()
	{
		return counter.get()>0;
	}
	
}
