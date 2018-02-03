package org.usfirst.frc.team4645.robot.commands;

import org.usfirst.frc.team4645.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class GetEncoderVal extends Command {

	double distance;
	
    public GetEncoderVal(double pDistance) {
        // Use requires() here to declare subsystem dependencies
    	    requires(Robot.kMotorTest);
    	    distance = pDistance;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
		Robot.kMotorTest.initMotor();
		Robot.kMotorTest.driveForward(0.3);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    //Robot.kMotorTest.turnMotor();
    	//Robot.kMotorTest.driveForward(0.1);
    	SmartDashboard.putNumber("encoder", Robot.kMotorTest.getPosition());
    		
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        //return (Robot.kMotorTest.setDistance(14));
    	return (Robot.kMotorTest.getPosition() >= distance);
    }

    // Called once after isFinished returns true
    protected void end() {
    		Robot.kMotorTest.stopMotor();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	
    }
    
}
