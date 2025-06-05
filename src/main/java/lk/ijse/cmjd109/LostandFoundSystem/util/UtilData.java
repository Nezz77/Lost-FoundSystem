package lk.ijse.cmjd109.LostandFoundSystem.util;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

import static java.time.LocalTime.now;

public class UtilData {
    public static String generateItemId(){
        return "I-"+ UUID.randomUUID().toString().substring(0, 8);
    }
    public static String generateRequestId(){
        return "R-"+ UUID.randomUUID().toString().substring(0, 8);
    }
    public static String generateUserId(){
        return "U-"+ UUID.randomUUID().toString().substring(0, 8);
    }

    ///generate requested date and time
    public static LocalDate generateTodayDate(){
        return LocalDate.now();
    }
    public static LocalTime generateCurrentTime(){
        return Time.valueOf(now()).toLocalTime();
    }
    //
}
