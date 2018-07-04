package com.example.demo.dto;

/**
 * Created by haoyuexun on 2018/6/27.
 */

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import com.example.demo.utils.CodeUtils;
import com.github.pagehelper.Page;
import com.google.common.base.Joiner;
import com.example.demo.utils.PageInfo;
import java.util.List;
public class CommonResponse extends HashMap<String, Object> {

    private static final long serialVersionUID = 1L;

    /**
     * 默认构造方法
     */
    public CommonResponse() {
        super();
        this.put("success", true);
    }
    /**
     * 默认失败构造方法
     */
    public CommonResponse(boolean status) {
        super();
        this.put("success", status);
    }
    /**
     * 设置为成功应答
     */
    public void success() {
        this.put("code",CodeUtils.SUCCESS_CODE);
        this.put("message",CodeUtils.SUCCESS_MSG);
        //==========================临时
        this.put("old_timestamp", System.currentTimeMillis());
    }

    /**
     * 向通用应答内设置一项数据对象
     * @param data
     */
    public void setData(Object data) {
        Collection collection;
        if (!containsKey("res") || get("res") == null) {
            collection = new ArrayList();
            put("res", collection);
        } else {
            collection = (Collection) get("res");
        }
        collection.add(data);
    }

    /**
     * 向通用应答内设置一个集合对象
     * @param collection
     */
    public void setData(Collection collection) {
        this.put("res", collection);
    }

    /**
     * 快速创建一个成功应答对象
     * @return
     */
    public static CommonResponse createCommonResponse() {
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.success();
        return commonResponse;
    }

    /**
     * 快速创建一个应答对象, 可传入一个数据对象, 并置为success
     * @param data
     * @return
     */
    public static CommonResponse createCommonResponse(Object data) {
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.success();
        commonResponse.put("res",data);
        // commonResponse.setData(data);
        return commonResponse;
    }
    /**
     * @Title: createCommonResponseForId
     * @Description: 快速创建一个应答对象, 并将ID返回回去
     * @param id
     * @return
     */
    public static CommonResponse createCommonResponseForId(String id) {
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.success();
        commonResponse.put("id",id);
        return commonResponse;
    }
    /**
     * @Title: createExceptionCommonResponse
     * @Description: 异常信息
     * @return
     */
    public static CommonResponse createExceptionCommonResponse(Exception e) {
        CommonResponse commonResponse = new CommonResponse(false);
        commonResponse.put("code",CodeUtils.EXCEPTION_CODE);
        commonResponse.put("message",CodeUtils.EXCEPTION_MSG + e);
        return commonResponse;
    }
    /**
     * @Title: createWrongParamCommonResponse
     * @Description: 数据不合法
     * @param message
     * @return
     */
    public static CommonResponse createWrongParamCommonResponse(String message) {
        CommonResponse commonResponse = new CommonResponse(false);
        commonResponse.put("code",CodeUtils.DATA_WRONGFULNESS_CODE);
        commonResponse.put("message", Joiner.on("-").join(CodeUtils.DATA_WRONGFULNESS_MSG,message));
        return commonResponse;
    }
    /**
     * @Title: createEmptyListCommonResponse
     * @Description: 数据集合为空
     * @return
     */
    public static CommonResponse createEmptyListCommonResponse() {
        CommonResponse commonResponse = new CommonResponse(false);
        commonResponse.put("code",CodeUtils.EMPTY_LIST_CODE);
        commonResponse.put("message",CodeUtils.EMPTY_LIST_MSG);
        return commonResponse;
    }
    /**
     * @Title: createEmptyDataCommonResponse
     * @Description: 数据为空
     * @return
     */
    public static CommonResponse createEmptyDataCommonResponse() {
        CommonResponse commonResponse = new CommonResponse(false);
        commonResponse.put("code",CodeUtils.EMPTY_DAT_CODE);
        commonResponse.put("message",CodeUtils.EMPTY_DAT_MSG);
        return commonResponse;
    }
    /**
     * @Title: createNotExistCommonResponse
     * @Description: 数据为null
     * @return
     */
    public static CommonResponse createNotExistCommonResponse() {
        CommonResponse commonResponse = new CommonResponse(false);
        commonResponse.put("code",CodeUtils.DATA_NOT_EXIST_CODE);
        commonResponse.put("message",CodeUtils.DATA_NOT_EXIST_MSG);
        return commonResponse;
    }
    /**
     * @Title: createNotExistCommonResponse
     * @Description: 数据为null
     * @return
     */
    public static CommonResponse createNotExistCommonResponse(String column) {
        CommonResponse commonResponse = new CommonResponse(false);
        commonResponse.put("code",CodeUtils.DATA_NOT_EXIST_CODE);
        commonResponse.put("message",Joiner.on(" ").join(column, CodeUtils.DATA_NOT_EXIST_MSG)
        );
        return commonResponse;
    }
    /**
     * @Title: createExistCommonResponse
     * @Description:  数据重复
     * @param @return
     * @return CommonResponse    返回类型
     * @throws
     */
    public static CommonResponse createExistCommonResponse() {
        CommonResponse commonResponse = new CommonResponse(false);
        commonResponse.put("code",CodeUtils.DATA_DUPLICATION_CODE);
        commonResponse.put("message",CodeUtils.DATA_DUPLICATION_MSG);
        return commonResponse;
    }
    /**
     * @Title: createPageCommonResponse
     * @Description: 	返回分页数据
     * @param  list
     * @return CommonResponse
     */

    public static CommonResponse createPageCommonResponse(List list) {

        PageInfo page= new PageInfo(list);
        if(list == null) {
            return CommonResponse.createEmptyDataCommonResponse();
        }else if(page.getTotal() == 0 || list == null){
            return CommonResponse.createEmptyDataCommonResponse();
        }

        CommonResponse commonResponse = new CommonResponse();
        commonResponse.success();
        commonResponse.put("total", page.getTotal());
        commonResponse.put("last_page_no", page.getPages());
        commonResponse.put("page_no", page.getPageNum());
        commonResponse.put("res", page.getList());
        return commonResponse;
    }
}
