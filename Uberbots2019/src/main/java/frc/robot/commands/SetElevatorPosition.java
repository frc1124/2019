package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class SetElevatorPosition extends Command {
    private double targetPosition;
    private double CLOSE = 0.5; // in inches

    public SetElevatorPosition(double position) {
        super("SetElevatorPosition");
        requires(Robot.elevator);

        // Convert position from inches to rotations at 2mm per rotation
        this.targetPosition = position;
    }

    protected void execute() {
        // Figure out which way to run the elevator and go
        double diff = Robot.elevator.getPosition() - this.targetPosition;

        // If we're close, run half speed
        double speed = (Math.abs(diff) < CLOSE) ? 0.5 : 1;
        if (diff < 0) {
            speed *= -1;
        }

        // Run the elevator
        Robot.elevator.set(speed);
    }

    protected boolean isFinished() {
        return (Robot.elevator.getPosition() == this.targetPosition);
    }
}