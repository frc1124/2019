package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;


public class ElevatorUp extends Command {
	// TODO: GET VALUE
	private double pos = 0;

	public ElevatorUp(){
        // requires(Robot.elevator);

        setInterruptible(true);
    }

    public boolean isFinished(){
		return false;
    }

    @Override
  protected void execute() {
    // Robot.elevator.setPosition(pos);
  }

}
