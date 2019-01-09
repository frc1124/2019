package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class Gearbox extends PIDSubsystem{

    public Gearbox(){
        super("Gearbox", 0.0, 0.0, 0.0);

    }

    public void initDefaultCommand(){

    }

    public double returnPIDInput(){
        return 0.0;
    }

    public void usePIDOutput(double input){

    }

}