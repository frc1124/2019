```plantuml
@startuml
package "robot domain" #DDDDDD {

	IterativeRobot <|-- OurRobot
	OurRobot "1" *-- "1" OI
	OurRobot "1" *-- "1" RobotMap

	OurRobot .. Scheduler : uses
	OurRobot .. SmartDashboard : uses

	class OurRobot {
	}
	OurRobot : robotInit()
	OurRobot : autonomousInit()
	OurRobot : autonomousPeriodic()
	OurRobot : teleopInit()
	OurRobot : teleopPeriodic()
	OurRobot : testInit()
	OurRobot : testPeriodic()

	Command <|-- AutoCommand
	OurRobot "1" -- "1" AutoCommand

	class AutoCommand {
	}

	Command <|-- DriveCommand
	OurRobot "1" -- "1" DriveCommand

	class DriveCommand {
	}


	OurRobot "1" *-- "1" Drivetrain
	DriveCommand -- Drivetrain

	class Drivetrain {
	}

	OI "1" .. "many" Command : uses

	class OI {
		joystick1
		jobystick2
		button1
		button2
		button3
		...

	}

	class RobotMap {
		motor1
		motor2
		motor3
		...
		pneumatic1
		pneumatic2
		pneumatic3
		...
		pressureSwitch
		leftEncoder
		rightEncoder
		...
		limitSwitch
		gyro
		compressor
	}

	skinparam class {
		BackgroundColor<<WPI>> #AAAAAA
		BackgroundColor<<WPI Singleton>> #AAAAAA
	}

	Scheduler -- Command
	Command <|-- CommandGroup

	class IterativeRobot << (W,#9999FF) WPI>>
	class SmartDashboard << (W,#9999FF) WPI Singleton>>
	class Scheduler << (W,#9999FF) WPI Singleton>>
	abstract class Command << (W,#9999FF)WPI>>
	abstract class CommandGroup << (W,#9999FF)WPI>>
}
@enduml