package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name="TestBot", group = "Pushbot")
public class TestBot extends OpMode{
    DcMotor leftdrive1;
    DcMotor rightdrive1;

    public void init () {
        leftdrive1 = hardwareMap.dcMotor.get("leftdrive1");
        rightdrive1 = hardwareMap.dcMotor.get("rightdrive1");
    }

    public void loop () {
        float left = gamepad1.right_stick_y;
        float right = gamepad1.left_stick_y;

        leftdrive1.setPower(.5 * left);
        rightdrive1.setPower(.5 * right);
    }

    public void stop() {

        }

}
