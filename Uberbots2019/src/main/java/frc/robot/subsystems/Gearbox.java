package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.PIDSourceType;

public class Gearbox extends PIDSubsystem{
	private SpeedController front, back;
	private SpeedControllerGroup speedControllerGroup;
	private Encoder encoder;

    public Gearbox(SpeedController front, SpeedController back, Encoder encoder, double p, double i, double d, double f){
        super("Gearbox",p,i,d,f);
		this.speedControllerGroup = new SpeedControllerGroup(back, front);
		this.front = front;
		this.back = back;
		this.encoder = encoder;
    }

    public void initDefaultCommand(){

    }

    public double returnPIDInput(){
		System.out.println("Rate: " + encoder.getRate());
        return this.encoder.getRate();
    }

    public void usePIDOutput(double input){
		System.out.println("use Output, Input:" + input);
    	this.speedControllerGroup.pidWrite(input);
    }

	public SpeedController getFront() {
		return this.front;
	}

	public SpeedController getBack() {
		return this.back;
	}

	public Encoder getEncoder() {
		return this.encoder;
	}

	public SpeedControllerGroup getSpeedControllerGroup() {
		return this.speedControllerGroup;
	}

	public void setPIDSourceType(PIDSourceType pidSourceType) {
		this.encoder.setPIDSourceType(pidSourceType);
	}

}