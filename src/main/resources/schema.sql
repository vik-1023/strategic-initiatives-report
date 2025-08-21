--  Categories
CREATE TABLE category (
id INT AUTO_INCREMENT PRIMARY KEY,
category_name VARCHAR(255)
);
--  Subcategories
CREATE TABLE subcategory (
id INT AUTO_INCREMENT PRIMARY KEY,
subcategory_name VARCHAR(255)
);
--  Initiatives
CREATE TABLE initiative (
id INT AUTO_INCREMENT PRIMARY KEY,
category_id INT,
subcategory_id INT,
status VARCHAR(50),
FOREIGN KEY (category_id) REFERENCES category(id),
FOREIGN KEY (subcategory_id) REFERENCES subcategory(id)
);
--  Initiative Template Details
CREATE TABLE initiative_template (
id INT AUTO_INCREMENT PRIMARY KEY,
initiative_id INT,
template_name VARCHAR(255),
FOREIGN KEY (initiative_id) REFERENCES initiative(id)
);
--  Duration Variance
CREATE TABLE initiative_duration_variance (
id INT AUTO_INCREMENT PRIMARY KEY,
template_id INT,
variance_days INT,
FOREIGN KEY (template_id) REFERENCES initiative_template(id)
);
--  Cost of Delay
CREATE TABLE initiative_cost_of_delay (
id INT AUTO_INCREMENT PRIMARY KEY,
template_id INT,
revenue_lost DECIMAL(15,2),
FOREIGN KEY (template_id) REFERENCES initiative_template(id)
);
--  Budget Projection
CREATE TABLE initiative_budget_projection (
id INT AUTO_INCREMENT PRIMARY KEY,
initiative_id INT,
variance_amount DECIMAL(15,2),
FOREIGN KEY (initiative_id) REFERENCES initiative(id)
);
