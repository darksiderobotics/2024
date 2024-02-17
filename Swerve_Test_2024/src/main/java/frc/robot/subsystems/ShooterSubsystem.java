package frc.robot.subsystems;

import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.NoteConstants;

public class ShooterSubsystem extends SubsystemBase{
    CANSparkMax RShooterMotor;
    CANSparkMax LShooterMotor;
    CANSparkMax SharedMotor;

    public ShooterSubsystem(){
        RShooterMotor = new CANSparkMax(NoteConstants.RShooterMotorID, MotorType.kBrushless);
        LShooterMotor = new CANSparkMax(NoteConstants.LShooterMotorID, MotorType.kBrushless);
        SharedMotor = new CANSparkMax(NoteConstants.SharedMotorID, MotorType.kBrushless);
    }

    public void ShootAmp(){
        SharedMotor.set(NoteConstants.AmpSpeed);
        RShooterMotor.set(NoteConstants.AmpSpeed);
        LShooterMotor.set(-NoteConstants.AmpSpeed);
    }

    public void ShootSpeaker(){
        SharedMotor.set(NoteConstants.SpeakerSpeed);
        RShooterMotor.set(NoteConstants.SpeakerSpeed);
        LShooterMotor.set(-NoteConstants.SpeakerSpeed);
    }

    public void StopShooter(){
        SharedMotor.set(0);
        RShooterMotor.set(0);
        LShooterMotor.set(0);
    }
}
