package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.I2cDevice;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cRangeSensor;
import com.qualcomm.robotcore.hardware.Gyroscope;
import com.qualcomm.robotcore.hardware.IntegratingGyroscope;


/**
 * Created by robo on 10/2/2018.
 */
@TeleOp(name = "TeleOp", group = "Pushbot")
public class TeleOp1 extends OpMode{

    DcMotor leftDrive1;
    DcMotor rightDrive1;

    public void init(){

        leftDrive1 = hardwareMap.dcMotor.get("leftDrive1");
        rightDrive1 = hardwareMap.dcMotor.get("rightDrive1");

        rightDrive1.setDirection(DcMotor.Direction.REVERSE);

    }
    public void loop(){


        float right = gamepad1.right_stick_y;
        float left = gamepad1.left_stick_y;

        leftDrive1.setPower(.5*left);
        rightDrive1.setPower(.5*right);

    }
    public void stop(){

    }

}