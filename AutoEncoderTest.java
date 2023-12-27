package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.CRServo;

@Autonomous(name = "AutoEncoderTest")

public class AutoEncoderTest extends LinearOpMode {

    private DcMotor bigMotor;
    private DcMotor littleMotor;
    private int bigEncoderRotation;
    private int littleEncoderRotation;


    @Override
    public void runOpMode() { //void opmode bracket
        
    bigMotor = hardwareMap.get(DcMotor.class, "bigMotor");
    littleMotor = hardwareMap.get(DcMotor.class, "littleMotor");
    bigMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    littleMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

    bigEncoderRotation = 0;
    littleEncoderRotation = 0;
    
    telemetry.addData("Status", "Initialized");
    telemetry.update();
        
    waitForStart();

    /* goBILDA 5203-series Yellow Jacket 312 RPM motors have a total of 537.7
    ticks per rotation. This value varies from motor to motor, so you have to
    refer to the motor's website for more information. Also, use integer values,
    so round how you see fit. For example, a full rotation from a 312 RPM motor
    would be around 538 ticks. */

    drive(269, 10, 0.1);
    drive(-269, -10, 0.1);
    sleep(1000);
    drive(538, -538, 0.1);

    /* GOAL: half-rotation clockwise
	     half-rotation counter-clockwise
	     wait for 1 second
	     full-rotation clockwise
    */
		  

    }
    
    private void drive(int encoderPosition, double speed) {
        
        bigEncoderRotation += bigEncoderPosition;
        littleEncoderRotation += littleEncoderPosition;
        
        bigMotor.setTargetPosition(bigEncoderRotation);
        littleMotor.setTargetPosition(littleEncoderRotation);
        
        bigMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        littleMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        
        bigMotor.setPower(speed);
        littleMotor.setPower(speed);
        
        while(opModeIsActive() && bigMotor.isBusy()) {
            
            idle();
            
        }
        
    }
    
    
}

