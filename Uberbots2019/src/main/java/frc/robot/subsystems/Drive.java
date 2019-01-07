package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

import frc.robot.RobotMap;
import frc.robot.commands.ArcadeDriveJoystick;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class Drive extends Subsystem{

    protected static WPI_TalonSRX leftBack, leftFront;
    protected static WPI_TalonSRX rightBack, rightFront;

    protected static SpeedControllerGroup left, right;

    protected static DifferentialDrive diffDrive;

    protected final double THROTTLE = .75;

    public Drive(){
        super("Drive");
        leftBack = new WPI_TalonSRX(RobotMap.LEFT_1); //Check device numbers
        leftFront = new WPI_TalonSRX(RobotMap.LEFT_2);
        left = new SpeedControllerGroup(leftBack, leftFront);

        rightBack = new WPI_TalonSRX(RobotMap.RIGHT_1);
        rightFront = new WPI_TalonSRX(RobotMap.RIGHT_2);
        right = new SpeedControllerGroup(rightBack, rightFront);

        diffDrive = new DifferentialDrive(left, right);
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