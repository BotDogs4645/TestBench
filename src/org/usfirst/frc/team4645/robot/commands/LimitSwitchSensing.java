package org.usfirst.frc.team4645.robot.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4645.robot.Robot;

/**
 *
 */
public class LimitSwitchSensing extends Command {

    public LimitSwitchSensing() 
    {
  
		requires(Robot.LimitSwitchSubsystem);    	
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    		Robot.LimitSwitchSubsystem.switchValue();
    }

    //since it always returns false, it is always running
    protected boolean isFinished() 
    {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
