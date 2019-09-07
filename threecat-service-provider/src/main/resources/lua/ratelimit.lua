local key = KEYS[1] --限流key（一秒一个）
local limit = tonumber(ARGV[1]) --限流大小 10
local current = tonumber(redis.call('get', key) or "0")
if current + 1 > limit then --如果超出限流大小
    return 0
else --请求数+1，并设置2s过期
    redis.call("INCRBY", key, "1")
    redis.call("EXPIRE", key, "2")
    return 1
end

--注意key是ip+System.currentTimeMillis()/1000整合而来，除以1000表示相同key是当前1s内的请求