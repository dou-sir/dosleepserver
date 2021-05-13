package com.jit.dyy.dosleepserver.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jit.dyy.dosleepserver.bean.Result;
import com.jit.dyy.dosleepserver.bean.Soundtype;

public interface ISoundtypeService extends IService<Soundtype> {

    Result addSoundtype(Soundtype soundtype);

    Result deleteSoundtype(Soundtype soundtype);

    Result updateSoundtype(Soundtype soundtype);

    Result getSoundtypeList(int pageNum);
}
