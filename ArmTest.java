package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;


//import org.firstinspires.ftc.robotcore.external.camera.Webcam1;

@TeleOp

 public class ArmTest extends LinearOpMode { // public class bracket
    
    //assigning electronics to the robot
    private DcMotor leftF;
    private DcMotor leftR;
    private DcMotor rightF;
    private DcMotor rightR;
    private Servo launcherS;
    private DcMotor leftArmMotor;
    private DcMotor rightArmMotor;
    private Servo clawRotate;
    private Servo clawGrab;

    @Override
    public void runOpMode() {//public void bracket
        
        //hardware mapping each electronic
        leftF = hardwareMap.get(DcMotor.class, "leftF"); 
    leftR = hardwareMap.get(DcMotor.class, "leftR");
    rightF = hardwareMap.get(DcMotor.class, "rightF");
    rightR = hardwareMap.get(DcMotor.class, "rightR");
        
        
        //arm bar motors
        leftArmMotor = hardwareMap.get(DcMotor.class, "leftArmMotor");
        rightArmMotor = hardwareMap.get(DcMotor.class, "rightArmMotor");
        
        leftArmMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightArmMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        //servos
        clawGrab = hardwareMap.get(Servo.class, "clawGrab");
        clawRotate = hardwareMap.get(Servo.class, "clawRotate");
                launcherS = hardwareMap.get(Servo.class, "launcherS");

        
        
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        
        clawRotate.setPosition(0);

        
        //wait for the game to start (when driver presses PLAY)
        waitForStart();
        

        while (opModeIsActive()) { // opmode bracket
        
        telemetry.addData("Status", "Running");
        telemetry.update();
       
       
        double rx = gamepad1.left_stick_y;
        double x = gamepad1.left_stick_x;
        double y = -gamepad1.right_stick_x;
        
        //math involved to run each motor based off joystick position
        double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
        double leftFPower = (y+x+rx) / denominator;
        double leftRPower = (y-x+rx) / denominator;
        double rightFPower = (y-x-rx) / denominator;
        double rightRPower = (y+x-rx) / denominator;
        
        //set the motors to run on the power based off the math
        leftF.setPower(leftFPower);
        leftR.setPower(leftRPower);
        rightF.setPower(rightFPower);
        rightR.setPower(rightRPower);
       
       
       if(gamepad1.dpad_up) {
            
            launcherS.setPosition(0.6);
            sleep(500);
            launcherS.setPosition(1);
            
        }
       
       
       if(gamepad1.y) {
            leftArmMotor.setPower(-0.7);
            rightArmMotor.setPower(0.7);
        }
        
        else {
            
            leftArmMotor.setPower(0);
            rightArmMotor.setPower(0);
            leftArmMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightArmMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

            
        }
        
        if(gamepad1.a){
            leftArmMotor.setPower(0.7);
            rightArmMotor.setPower(-0.7);
            
        }
        
        else {
            
            leftArmMotor.setPower(0);
            rightArmMotor.setPower(0);
            leftArmMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightArmMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

            
        }
      
              if(gamepad1.dpad_right) {
            
            clawGrab.setPosition(0.78);
            
        }
        
        //use this function to zero the servo
        if(gamepad1.dpad_left) {
            
            clawGrab.setPosition(1);
            
        }
      
      if (gamepad1.right_bumper) {
          
          clawRotate.setPosition(0.9);
          
      }
      
      if (gamepad1.left_bumper) {
          
          clawRotate.setPosition(0);
          
      }
      
      double clawArm;
      clawArm = gamepad1.right_trigger;
      clawRotate.setPosition(clawArm/1.2);
        }
        
    } //public void bracket
    
     public void turn(int armPos, double speed) {
                
     
        rightArmMotor.setTargetPosition(armPos);
        leftArmMotor.setTargetPosition(armPos);
        
        rightArmMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftArmMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        
        rightArmMotor.setPower(speed);
        leftArmMotor.setPower(speed);

        }
        
    
} //public class bracket
