package com.iplay.jread.utils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Description :
 * Author : iplay
 * Email  : iplaycloud@gmail.com
 * Blog   : www.iplaycloud.xyz
 * Date   : 15/12/17
 */
public class JsonUtilsTest {

    class User {
        String name;
        String sex;
        public User(String name, String sex) {
            this.name = name;
            this.sex = sex;
        }
    }


    @Test
    public void testSerialize() throws Exception {
        assertEquals("{\"name\":\"JiangShen\",\"sex\":\"男\"}", JsonUtils.serialize(new User("JiangShen", "男")));
    }

    @Test
    public void testDeserialize() throws Exception {
        assertNotNull(JsonUtils.deserialize("{\"name\":\"JiangShen\",\"sex\":\"男\"}", User.class));
    }

    @Test
    public void testDeserialize1() throws Exception {
        assertNotNull(JsonUtils.deserialize("{\"name\":\"JiangShen\",\"sex\":\"男\"}", User.class));
    }
}