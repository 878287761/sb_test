package com.lilei.config;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<String,Object> redisTemplate(RedisConnectionFactory rcf){
        RedisTemplate<String,Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(rcf);

        //序列化工具
        Jackson2JsonRedisSerializer j2jrs = new Jackson2JsonRedisSerializer(Object.class);
        //ObjectMapper是 Jackson 提供的一个类，作用是将 java 对象与 json 字符串相互转化。
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        //该方法是指定序列化输入的类型，就是将数据库里的数据安装一定类型存储到redis缓存中。
        //如果注释掉enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL)，那存储到redis里的数据将是没有类型的纯json
        //enableDefaultTyping已被弃用  替换为如下方法
        om.activateDefaultTyping(LaissezFaireSubTypeValidator.instance ,
                ObjectMapper.DefaultTyping.NON_FINAL, JsonTypeInfo.As.PROPERTY);
        j2jrs.setObjectMapper(om);
        StringRedisSerializer srs = new StringRedisSerializer();
        //key采用string的序列化方式
        redisTemplate.setKeySerializer(srs);
        //hash的key也采用String的序列化方式
        redisTemplate.setHashKeySerializer(srs);
        //vakue采用jackson
        redisTemplate.setValueSerializer(j2jrs);
        //hash的value也采用jackson序列化方式
        redisTemplate.setHashValueSerializer(j2jrs);
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }
}
