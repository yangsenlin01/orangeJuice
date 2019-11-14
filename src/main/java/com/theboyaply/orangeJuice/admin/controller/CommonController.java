package com.theboyaply.orangeJuice.admin.controller;

import com.theboyaply.orangeJuice.common.dto.ResponseResult;
import com.theboyaply.orangeJuice.common.utils.FileUtil;
import com.theboyaply.orangeJuice.config.OrangeJuiceProperties;
import com.theboyaply.orangeJuice.config.SwaggerConfig;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author theboyaply
 * @version V1.0
 * @Date 2019-11-14
 * @description 通用controller
 */

@Api(tags = SwaggerConfig.COMMON)
@RestController
@RequestMapping("/admin/common")
public class CommonController {

    @Autowired
    private OrangeJuiceProperties orangeJuiceProperties;

    @ApiOperation("上传文件")
    @PostMapping("/upload")
    public ResponseResult uploadFile(@RequestParam("file") MultipartFile file,
                                     @ApiParam("业务类型") @RequestParam("type") String type,
                                     @ApiParam("业务ID") @RequestParam("id") Long id) {
        if (file.isEmpty()) {
            return ResponseResult.ok(400, "文件不能为空");
        }
        String realFilePath = FileUtil.uploadFile(orangeJuiceProperties.getFilePath(), false, file);

        return ResponseResult.ok();
    }

}
