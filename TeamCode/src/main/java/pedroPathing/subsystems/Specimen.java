package pedroPathing.subsystems;

import com.qualcomm.robotcore.hardware.Servo;
import com.rowanmcalpin.nextftc.core.Subsystem;
import com.rowanmcalpin.nextftc.core.command.Command;
import com.rowanmcalpin.nextftc.ftc.OpModeData;
import com.rowanmcalpin.nextftc.ftc.hardware.MultipleServosToSeperatePositions;

import java.util.HashMap;

public class Specimen extends Subsystem {
    // BOILERPLATE
    public static final Specimen INSTANCE = new Specimen();
    private Specimen() { }

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
    public Servo right_spine;
    public Servo left_spine;

//    public String name = "claw_servo";


    public Command teleOpSpecimen() {
        return new MultipleServosToSeperatePositions(generateServosAndPositionsMap(left_shoulder,0.05,right_shoulder,0.05,elbow,0,wrist,0.5,finger,0.4), this);
    }

    public Command lastteleOpSpecimen() {
        return new MultipleServosToSeperatePositions(generateServosAndPositionsMap(left_shoulder,0.05,right_shoulder,0.05,elbow,0,wrist,0.5), this);
    }

    public Command IntakeWallSpecimen() {
        return new MultipleServosToSeperatePositions(generateServosAndPositionsMap(left_shoulder,0.275,right_shoulder,0.275,elbow,0.335,finger,0.32), this);
    }


    public Command IntakeWallSpecimenTele() {
        return new MultipleServosToSeperatePositions(generateServosAndPositionsMap(right_shoulder, 0.29, left_shoulder, 0.29, elbow, 0.325, finger, 0.32), this);
    }

    public Command IntakeWallSpecimenAuto() {
        return new MultipleServosToSeperatePositions(generateServosAndPositionsMap(right_shoulder, 0.29, left_shoulder, 0.29, elbow, 0.325), this);
    }

    public Command resetArm() {
        return new MultipleServosToSeperatePositions(generateServosAndPositionsMap(left_shoulder,0.015,right_shoulder,0.015,elbow,0.5,wrist,0.495,finger,0.7), this);
    }

    public Command resetArmAuto() {
        return new MultipleServosToSeperatePositions(generateServosAndPositionsMap(left_shoulder,0.01,right_shoulder,0.01,elbow,0.5,wrist,0.495), this);
    }

    public Command resetHorizontal() {
        return new MultipleServosToSeperatePositions(generateServosAndPositionsMap(left_spine,0.2,right_spine,0.2), this);
    }

    public Command autoSpecimen() {
        return new MultipleServosToSeperatePositions(generateServosAndPositionsMap(right_shoulder,0.35,left_shoulder,0.35,elbow,0.7), this);
//        setPoint = 1000;
    }


    @Override
    public void initialize() {
//        servo = OpModeData.INSTANCE.getHardwareMap().get(Servo.class, name);
        left_shoulder = OpModeData.hardwareMap.servo.get("leftshoulder");
        right_shoulder = OpModeData.hardwareMap.servo.get("rightshoulder");
        elbow = OpModeData.hardwareMap.servo.get("elbow");
        elbow.setDirection(Servo.Direction.REVERSE);
        elbow.scaleRange(0,1);
        wrist = OpModeData.hardwareMap.servo.get("wrist");
        wrist.setDirection(Servo.Direction.REVERSE);
        finger = OpModeData.hardwareMap.get(Servo.class,"claw");
        left_spine = OpModeData.hardwareMap.get(Servo.class,"leftspine");
        right_spine = OpModeData.hardwareMap.get(Servo.class,"rightspine");

        left_spine.setPosition(0.2);
        right_spine.setPosition(0.2);
        left_shoulder.setPosition(0.015);
        right_shoulder.setPosition(0.015);
        elbow.setPosition(0.5);
        wrist.setPosition(0.495);
        finger.setPosition(0.62);
//        slides1 = OpModeData.hardwareMap.get(DcMotorEx.class, "slides1");
//        slides2 = OpModeData.hardwareMap.get(DcMotorEx.class,"slides2");
//        slides2.setDirection(DcMotorSimple.Direction.REVERSE);
//        slides1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//        slides2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//        slides1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
//        slides2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }
}
