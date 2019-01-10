package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class HatchMechanism extends Subsystem{
   
    protected static DoubleSolenoid Push1, Push2, Bar;

    public HatchMechanism(){
        super("HatchMechanism");

        Push1 = new DoubleSolenoid (0,1);
        Push2 = new DoubleSolenoid (2,3);
        Bar = new DoubleSolenoid (4,5);

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


