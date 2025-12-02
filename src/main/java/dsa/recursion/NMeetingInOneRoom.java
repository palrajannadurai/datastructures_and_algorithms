package dsa.recursion;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Meetings {
    int start;
    int end;

    public Meetings(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}


public class NMeetingInOneRoom {

    public static int maxMeetings(int[] start, int[] end) {
        // converting into meeting object
        List<Meetings> meetings = new ArrayList<>(start.length);
        for (int i = 0; i < start.length; i++) {
            meetings.add(new Meetings(start[i], end[i]));
        }

        //
        meetings.sort(Comparator.comparingInt(Meetings::getEnd));
        int noOfMeetings = 1;
        int lastEndTime = meetings.get(0).getEnd();
        for (int i = 1; i < meetings.size() ; i++) {
            if (meetings.get(i).getStart() > lastEndTime) {
                noOfMeetings++;
                lastEndTime = meetings.get(i).getEnd();
            }
        }
        return noOfMeetings;
    }

    public static void main(String[] args) {
        int[] start = {10, 12, 20};
        int[] end = {20, 25, 30};
        System.out.println(maxMeetings(start, end));
    }
}
