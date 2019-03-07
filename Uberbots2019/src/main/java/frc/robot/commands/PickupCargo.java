package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.SetElevatorPosition;
import frc.robot.commands.SetArmPosition;

public class PickupCargo extends CommandGroup {
    public PickupCargo() {
        addParallel(new SetElevatorPosition(11.6)); // in inches
        addParallel(new SetArmPosition(0)); // in degrees
    }
}