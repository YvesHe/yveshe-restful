/**   
 * Filename:    UserEndpoint.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2017-9-4
 * Description:  
 *
 * Author       Yves He 
 */
package cn.com.yves.server.enterprise.endpoint;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.yves.module.IModuleService;
import cn.com.yves.module.ImplModuleService;
import cn.com.yves.module.bo.UserBo;
import cn.com.yves.module.bo.filter.UserFilter;
import cn.com.yves.server.BasicEndpoint;
import cn.com.yves.server.RESTfulResult;
import cn.com.yves.server.util.RESTfulServerLog;

/**
 * 业务操作
 * 
 * @author Yves He
 * 
 */

@Controller
@RequestMapping("v1/user")
public class UserEndpoint extends BasicEndpoint {

    // 功能如下：
    // 增 add
    // 删 delete
    // 改 update
    // 查 getUserById && listUser

    private final RESTfulServerLog logger = new RESTfulServerLog(UserEndpoint.class);
    private final IModuleService modService = new ImplModuleService();

    /**
     * 新增: POST
     * 
     * 
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public RESTfulResult add(@RequestBody UserBo user) {
        logger.debug("invoke add");
        RESTfulResult result = null;
        try {
            String id = modService.saveUser(user);
            UserBo userBo = modService.getUserByPrimaryKey(id);
            if (userBo == null) {
                throw OPTIONS_POST.exception().newInternalServerError("add to database success,but can't find it,the id is:" + id);
            }
            result = success(OPTIONS_POST.status().newSuccess(), userBo);
        } catch (Throwable e) { // 将两种异常: RESTfulException,ModuleException都收集
            result = error(e);
        }
        logger.debug("end add");
        return result;
    }

    /**
     * 删除: DELETE
     * 
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public RESTfulResult del(@PathVariable(value = "id") String id) {
        RESTfulResult result = null;
        try {
            modService.delUser(id);
            result = success(OPTIONS_DELETE.status().newSuccess());
        } catch (Throwable e) {
            result = error(e);
        }
        return result;
    }

    /**
     * 更新: PUT
     * 
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public RESTfulResult update(@PathVariable(value = "id") String id, UserBo user) {
        RESTfulResult result = null;
        try {
            if (!id.equals(user.getId())) {
                throw OPTIONS_PUT.exception().newBadRequest("the path id not equals the bean's id.");
            }

            String returnId = modService.saveUser(user);
            UserBo data = modService.getUserByPrimaryKey(returnId);
            if (modService.getUserByPrimaryKey(returnId) == null) {
                throw OPTIONS_PUT.exception().newInternalServerError("update to database success,but can't find it,the id is:" + id);
            }
            result = success(OPTIONS_PUT.status().newSuccess(), data);
        } catch (Throwable e) {
            result = error(e);
        }
        return result;
    }

    /**
     * 查询 ById: GET
     * 
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public RESTfulResult getById(@PathVariable(value = "id") String id) {
        RESTfulResult result = null;
        try {
            UserBo data = modService.getUserByPrimaryKey(id);
            if (data == null) {
                throw OPTIONS_GET.exception().newNotFound("not find the data in database, the query id is:" + id);
            }
            result = success(OPTIONS_GET.status().newSuccess(), data);
        } catch (Throwable e) {
            result = error(e);
        }
        return result;
    }

    /**
     * 组合查询 by条件:GET
     * 
     * <br>
     * <br>
     * 条件设置: Bo除了id的其他属性 + (sort , offset , row_count)
     * 
     * <br>
     * <br>
     * sort: 表示排序,通过"+"/"-"来表示排序顺序,默认不写,等同于"+". eg:
     * "+name"/"name"表示正序,"-name"表示倒序.该参数允许配置多个,比如："?sort=name&sort=-age"
     * 
     * <br>
     * offset和row_count:
     * 分页功能,offset表示起始下标,row_count表示查询数量,两个参数必须同时使用才,分页功能才生效,使用分页功能试试
     * ,返回的结果会带有totalsize结果.
     * 
     * @return
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public RESTfulResult list(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "age", required = false) Integer age, @RequestParam(value = "address", required = false) String address, @RequestParam(value = "sorts", required = false) List<String> sorts, @RequestParam(value = "offset", required = false) Integer offset, @RequestParam(value = "row_count", required = false) Integer row_count) {
        RESTfulResult result = null;
        UserFilter filter = new UserFilter();
        filter.setAddress(address);
        filter.setAge(age);
        filter.setName(name);
        filter.setOffset(offset);
        filter.setRowCount(row_count);
        filter.setSorts(sorts.toArray(new String[sorts.size()]));
        try {
            // 查询数据
            List<UserBo> data = modService.listUserByFilter(filter);

            // 查询总数
            int size = 0;
            if (offset != null && row_count != null) {
                size = data.size();
            }
            result = success(OPTIONS_GET.status().newSuccess(), data, size);
        } catch (Throwable e) {
            result = error(e);
        }
        return result;
    }

    // TODO 待完善:使用springmvc来实现文件的上传和下载.

    /**
     * 测试: add
     * 
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/{id}/testAdd", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public RESTfulResult testAdd(@PathVariable(value = "id") String id, @RequestBody UserBo user) {
        // 判断path中的id 与 UserBo中的id是否一致.
        RESTfulResult result = new RESTfulResult();
        return result;
    }

    /**
     * 测试: update
     * 
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/{id}/testUpdate", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public RESTfulResult testUpdate(@PathVariable(value = "id") String id, @RequestBody UserBo user) {
        // 判断path中的id 与 UserBo中的id是否一致.
        RESTfulResult result = new RESTfulResult();
        return result;
    }

}
