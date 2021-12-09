package frc.team5115.Subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.team5115.Robot.RobotContainer;

import static frc.team5115.Constants.*;

public class Drivetrain extends SubsystemBase{

    private VictorSPX frontLeft;
    private VictorSPX frontRight;
    private TalonSRX backLeft;
    private TalonSRX backRight;

    private double rightSpd;
    private double leftSpd;


    public Drivetrain(RobotContainer x) {
        frontLeft = new VictorSPX(FRONT_LEFT_MOTOR_ID);
        frontRight = new VictorSPX(FRONT_RIGHT_MOTOR_ID);
        backLeft = new TalonSRX(BACK_LEFT_MOTOR_ID);
        backRight = new TalonSRX(BACK_RIGHT_MOTOR_ID);
    }

    public void stop() {
        
    }

    public  void drive(double throttle, x, y, x1, y1) { 

        leftSpd = (x-y) * throttle;
        rightSpd = (x1-y1) * throttle;

        frontLeft.set(ControlMode.PercentOutput, leftSpd);
        frontRight.set(ControlMode.PercentOutput, rightSpd);
        backLeft.set(ControlMode.PercentOutput, leftSpd);
        backRight.set(ControlMode.PercentOutput, rightSpd);
    }

    public void XBoxDrive(Joystick joy) {
        double x = joy.getRawAxis(XBOX_X_AXIS_ID);
        double y = -joy.getRawAxis(XBOX_Y_AXIS_ID);
    }
    public void XBoxDrive1(Joystick joy) {
        double x1 = joy.getRawAxis(XBOX_X_AXIS_ID);
        double y1 = -joy.getRawAxis(XBOX_Y_AXIS_ID);

    }

}


