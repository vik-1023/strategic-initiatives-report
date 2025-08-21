package com.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ReportEntity {
    @Id
    @Column(name = "category")
    private String category;

    @Column(name = "subcategory")
    private String subcategory;

    @Column(name = "total_count")
    private Long totalCount;

    @Column(name = "completed")
    private Long completed;

    @Column(name = "dropped")
    private Long dropped;

    @Column(name = "in_draft")
    private Long inDraft;

    @Column(name = "in_progress")
    private Long inProgress;

    @Column(name = "on_hold")
    private Long onHold;

    @Column(name = "variance_sum")
    private Double varianceSum;

    @Column(name = "delay_days")
    private Integer delayDays;

    @Column(name = "revenue_lost")
    private Double revenueLost;

    
    
    
    
    
    public ReportEntity(String category, String subcategory, Long totalCount, Long completed, Long dropped,
			Long inDraft, Long inProgress, Long onHold, Double varianceSum, Integer delayDays, Double revenueLost) {
		super();
		this.category = category;
		this.subcategory = subcategory;
		this.totalCount = totalCount;
		this.completed = completed;
		this.dropped = dropped;
		this.inDraft = inDraft;
		this.inProgress = inProgress;
		this.onHold = onHold;
		this.varianceSum = varianceSum;
		this.delayDays = delayDays;
		this.revenueLost = revenueLost;
		
		
		
		
		
	}
	public ReportEntity() {
		super();
		
	}
	// --- getters and setters ---
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getSubcategory() { return subcategory; }
    public void setSubcategory(String subcategory) { this.subcategory = subcategory; }

    public Long getTotalCount() { return totalCount; }
    public void setTotalCount(Long totalCount) { this.totalCount = totalCount; }

    public Long getCompleted() { return completed; }
    public void setCompleted(Long completed) { this.completed = completed; }

    public Long getDropped() { return dropped; }
    public void setDropped(Long dropped) { this.dropped = dropped; }

    public Long getInDraft() { return inDraft; }
    public void setInDraft(Long inDraft) { this.inDraft = inDraft; }

    public Long getInProgress() { return inProgress; }
    public void setInProgress(Long inProgress) { this.inProgress = inProgress; }

    public Long getOnHold() { return onHold; }
    public void setOnHold(Long onHold) { this.onHold = onHold; }

    public Double getVarianceSum() { return varianceSum; }
    public void setVarianceSum(Double varianceSum) { this.varianceSum = varianceSum; }

    public Integer getDelayDays() { return delayDays; }
    public void setDelayDays(Integer delayDays) { this.delayDays = delayDays; }

    public Double getRevenueLost() { return revenueLost; }
    public void setRevenueLost(Double revenueLost) { this.revenueLost = revenueLost; }
	@Override
	public String toString() {
		return "ReportEntity [category=" + category + ", subcategory=" + subcategory + ", totalCount=" + totalCount
				+ ", completed=" + completed + ", dropped=" + dropped + ", inDraft=" + inDraft + ", inProgress="
				+ inProgress + ", onHold=" + onHold + ", varianceSum=" + varianceSum + ", delayDays=" + delayDays
				+ ", revenueLost=" + revenueLost + "]";
	}
    
    
}
