package com.bilgeadam.controller.database;

import com.bilgeadam.dao.IDaoConnection;
import com.bilgeadam.dao.SubScriberDao;
import com.bilgeadam.dto.SubScriberDto;

import java.util.ArrayList;
import java.util.List;

public class DatabaseSubScriberController implements IDaoConnection<SubScriberDto> {

    private SubScriberDto subScriberDto;
    private SubScriberDao subScriberDao;
    private List<SubScriberDto> subScriberDtoList;

    public DatabaseSubScriberController() {
          subScriberDto=new SubScriberDto();
          subScriberDao =new SubScriberDao();
        subScriberDtoList=new ArrayList<SubScriberDto>();
    }

    @Override
    public void create(SubScriberDto subScriberDto) {
        subScriberDao.create(subScriberDto);
    }

    @Override
    public void update(SubScriberDto subScriberDto) {
        subScriberDao.update(subScriberDto);
    }

    @Override
    public void delete(SubScriberDto subScriberDto) {
        subScriberDao.delete(subScriberDto);
    }

    @Override
    public ArrayList<SubScriberDto> list() {
        return subScriberDao.list();
    }
}
