package com.dugu.ddd.infra.mw.database.mapper.dugut;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dugu.ddd.domain.dao.dugut.user.TestSysUserDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 测试用户mapper
 *
 * @author cihun
 * @date 2023-09-07 15:56
 */
public interface TestSysUserMapper extends BaseMapper<TestSysUserDO> {
    /**
     * 批量更新或者插入
     *
     * @param list {@link TestSysUserDO}
     */
    void saveOrUpdateBatch(@Param("list") List<TestSysUserDO> list);
}
