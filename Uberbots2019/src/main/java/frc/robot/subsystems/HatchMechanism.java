package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class HatchMechanism extends Subsystem{
   

    public HatchMechanism(){
        super("HatchMechanism");

        DoubleSolenoid Push1 = new DoubleSolenoid (0,1);
        DoubleSolenoid Push2 = new DoubleSolenoid (2,3);
        DoubleSolenoid Bar = new DoubleSolenoid (4,5);

    }

    public void initDefaultCommand(){

    }
    public void HatchRelease(){

        Push1.set(DoubleSolenoid.Value.kForward);
        Push2.set(DoubleSolenoid.Value.kForward);
        
    }
    public void HatchRetract(){

        Push1.set(DoubleSolenoid.Value.kReverse);
        Push2.set(DoubleSolenoid.Value.kReverse);

    }
}


