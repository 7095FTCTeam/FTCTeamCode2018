package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by robo on 9/6/2018.
 */
@TeleOp(name = "TeleOp/group", group = "Pushbot")
public class Group extends OpMode {

    DcMotor leftDrive;
    DcMotor rightDrive;

    public void init() {
        leftDrive = hardwareMap.dcMotor.get("leftDrive");
        rightDrive = hardwareMap.dcMotor.get("rightDrive");

        rightDrive.setDirection(DcMotor.Direction.REVERSE);

    }

    public void loop() {
        float left = gamepad1.left_stick_y;
        float right = gamepad1.right_stick_y;

        leftDrive.setPower(.5 * left);
        rightDrive.setPower(.5 * right);
    }

    public void stop() {
    }
}
