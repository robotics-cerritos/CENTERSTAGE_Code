package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.CRServo;

@Autonomous(name = "DistancePerRotationEncoderTest")

public class DistancePerRotationEncoderTest extends LinearOpMode {

    private DcMotor leftF;
    private DcMotor leftR;
    private DcMotor rightF;
    private DcMotor rightR;
    private DcMotor rSlide;
    private int leftFVal;
    private int leftRVal;
    private int rightFVal;
    private int rightRVal;


    @Override
    public void runOpMode() { //void opmode bracket
        
    leftF = hardwareMap.get(DcMotor.class, "leftF"); 
    leftR = hardwareMap.get(DcMotor.class, "leftR");
    rightF = hardwareMap.get(DcMotor.class, "rightF");
    rightR = hardwareMap.get(DcMotor.class, "rightR");
    leftF.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    leftR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    rightF.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    rightR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

    leftFVal = 0;
    leftRVal = 0;
    rightFVal = 0;
    rightRVal = 0;
    
    telemetry.addData("Status", "Initialized");
    telemetry.update();
        
    waitForStart();

    /* goBILDA 5203-series Yellow Jacket 312 RPM motors have a total of 537.7
    ticks per rotation. This value varies from motor to motor, so you have to
    refer to the motor's website for more information. Also, use integer values,
    so round how you see fit. For example, a full rotation from a 312 RPM motor
    would be around 538 ticks. */

    drive(100, 100, 100, 100, 0.1);
    sleep(500);
    drive(-100, -100, -100, -100, 0.1);
    sleep(500);


    }
    
    private void drive(int leftFPos, int leftRPos, int rightFPos, int rightRPos, double speed) {
        
        leftFVal += leftFPos;
        leftRVal += leftRPos;
        rightFVal += rightFPos;
        rightRVal += rightRPos;
        
        leftF.setTargetPosition(leftFVal);
        leftR.setTargetPosition(leftRVal);
        rightF.setTargetPosition(rightFVal);
        rightR.setTargetPosition(rightRVal);
        
        leftF.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightF.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightR.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        leftF.setPower(speed);
        leftR.setPower(speed);
        rightF.setPower(speed);
        rightR.setPower(speed);
        
        while(opModeIsActive() && leftF.isBusy() && leftR.isBusy() && rightF.isBusy() && rightR.isBusy()) {
            
            idle();
            
        }
        
    }
    
    
}
