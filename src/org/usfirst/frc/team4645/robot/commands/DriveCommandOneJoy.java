package org.usfirst.frc.team4645.robot.commands;
import org.usfirst.frc.team4645.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class DriveCommandOneJoy extends Command 
{
	

    public DriveCommandOneJoy() 
    {
    		requires(Robot.tankDriveSubsystem);
    }

    protected void initialize() 
    {
    		Robot.tankDriveSubsystem.init();
    }

    protected void execute() 
    {	
    		
    		Robot.tankDriveSubsystem.driveWithJoystick();
    		//SmartDashboard.putNumber("encoder position", Robot.tankDriveSubsystem.getLeftPosition());
    		
    		//SmartDashboard.putNumber("Encoder position (joystick command)", Robot.tankDriveSubsystem.getLeftPosition());
    		//SmartDashboard.getBoolean("is finished", Robot.tankDriveSubsystem.getPIDController().onTarget());
    }

    protected boolean isFinished() 
    {
        return false;
    }

    protected void end() 
    {
    }

    protected void interrupted() 
    {
    	  Robot.tankDriveSubsystem.stop();	
    }
}
