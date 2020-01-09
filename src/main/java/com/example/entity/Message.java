package com.example.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Message {
    private int messageid;
    private int receiveid;
    private int sendid;
    private String sendtime;
    private String sendcontent;
    private int messagestatus;
    private String sendname;
}
