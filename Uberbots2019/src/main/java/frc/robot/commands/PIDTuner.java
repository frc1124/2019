package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import frc.robot.Robot;
import frc.robot.subsystems.PIDDrive;

public class PIDTuner extends Command{

    private double setpoint;

    private final double TOLERANCE = 0.001;

    public PIDTuner(double setpoint){
        super("PIDTuner");
        requires(Robot.driveTrain);
        
        this.setpoint = setpoint;
    }

    public boolean isFinished(){
        boolean finished = Math.abs(Robot.driveTrain.getLeftGearbox().getSetpoint() - Robot.driveTrain.getLeftGearbox().getPosition()) <= TOLERANCE;

        return finished;
    }

    public void initialize() {
        Robot.driveTrain.getLeftGearbox().setSetpoint(setpoint);
    }

    public void execute(){
    }

    @Override
    public void end(){
        System.out.println("Error END");
        Robot.driveTrain.stop();
    }

    @Override
    public void interrupted(){
        Robot.driveTrain.stop();
    }

}