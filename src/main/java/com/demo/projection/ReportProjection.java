package com.demo.projection;

public interface ReportProjection {
    String getCategory();
    String getSubcategory();
    Long getTotalCount();
    Long getCompleted();
    Long getDropped();
    Long getInDraft();
    Long getInProgress();
    Long getOnHold();
    Double getVarianceSum();
    Integer getDelayDays();
    Double getRevenueLost();
}