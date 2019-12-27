package com.ac.controller;

import com.ac.common.utils.GuavaStringUtils;
import com.ac.service.UplodaFileService;
import com.ac.webutil.DateUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author anchao
 * @date 2019/12/27 15:30
 */
@Slf4j
@Controller
@Api(value = "文件服务",tags = "文件服务")
@RequestMapping("file")
public class FileController {

    @Resource
    private UplodaFileService uplodaFileService;



    @PostMapping("upload")
    @ResponseBody
    @ApiOperation("文件上传")
    public String uploadFile(@ApiParam("file")MultipartFile file){
        try {
            String dateFolder = DateUtil.getDateFolder();

            String fileName = GuavaStringUtils.JOINER.join(LocalDateTime.now().format(DateTimeFormatter.ofPattern(DateUtil.YYYYMMDDHHMMSSS)), file.getOriginalFilename());

            File fileNew = new File(dateFolder, fileName);

            if(!fileNew.getParentFile().exists()){
                fileNew.getParentFile().mkdirs();
            }

            FileUtils.copyInputStreamToFile(file.getInputStream(),fileNew);

            return fileNew.getPath();

        } catch (IOException e) {
            log.error("FileController.uploadFile.error={}",e.toString());
        }
        return StringUtils.EMPTY;
    }
}
