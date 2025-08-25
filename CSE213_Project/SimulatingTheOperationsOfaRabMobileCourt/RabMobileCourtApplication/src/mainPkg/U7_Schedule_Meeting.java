/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainPkg;

import java.time.LocalDate;

/**
 *
 * @author Hamida
 */
public class U7_Schedule_Meeting {
    private String meetingId;
    private LocalDate meetingDate;
    private String MeetingTime;
    private String participant;

    public U7_Schedule_Meeting() {
    }

    public U7_Schedule_Meeting(String meetingId, LocalDate meetingDate, String MeetingTime, String participant) {
        this.meetingId = meetingId;
        this.meetingDate = meetingDate;
        this.MeetingTime = MeetingTime;
        this.participant = participant;
    }

    public String getMeetingId() {
        return meetingId;
    }

    public LocalDate getMeetingDate() {
        return meetingDate;
    }

    public String getMeetingTime() {
        return MeetingTime;
    }

    public String getParticipant() {
        return participant;
    }

    public void setMeetingId(String meetingId) {
        this.meetingId = meetingId;
    }

    public void setMeetingDate(LocalDate meetingDate) {
        this.meetingDate = meetingDate;
    }

    public void setMeetingTime(String MeetingTime) {
        this.MeetingTime = MeetingTime;
    }

    public void setParticipant(String participant) {
        this.participant = participant;
    }

    @Override
    public String toString() {
        return "meetingId : " + meetingId + 
                ", "+ "meetingDate : " + meetingDate + 
                
                ", MeetingTime : " + MeetingTime + ", participant=" + participant + "\n";
    }
    
    
    
}
