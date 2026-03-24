CREATE TABLE monitor_microservice_service (
  id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
  namespace VARCHAR(255) NOT NULL COMMENT '命名空间',
  service_name VARCHAR(255) NOT NULL COMMENT 'Service 名称',
  sort_order INT DEFAULT 0 COMMENT '排序',
  del_flag CHAR(1) DEFAULT '0' COMMENT '删除标志（0=正常 2=删除）',
  create_by VARCHAR(64) COMMENT '创建者',
  create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  update_by VARCHAR(64) COMMENT '更新者',
  update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  UNIQUE KEY uk_namespace_service (namespace, service_name),
  KEY idx_namespace (namespace),
  KEY idx_del_flag (del_flag)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='微服务 Service 配置表';