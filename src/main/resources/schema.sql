CREATE TABLE IF NOT EXISTS Mobile_Data
(
column_id INT UNIQUE NOT NULL,
mobile_no LONG UNIQUE NOT NULL,
cal_balance DOUBLE,
sms_balance DOUBLE,
created_time timestamp DEFAULT CURRENT_TIMESTAMP,
updated_time timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY(column_id)
);          