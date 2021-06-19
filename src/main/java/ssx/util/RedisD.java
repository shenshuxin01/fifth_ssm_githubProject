package ssx.util;

import redis.clients.jedis.Client;
import redis.clients.jedis.Jedis;

public class RedisD {
    public static String main(String args) {
//        Client client = new Client("192.168.192.129",6379);
//        client.auth("1");
//        client.select(9);
        Jedis jedis = new Jedis("192.168.192.129", 6379);
        jedis.auth("1");
        String select = jedis.select(8);
        String hello = jedis.get(args);
        return hello;

    }
}
