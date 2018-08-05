package com.htf.common.service;

import com.htf.common.mapper.BaseMapper;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author acumes
 * @date 2018/7/27 15:05
 */
public interface IBaseService<M extends BaseMapper<E, ID>, E, ID> {
    public int insert(E entity);
    public int insertSelective(E entity);
    public int deleteByPrimaryKey(ID id);
    public int deleteByPrimaryKeys(Collection<ID> ids);
    public int updateByPrimaryKey(E entity);
    public int updateByPrimaryKeySelective(E entity);
    public E selectByPrimaryKey(ID id);
    public List<E> selectByPrimaryKeys(Collection<ID> ids);
    public List<E> selectAll();
    public List<E> selectByEntity(E entity);
    public E selectOneByEntity(E entity);
    public List<E> selectByConditions(@SuppressWarnings("rawtypes") Map conditions);
    public E selectOneByConditions(@SuppressWarnings("rawtypes") Map conditions);
    public int batchInsert(List<E> entities);
    public int batchUpdate(List<E> entities);
    public Long count();
    public boolean isExists(E entity);
    public void act_add(E entity);
    public void act_modify(E entity);
    public void delete(ID id);
    public void batchDelete(List<ID> ids);
}
