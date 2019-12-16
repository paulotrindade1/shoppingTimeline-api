package com.example.shoppingTimeline.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public class SortTimeline implements Comparator<Timeline> {

    @Override
    public int compare(Timeline timeline1, Timeline timeline2) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSSSX");
        Date timeline1Date = new Date();
        Date timeline2Date = new Date();
        try {
            timeline1Date = sdf.parse(timeline1.getTimestamp());
            timeline2Date = sdf.parse(timeline2.getTimestamp());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (timeline1Date.compareTo(timeline2Date) > 0) {
            return -1;
        } else if(timeline1Date.compareTo(timeline2Date) < 0) {
            return 1;
        }
        return 0;
    }
}
