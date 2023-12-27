package com.zifeiyu.zifeichat.common;

import com.zifeiyu.zifeichat.common.user.dao.UserDao;
import com.zifeiyu.zifeichat.common.user.domain.entity.User;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpQrCodeTicket;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: wxh
 * @version:
 * @date: 2023/12/26 9:24
 * @description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class DaoTest {
    
    @Autowired
    private UserDao userDao;
    
    @Autowired
    private WxMpService wxMpService;
    
    @Test
    public void test(){
        User byId = userDao.getById(1);
        User user = new User();
        user.setName("zifei-1");
        user.setOpenId("111222");
        boolean save = userDao.save(user);
        System.out.println(save);
    }
    
    
    @Test
    public void test2(){
        boolean b = userDao.removeById(10485);
        System.out.println(b);
    }
    
    @Test
    public void test3() throws WxErrorException {
        WxMpQrCodeTicket wxMpQrCodeTicket = wxMpService.getQrcodeService().qrCodeCreateTmpTicket(1, 1000);
        String url = wxMpQrCodeTicket.getUrl();
        System.out.println(url);
    }
    
}
