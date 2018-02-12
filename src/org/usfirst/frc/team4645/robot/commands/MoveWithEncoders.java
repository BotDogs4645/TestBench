package org.usfirst.frc.team4645.robot.commands;

import org.usfirst.frc.team4645.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class MoveWithEncoders extends Command 
{

	double targetDistance;
	
	//takes the distance the user wants to move as a parameter
    public MoveWithEncoders(double pDistance) 
    {
    	    requires(Robot.tankDriveSubsystem);
    	    targetDistance = pDistance + Robot.tankDriveSubsystem.getRightPosition();
    }

    //slaves and inverts motors; configures optical encoders; 
    protected void initialize() 
    {
    		Robot.tankDriveSubsystem.init();		
    }

    //sets motor speed; displays current encoder position & target distance
    protected void execute() 
    {
    		Robot.tankDriveSubsystem.driveForward();    	
    		SmartDashboard.putNumber("encoder position", Robot.tankDriveSubsystem.getRightPosition());
    		SmartDashboard.putNumber("target distance", targetDistance);
    		
    }

   //motors stop running when the target position is reached
    protected boolean isFinished() 
    {    
    		return (Robot.tankDriveSubsystem.getRightPosition() >= targetDistance);
    		
    }

    // Called once after isFinished returns true
    protected void end() {
    		Robot.tankDriveSubsystem.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() 
    {
    	
    }
    
}
