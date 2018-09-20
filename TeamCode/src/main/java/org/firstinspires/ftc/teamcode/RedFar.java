package org.firstinspires.ftc.teamcode;


import android.graphics.Color;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.I2cDevice;
import com.qualcomm.robotcore.hardware.ColorSensor;

import org.firstinspires.ftc.teamcode.ModernRoboticsI2cColorSensor2.ModernRoboticsI2cColorSensor2;


@Autonomous (name = "RedFar", group = "Autonomous")
public class RedFar extends LinearOpMode {
    // Motors Used //
    DcMotor leftDrive1;
    DcMotor leftDrive2;
    DcMotor rightDrive1;
    DcMotor rightDrive2;
    DcMotor armDrive;
    Servo jewel;
    Servo claw = null;
    ColorSensor color1;

    protected void InitializeMotors() throws InterruptedException {
        leftDrive1 = hardwareMap.dcMotor.get("leftDrive1");
        rightDrive1 = hardwareMap.dcMotor.get("rightDrive1");
        leftDrive2 = hardwareMap.dcMotor.get("leftDrive2");
        rightDrive2 = hardwareMap.dcMotor.get("rightDrive2");
        armDrive = hardwareMap.dcMotor.get("armDrive");


        rightDrive1.setDirection(DcMotor.Direction.REVERSE);
        rightDrive2.setDirection(DcMotor.Direction.REVERSE);
        color1 = hardwareMap.get(ColorSensor.class, "colorSensor");
        color1.enableLed(true);
        int redReading = color1.red();
        int blueReading = color1.blue();
        telemetry.addData("red", redReading);
        telemetry.addData("blue", blueReading);
    }

    public void runOpMode()throws InterruptedException {


        waitForStart();

        leftDrive1.setPower(0);
        leftDrive2.setPower(0);

        rightDrive2.setPower(0);
        rightDrive1.setPower(0);

        armDrive.setPower(0);

        ElapsedTime eTime = new ElapsedTime();

        eTime.reset();

        while(eTime.time() <= 1.1) {

            leftDrive1.setPower(-1);
            leftDrive2.setPower(-1);
            rightDrive1.setPower(-1);
            rightDrive2.setPower(-1);
        }

        leftDrive1.setPower(0);
        leftDrive2.setPower(0);
        rightDrive1.setPower(0);
        rightDrive2.setPower(0);
    }


}
