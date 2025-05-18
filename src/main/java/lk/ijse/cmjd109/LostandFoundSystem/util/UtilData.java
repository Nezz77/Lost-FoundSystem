package lk.ijse.cmjd109.LostandFoundSystem.util;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

import static java.time.LocalTime.now;

public class UtilData {
    public static String generateItemId(){
        return "I-"+ UUID.randomUUID();
    }
    public static String generateRequestId(){
        return "R-"+ UUID.randomUUID();
    }
    public static String generateUserId(){
        return "U-"+ UUID.randomUUID();
    }

    ///generate requested date and time
    public static LocalDate generateTodayDate(){
        return LocalDate.now();
    }
    public static LocalTime generateCurrentTime(){
        return Time.valueOf(now()).toLocalTime();
    }

}
