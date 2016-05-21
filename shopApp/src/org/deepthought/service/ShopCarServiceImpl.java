package org.deepthought.service;

import java.util.List;
import java.util.Map;

import org.deepthought.annotation.OutoMapper;
import org.deepthought.mapper.ShopCarMapper;

public class ShopCarServiceImpl implements ShopCarService {

	@OutoMapper()
	private ShopCarMapper shopCarMapper;

	@Override
	public void insertShopCar(String user_id, String goods_id,
			String goods_amount) {

		shopCarMapper.insertShopCar(user_id, goods_id, goods_amount);

	}

	@Override
	public List<Map<Integer, Integer>> selectShopCar(String user_id) {

		List<Map<Integer, Integer>> selectShopCar = shopCarMapper
				.selectShopCar(user_id);
		return selectShopCar;
	}

	@Override
	public void updateShopCar(String user_id, String goods_id,
			String goods_amount) {

		shopCarMapper.updateShopCar(user_id, goods_id,
				goods_amount);
		
	}

	@Override
	public void deleteShopCar(String user_id, String goods_id) {

		shopCarMapper.deleteShopCar(user_id, goods_id);
		
	}
}
