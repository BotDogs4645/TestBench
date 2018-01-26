package org.usfirst.frc.team4645.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;


import edu.wpi.first.wpilibj.Talon;
/**
 *
 */
public class IntakeSystem extends Subsystem {
	private static WPI_TalonSRX motorIntake1 = new WPI_TalonSRX(1);
	private static WPI_TalonSRX motorIntake2 = new WPI_TalonSRX(2);

	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void intakeIn()
    {
    	motorIntake1.set(1);
    	motorIntake2.set(-1);
    	
    }
    
    public void intakeOut()
    {
    	motorIntake1.set(-1);
    	motorIntake2.set(1);
    	
    }
    
    
    public void intakeRest()
    {
    	motorIntake1.set(0);
    	motorIntake2.set(0);
    }
}

