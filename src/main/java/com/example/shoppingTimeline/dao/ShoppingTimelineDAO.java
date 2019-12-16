package com.example.shoppingTimeline.dao;

import com.example.shoppingTimeline.model.*;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ShoppingTimelineDAO{

    public ShoppingTimeline getShoppingTimeline(Events events) {

        Gson gson = new Gson();

        List<Event> eventList = events.getEvents();
        List<EventComprou> eventComprouList = new ArrayList<EventComprou>();
        List<EventComprouProduto> eventComprouProdutoList = new ArrayList<EventComprouProduto>();
        List<Timeline> timelineList = new ArrayList<Timeline>();
        ShoppingTimeline shoppingTimeline = new ShoppingTimeline();

        for (Event event : eventList) {
            if(event.getEvent().equals("comprou")) {
                String eventComprouJson = gson.toJson(event, Event.class);
                eventComprouList.add(gson.fromJson(eventComprouJson, EventComprou.class));
            } else if(event.getEvent().equals("comprou-produto")) {
                String eventComprouProdutoJson = gson.toJson(event, Event.class);
                eventComprouProdutoList.add(gson.fromJson(eventComprouProdutoJson, EventComprouProduto.class));
            }
        }

        for (EventComprou eventcomprou : eventComprouList) {
            Timeline timeline = new Timeline();
            timeline.setTimestamp(eventcomprou.getTimestamp());
            timeline.setRevenue(eventcomprou.getRevenue());
            String transaction_id = eventcomprou.getValueByKey("transaction_id");
            timeline.setTransaction_id(transaction_id);
            timeline.setStore_name(eventcomprou.getValueByKey("store_name"));
            List<Product> products = getEventComprouProducts(eventComprouProdutoList, transaction_id);
            timeline.setProducts(products);

            timelineList.add(timeline);
        }

        Collections.sort(timelineList, new SortTimeline());
        shoppingTimeline.setItems(timelineList);

        return shoppingTimeline;
    }

    private List<Product> getEventComprouProducts(List<EventComprouProduto> eventComprouProdutoList, String comprouTransaction_id) {
        List<Product> products = new ArrayList<Product>();
        for (EventComprouProduto eventcomprouproduto : eventComprouProdutoList) {
            String comprouProdutoTransaction_id = eventcomprouproduto.getValueByKey("transaction_id");
            if(comprouProdutoTransaction_id.equals(comprouTransaction_id)) {
                Product product = new Product();
                String productName = eventcomprouproduto.getValueByKey("product_name");
                double productPrice = Double.parseDouble(eventcomprouproduto.getValueByKey("product_price"));
                product.setName(productName);
                product.setPrice(productPrice);
                products.add(product);
            }
        }
        return products;
    }
}
