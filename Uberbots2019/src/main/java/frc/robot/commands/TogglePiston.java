package frc.robot.commands;

import frc.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class TogglePiston extends Command {

    private boolean hasToggled = false;

    public TogglePiston(){
        requires(Robot.hatchMechanism);

        setInterruptible(true);
    }

    public boolean isFinished(){
        return hasToggled;
    }

    @Override
    protected void execute() {
        Robot.hatchMechanism.PistonToggle();
        hasToggled = true;
    }

}
