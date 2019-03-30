import java.util.ArrayList;

enum AbbreviationOfDays{

    SUNDAY("SUN"), MONDAY("MON"), TUESDAY("TUE"), WEDNESDAY("WED"),

    THURSDAY("THUR"), FRIDAY("FRI"), SATURDAY("SAT");

    private String abbreviation;

    public String getAbbreviation() {
        return abbreviation;
    }

    AbbreviationOfDays(String abbreviation) {
        this.abbreviation = abbreviation;
    }
}

class SimpleEnumExample {
    enum Days {
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
    }

    public String getStringRepresentationViaIf(Days day) {
        if(Days.SUNDAY == day) {
            return "It's SUNDAY";
        } else if(Days.MONDAY == day) {
            return "It's MONDAY";
        } else if(Days.TUESDAY == day) {
            return "It's TUESDAY";
        } else if(Days.WEDNESDAY == day) {
            return "It's WEDNESDAY";
        } else if(Days.THURSDAY == day) {
            return "It's THURSDAY";
        } else if(Days.FRIDAY == day) {
            return "It's FRIDAY";
        } else {
            return "It's SATURDAY";
        }
    }

    public String getStringRepresentationViaSwitch(Days day) {
        String result = "";
        switch(day) {
            case SUNDAY:
                result = "It's SUNDAY";
                break;
            case MONDAY:
                result = "It's MONDAY";
                break;
            case TUESDAY:
                result = "It's TUESDAY";
                break;
            case WEDNESDAY:
                result = "It's WEDNESDAY";
                break;
            case THURSDAY:
                result = "It's THURSDAY";
                break;
            case FRIDAY:
                result = "It's FRIDAY";
                break;
            case SATURDAY:
                result = "It's SATURDAY";
                break;
        }
        return result;
    }

    public ArrayList<String> getEnumValues() {
        Days[] days = Days.values();
        ArrayList<String> week = new ArrayList<String>(days.length);
        for(Days day : days) {
            week.add(day.toString());
        }
        return week;
    }

    public ArrayList<String> getWeekdaysAbbreviations() {
        AbbreviationOfDays[] weekdaysAbbreviations = AbbreviationOfDays.values();
        ArrayList<String> weekdaysAbbreviationsString = new ArrayList<String>(weekdaysAbbreviations.length);
        for(AbbreviationOfDays day : weekdaysAbbreviations) {
            weekdaysAbbreviationsString.add(day.getAbbreviation());
        }
        return weekdaysAbbreviationsString;
    }
}