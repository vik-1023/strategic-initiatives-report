package com.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.entity.ReportEntity;
import com.demo.projection.ReportProjection;

@Repository
public interface ReportRepository extends JpaRepository<ReportEntity, String> {

	@Query(value = """
					   WITH initiative_stats AS (
			    SELECT
			        i.id,
			        i.category_id,
			        i.subcategory_id,
			        i.status,
			        COALESCE(bp.total_variance, 0) AS total_variance,
			        COALESCE(dv.total_days, 0) AS total_days,
			        COALESCE(cd.total_revenue, 0) AS total_revenue
			    FROM initiative i
			    LEFT JOIN (
			        SELECT initiative_id, SUM(variance_amount) AS total_variance
			        FROM initiative_budget_projection
			        GROUP BY initiative_id
			    ) bp ON bp.initiative_id = i.id
			    LEFT JOIN (
			        SELECT initiative_id, SUM(variance_days) AS total_days
			        FROM (
			            SELECT it.initiative_id, idv.variance_days
			            FROM initiative_template it
			            JOIN initiative_duration_variance idv ON it.id = idv.template_id
			        ) X
			        GROUP BY initiative_id
			    ) dv ON dv.initiative_id = i.id
			    LEFT JOIN (
			        SELECT initiative_id, SUM(revenue_lost) AS total_revenue
			        FROM (
			            SELECT it.initiative_id, icd.revenue_lost
			            FROM initiative_template it
			            JOIN initiative_cost_of_delay icd ON it.id = icd.template_id
			        ) Y
			        GROUP BY initiative_id
			    ) cd ON cd.initiative_id = i.id
			)

			SELECT
			    c.category_name AS category,
			    s.subcategory_name AS subcategory,
			    COUNT(is1.id) AS total_count,
			    SUM(CASE WHEN is1.status = 'Completed' THEN 1 ELSE 0 END) AS completed,
			    SUM(CASE WHEN is1.status = 'Dropped' THEN 1 ELSE 0 END) AS dropped,
			    SUM(CASE WHEN is1.status = 'In Draft' THEN 1 ELSE 0 END) AS in_draft,
			    SUM(CASE WHEN is1.status = 'In Progress' THEN 1 ELSE 0 END) AS in_progress,
			    SUM(CASE WHEN is1.status = 'On Hold' THEN 1 ELSE 0 END) AS on_hold,
			    SUM(is1.total_variance) AS variance_sum,
			    SUM(is1.total_days) AS delay_days,
			    SUM(is1.total_revenue) AS revenue_lost
			FROM
			    initiative_stats is1
			JOIN
			    category c ON is1.category_id = c.id
			JOIN
			    subcategory s ON is1.subcategory_id = s.id
			GROUP BY
			    c.category_name,
			    s.subcategory_name
			ORDER BY
			    c.category_name,
			    s.subcategory_name

					    """, nativeQuery = true)
	List<ReportProjection> fetchReport();
}