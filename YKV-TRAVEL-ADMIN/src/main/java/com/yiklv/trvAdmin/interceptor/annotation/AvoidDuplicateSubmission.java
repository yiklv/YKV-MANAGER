package com.yiklv.trvAdmin.interceptor.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**   
 * @ClassName:  AvoidDuplicateSubmission   
 * @Description:TODO(防止重复提交注解，用于方法上<br/>)   
 * @author: 一科律科技  
 * @date:   2018年6月30日 下午2:07:50   
 *     
 * @Copyright: 2018 www.yiklv.com Inc. All rights reserved.
 *  
 * 注意：本内容仅限于一科律科技公司内部传阅，禁止外泄以及用于其他的商业目 
 * 
 * <p>
 * 防止重复提交注解，用于方法上<br/>
 * 在新建页面方法上，设置needSaveToken()为true，此时拦截器会在Session中保存一个token，
 * 同时需要在新建的页面中添加
 * <input type="hidden" name="token" value="${token}">
 * <br/>
 * 保存方法需要验证重复提交的，设置needRemoveToken为true
 * 此时会在拦截器中验证是否重复提交
 * </p>
 */ 
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AvoidDuplicateSubmission {
    boolean needSaveToken() default false;
    boolean needRemoveToken() default false;
}
