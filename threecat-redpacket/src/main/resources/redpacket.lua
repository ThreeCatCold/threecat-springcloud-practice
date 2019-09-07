--在项目中我把redpacket这个字符串缩写为rp
--KEYS[1] redpacket:pool:list:orderid
--KEYS[2] redpacket:detail:list:orderid
--KEYS[3] redpacket:hold:hash:orderid
--KEYS[4] 抢红包的用户id
--查询用户是否已经抢过红包，若已抢过红包，则返回1表示已抢过
if redis.call('hexists', KEYS[3], KEYS[4]) ~= 0
then
    --如果抢过红包，返回0
    return '0'
else
    --从红包中弹出一个红包
    local redPacket = redis.call('rpop', KEYS[1]);
    --判断从红包池中弹出的红包是否为空
    if redPacket
    then
        local x = cjson.decode(redPacket);
        --将用户ID信息追加到红包信息中，表示该用户已抢到红包
        x['userId'] = KEYS[4];
        local redJson = cjson.encode(x);
        --记录用户已抢过，记录redpacket:hold:hash:{orderId}
        redis.call('hset', KEYS[3], KEYS[4], '1');
        --将抢红包的结果详情存入redpacket:detail:list:{orderId}
        redis.call('lpush', KEYS[2], redJson);
        return x['money'];
    else
        --如果红包已被抢完，返回-1
        return '-1';
    end
end
