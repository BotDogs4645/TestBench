package org.usfirst.frc.team4645.robot;
import org.usfirst.frc.team4645.robot.commands.AutonomousTest;
import org.usfirst.frc.team4645.robot.commands.MoveWithEncoders;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI 
{
	
	public static Joystick joystick1 = new Joystick(0);
	
	
	Button encoderButton = new JoystickButton(joystick1, 3);
	
	
	
	public OI()
	{
		System.out.println("test");
		encoderButton.whenPressed(new MoveWithEncoders(36));//in inches
	}

}
