/*
 *  @description: CodeGenerateService.java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2024/12/17 下午3:26
 *  @date: 2024-12-17 15:26
 *
 */

package com.wxs.code.generate.service;

import com.wxs.code.generate.entity.DTO.CodeOption;
import com.wxs.code.generate.entity.DTO.DB.TableField;
import com.wxs.code.generate.mapper.TableFiledMapper;
import com.wxs.code.generate.utils.FinalEnjoyUtils;
import lombok.extern.slf4j.Slf4j;
import org.dromara.hutool.core.bean.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
@Slf4j
public class CodeGenerateService {

    @Autowired
    TableFiledMapper tableFiledMapper;


    /**
     * 渲染文件名
     *
     * @param fullName 文件名
     * @param data     模板内容
     * @return 结果
     */
    public String renderName(String fullName, Map data) {
        return FinalEnjoyUtils.renderStr(fullName, data);
    }

    /**
     * 渲染classPath中的模板
     *
     * @param templateName /template/enjoy下的文件名或者相对路径
     * @param data         渲染的数据值
     * @param targetPath   文件输出的结果目录，不包含最终的文件名
     * @return 最终的文件名
     */
    public String renderTemplateToFile(String templateName, Map data, String targetPath) {
        String target_filename = FinalEnjoyUtils.renderStr(templateName, data);
        String target_full_path = targetPath + File.separator + target_filename;
        FinalEnjoyUtils.renderFile(templateName, data, target_full_path);
        return target_full_path;
    }


    /**
     * 渲染classPath中的某个文件夹下的所有模板
     *
     * @param fromPath 来源文件夹
     * @param data     渲染值
     */
    public void renderFolder(String fromPath, CodeOption data) {
        try {
            ClassPathResource resource = new ClassPathResource(FinalEnjoyUtils.getBasePath() + fromPath);
            File file = resource.getFile();
            List<File> files = listFileCore(file, new ArrayList<>(), 0);
            String toPath = "";
            Map<String, Object> map_data = BeanUtil.beanToMap(data);
            for (File item : files) {
                // eg: /template/enjoy/a.txt -> a.txt
                String relativePath = FinalEnjoyUtils.getRelativePath(item.getAbsolutePath());
                if (data.getPath() != null) {
                    toPath = data.getPath();
                }

                String target_full_path = toPath + (data.getPackageName() + "." + data.getEntityPackage() + "." + data.getModuleName().toLowerCase()).replace(".", "/") + "/" + relativePath.replace(fromPath, "").replace("\\", "/");
                if (item.isDirectory()) {
                    new File(target_full_path).mkdirs();
                    continue;
                }
                String path = target_full_path.substring(0, target_full_path.lastIndexOf("/") + 1);
                String filename = FinalEnjoyUtils.renderStr(target_full_path.substring(target_full_path.lastIndexOf("/") + 1), map_data).replace(FinalEnjoyUtils.getTemplateSuffix(), "");
                FinalEnjoyUtils.renderFile(relativePath, map_data, path + filename);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取文件夹下所有文件和文件夹列表
     * 遍历 添加文件和文件夹
     *
     * @param file
     * @return result
     */
    public List<File> listFileCore(File file, List<File> result, int level) {
        if (level > 0)
            result.add(file);
        if (file.isDirectory()) {
            File[] childrenFile = Objects.requireNonNull(file.listFiles());
            for (File childFile : childrenFile) {
                listFileCore(childFile, result, level + 1);
            }
        }
        return result;
    }

    public List<TableField> getTableFields(String tableName) {
        return tableFiledMapper.getTableFiled(tableName);
    }
}
