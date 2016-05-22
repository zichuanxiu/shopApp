package org.deepthought.sqlService.util;

import java.util.List;
import java.util.Map;

import org.deepthought.bean.User;
import org.deepthought.service.ShopCarService;
import org.deepthought.service.ShopCarServiceImpl;
import org.deepthought.service.util.ServiceProxy;
import org.junit.Test;

public class SqlService {
//	 static ServiceProxy serviceProxy=null;
//	 static ShopCarService shopCarService=null;
//	 static{
//	 ServiceProxy serviceProxy = new ServiceProxy();
//	
//	 ShopCarService shopCarService = (ShopCarService) serviceProxy
//	 .bind(new ShopCarServiceImpl());
//	 }
	
	
	
	// 将User_id，goods_id，goods_amount 插入到数据库购物车中
	public static void insertShopCar(String user_id, String goods_id,
			String goods_amount) {
		ServiceProxy serviceProxy = new ServiceProxy();

		ShopCarService shopCarService = (ShopCarService) serviceProxy
				.bind(new ShopCarServiceImpl());

		shopCarService.insertShopCar(user_id, goods_id, goods_amount);

	}

	// 通过user_id查询shopcar里面的所有信息
	public static List<Map<Integer, Integer>> selectShopCar(String user_id) {
		ServiceProxy serviceProxy = new ServiceProxy();

		ShopCarService shopCarService = (ShopCarService) serviceProxy
				.bind(new ShopCarServiceImpl());
		List<Map<Integer, Integer>> selectShopCar = (List<Map<Integer, Integer>>)shopCarService
				.selectShopCar(user_id);

		return  selectShopCar;
	}
	
	// 通过user_id和goods_id修改shopcar里的goods_amount信息
	public static void updateShopCar(String user_id,String goods_id,String goods_amount){
		ServiceProxy serviceProxy = new ServiceProxy();

		ShopCarService shopCarService = (ShopCarService) serviceProxy
				.bind(new ShopCarServiceImpl());
		
		shopCarService.updateShopCar(user_id, goods_id,goods_amount);
	}
	
	//通过user_id和goods_id删除shopcar里面物品信息
	public static void deleteShopCar(String user_id,String goods_id){
		ServiceProxy serviceProxy = new ServiceProxy();

		ShopCarService shopCarService = (ShopCarService) serviceProxy
				.bind(new ShopCarServiceImpl());
		shopCarService.deleteShopCar(user_id, goods_id);
	}

	


}
