package com.threecat.springboot.redpacket.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.threecat.springboot.commons.util.UUIDUtils;
import com.threecat.springboot.redpacket.commons.RedPacketConstants;
import com.threecat.springboot.redpacket.model.RedPacket;
import com.threecat.springboot.redpacket.model.RedPacketOrder;
import com.threecat.springboot.redpacket.redis.RedisClient;
import com.threecat.springboot.redpacket.service.RedPacketService;
import com.threecat.springboot.redpacket.util.IdGenerator;
import com.threecat.springboot.redpacket.util.RedPacketUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 红包服务
 */
@Slf4j
@Service public class RedPacketServiceImpl implements RedPacketService
{
	@Autowired
	private RedisClient redisClient;

	private DefaultRedisScript<List> script;

	@PostConstruct
	public void init()
	{
		script = new DefaultRedisScript<>();
		script.setResultType(List.class);
		script.setScriptSource(new ResourceScriptSource(new ClassPathResource("redpacket.lua")));
	}

	@Override
	public long createOrderId()
	{
		return IdGenerator.nextId();
	}

	@Override
	public String createOrder(RedPacketOrder order)
	{
		int amount = order.getAmount();
		int peopleCount = order.getPeopleCount();
		List<Integer> divideAmounts = RedPacketUtils.divideRedPacket(amount, peopleCount);

		List<String> redPackets = new ArrayList<>(divideAmounts.size());
		divideAmounts.stream().forEach((everyAmount) -> {
			RedPacket redPacket = new RedPacket(UUIDUtils.uuid(), everyAmount);
			redPackets.add(JSONObject.toJSONString(redPacket));
		});
		String redPacketKey = RedPacketUtils.genRedPacketKey(order.getOrderId());
		redisClient.lLeftPushAll(redPacketKey, redPackets);
		return redPacketKey;
	}

	@Override
	public int grabRedPacket(String userId, long orderId)
	{
		String redPacketPoolKey = RedPacketConstants.RED_PACKET_POOL_LIST + orderId;
		String redPacketDetailsKey = RedPacketConstants.RED_PACKET_DETAIL_LIST + orderId;
		String redPacketHoldKey = RedPacketConstants.RED_PACKET_HOLD_HASH + orderId;;

		String[] params = {redPacketPoolKey, redPacketDetailsKey, redPacketHoldKey, "" + orderId};
		List result = redisClient.execute(script, Arrays.asList(params));
		log.info("result:" + result);

		return 0;
	}
}
