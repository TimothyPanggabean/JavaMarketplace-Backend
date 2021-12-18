package com.TimothyJmartKD;

import com.TimothyJmartKD.dbjson.JsonDBEngine;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Class Jmart
 * isi: memulai JsonDBEngine dan menggunakan thread
 *
 */

@SpringBootApplication
public class Jmart
{
	public static long DELIVERED_LIMIT_MS = 200;
	public static long ON_DELIVERY_LIMIT_MS = 300;
	public static long ON_PROGRESS_LIMIT_MS = 300;
	public static long WAITING_CONF_LIMIT_MS = 200;
	
	public static void main(String[] args)
	{
		JsonDBEngine.Run(Jmart.class);
		SpringApplication.run(Jmart.class,args);
		Runtime.getRuntime().addShutdownHook(new Thread(() -> JsonDBEngine.join()));
	}
}