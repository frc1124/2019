package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class HatchMechanism extends Subsystem{
    DoubleSolenoid HatchClamp = new DoubleSolenoid (0,1);

    public HatchMechanism(){
        super("HatchMechanism");
    }

    public void initDefaultCommand(){

    }
}


