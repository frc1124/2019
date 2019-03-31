package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;


public class ToggleElevator extends Command {
	// TODO: Find setPoint
	//private double setPoint = 0;
	//private final double TOLERANCE = 0.1;
	private boolean done = false;

	public ToggleElevator(){
		//super("ToggleElevator", RobotMap.ELEVATOR_P, RobotMap.ELEVATOR_I, RobotMap.ELEVATOR_D);
		requires(Robot.elevator);

		setInterruptible(false);
    }
	
	public boolean isFinished(){
		//return Math.abs(Robot.elevator.getEncoderDistance() - setPoint) <= TOLERANCE;
		return this.done;
	}

	@Override
	protected void execute() {
		Robot.elevator.moveUp(Robot.elevator.getRaiseElevator());
		this.done = true;
	}

	public double returnPIDInput(){
		//return Robot.elevator.getEncoderDistance();
		return 0.0;
	}
    /*
	public void usePIDOutput(double output) {
		Robot.elevator.getPIDController().pidWrite(output);
	}

    @Override
    public void end(){
        Robot.elevator.toggleRaiseElevator();
    }*/
}
