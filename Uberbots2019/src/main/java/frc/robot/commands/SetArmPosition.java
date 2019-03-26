package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class SetArmPosition extends Command {
    private double targetAngle;
    private final double CLOSE = 5;
    private final double TOP = 130;

    public SetArmPosition(double angle) {
        super("SetArmPosition");
        requires(Robot.arm);
        this.targetAngle = angle;
    }

    protected void execute() {
/*
        // Figure out which way to run the arm and go
        double diff = Robot.arm.getPosition() - this.targetPosition;

        // If we're close, run half speed
        double speed = (Math.abs(diff) < CLOSE) ? 0.5 : 1;
        if (diff < 0) {
            speed *= -1;
        }

        // Go to full if we're in a certain angle range no matter what; we need everything we can get
        if ((Robot.arm.getAngle() < TOP && speed > 0) ||
            (Robot.arm.getAngle() >= TOP && speed < 0)) {
                speed = (speed < 0) ? -1 : 1;
            }

        // If the angle is about to go too low for the elevator height, wait
        double armHeight = 31.25 * Math.sin(Robot.arm.getAngle()); // in inches
        if ((armHeight + Robot.elevator.getPosition()) < 4.0) {
            speed = 0; // hold
        }

        // Run the arm
        Robot.arm.setVelocity(speed);
*/
        //Robot.arm.setAngle(targetAngle);
    }

    protected void end() {
        //Robot.arm.setVelocity(0);
    }

    protected void interrupted() {
        // Robot.arm.setVelocity(0);
    }

    protected boolean isFinished() {
        // return (Robot.arm.getAngle() == this.targetAngle);
        return false;
    }
}