package org.firstinspires.ftc.teamcode;

/**
 * Created by robo on 11/15/2017.
 */
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

public class AutoStopOnLine extends AUTOAbstract {

    @Override

    public void runOpMode() throws InterruptedException{

        startAutoOp();
        moveTillWhite(.5);


    }
}
