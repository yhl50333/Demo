package com.example.entity;



import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Permission  implements Serializable {
    private int pid;
    private String pname;
    private int permission_group_id;
    private String permission_group_name;
    private String href;

@Override
public String toString() {
        return "Permission{" +
        "pid=" + pid +
        ", pname='" + pname + '\'' +
        ", permission_group_id=" + permission_group_id +
        ", permission_group_name='" + permission_group_name + '\'' +
        ", href='" + href + '\'' +
        '}';
        }


}