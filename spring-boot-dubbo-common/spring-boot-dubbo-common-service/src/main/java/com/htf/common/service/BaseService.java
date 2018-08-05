package com.htf.common.service;

import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.htf.common.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

/**
 * @author acumes
 * @date 2018/7/27 15:08
 */
public class BaseService<M extends BaseMapper<E, ID>, E, ID> implements IBaseService<M, E, ID>{
    private static final int BATCH_SIZE = 500;

    @Autowired
    protected M mapper;

    @Override
    public int insert(E entity) {
        return mapper.insert(entity);
    }

    @Override
    public int insertSelective(E entity) {
        return mapper.insertSelective(entity);
    }

    @Override
    public int deleteByPrimaryKey(ID id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteByPrimaryKeys(Collection<ID> ids) {
        return mapper.deleteByPrimaryKeys(new ArrayList<>(ids));
    }

    @Override
    public int updateByPrimaryKey(E entity) {
        return mapper.updateByPrimaryKey(entity);
    }

    @Override
    public int updateByPrimaryKeySelective(E entity) {
        return mapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public E selectByPrimaryKey(ID id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public List<E> selectByPrimaryKeys(Collection<ID> ids) {
        return mapper.selectByPrimaryKeys(new ArrayList<>(ids));
    }

    @Override
    public List<E> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public List<E> selectByEntity(E entity) {
        return mapper.selectByRecord(entity);
    }

    @Override
    public E selectOneByEntity(E entity) {
        List<E> entities = mapper.selectByRecord(entity);
        if (null != entities && !entities.isEmpty()) {
            return entities.get(0);
        }
        return null;
    }

    @Override
    public List<E> selectByConditions(@SuppressWarnings("rawtypes") Map conditions) {
        return mapper.selectByConditions(conditions);
    }

    @Override
    public E selectOneByConditions(@SuppressWarnings("rawtypes") Map conditions) {
        List<E> entities = mapper.selectByConditions(conditions);
        if (null != entities && !entities.isEmpty()) {
            return entities.get(0);
        }
        return null;
    }

    @Override
    public int batchInsert(List<E> entities) {
        int size = entities.size();
        int batchTime = size / BATCH_SIZE;
        int remaining = size % BATCH_SIZE;
        int updateCount = 0;
        for (int i = 0; i < batchTime; i++) {
            updateCount += mapper.batchInsert(entities.subList(i * BATCH_SIZE, (i + 1) * BATCH_SIZE));
        }
        if (remaining > 0) {
            updateCount += mapper.batchInsert(entities.subList(size - remaining, size));
        }
        return updateCount;
    }

    @Override
    public int batchUpdate(List<E> entities) {
        int size = entities.size();
        int batchTime = size / BATCH_SIZE;
        int remaining = size % BATCH_SIZE;
        int updateCount = 0;
        for (int i = 0; i < batchTime; i++) {
            updateCount += mapper.batchUpdate(entities.subList(i * BATCH_SIZE, (i + 1) * BATCH_SIZE));
        }
        if (remaining > 0) {
            updateCount += mapper.batchUpdate(entities.subList(size - remaining, size));
        }
        return updateCount;
    }

    @Override
    public Long count() {
        return mapper.count();
    }

    @Override
    public boolean isExists(E entity) {
        return false;
    }

    @Override
    public void act_add(E entity) {
        mapper.insert(entity);
    }

    @Override
    public void act_modify(E entity) {
        mapper.updateByPrimaryKey(entity);
    }

    @Override
    public void delete(ID id) {
        mapper.deleteByPrimaryKey(id);
    }

    @Override
    public void batchDelete(List<ID> ids) {
        mapper.deleteByPrimaryKeys(ids);
    }
}

