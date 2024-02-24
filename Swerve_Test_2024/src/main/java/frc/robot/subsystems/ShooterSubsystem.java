package frc.robot.subsystems;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.NoteConstants;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;
import com.revrobotics.ColorSensorV3;

public class ShooterSubsystem extends SubsystemBase{
    static ColorSensorV3 IntakeColorSensor;
    static CANSparkMax SharedMotor;
    static CANSparkMax LShooterMotor;
    static CANSparkMax IntakeMotor;
    static CANSparkMax RShooterMotor;

    private static final Object lock = new Object();

    public ShooterSubsystem(){
        IntakeColorSensor = new ColorSensorV3(I2C.Port.kOnboard);
        IntakeMotor = new CANSparkMax(NoteConstants.IntakeMotorID, MotorType.kBrushless);
        SharedMotor = new CANSparkMax(NoteConstants.SharedMotorID, MotorType.kBrushless);
        LShooterMotor = new CANSparkMax(NoteConstants.LShooterMotorID, MotorType.kBrushless);
        RShooterMotor = new CANSparkMax(NoteConstants.RShooterMotorID, MotorType.kBrushless);
    }

    public static void getColors(){
        SmartDashboard.putNumber("Red",IntakeColorSensor.getRed());
        SmartDashboard.putNumber("Green",IntakeColorSensor.getGreen());
        SmartDashboard.putNumber("Blue",IntakeColorSensor.getBlue());
        int red = IntakeColorSensor.getRed();
        int green = IntakeColorSensor.getGreen();
        int blue = IntakeColorSensor.getBlue();
        Color color = IntakeColorSensor.getColor();
        if( color == Color.kOrange || color == Color.kOrangeRed){
            SmartDashboard.putString("Detected: ", "Note Found General");
            //Run the intake motors for 3 seconds
            runIntake();
            try {
                lock.wait(3000);
            } catch (Exception e) {
                // TODO: handle exception
            }
            stopIntake();
        }
        else if (1300 > red && red > 1100 && 1050>green && green>850 && 400>blue && blue>250 ) {
            SmartDashboard.putString("Detected: ", "Note Found Values");
            //Run the intake motors for 3 seconds
            runIntake();
            try {
                lock.wait(3000);
            } catch (Exception e) {
                // TODO: handle exception
            }
            stopIntake();
        }
        else{
            SmartDashboard.putString("Detected: ", "Nothing for now");
        }
        
    }
    
    public static void runIntake(){
        SmartDashboard.putString("Intake Status", "Running");
        IntakeMotor.set(NoteConstants.IntakeSpeed);
        SharedMotor.set(NoteConstants.SharedMotorSpeed);
    }

    public static void stopIntake(){
        SmartDashboard.putString("Intake Status", "Off");
        IntakeMotor.set(0);
        SharedMotor.set(0);
    }

    public static void ShootAmp(){
        SmartDashboard.putString("Shooter Status", "Firing at Amp");
        SharedMotor.set(NoteConstants.SharedMotorSpeed);
        RShooterMotor.set(NoteConstants.AmpSpeed);
        LShooterMotor.set(-NoteConstants.AmpSpeed);
    }

    public static void ShootSpeaker(){
        SmartDashboard.putString("Shooter Status", "Firing at Speaker");
        SharedMotor.set(NoteConstants.SharedMotorSpeed);
        RShooterMotor.set(NoteConstants.SpeakerSpeed);
        LShooterMotor.set(-NoteConstants.SpeakerSpeed);
    }

    public static void StopShooter(){
        SmartDashboard.putString("Shooter Status", "Off");
        SharedMotor.set(0);
        RShooterMotor.set(0);
        LShooterMotor.set(0);
    }
}