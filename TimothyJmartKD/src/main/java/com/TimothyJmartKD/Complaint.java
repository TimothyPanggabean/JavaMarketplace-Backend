package com.TimothyJmartKD;
import com.TimothyJmartKD.dbjson.Serializable;

import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Class Complaint
 *
 * Timothy Christian Panggabean
 * 1906355705
 */
public class Complaint extends Serializable
{
    public String desc;
    public Date date;

    public Complaint(String desc)
    {
        this.desc = desc;
    }
    
    public String toString()
    {
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyy");
        return
        "Complaint{date=" + format.format(date) + ", desc=' " + desc + "'}";
    }
}