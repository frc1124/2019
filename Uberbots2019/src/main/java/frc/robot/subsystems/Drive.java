package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import frc.robot.RobotMap;
import frc.robot.commands.ArcadeDriveJoystick;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class Drive extends Subsystem{

    protected DifferentialDrive diffDrive;
    protected WPI_TalonSRX 

    protected final double THROTTLE = .75;

    public Drive(){
        super("Drive");


    }

    @Override
    public void initDefaultCommand(){
        setDefaultCommand(new ArcadeDriveJoystick());
    }

    public void drive(double move, double rotate){
        diffDrive.arcadeDrive(move, rotate);
    }

    public void drive(Joystick joystick){
        this.drive(THROTTLE * -joystick.getY(), THROTTLE * -joystick.getX());
    }

    public void stop(){
        diffDrive.arcadeDrive(0, 0);
    }

}