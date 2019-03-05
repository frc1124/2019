package frc.robot.commands;

import frc.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;


public class PIDDriveTest extends Command {

	private double setPoint;

	public PIDDriveTest(double setPoint){
		this.setPoint = setPoint;
		requires(Robot.driveTrain);
		setInterruptible(true);
	}

	public boolean isFinished(){
		Robot.ntInfo.update();
		System.out.println("Left Encoder: " + Robot.driveTrain.getLeftEncoderDistance());
		System.out.println("Right Encoder: " + Robot.driveTrain.getRightEncoderDistance());
		return false;
	}

	@Override
	protected void execute() {
		//Robot.driveTrain.setLeftPosition(setPoint);
		Robot.driveTrain.setRightPosition(setPoint);
	}

}
