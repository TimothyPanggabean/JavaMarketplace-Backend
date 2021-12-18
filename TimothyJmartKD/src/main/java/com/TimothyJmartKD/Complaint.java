package com.TimothyJmartKD;
import com.TimothyJmartKD.dbjson.Serializable;

import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Class Complaint
 * isi: constructor untuk inisiasi dan toString untuk menampilkan data (yang digunakan punya front end)
 * tidak diimplementasi di program akhir
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