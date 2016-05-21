package org.deepthought.service;

import java.util.List;
import java.util.Map;

public interface ShopCarService {

	void insertShopCar(String user_id, String goods_id, String goods_amount);

	List<Map<Integer, Integer>> selectShopCar(String user_id);

	void updateShopCar(String user_id, String goods_id,String goods_amount);

	void deleteShopCar(String user_id, String goods_id);
	
}
