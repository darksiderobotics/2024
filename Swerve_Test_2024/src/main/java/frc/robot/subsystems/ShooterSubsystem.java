package frc.robot.subsystems;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.NoteConstants;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;
import com.revrobotics.ColorSensorV3;

public class IntakeSubsystem extends SubsystemBase{
    ColorSensorV3 IntakeColorSensor;
    CANSparkMax IntakeMotor;
    CANSparkMax SharedMotor;

    public IntakeSubsystem(){
        IntakeColorSensor = new ColorSensorV3(I2C.Port.kOnboard);
        IntakeMotor = new CANSparkMax(NoteConstants.IntakeMotorID, MotorType.kBrushless);
        SharedMotor = new CANSparkMax(NoteConstants.SharedMotorID, MotorType.kBrushless);
    }

    public void getColors(){
        SmartDashboard.putNumber("Red",IntakeColorSensor.getRed());
        SmartDashboard.putNumber("Green",IntakeColorSensor.getGreen());
        SmartDashboard.putNumber("Blue",IntakeColorSensor.getBlue());
        int red = IntakeColorSensor.getRed();
        int green = IntakeColorSensor.getGreen();
        int blue = IntakeColorSensor.getBlue();
        Color color = IntakeColorSensor.getColor();
        if( color == Color.kOrange || color == Color.kOrangeRed){
            SmartDashboard.putString("Detected: ", "Note Found");
        }
        else{
            SmartDashboard.putString("Detected: ", "Nothing for now");
        }
        if (1300 > red && red > 1100 && 1050>green && green>850 && 400>blue && blue>250 ) {
            //Run the intake motors for 3 seconds
            runIntake();
            try {
                wait(3000);
            } catch (Exception e) {
                // TODO: handle exception
            }
            stopIntake();
        }
    }
    
    public void runIntake(){
        IntakeMotor.set(0.65);
        SharedMotor.set(0.65);
    }

    public void stopIntake(){
        IntakeMotor.set(0);
        SharedMotor.set(0);
    }
}