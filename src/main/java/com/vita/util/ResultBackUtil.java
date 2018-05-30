package com.vita.util;

import com.vita.entity.ResultBack;
import com.vita.enums.ResultBackCodeEnum;

/**
 * Created by bobo on 2018/5/30.
 *
 * @email ruantianbo@163.com
 */
public class ResultBackUtil {
    public static ResultBack success(Object o){
        return new ResultBack(ResultBackCodeEnum.STATE_OK.getStatus().value(), ResultBackCodeEnum.STATE_OK.getMsg(),o);
    }

    public static ResultBack success(){
        return new ResultBack(ResultBackCodeEnum.STATE_OK.getStatus().value(),ResultBackCodeEnum.STATE_OK.getMsg(),"");
    }

    public static ResultBack error(ResultBackCodeEnum resultBackCodeEnum){
        return new ResultBack(resultBackCodeEnum.getStatus().value(),resultBackCodeEnum.getMsg(),"");
    }
}
