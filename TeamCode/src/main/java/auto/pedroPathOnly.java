package auto;

import com.pedropathing.follower.Follower;
import com.pedropathing.localization.Pose;
import com.pedropathing.pathgen.BezierCurve;
import com.pedropathing.pathgen.BezierLine;
import com.pedropathing.pathgen.Path;
import com.pedropathing.pathgen.PathChain;
import com.pedropathing.pathgen.Point;
import com.pedropathing.util.Constants;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.rowanmcalpin.nextftc.core.command.Command;
import com.rowanmcalpin.nextftc.core.command.groups.ParallelGroup;
import com.rowanmcalpin.nextftc.core.command.groups.SequentialGroup;
import com.rowanmcalpin.nextftc.core.command.utility.InstantCommand;
import com.rowanmcalpin.nextftc.core.command.utility.delays.Delay;
import com.rowanmcalpin.nextftc.ftc.OpModeData;
import com.rowanmcalpin.nextftc.pedro.FollowPath;
import com.rowanmcalpin.nextftc.pedro.PedroOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import pedroPathing.constants.FConstants;
import pedroPathing.constants.LConstants;
import pedroPathing.subsystems.Sample;
import pedroPathing.subsystems.Slides;
import pedroPathing.subsystems.Specimen;
import pedroPathing.subsystems.claw;
import pedroPathing.subsystems.turret;

@Autonomous(name = "BlueSamplePathOnly")
public class pedroPathOnly extends PedroOpMode {
    public pedroPathOnly() {
        super(claw.INSTANCE, Slides.INSTANCE, Specimen.INSTANCE, turret.INSTANCE, Sample.INSTANCE);
    }

    /**
     * This is the variable where we store the state of our auto.
     * It is used by the pathUpdate method.
     */
//    private int pathState;
    private final Pose startPose = new Pose(8, 112, Math.toRadians(0));
    private Path startToCornerBasket,cornerToPickUp1,pickUp1ToCorner,cornerToPickUp2,pickUp2toCorner,cornerToPickUp3, pickUp3ToCorner,line8,line9,line10,line11,line12,line13,line14;
    private PathChain preload,pushSpec;


    public Command scorePreloadRoutine() {
        return new SequentialGroup(
                new ParallelGroup(
//                        Specimen.INSTANCE.autoSpecimen(),
//                        Slides.INSTANCE.autoSpecimenLift(),
                        new FollowPath(preload, true)
                )
//                        new Delay(2)
//                new Delay(0.05),

        );
    }

    public Command pushSpecGrabPickup1() {
        return new SequentialGroup(
//                claw.INSTANCE.openClaw(),
//                new ParallelGroup(
//                        new SequentialGroup(
////                                Specimen.INSTANCE.resetHorizontal(),
////                                new Delay(0.5),
////                                Specimen.INSTANCE.resetArmAuto(),
////                                new Delay(0.1),
//////                                Slides.INSTANCE.resetVert(),
//////                                new Delay(0.85),
//////                                turret.INSTANCE.spinTurret()
////                                new ParallelGroup(
////                                        Slides.INSTANCE.resetVert(),
////                                        turret.INSTANCE.spinTurret()
//                                )
//                        ),
                new SequentialGroup(
//                                new FollowPath(line2),
                        new FollowPath(pushSpec,true),
                        new ParallelGroup(
//                                        Specimen.INSTANCE.IntakeWallSpecimen(),
//                                        claw.INSTANCE.openClaw(),
                                new FollowPath(pickUp3ToCorner)
                        )
                )
//
//                ),
//                claw.INSTANCE.closeClaw(),
//                Specimen.INSTANCE.resetArm()
        );
    }

    public Command scorePickup1() {
        return new SequentialGroup(
//                new ParallelGroup(
//                        new SequentialGroup(
//                                claw.INSTANCE.closeClaw(),
//                                new Delay(0.03),
//                                Specimen.INSTANCE.resetArm(),
//                                new Delay(0.5),
//                                turret.INSTANCE.resetTurret(),
//                                new ParallelGroup(
//                                        Specimen.INSTANCE.autoSpecimen(),
//                                        Slides.INSTANCE.autoSpecimenLift()
//                                )
//                        ),
                new FollowPath(line8,true,1.0)
//                )
        );
    }

    public Command grabPickup2() {
        return new SequentialGroup(
//                claw.INSTANCE.openClaw(),
                new ParallelGroup(
                        new SequentialGroup(
//                                Specimen.INSTANCE.resetArmAuto(),
//                                new Delay(0.1),
//                                Slides.INSTANCE.resetVert(),
//                                new Delay(0.85),
//                                turret.INSTANCE.spinTurret()
//                                new ParallelGroup(
//                                        Slides.INSTANCE.resetVert(),
//                                        turret.INSTANCE.spinTurret()
//                                ),
//                                new Delay(0.05),
//                                Specimen.INSTANCE.IntakeWallSpecimen()
                        ),
//                        new SequentialGroup(
//                                new Delay(0.5),
                        new FollowPath(line9,true,1.0)
//                        )
                )
        );
    }

    public Command scorePickup2() {
        return new SequentialGroup(
                new ParallelGroup(
//                        new SequentialGroup(
//                                claw.INSTANCE.closeClaw(),
//                                Specimen.INSTANCE.resetArm(),
//                                new Delay(0.5),
//                                turret.INSTANCE.resetTurret(),
//                                new Delay(0.25),
//                                new ParallelGroup(
//                                        Specimen.INSTANCE.autoSpecimen(),
//                                        Slides.INSTANCE.autoSpecimenLift()
//                                )
//                        ),
                        new FollowPath(line10,true,1.0)
                )
        );
    }

    public Command grabPickup3() {
        return new SequentialGroup(
//                claw.INSTANCE.openClaw(),
                new ParallelGroup(
//                        new SequentialGroup(
//                                Specimen.INSTANCE.resetArmAuto(),
//                                new Delay(0.1),
//                                new ParallelGroup(
//                                        Slides.INSTANCE.resetVert(),
//                                        turret.INSTANCE.spinTurret()
//                                ),
////                                new Delay(0.05),
//                                Specimen.INSTANCE.IntakeWallSpecimen()
//                        ),
//                        new SequentialGroup(
//                                new Delay(0.5),
                        new FollowPath(line11,true,1.0)
//                        )
                )
        );
    }

    public Command scorePickup3() {
        return new SequentialGroup(
                new ParallelGroup(
//                        new SequentialGroup(
//                                claw.INSTANCE.closeClaw(),
//                                Specimen.INSTANCE.resetArm(),
//                                new Delay(0.5),
//                                turret.INSTANCE.resetTurret(),
//                                new Delay(0.25),
////                                new ParallelGroup(
////                                        Specimen.INSTANCE.autoSpecimen(),
////                                        Slides.INSTANCE.autoSpecimenLift()
////                                )
//                        ),
                        new FollowPath(line12,true,1.0)
                )
        );
    }

    public Command grabPickup4() {
        return new SequentialGroup(
//                claw.INSTANCE.openClaw(),
                new ParallelGroup(
//                        new SequentialGroup(
//                                Specimen.INSTANCE.resetArmAuto(),
//                                new Delay(0.1),
//                                new ParallelGroup(
//                                        Slides.INSTANCE.resetVert(),
//                                        turret.INSTANCE.spinTurret()
//                                ),
////                                new Delay(0.05),
//                                Specimen.INSTANCE.IntakeWallSpecimen()
//                        ),
                        new SequentialGroup(
//                                new Delay(0.5),
                                new FollowPath(line13,true,1.0)
                        )
                )
        );
    }

    public Command scorePickup4() {
        return new SequentialGroup(
//                new ParallelGroup(
//                        new SequentialGroup(
//                                claw.INSTANCE.closeClaw(),
//                                Specimen.INSTANCE.resetArm(),
//                                new Delay(0.5),
//                                turret.INSTANCE.resetTurret(),
//                                new Delay(0.25),
//                                new ParallelGroup(
//                                        Specimen.INSTANCE.autoSpecimen(),
//                                        Slides.INSTANCE.autoSpecimenLift()
//                                )
//                        ),
                new FollowPath(line14,true,1.0)
//                ),
//                claw.INSTANCE.openClaw()
        );
    }


    public void GeneratedPaths() {
//        public static PathBuilder builder = new PathBuilder();
        startToCornerBasket = new Path(
                new BezierLine(
                        new Point(8.000, 104.000, Point.CARTESIAN),
                        new Point(16.110, 128.290, Point.CARTESIAN)
                )
        );
        startToCornerBasket.setLinearHeadingInterpolation(Math.toRadians(0), Math.toRadians(0));

        cornerToPickUp1 = new Path(
                new BezierLine(
                        new Point(8.000, 104.000, Point.CARTESIAN),
                        new Point(16.110, 128.290, Point.CARTESIAN)
                )
        );
        cornerToPickUp1.setConstantHeadingInterpolation(Math.toRadians(0));

        pickUp1ToCorner = new Path(
                new BezierCurve(
                        new Point(33.000, 120.800, Point.CARTESIAN),
                        new Point(24.480, 119.931, Point.CARTESIAN),
                        new Point(15.000, 127.000, Point.CARTESIAN)
                )
        );
        pickUp1ToCorner.setConstantHeadingInterpolation(Math.toRadians(0));


        cornerToPickUp2 = new Path(
                new BezierCurve(
                        new Point(15.000, 130.000, Point.CARTESIAN),
                        new Point(25.920, 130.834, Point.CARTESIAN),
                        new Point(34.500, 129.800, Point.CARTESIAN)
                )
        );
        cornerToPickUp2.setConstantHeadingInterpolation(Math.toRadians(0));

        pickUp2toCorner = new Path(
                new BezierCurve(
                        new Point(34.500, 129.800, Point.CARTESIAN),
                        new Point(25.920, 130.834, Point.CARTESIAN),
                        new Point(15.000, 129.000, Point.CARTESIAN)
                )
        );
        pickUp2toCorner.setConstantHeadingInterpolation(Math.toRadians(0));

        cornerToPickUp3 = new Path(
                new BezierCurve(
                        new Point(17.110, 127.290, Point.CARTESIAN),
                        new Point(27.360, 136.800, Point.CARTESIAN),
                        new Point(35.000, 136.000, Point.CARTESIAN)
                )
        );
        cornerToPickUp3.setConstantHeadingInterpolation(Math.toRadians(0));

        pickUp3ToCorner = new Path(
                new BezierCurve(
                        new Point(35.000, 136.000, Point.CARTESIAN),
                        new Point(31.269, 130.217, Point.CARTESIAN),
                        new Point(16.700, 129.500, Point.CARTESIAN)
                )
        );
        pickUp3ToCorner.setConstantHeadingInterpolation(Math.toRadians(0));

        line8 = new Path(
                new BezierCurve(
                        new Point(16.700, 129.500, Point.CARTESIAN),
                        new Point(58.629, 126.926, Point.CARTESIAN),
                        new Point(59.000, 96.000, Point.CARTESIAN)
                )
        );
        line8.setLinearHeadingInterpolation(Math.toRadians(0), Math.toRadians(-90));

        line9 = new Path(
                new BezierCurve(
                        new Point(59.000, 96.000, Point.CARTESIAN),
                        new Point(58.629, 115.086, Point.CARTESIAN),
                        new Point(14.000, 127.000, Point.CARTESIAN)
                )
        );
        line9.setTangentHeadingInterpolation();
        line9.setReversed(true);


        line10 = new Path(
                new BezierCurve(
                        new Point(14.000, 127.000, Point.CARTESIAN),
                        new Point(58.629, 114.994, Point.CARTESIAN),
                        new Point(59.000, 96.000, Point.CARTESIAN)
                )
        );
        line10.setTangentHeadingInterpolation();


        line11 = new Path(
                new BezierCurve(
                        new Point(59.000, 96.000, Point.CARTESIAN),
                        new Point(58.629, 114.994, Point.CARTESIAN),
                        new Point(14.000, 128.500, Point.CARTESIAN)
                )
        );
        line11.setTangentHeadingInterpolation();
        line11.setReversed(true);

        line12 = new Path(
                new BezierCurve(
                        new Point(14.000, 128.500, Point.CARTESIAN),
                        new Point(58.629, 114.994, Point.CARTESIAN),
                        new Point(59.000, 96.000, Point.CARTESIAN)
                )
        );
        line12.setTangentHeadingInterpolation();


        line13 = new Path(
                new BezierCurve(
                        new Point(59.000, 96.000, Point.CARTESIAN),
                        new Point(58.629, 114.994, Point.CARTESIAN),
                        new Point(14.000, 130.000, Point.CARTESIAN)
                )
        );
        line13.setTangentHeadingInterpolation();
        line13.setReversed(true);


        line14 = new Path(
                new BezierCurve(
                        new Point(14.000, 130.000, Point.CARTESIAN),
                        new Point(58.629, 114.994, Point.CARTESIAN),
                        new Point(59.000, 96.000, Point.CARTESIAN)
                )
        );
        line14.setTangentHeadingInterpolation();
    }


//    public void unGeneratedPaths() {
//        line1 = new Path(
//                new BezierCurve(
//                        new Point(8.229, 56.160, Point.CARTESIAN),
//                        new Point(17.897, 73.234, Point.CARTESIAN),
//                        new Point(39.497, 71.794, Point.CARTESIAN)
//                )
//        );
//        line1.setConstantHeadingInterpolation(Math.toRadians(0));
//
//        line2 = new Path(
//                new BezierCurve(
//                        new Point(39.497, 71.794, Point.CARTESIAN),
//                        new Point(0.411, 27.360, Point.CARTESIAN),
//                        new Point(36.617, 36.411, Point.CARTESIAN),
//                        new Point(51.223, 34.560, Point.CARTESIAN)
//                )
//        );
//        line2.setConstantHeadingInterpolation(Math.toRadians(0));
//
//        line3 = new Path(
//                new BezierCurve(
//                        new Point(51.223, 34.560, Point.CARTESIAN),
//                        new Point(57.600, 36.206, Point.CARTESIAN),
//                        new Point(78.171, 20.777, Point.CARTESIAN),
//                        new Point(24.137, 26.537, Point.CARTESIAN)
//                )
//        );
//
//        line3.setConstantHeadingInterpolation(Math.toRadians(0));
//
//        line4 = new Path(
//                new BezierCurve(
//                        new Point(24.137, 26.537, Point.CARTESIAN),
//                        new Point(58.629, 27.360, Point.CARTESIAN),
//                        new Point(59.863, 19.337, Point.CARTESIAN)
//                )
//        );
//        line4.setConstantHeadingInterpolation(Math.toRadians(0));
//
//        line5 = new Path(
//                new BezierCurve(
////                new Point(59.863, 19.337, Point.CARTESIAN),
////                new Point(58.011, 12.754, Point.CARTESIAN),
////                new Point(24.549, 17.606, Point.CARTESIAN)
//                        new Point(59.863, 19.337, Point.CARTESIAN),
//                        new Point(58.011, 16.251, Point.CARTESIAN),
//                        new Point(22.309, 18.103, Point.CARTESIAN)
//                )
//        );
//        line5.setConstantHeadingInterpolation(Math.toRadians(0));
//
//        line6 = new Path(
//                new BezierCurve(
////                        new Point(24.549, 17.606, Point.CARTESIAN),
////                        new Point(53.280, 14.811, Point.CARTESIAN),
////                        new Point(58.217, 14.786, Point.CARTESIAN)
//                        new Point(22.309, 18.103, Point.CARTESIAN),
//                        new Point(53.280, 14.811, Point.CARTESIAN),
//                        new Point(58.217, 18.103, Point.CARTESIAN)
//                )
//        );
//        line6.setConstantHeadingInterpolation(Math.toRadians(0));
//
//        line7 = new Path(
//                new BezierCurve(
////                        new Point(58.217, 14.786, Point.CARTESIAN),
////                        new Point(57.394285714285715, 9.668571428571433, Point.CARTESIAN),
////                        new Point(24.343, 14.786, Point.CARTESIAN)
//                        new Point(58.217, 14.286, Point.CARTESIAN),
//                        new Point(57.600, 7.817, Point.CARTESIAN),
//                        new Point(16.514, 12.434, Point.CARTESIAN)
//                )
//        );
//        line7.setConstantHeadingInterpolation(Math.toRadians(0));
//
//
//
//        linep = new Path(
//                new BezierCurve(
//                        new Point(24.514, 17.609, Point.CARTESIAN),
//                        new Point(119.348, 10.761, Point.CARTESIAN),
//                        new Point(16.043, 11.152, Point.CARTESIAN)
//                )
//        );
//
//        linep.setConstantHeadingInterpolation(Math.toRadians(0));
//
//        line8 = new Path(
//                new BezierCurve(
//                        new Point(16.515, 12.434, Point.CARTESIAN),
//                        new Point(17.897, 73.234, Point.CARTESIAN),
//                        new Point(39.497, 71.794, Point.CARTESIAN)
//                )
//        );
//        line8.setConstantHeadingInterpolation(Math.toRadians(0));
//
//        line9 = new Path(
//                new BezierCurve(
//                        new Point(39.497, 71.794, Point.CARTESIAN),
//                        new Point(15.429, 68.297, Point.CARTESIAN),
//                        new Point(47.726, 30.034, Point.CARTESIAN),
//                        new Point(18.103, 34.971, Point.CARTESIAN)
//                )
//        );
//        line9.setConstantHeadingInterpolation(Math.toRadians(0));
//
//        line10 = new Path(
//                new BezierCurve(
//                        new Point(18.309, 34.971, Point.CARTESIAN),
//                        new Point(23.451, 71.383, Point.CARTESIAN),
//                        new Point(39.497, 67.000, Point.CARTESIAN)
//                )
//        );
//        line10.setConstantHeadingInterpolation(Math.toRadians(0));
//
//        line11 = new Path(
//                new BezierCurve(
//                        new Point(39.497, 67.000, Point.CARTESIAN),
//                        new Point(15.429, 68.297, Point.CARTESIAN),
//                        new Point(47.726, 30.034, Point.CARTESIAN),
//                        new Point(18.103, 34.971, Point.CARTESIAN)
//                )
//        );
//
//        line11.setConstantHeadingInterpolation(Math.toRadians(0));
//
//        line12 = new Path(
//                new BezierCurve(
//                        new Point(18.309, 23.657, Point.CARTESIAN),
//                        new Point(23.451, 71.383, Point.CARTESIAN),
//                        new Point(39.497, 67.000, Point.CARTESIAN)
//                )
//        );
//
//        line12.setConstantHeadingInterpolation(Math.toRadians(0));
//
//        line13 = new Path(
//                new BezierCurve(
//                        new Point(39.497, 67.000, Point.CARTESIAN),
//                        new Point(15.429, 68.297, Point.CARTESIAN),
//                        new Point(47.726, 30.034, Point.CARTESIAN),
//                        new Point(18.103, 34.971, Point.CARTESIAN)
//                )
//        );
//
//        line13.setConstantHeadingInterpolation(Math.toRadians(0));
//
//        line14 = new Path(
//                new BezierCurve(
//                        new Point(18.309, 23.657, Point.CARTESIAN),
//                        new Point(23.451, 71.383, Point.CARTESIAN),
//                        new Point(39.497, 67.000, Point.CARTESIAN)
//                )
//        );
//
//        line14.setConstantHeadingInterpolation(Math.toRadians(0));
//
//        preload = follower.pathBuilder()
//                .addPath(line1)
//                .build();
//
//        pushSpec = follower.pathBuilder()
//                .addPath(line2)
//                .addPath(line3)
//                .addPath(line4)
//                .addPath(line5)
//                .addPath(line6)
////                .addPath(line7)
////                .addPath(linep)
//                .build();
//    }

    @Override
    public void onUpdate() {
        // Feedback to Driver Hub
        telemetry.addData("x", follower.getPose().getX());
        telemetry.addData("y", follower.getPose().getY());
        telemetry.addData("heading", follower.getPose().getHeading());
        telemetry.update();
    }

    @Override
    public void onInit() {
//        follower.setupConstants(FConstants.class, LConstants.class);
        follower = new Follower(hardwareMap, FConstants.class, LConstants.class);
        follower.setStartingPose(startPose);
//        follower = new Follower(hardwareMap);
//        claw.INSTANCE.closeClaw();
//        turret.INSTANCE.resetTurret();
        OpModeData.telemetry = telemetry;
        GeneratedPaths();
    }

    @Override
    public void onStartButtonPressed() {
//        new SequentialGroup(
//                scorePreloadRoutine(),
////                pushSpecGrabPickup1(),
////                scorePickup1(),
//                grabPickup2(),
//                scorePickup2(),
//                grabPickup3(),
//                scorePickup3(),
//                grabPickup4(),
//                scorePickup4()s
//        ).invoke();
        new SequentialGroup(
                new FollowPath(startToCornerBasket,true),
                new FollowPath(cornerToPickUp1),
                new FollowPath(pickUp1ToCorner),
                new FollowPath(cornerToPickUp2),
                new FollowPath(pickUp2toCorner),
                new FollowPath(cornerToPickUp3),
                new FollowPath(pickUp3ToCorner)
        )
                .invoke();


    }



}

