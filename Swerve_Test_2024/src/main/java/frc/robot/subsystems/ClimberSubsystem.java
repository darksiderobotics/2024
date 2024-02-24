package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ClimberConstants;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;

public class ClimberSubsystem extends SubsystemBase{
    CANSparkMax ClimberMotor;
    //ClimberHighLimit;
    //ClimberLowLimit;

    public ClimberSubsystem(){
        ClimberMotor = new CANSparkMax(ClimberConstants.ClimberMotorID, MotorType.kBrushless);
        //ClimberHighLimit = new(ClimberConstants.ClimberHighLimitID);
        //ClimberLowLimit = new(ClimberConstants.ClimberLowLimitID);
    }
    
    public void runClimber(){
        /*
        if (ClimberHighLimit == 0) {
            ClimberMotor.set(ClimberConstants.ClimberSpeed);
        }
        else if (ClimberLowLimit == 0) {
            ClimberMotor.set(-ClimberConstants.ClimberSpeed)
        }
        else
        */
    }

    public void stopClimber(){
        ClimberMotor.set(0);
    }
}