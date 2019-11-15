package com.theboyaply.orangeJuice.web.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.theboyaply.orangeJuice.web.domain.SysFile;
import com.theboyaply.orangeJuice.web.enums.BizTypeEnum;
import com.theboyaply.orangeJuice.web.service.SysFileService;
import com.theboyaply.orangeJuice.common.dto.ResponseResult;
import com.theboyaply.orangeJuice.common.utils.FileUtil;
import com.theboyaply.orangeJuice.config.OrangeJuiceProperties;
import com.theboyaply.orangeJuice.config.SwaggerConfig;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    @Autowired
    private SysFileService sysFileService;

    @ApiOperation("根据业务ID获取文件")
    @GetMapping("/file")
    public ResponseResult getSysFileByBizId(@ApiParam(value = "业务ID", example = "123") @RequestParam("bizId") Long bizId,
                                            @ApiParam("业务类型") @RequestParam("bizType") String bizType) {
        SysFile sysFile = sysFileService.selectOne(new EntityWrapper<SysFile>()
                .eq("biz_id", bizId).eq("biz_type", bizType));
        return ResponseResult.ok(sysFile);
    }

    @ApiOperation("上传文件")
    @PostMapping("/upload")
    public ResponseResult uploadFile(@RequestParam("file") MultipartFile file,
                                     @ApiParam("业务类型") @RequestParam("bizType") String bizType,
                                     @ApiParam(value = "业务ID", example = "123") @RequestParam("bizId") Long bizId) {
        if (file.isEmpty()) {
            return ResponseResult.ok(400, "文件不能为空");
        }
        // 实际存放路径
        String filePath = FileUtil.uploadFile(orangeJuiceProperties.getFilePath(), false, file);

        // nginx代理访问路径
        String fileUrl = null;

        if (filePath != null) {
            fileUrl = orangeJuiceProperties.getFileUrlPath() + filePath.substring(filePath.lastIndexOf("/") + 1);

            // 文件原始名称
            String originalFileName = file.getOriginalFilename();

            SysFile sysFile = sysFileService.selectOne(new EntityWrapper<SysFile>()
                    .eq("biz_id", bizId)
                    .eq("biz_type", bizType));
            if (sysFile == null) {
                sysFile = new SysFile();
                sysFile.setBizId(bizId);
                for (BizTypeEnum bizTypeEnum : BizTypeEnum.values()) {
                    if (bizType.equals(bizTypeEnum.getType())) {
                        sysFile.setBizType(bizTypeEnum);
                        break;
                    }
                }
            } else {
                // 如果是更新文件，需要先删除以前的文件
                FileUtil.deleteFile(sysFile.getFilePath());
            }
            sysFile.setFilePath(filePath);
            sysFile.setFileUrl(fileUrl);
            sysFile.setFileName(originalFileName);
            sysFile.setFileType(originalFileName.substring(originalFileName.lastIndexOf(".")));

            sysFileService.insertOrUpdate(sysFile);
        }
        return ResponseResult.ok("上传成功");
    }

}
