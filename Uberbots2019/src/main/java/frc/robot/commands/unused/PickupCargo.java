package frc.robot.commands.unused;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.unused.SetElevatorPosition;
import frc.robot.commands.unused.SetArmPosition;

public class PickupCargo extends CommandGroup {
    public PickupCargo() {
        addParallel(new SetElevatorPosition(11.6)); // in inches
        addParallel(new SetArmPosition(0)); // in degrees
    }
}