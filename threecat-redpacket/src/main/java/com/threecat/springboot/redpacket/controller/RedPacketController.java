package com.threecat.springboot.redpacket.controller;

import com.threecat.springboot.commons.dto.BaseResult;
import com.threecat.springboot.commons.util.UUIDUtils;
import com.threecat.springboot.redpacket.model.RedPacketOrder;
import com.threecat.springboot.redpacket.service.RedPacketService;
import com.threecat.springboot.redpacket.util.IdGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Slf4j
@RestController
public class RedPacketController
{
	@Autowired
	private RedPacketService redPacketService;

	@GetMapping("/orderId")
	public BaseResult<Long> createRedPacketOrder()
	{
		long id = redPacketService.createOrderId();
		return new BaseResult<>(HttpStatus.OK.value(), "Get RedPacket OrderId success.", id);
	}

	@PostMapping("/create")
	public BaseResult<String> createRedPacket(@NotNull @RequestBody RedPacketOrder order)
	{
		String key = redPacketService.createOrder(order);
		return new BaseResult<>(HttpStatus.OK.value(), "Create RedPacket Order success.", key);
	}

	@GetMapping("/grab/{userId}/{orderId}")
	public BaseResult<Integer> grabRedPacket(@NotNull @PathVariable("orderId") Long orderId,
			@PathVariable("userId") String userId)
	{
		// 测试时用户名随机创建
//		userId = "threecat:" + UUIDUtils.uuid();
		int money = redPacketService.grabRedPacket(userId, orderId);
		if (money != 0)
		{
			log.info("userId:" + userId + "money:" + money);
		}
		return new BaseResult<>(HttpStatus.OK.value(), "Grab RedPacket success.", money);
	}
}
