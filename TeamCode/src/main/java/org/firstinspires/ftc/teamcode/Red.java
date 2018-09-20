package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.I2cDevice;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.I2cAddr;
import com.qualcomm.robotcore.hardware.I2cDeviceSynch;
import com.qualcomm.robotcore.hardware.I2cDeviceSynchImpl;
import com.qualcomm.robotcore.hardware.ServoController;

import org.firstinspires.ftc.teamcode.ExampleNewI2cColorOpMode;
@Autonomous (name = "AutoRed",group = "Auto")
public class Red extends LinearOpMode{
    int color = 0;

    ColorSensor color1;

    boolean bLEDOn = true;

    private DcMotor leftDrive1;
    private DcMotor leftDrive2;
    private DcMotor rightDrive1;
    private DcMotor rightDrive2;
    private DcMotor armDrive;

    private Servo jewel;

    Servo claw = null;


    public void runOpMode() throws InterruptedException {

        leftDrive1 = hardwareMap.dcMotor.get("leftDrive1");
        rightDrive1 = hardwareMap.dcMotor.get("rightDrive1");
        leftDrive2 = hardwareMap.dcMotor.get("leftDrive2");
        rightDrive2 = hardwareMap.dcMotor.get("rightDrive2");
        armDrive = hardwareMap.dcMotor.get("armDrive");
        claw = hardwareMap.servo.get("clawServo");
        jewel = hardwareMap.servo.get("jewelArm");

        color1 = hardwareMap.get(ColorSensor.class, "colorSensor");
        color1.enableLed(true);
        rightDrive1.setDirection(DcMotor.Direction.REVERSE);
        rightDrive2.setDirection(DcMotor.Direction.REVERSE);
        int redReading = color1.red();
        int blueReading = color1.blue();
        telemetry.addData("red", redReading);
        telemetry.addData("blue", blueReading);

        telemetry.update();

        waitForStart();

        leftDrive1.setPower(0);
        leftDrive2.setPower(0);

        rightDrive2.setPower(0);
        rightDrive1.setPower(0);

        armDrive.setPower(0);
        while(getRuntime() >= 2) {

            jewel.setPosition(1);
            telemetry.update();
        }
        ElapsedTime eTime = new ElapsedTime();

        eTime.reset();

        while(eTime.time() <= 1) {

            jewel.setPosition(1);
            telemetry.update();
        }
        if (blueReading > redReading) {
            while (eTime.time() <= 1.2) {
                leftDrive1.setPower(-1);
                leftDrive2.setPower(-1);
                rightDrive1.setPower(-1);
                rightDrive2.setPower(-1);
            }
            if (eTime.time() >= 1.2) {
                rightDrive1.setPower(1);
                rightDrive2.setPower(1);
            }
        }
        while (eTime.time() <= 1.5) {
            rightDrive2.setPower(0);
            rightDrive1.setPower(0);
        }
        if (eTime.time() <= 1.7) {
            leftDrive1.setPower(1);
            leftDrive2.setPower(1);
            rightDrive1.setPower(1);
            rightDrive2.setPower(1);
        } else if (redReading > blueReading) {
            while(eTime.time() <= 2.7)
                leftDrive2.setPower(1);
            leftDrive1.setPower(1);
            rightDrive1.setPower(1);
            rightDrive2.setPower(1);
        }
    }
}
