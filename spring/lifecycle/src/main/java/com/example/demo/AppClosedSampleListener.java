package com.example.demo;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;

@Component
public class AppClosedSampleListener implements ApplicationListener<ContextClosedEvent> {

    private final DemoBean demoBean;

    public AppClosedSampleListener(DemoBean demoBean) {
        this.demoBean = demoBean;
    }

    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        System.out.println("=====================");
        System.out.println("Application closed");
        demoBean.print();
        System.out.println("=====================");
    }
}
