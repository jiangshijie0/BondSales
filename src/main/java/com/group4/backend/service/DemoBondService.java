package com.group4.backend.service;


import com.group4.backend.entity.DemoBond;

import java.util.List;

public interface DemoBondService {
    public List<DemoBond> queryBond(DemoBond condition);
    public void addRecord(DemoBond bondSales);
    public List<DemoBond> orderBySaleName(DemoBond demoBond);
    public List<DemoBond> orderByCreated(DemoBond demoBond);
    public void deleteRecord(DemoBond bondSales);
    public void modifyRecord(DemoBond bondSales);
}
