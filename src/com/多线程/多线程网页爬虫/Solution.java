package com.多线程.多线程网页爬虫;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * // This is the HtmlParser's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface HtmlParser {
 * public List<String> getUrls(String url) {}
 * }
 */
class Solution {
    AtomicInteger count = new AtomicInteger(0);
    LinkedList<String> list = new LinkedList<>();
    ConcurrentHashMap<String, Boolean> concurrentHashMap = new ConcurrentHashMap<>();
    String start;
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        startUrl = "http://" + startUrl.split("http://")[1].split("/")[0];
        this.start=startUrl;
        count.getAndIncrement();
        dosome(startUrl,htmlParser);
        while(list.size()==0||count.get()>0){}
        return list;
    }

    public void dosome(String startUrl, HtmlParser htmlParser) {

        try {
            synchronized (list){
                System.out.println(startUrl);
                if(concurrentHashMap.containsKey(startUrl)){
                    return;
                }
                if(startUrl.startsWith(start)){
                    list.add(startUrl);
                    concurrentHashMap.put(startUrl,true);
                }
            }
            count.getAndIncrement();
            new Thread(){
                @Override
                public void run() {

                    htmlParser.getUrls(startUrl).stream().filter(v->!concurrentHashMap.containsKey(v)).forEach(v->{

                        count.getAndIncrement();
                        dosome(v,htmlParser);
                    });
                    count.getAndDecrement();
                }
            }.start();
        }finally {
            count.getAndDecrement();

        }
    }

    interface HtmlParser {
        // Return a list of all urls from a webpage of given url.
        // This is a blocking call, that means it will do HTTP request and return when this request is finished.
        public List<String> getUrls(String url);
    }

}