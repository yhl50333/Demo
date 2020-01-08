package com.example.mapper;



import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.entity.Keh;
import org.springframework.stereotype.Repository;


@Repository
public interface KehMapper extends BaseMapper<Keh> {
    Keh Sel(int id);
}
