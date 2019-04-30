package com.platform.chorus.web;

import com.platform.chorus.ChorusPlatformApplication;
import com.platform.chorus.web.exception.BadRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by A.T on 2019/4/29
 */
@RestController
@RequestMapping("/admin")
public class ServerController {
    static final Logger logger = LoggerFactory.getLogger(ServerController.class);

    @RequestMapping("/exit")
    public String exit() {
        new Thread(()-> {
            try {
                Thread.sleep(1000);
                ChorusPlatformApplication.exit();
            } catch (InterruptedException e) {
                logger.error("server stop failed");
            }
        }).start();
        return "server shutdown";
    }

    @RequestMapping("/error")
    public String error() {
        throw new BadRequestException();
    }


}
