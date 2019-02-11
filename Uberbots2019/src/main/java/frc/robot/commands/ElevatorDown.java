package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;


public class ElevatorDown extends Command {
	// TODO: GET VALUE
	private double pos = 0;

	public ElevatorDown(){
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
