package ${package.Controller};

import ${package.Service}.${table.serviceName};
import ${package.Entity}.${entity};
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import cn.xdf.hr.door.common.base.builder.ResultDTOBuilder;
import cn.xdf.hr.door.common.base.dto.ResultDTO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
<#if restControllerStyle>
import org.springframework.web.bind.annotation.RestController;
<#else>
import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>

/**
 * <p>
 * ${table.comment!} 前端控制器
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@Slf4j
@Api(tags = "${table.comment!}")
<#if restControllerStyle>
@RestController
<#else>
@Controller
</#if>
@RequestMapping("<#if package.ModuleName??>/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
<#if kotlin>
public class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
    <#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass} {
    <#else>
public class ${table.controllerName} {

    @Autowired
    public ${table.serviceName} ${table.entityPath}Service;

    @ApiOperation(value = "${table.comment!}新增")
    @PostMapping("/save")
    public ResultDTO<Long> save(@RequestBody ${entity} ${table.entityPath}){
        ${table.entityPath}Service.save(${table.entityPath});
        return ResultDTOBuilder.newSuccess(${table.entityPath}.getId());
    }

    @ApiOperation(value = "${table.comment!}按id删除")
    @PostMapping("/delete/{id}")
    public ResultDTO<Long> delete(@PathVariable("id") Long id){
        ${table.entityPath}Service.removeById(id);
        return ResultDTOBuilder.newSuccess(id);
    }
    
    @ApiOperation(value = "${table.comment!}按id修改")
    @PostMapping("/update/{id}")
    public ResultDTO<Long> update(@PathVariable("id") Long id, @RequestBody ${entity} ${table.entityPath}){
        ${table.entityPath}.setId(id);
        ${table.entityPath}Service.updateById(${table.entityPath});
        return ResultDTOBuilder.newSuccess(${table.entityPath}.getId());
    }

    @ApiOperation(value = "${table.comment!}按id查询")
    @GetMapping("/get/{id}")
    public ResultDTO<${entity}> get(@PathVariable("id") Long id){
        ${entity} ${table.entityPath} = ${table.entityPath}Service.getById(id);
        return ResultDTOBuilder.newSuccess(${table.entityPath});
    }
 
    @ApiOperation(value = "${table.comment!}条件查询带分页")
    @PostMapping("/list")
    public ResultDTO<IPage<${entity}>> list(@RequestBody Query<${entity}> ${table.entityPath}Query){
        Long pageNum=${table.entityPath}Query.getPageNum();
        Long pageSize=${table.entityPath}Query.getPageSize();
        ${entity} ${table.entityPath}=${table.entityPath}Query.getCondition();
        IPage<${entity}> ${table.entityPath}List = ${table.entityPath}Service.page(new Page<>(pageNum, pageSize), new QueryWrapper<>(${table.entityPath}));
        return ResultDTOBuilder.newSuccess(${table.entityPath}List);
    }
    </#if>

}
</#if>