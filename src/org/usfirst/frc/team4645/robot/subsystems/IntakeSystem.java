package org.usfirst.frc.team4645.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;


import edu.wpi.first.wpilibj.Talon;
/**
 *
 */
public class IntakeSystem extends Subsystem {
	private static Talon intakeWheel1 = new Talon(1);
	private static Talon intakeWheel2 = new Talon(2);

	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void intakeIn()
    {
    	intakeWheel1.set(1);
    	intakeWheel2.set(-1);
    	
    }
    public void intakeOut()
    {
    	intakeWheel1.set(-1);
    	intakeWheel2.set(1); 
    	
    }
}

