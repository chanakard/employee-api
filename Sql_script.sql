/*Create new user*/

CREATE USER 'employee_list'@'localhost' IDENTIFIED BY 'employee_list';
GRANT ALL PRIVILEGES ON * . * TO 'employee_list'@'localhost';

CREATE SCHEMA EMPLOYEE;

/*employee table script*/
CREATE TABLE IF NOT EXISTS employee (
    employee_id INT AUTO_INCREMENT PRIMARY KEY,
    employee_title VARCHAR(255) NOT NULL,
    employee_name VARCHAR(255) NOT NULL,
    employee_address VARCHAR(255) NOT NULL,
    employee_telephone VARCHAR(255)  NULL,
    employee_email VARCHAR(255) NOT NULL,
    employee_imgurl VARCHAR(255) NOT NULL,
    employee_added_date DATE,
    employee_status TINYINT NOT NULL
);


/*title table script*/
CREATE TABLE IF NOT EXISTS title (
    title_id INT AUTO_INCREMENT PRIMARY KEY,
    title_name VARCHAR(255) NOT NULL,
    title_added_date DATE,
    title_status TINYINT NOT NULL
);


/*status table script*/
CREATE TABLE IF NOT EXISTS status (
    status_id INT,
    status_description VARCHAR(255) NOT NULL,
	status_ref_table VARCHAR(20) NOT NULL,
    status_added_date DATE,
    status_status TINYINT NOT NULL
);

ALTER TABLE status
ADD PRIMARY KEY (status_id,status_ref_table);


/*Insert scripts for employee*/
INSERT INTO `employee` (`employee_id`, `employee_title`, `employee_name`, `employee_address`, `employee_telephone`, `employee_email`, `employee_imgurl`, `employee_added_date`, `employee_status`) VALUES 
('1', 'Mr.', 'Chanaka Roshan', '115/29A, Siripapura Pedesa,Sigera Road, Madiwela, Kotte', '0718108178', 'chanakaroshan86@gmail.com', '/test/chanaka.jpg', '2020-06-15', '1');
commit;

/*Insert scripts for title*/
INSERT INTO `title` (`title_id`, `title_name`, `title_added_date`, `title_status`) VALUES 
('1', 'Mr.', '2020-06-15', '1');
commit;

/*Insert scripts for title*/
INSERT INTO `status` (`status_id`, `status_description`, `status_ref_table`, `status_added_date`, `status_status`) VALUES 
('1', 'Active', 'employee', '2020-06-15', '1');
INSERT INTO `status` (`status_id`, `status_description`, `status_ref_table`, `status_added_date`, `status_status`) VALUES 
('1', 'Active', 'title', '2020-06-15', '1');
commit;
