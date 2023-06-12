package models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Sleep {
    private String start;
    private String end;
    private String startDate;
    private String endDate;
    private long duration;

    public Sleep(String startDate, String start, String endDate, String end){
        this.startDate = startDate;
        this.start = start;
        this.end = end;
        this.endDate = endDate;
        setDuration(startDate, start, endDate, end);
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(String startDate, String start, String endDate, String end) {
        String begin = startDate + " " + start;
        String finish = endDate + " " + end;

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy HH:mm");
        try {
            Date date1 = format.parse(begin);
            Date date2 = format.parse(finish);
            this.duration = date2.getTime() - date1.getTime();
        } catch (ParseException e){
            e.printStackTrace();
        }
    }

    public String stringDuration(){
        long hours = (duration/(1000 * 60 * 60)) % 24;
        long minutes = ((duration/1000) / 60) % 60;
        return hours + " Hours and " +  minutes + " minutes";
    }

    public int calculateHours(){
        long hours = (duration/(1000 * 60 * 60)) % 24;
        return (int) hours;
    }

    public int calculateMinutes(){
        long minutes = ((duration/1000) / 60) % 60;
        return (int) minutes;
    }

}
