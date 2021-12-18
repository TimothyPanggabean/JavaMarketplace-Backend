package com.TimothyJmartKD;

/**
 * Class PhoneTopUp
 * isi: mengisi saldo menggunakan nomor telepon
 * tidak diimplementasi di produk akhir
 */
public class PhoneTopUp extends Invoice{
	public String phoneNumber;
	public Status status;
	
	public PhoneTopUp(int buyerId, int productId, String phoneNumber)
	{
		super(buyerId, productId);
		this.phoneNumber = phoneNumber;
	}
	
	public double getTotalPay(Product product)
	{
		return product.price - (product.price * product.discount);
	}
}
