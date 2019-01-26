package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.PIDSubsystem;

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
        return this.encoder.getRate();
    }

    public void usePIDOutput(double input){
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
		this.encoder(pidSourceType);
	}

}