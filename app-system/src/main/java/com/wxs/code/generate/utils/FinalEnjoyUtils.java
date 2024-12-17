/*
 *  @description: FinalEnjoyUtils.java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2024/12/17 下午3:26
 *  @date: 2024-12-17 15:26
 *
 */

package com.wxs.code.generate.utils;

import com.jfinal.template.Engine;
import com.jfinal.template.Template;
import com.wxs.code.core.ext.spring.JFinalViewResolver;
import com.wxs.code.core.utils.SpringUtils;

import java.io.OutputStream;
import java.util.Map;

/**
 * final.enjoy的工具类
 *
 * @author xswang
 */
public class FinalEnjoyUtils {
    private static final JFinalViewResolver FINAL_VIEW_RESOLVER = SpringUtils.get(JFinalViewResolver.class);


    /**
     * 模板文件后缀名
     */
    private static final String TEMPLATE_SUFFIX = ".template";

    public static String getTemplateSuffix() {
        return TEMPLATE_SUFFIX;
    }
    /**
     * 获取FINAL_VIEW_RESOLVER中的引擎
     *
     * @return 引擎实例
     */
    private static Engine getEngine() {
        if (FINAL_VIEW_RESOLVER.getEngine() == null) {
            throw new RuntimeException("JFinalViewResolver.engine is null, please check it.");
        }
        return FINAL_VIEW_RESOLVER.getEngine();
    }

    public static String getBasePath() {
        if (FINAL_VIEW_RESOLVER.getEngine() == null) {
            throw new RuntimeException("JFinalViewResolver.engine is null, please check it.");
        }
        return FINAL_VIEW_RESOLVER.getEngine().getBaseTemplatePath() + "/";
    }

    /**
     * 渲染到字符串
     *
     * @param content 模板字符串
     * @param data    替换数据Map
     * @return 模板后的字符串
     */
    public static String renderStr(String content, Map data) {
        Template template = getEngine().getTemplateByString(content);
        return template.renderToString(data);
    }

    /**
     * 渲染字符串到文件
     *
     * @param content      模板字符串
     * @param data         替换数据Map
     * @param fullFileName 文件的全路径 eg: D://tmp/a.html、  /home/tmp/a.html
     */
    public static void renderStrToFile(String content, Map data, String fullFileName) {
        Template template = getEngine().getTemplateByString(content);
        template.render(data, fullFileName);
    }

    /**
     * 渲染字符串到输出流
     *
     * @param content      模板字符串
     * @param data         替换数据Map
     * @param outputStream 输出流，自行处理，可以给response
     */
    public static void renderStrToFile(String content, Map data, OutputStream outputStream) {
        Template template = getEngine().getTemplateByString(content);
        template.render(data, outputStream);
    }

    /**
     * 渲染文件到文件
     *
     * @param fileName     文件名
     * @param data         替换数据Map
     * @param fullFileName 文件的全路径 eg: D://tmp/a.html、  /home/tmp/a.html
     */
    public static void renderFile(String fileName, Map data, String fullFileName) {
        Template template = getEngine().getTemplate(fileName);
        template.render(data, fullFileName);
    }

    /**
     * 渲染文件到输出流
     *
     * @param fileName     文件名
     * @param data         替换数据Map
     * @param outputStream 输出流，自行处理，可以给response
     */
    public static void renderFile(String fileName, Map data, OutputStream outputStream) {
        Template template = getEngine().getTemplateByString(fileName);
        template.render(data, outputStream);
    }

    /**
     * 获取相对于/templates/enjoy/的相对路径
     */
    public static String getRelativePath(String fullFileName) {
        String basePath = getBasePath().replace("/", "\\");

        return fullFileName.substring(fullFileName.indexOf(basePath) + basePath.length());
    }

}
