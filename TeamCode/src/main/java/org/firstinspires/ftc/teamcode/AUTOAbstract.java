package org.firstinspires.ftc.teamcode;

/**
 * Created by robo on 11/15/2017.
 */
import android.graphics.Color;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.I2cAddr;
import com.qualcomm.robotcore.hardware.I2cDevice;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.ModernRoboticsI2cColorSensor2.ModernRoboticsI2cColorSensor2;

public abstract class AUTOAbstract extends LinearOpMode {
    ColorSensor colorSensor;
    DcMotor leftDrive1;
    DcMotor rightDrive1;
    DcMotor leftDrive2;
    DcMotor rightDrive2;
    DcMotor armDrive;
    Servo jewel;
    Servo claw = null;

    public final int ONE_WHEEL_ROTATION = 1;

    protected void InitializeMotors() throws InterruptedException {
        leftDrive1 = hardwareMap.dcMotor.get("leftDrive1");
        rightDrive1 = hardwareMap.dcMotor.get("rightDrive1");
        leftDrive2 = hardwareMap.dcMotor.get("leftDrive2");
        rightDrive2 = hardwareMap.dcMotor.get("rightDrive2");
        armDrive = hardwareMap.dcMotor.get("armDrive");
        jewel = hardwareMap.servo.get("jewelArm");
        claw = hardwareMap.servo.get("clawServo");

        rightDrive1.setDirection(DcMotor.Direction.REVERSE);
        rightDrive2.setDirection(DcMotor.Direction.REVERSE);
    }

    protected void InitializeColorSensors() throws InterruptedException{
        colorSensor = hardwareMap.get(ColorSensor.class, "colorSensor");
        colorSensor.setI2cAddress(I2cAddr.create8bit(0x44));
        colorSensor.enableLed(true);

    }

    protected void moveTillWhite(double speed) throws InterruptedException{
        leftDrive1.setPower(speed);
        leftDrive2.setPower(speed);
        rightDrive1.setPower(speed);
        rightDrive2.setPower(speed);

        telemetry.addData("Red:",colorSensor.red());
        telemetry.addData("Blue:",colorSensor.blue());
        telemetry.addData("White:",colorSensor.alpha());
        telemetry.addData("Green:",colorSensor.green());
        telemetry.update();
        while (colorSensor.alpha()<1000){
            telemetry.addData("Red:",colorSensor.red());

            telemetry.addData("Blue:",colorSensor.blue());
            telemetry.addData("White:",colorSensor.alpha());
            telemetry.addData("Green:",colorSensor.green());
            telemetry.update();

        }
        leftDrive1.setPower(0);
        leftDrive2.setPower(0);
        rightDrive1.setPower(0);
        rightDrive2.setPower(0);
        telemetry.addData("Red:",colorSensor.red());
        telemetry.addData("Blue:",colorSensor.blue());
        telemetry.addData("White:",colorSensor.alpha());
        telemetry.addData("Green:",colorSensor.green());
        telemetry.update();

    }

    protected void startAutoOp() throws InterruptedException{

        InitializeColorSensors();
        InitializeMotors();
        waitForStart();

    }



}
