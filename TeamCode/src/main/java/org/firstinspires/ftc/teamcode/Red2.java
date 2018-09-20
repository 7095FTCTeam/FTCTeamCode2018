package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;


public class Red2 extends LinearOpMode{
    int color = 0;

    ColorSensor color1;

    boolean bLEDOn = true;


    public void runOpMode() throws InterruptedException {

        color1 = hardwareMap.get(ColorSensor.class, "jewel");
        color1.enableLed(true);
        int redReading = color1.red();
        int blueReading = color1.blue();
        telemetry.addData("red", redReading);
        telemetry.addData("blue", blueReading);

        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {
        }

        }
    }

