package pedroPathing.subsystems;

import com.qualcomm.robotcore.hardware.Servo;
import com.rowanmcalpin.nextftc.core.Subsystem;
import com.rowanmcalpin.nextftc.core.command.Command;
import com.rowanmcalpin.nextftc.ftc.OpModeData;
import com.rowanmcalpin.nextftc.ftc.hardware.MultipleServosToSeperatePositions;

import java.util.HashMap;

public class Sample extends Subsystem {
    public static final Sample INSTANCE = new Sample();
    private Sample() { }

    //    public DcMotorEx slides1;
    //    public DcMotorEx slides2;


    //    public static HashMap<Servo, Double> generateServosAndPositionsMap(Servo k0, Double v0, Servo k1, Double v1) {
    //        HashMap<Servo,Double> map = new HashMap<Servo, Double>();
    //        map.put(k0, v0);
    //        map.put(k1, v1);
    //        return map;
    //    }

    public static HashMap<Servo, Double> generateServosAndPositionsMap(Object... pairs) {
        HashMap<Servo, Double> map = new HashMap<>();

        for (int i = 0; i < pairs.length; i += 2) {

            Servo key = (Servo) pairs[i];
            Double value = (Double) pairs[i + 1];
            map.put(key, value);
        }

        return map;
    }


    //    public PIDFController pidf = new PIDFController(0.01,0.00008 , 0.00008, 0);
    //    public PController p = new PController(0.015);
    ////    public static double kP = 0.01;
    //    public static double kI = 0.00008;
    //    public static double kD = 0.00008;
    //    public static double kF = 0;

    public Servo left_shoulder;
    public Servo right_shoulder;
    public Servo elbow;
    public Servo wrist;
    public Servo finger;

    //    public String name = "claw_servo";


    public Command intakeblock() {
        return new MultipleServosToSeperatePositions(generateServosAndPositionsMap(left_shoulder,0.31,right_shoulder,0.31,elbow,0,wrist,0.5), this);
    }

    public Command autoIntake() {
        return new MultipleServosToSeperatePositions(generateServosAndPositionsMap(left_shoulder,0.347,right_shoulder,0.347,elbow,0,wrist,0.5), this);
    }

    public Command basketDeposit() {
        return new MultipleServosToSeperatePositions(generateServosAndPositionsMap(left_shoulder,0.135,right_shoulder,0.135), this);
    }

    public Command basketDepositTee() {
        return new MultipleServosToSeperatePositions(generateServosAndPositionsMap(left_shoulder, 0.1, right_shoulder, 0.1, elbow, 0.35), this);
    }

    public Command basketDepositTefdafe() {
        return new MultipleServosToSeperatePositions(generateServosAndPositionsMap(left_shoulder,0.1,right_shoulder,0.1,elbow,0.28), this);
    }

    public Command basketDepositTefdafeLOL() {
        return new MultipleServosToSeperatePositions(generateServosAndPositionsMap(left_shoulder,0.25,right_shoulder,0.25,elbow,0.1), this);
    }

    public Command RightBefore() {
        return new MultipleServosToSeperatePositions(generateServosAndPositionsMap(left_shoulder,0.31,right_shoulder,0.31,elbow,0,wrist,0.5), this);
    }
    public Command AutoPark() {
        return new MultipleServosToSeperatePositions(generateServosAndPositionsMap(left_shoulder,0.1,right_shoulder,0.1), this);
    }

    public Command wristMiddle() {
        return new MultipleServosToSeperatePositions(generateServosAndPositionsMap(wrist,0.495), this);
    }




    @Override
    public void initialize() {
        left_shoulder = OpModeData.hardwareMap.servo.get("leftshoulder");
        right_shoulder = OpModeData.hardwareMap.servo.get("rightshoulder");
        elbow = OpModeData.hardwareMap.servo.get("elbow");
        elbow.setDirection(Servo.Direction.REVERSE);
        elbow.scaleRange(0,1);
        wrist = OpModeData.hardwareMap.servo.get("wrist");
        wrist.setDirection(Servo.Direction.REVERSE);
        finger = OpModeData.hardwareMap.servo.get("claw");
    }
}
