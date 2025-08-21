-- Categories
INSERT INTO category (category_name) VALUES ('Technology'), ('Infrastructure');
-- Subcategories
INSERT INTO subcategory (subcategory_name) VALUES ('Cloud Migration'), ('Data Center'), ('Road Expansion'), ('Water Supply');
-- Initiatives
INSERT INTO initiative (category_id, subcategory_id, status) VALUES
(1, 1, 'Completed'),
(1, 1, 'In Progress'),
(1, 2, 'On Hold'),
(1, 2, 'Completed'),
(2, 3, 'In Draft'),
(2, 3, 'Dropped'),
(2, 4, 'Completed'),
(2, 4, 'In Progress');
-- Templates
INSERT INTO initiative_template (initiative_id, template_name) VALUES
(1, 'Template A'),
(2, 'Template B'),
(3, 'Template C'),
(4, 'Template D'),
(5, 'Template E'),
(6, 'Template F'),
(7, 'Template G'),
(8, 'Template H');
-- Duration Variance
INSERT INTO initiative_duration_variance (template_id, variance_days) VALUES
(1, 10),
(2, 0),
(3, 5),
(4, 15),
(5, 0),
(6, 7),
(7, 12),
(8, 0);
-- Cost of Delay
INSERT INTO initiative_cost_of_delay (template_id, revenue_lost) VALUES
(1, 10000),
(2, 5000),
(3, 0),
(4, 8000),
(5, 0),
(6, 2000),
(7, 12000),
(8, 0);
-- Budget Projections
INSERT INTO initiative_budget_projection (initiative_id, variance_amount) VALUES
(1, 25000),
(2, 15000),
(3, 0),
(4, 30000),
(5, 5000),
(6, 0),
(7, 20000),
(8, 0);