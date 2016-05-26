package org.deepthought.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface ShopCarMapper {

	@Insert("INSERT INTO ec_shopcar(user_id,goods_id,goods_amount) VALUES(#{user_id},#{goods_id},#{goods_amount})")
	void insertShopCar(@Param("user_id") String user_id,
			@Param("goods_id") String goods_id,
			@Param("goods_amount") String goods_amount);

	@Select("SELECT goods_id,goods_amount FROM ec_shopcar WHERE user_id = #{user_id}")
	List<Map<Integer, Integer>> selectShopCar(String user_id);

	@Update("UPDATE ec_shopcar SET goods_amount =#{goods_amount}  WHERE user_id=#{user_id} AND goods_id = #{goods_id} ")
	void updateShopCar(@Param("user_id") String user_id,
			@Param("goods_id") String goods_id,
			@Param("goods_amount") String goods_amount);

	@Delete("DELETE FROM ec_shopcar WHERE user_id=#{user_id} AND goods_id=#{goods_id}")
	void deleteShopCar(@Param("user_id") String user_id,
			@Param("goods_id") String goods_id);
	@Delete("DELETE FROM ec_shopcar WHERE user_id =#{user_id}")
	void deleteAllByUserid(int user_id);

}
