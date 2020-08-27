package com.group4.backend.dao;

import com.group4.backend.entity.DemoBond;

import java.util.List;
import java.util.Map;

public interface DemoBondDAO {
    public List<DemoBond> queryBond(DemoBond condition);
    public void addRecord(DemoBond demoBond);
    public List<Map<String, String>> orderBySaleName(DemoBond demoBond);
    public List<Map<String, String>> orderByCreated(DemoBond demoBond);
    public void deleteRecord(DemoBond demoBond);
    public void modifyRecord(DemoBond demoBond);
}
