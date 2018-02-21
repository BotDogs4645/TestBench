package org.usfirst.frc.team4645.robot.commands;

import org.usfirst.frc.team4645.robot.Robot;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class MoveWithEncoders extends Command 
{
	public PIDController drivePID;
	double distance;
	//double targetDistance;

	
	//takes the distance the user wants to move as a parameter
    public MoveWithEncoders(double distance) 
    {
    	
    	    requires(Robot.tankDriveSubsystem);
    	    drivePID = Robot.tankDriveSubsystem.getPIDController();
    	    this.distance = distance * 72 ; //there are 72 counts per inch
    	    
    }

    //slaves and inverts motors; configures optical encoders; 
    protected void initialize() 
    {
    		Robot.tankDriveSubsystem.init();
    		Robot.tankDriveSubsystem.setEncoderPosition(0);
    		
    		drivePID.setSetpoint(distance);
    		SmartDashboard.putNumber("target distance", distance);
    		drivePID.enable();
    		

    }

    //sets motor speed; displays current encoder position & target distance
    protected void execute() 
    {
   
    	SmartDashboard.putString("MoveWithEncoder", "execute");
    	SmartDashboard.putNumber("Velocity", Robot.tankDriveSubsystem.getLeftVelocity());
    	
    }

   //motors stop running when the target position is reached
    protected boolean isFinished() 
    {    
    		
    		return drivePID.onTarget();//(Robot.tankDriveSubsystem.getRightPosition() >= moveDistance);
    		
    }

    // Called once after isFinished returns true
    protected void end() {
    	
    		drivePID.disable();
    		Robot.tankDriveSubsystem.stop();
    		SmartDashboard.putString("MoveWithEncoder", "end");
    		
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() 
    {
    	
    }
    
}
