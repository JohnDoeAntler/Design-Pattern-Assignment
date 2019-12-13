package app.adapter;

/**
 * IProduct
 */
public interface ICoffeeProduct {

	// default method

	public String getName();

	public void setName(String name);

	public int getProductId();

	public void setProductId(int productId);

	public int getQty();

	public void setQty(int qty);

	// custom method

	public String getInfo();

	public String getDetailInfo();
}