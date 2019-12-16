package com.example.shoppingTimeline.model;

import java.util.List;

public class EventComprouProduto {
    private String event;
    private String timestamp;
    private List<CustomData> custom_data;

    public String getValueByKey(String key) {
        for (CustomData customData : custom_data) {
            if(customData.getKey().equals(key))
                return customData.getValue();
        }
        return null;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public List<CustomData> getCustomData() {
        return custom_data;
    }

    public void setCustomData(List<CustomData> custom_data) {
        this.custom_data = custom_data;
    }
}
