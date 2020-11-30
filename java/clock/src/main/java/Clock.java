public class Clock {
    private int totalMinutes; // It turns out the epoch format is a good idea.
    private static final int DAY = 24 * 60;

    public Clock(int hours, int minutes) {
        this.totalMinutes = 0;
        this.add(minutes + 60 * hours);
    }
    
    public void add(int minutes) {
        if(minutes < 0) {
            minutes = DAY - (Math.abs(minutes) % DAY);
        }
        totalMinutes += minutes;
        totalMinutes %= DAY;
    }
    
    @Override
    public int hashCode() {
        return totalMinutes;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Clock other = (Clock) obj;
        if (this.totalMinutes != other.totalMinutes) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        int hours = totalMinutes / 60;
        int minutes = totalMinutes % 60;
        return (hours < 10 ? "0" : "") + hours + ":" + (minutes < 10 ? "0" : "") + minutes;
    }
}