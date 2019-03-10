package frc.robot.commands;

import frc.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ToggleHatch extends Command {

    private boolean hasToggled = false;

    public ToggleHatch(){
        requires(Robot.hatchMechanism);

        setInterruptible(true);
    }

    public boolean isFinished(){
        return hasToggled;
    }

    @Override
    protected void execute() {
        Robot.hatchMechanism.HatchToggle();
        hasToggled = true;
    }

}
