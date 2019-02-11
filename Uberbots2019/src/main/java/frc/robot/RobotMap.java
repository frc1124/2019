/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

public class RobotMap {

    // Can addresses
    // public static final int ARM = 9999999;
    public static final int LEFT_1 = 3;
    public static final int LEFT_2 = 0;
    public static final int RIGHT_1 = 2;
    public static final int RIGHT_2 = 4;
	
	// TODO: GET VAUES
    // public static final int PDP_ID = 0;
    // public static final int COMPRESSOR_ID = 99999;

    // Digital
	public static final int LEFT_DRIVE_BACK = 0;
	public static final int LEFT_DRIVE_FRONT = 1;
	public static final int RIGHT_DRIVE_BACK = 2;
	public static final int RIGHT_DRIVE_FRONT = 3;

	// public static final int ARM_LIMIT_FORWARD = 4;
	// public static final int ARM_LIMIT_REVERSE = 5;

    // Analog Inputs
	public static final int GYRO = 0;

	// Pistons & Solenoid
	
	// public static final int SUCTION_FORWARD_CHANNEL = 99999;
	// public static final int SUCTION_BACKWARD_CHANNEL = 99999;

	public static final int PUSH1_FORWARD_CHANNEL = 0;
	public static final int PUSH1_BACKWARD_CHANNEL = 1;

	public static final int PUSH2_FORWARD_CHANNEL = 2;
	public static final int PUSH2_BACKWARD_CHANNEL = 3;

	public static final int SLIDE1_FORWARD_CHANNEL = 4;
	public static final int SLIDE1_BACKWARD_CHANNEL = 5;

	public static final int SLIDE2_FORWARD_CHANNEL = 6;
	public static final int SLIDE2_BACKWARD_CHANNEL = 7;

	//PID Values
	public static final double LEFT_P = 0.1;
	public static final double LEFT_I = 0.0;
	public static final double LEFT_D = 0.0;
	public static final double LEFT_F = 0.0;
	
	public static final double RIGHT_P = 0.001;
	public static final double RIGHT_I = 0.0;
	public static final double RIGHT_D = 0.0;
	public static final double RIGHT_F = 0.0;

	public static final double ARM_P = 0.0;
	public static final double ARM_I = 0.0;
	public static final double ARM_D = 0.0;
	public static final double ARM_F = 0.0;

	public static final double ELEVATOR_P = 0.0;
	public static final double ELEVATOR_I = 0.0;
	public static final double ELEVATOR_D = 0.0;
	public static final double ELEVATOR_F = 0.0;

}
