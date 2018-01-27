package org.usfirst.frc.team4645.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;


import edu.wpi.first.wpilibj.Talon;
/**
 *
 */
public class IntakeSystem extends Subsystem {
	//Creates motors 2018
	private WPI_TalonSRX motorIntake1 = new WPI_TalonSRX(10);
	private WPI_TalonSRX motorIntake2 = new WPI_TalonSRX(11);

	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    //intakes cube in
    public void intakeIn()
    {
    	motorIntake1.set(1);
    	motorIntake2.set(-1);
    	
    }
  //intakes cube out
    public void intakeOut()
    {
    	motorIntake1.set(-1);
    	motorIntake2.set(1);
    	
    }
    
    //Intake does not move
    public void intakeRest()
    {
    	motorIntake1.set(0);
    	motorIntake2.set(0);
    }
}

