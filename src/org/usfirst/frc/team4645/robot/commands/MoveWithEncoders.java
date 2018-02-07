package org.usfirst.frc.team4645.robot.commands;

import org.usfirst.frc.team4645.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class MoveWithEncoders extends Command 
{

	double distance;
	
    public MoveWithEncoders(double pDistance) 
    {
    	    requires(Robot.tankDriveSubsystem);
    	    distance = pDistance;
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
    		Robot.tankDriveSubsystem.init();
		
	
    }

    // Called repeatedly when this Command is scheduled to run
    //runs motors and returns encoder values
    protected void execute() 
    {
    		Robot.tankDriveSubsystem.driveForward(0.3);
    		SmartDashboard.putNumber("encoder position", Robot.tankDriveSubsystem.getLeftPosition());	
    }

   
    protected boolean isFinished() 
    {    
    		return (Robot.tankDriveSubsystem.getLeftPosition() >= distance);
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
