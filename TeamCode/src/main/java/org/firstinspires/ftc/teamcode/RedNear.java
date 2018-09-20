package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;


@Autonomous (name="RedNear", group="Autonomous")
public class RedNear extends LinearOpMode {
    // Motors Used //
    DcMotor leftDrive1;
    DcMotor leftDrive2;
    DcMotor rightDrive1;
    DcMotor rightDrive2;
    DcMotor armDrive;

    Servo claw = null;
    private Servo jewel;
    ColorSensor color1;

    public void runOpMode()throws InterruptedException {


            leftDrive1 = hardwareMap.dcMotor.get("leftDrive1");
            rightDrive1 = hardwareMap.dcMotor.get("rightDrive1");
            leftDrive2 = hardwareMap.dcMotor.get("leftDrive2");
            rightDrive2 = hardwareMap.dcMotor.get("rightDrive2");
            armDrive = hardwareMap.dcMotor.get("armDrive");
            claw = hardwareMap.servo.get("clawServo");
            jewel = hardwareMap.servo.get("jewelArm");
            color1 = hardwareMap.get(ColorSensor.class, "colorSensor");

            rightDrive1.setDirection(DcMotor.Direction.REVERSE);
            rightDrive2.setDirection(DcMotor.Direction.REVERSE);


            waitForStart();

            leftDrive1.setPower(0);
            leftDrive2.setPower(0);

            rightDrive2.setPower(0);
            rightDrive1.setPower(0);

            armDrive.setPower(0);

            ElapsedTime eTime = new ElapsedTime();

            eTime.reset();

        while(eTime.time() <= 1.175){
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