package com.example.shoppingTimeline.controller;

import com.example.shoppingTimeline.dao.ShoppingTimelineDAO;
import com.example.shoppingTimeline.model.Events;
import com.example.shoppingTimeline.model.ShoppingTimeline;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

@RestController
@RequestMapping("/timeline")
public class ShoppingTimelineController {

    private final ShoppingTimelineDAO shoppingTimelineDAO;

    public ShoppingTimelineController(ShoppingTimelineDAO shoppingTimelineDAO) {
        this.shoppingTimelineDAO = shoppingTimelineDAO;
    }

    @PostMapping()
    public ShoppingTimeline getTimeline() {
        ShoppingTimeline shoppingTimeline = new ShoppingTimeline();
        try {
            URL ditoEndPoint = new URL("https://storage.googleapis.com/dito-questions/events.json");
            BufferedReader in = new BufferedReader(new InputStreamReader(ditoEndPoint.openStream(), "UTF8"));
            String eventsJson = in.readLine();

            Gson gson = new Gson();
            Events events = gson.fromJson(eventsJson, Events.class);

            shoppingTimeline = shoppingTimelineDAO.getShoppingTimeline(events);
        } catch (Exception e) {
            System.out.println("Exception - " + e);
        }
        return shoppingTimeline;
    }
}
