package com.group4.backend.service;


import com.group4.backend.entity.DemoBond;

import java.util.List;
import java.util.Map;

public interface DemoBondService {
    public List<DemoBond> queryBond(DemoBond condition);
    public void addRecord(DemoBond bondSales);
    public List<Map<String, String>> orderBySaleName(DemoBond demoBond);
    public List<Map<String, String>> orderByCreated(DemoBond demoBond);
    public void deleteRecord(DemoBond bondSales);
    public void modifyRecord(DemoBond bondSales);
}
